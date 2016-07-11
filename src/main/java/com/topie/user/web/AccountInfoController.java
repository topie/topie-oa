package com.topie.user.web;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.topie.api.store.StoreConnector;
import com.topie.api.tenant.TenantHolder;
import com.topie.api.user.UserCache;
import com.topie.api.user.UserDTO;
import com.topie.auth.persistence.domain.UserStatus;
import com.topie.auth.persistence.manager.UserStatusManager;
import com.topie.core.auth.CustomPasswordEncoder;
import com.topie.core.export.Exportor;
import com.topie.core.mapper.BeanMapper;
import com.topie.core.page.Page;
import com.topie.core.query.PropertyFilter;
import com.topie.core.spring.MessageHelper;
import com.topie.party.persistence.domain.PartyEntity;
import com.topie.party.persistence.domain.PartyType;
import com.topie.party.persistence.manager.PartyEntityManager;
import com.topie.party.persistence.manager.PartyStructManager;
import com.topie.party.persistence.manager.PartyStructTypeManager;
import com.topie.user.persistence.domain.AccountAttendance;
import com.topie.user.persistence.domain.AccountAvatar;
import com.topie.user.persistence.domain.AccountCredential;
import com.topie.user.persistence.domain.AccountDevice;
import com.topie.user.persistence.domain.AccountInfo;
import com.topie.user.persistence.domain.PersonInfo;
import com.topie.user.persistence.manager.AccountAttendanceManager;
import com.topie.user.persistence.manager.AccountAvatarManager;
import com.topie.user.persistence.manager.AccountCredentialManager;
import com.topie.user.persistence.manager.AccountDeviceManager;
import com.topie.user.persistence.manager.AccountInfoManager;
import com.topie.user.persistence.manager.PersonInfoManager;
import com.topie.user.publish.UserPublisher;

@Controller
@RequestMapping("user")
public class AccountInfoController {
    private AccountInfoManager accountInfoManager;
    private AccountCredentialManager accountCredentialManager;
    private AccountAvatarManager accountAvatarManager;
    private PersonInfoManager personInfoManager;
    private UserCache userCache;
    private MessageHelper messageHelper;
    private Exportor exportor;
    private BeanMapper beanMapper = new BeanMapper();
    private CustomPasswordEncoder customPasswordEncoder;
    private StoreConnector storeConnector;
    private UserPublisher userPublisher;
    private TenantHolder tenantHolder;
    private PartyEntityManager partyEntityManager;
    private PartyStructManager partyStructManager;
    private PartyStructTypeManager partyStructTypeManager;
    private UserStatusManager userStatusManager;
    private AccountAttendanceManager accountAttendanceManager;
    private AccountDeviceManager accountDeviceManager;

	@RequestMapping("account-info-list")
    public String list(@ModelAttribute Page page,
            @RequestParam Map<String, Object> parameterMap, Model model) {
        String tenantId = tenantHolder.getTenantId();
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
        page = accountInfoManager.pagedQuery(page, propertyFilters);

        model.addAttribute("page", page);

        return "user/account-info-list";
    }

	@RequestMapping("account-info-input")
	public String input(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "orgId", required = false) Long orgId,
			Model model) {
        AccountInfo accountInfo = null;

        if (id != null) {
            accountInfo = accountInfoManager.get(id);
        } else {
            accountInfo = new AccountInfo();
        }

        model.addAttribute("model", accountInfo);
        model.addAttribute("orgId",orgId);

        return "user/account-info-input";
    }

	@RequestMapping("account-info-save")
	public String save(
			@ModelAttribute AccountInfo accountInfo,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "confirmPassword", required = false) String confirmPassword,
			@RequestParam(value = "orgId", required = false) Long orgId,
			RedirectAttributes redirectAttributes,
			@RequestParam(value = "userId", required = false) Long parentAccountId)
			throws Exception {
        String tenantId = tenantHolder.getTenantId();

        // 先进行校验
        if (password != null) {
            if (!password.equals(confirmPassword)) {
                messageHelper.addFlashMessage(redirectAttributes,
                        "user.user.input.passwordnotequals", "两次输入密码不符");

                // TODO: 还要填充schema
                return "user/account-info-input";
            }
        }

        // 再进行数据复制
        AccountInfo dest = null;
        Long id = accountInfo.getId();

        if (id != null) {
            dest = accountInfoManager.get(id);
            beanMapper.copy(accountInfo, dest);
        } else {
            dest = accountInfo;
            dest.setCreateTime(new Date());
            dest.setTenantId(tenantId);
            dest.setStatus("active");
            
            //设置部门
            PartyEntity partyEntity = partyEntityManager.get(orgId);
            dest.setPartyEntity(partyEntity);
        }
        
        //上级
        if(parentAccountId != null){
        	AccountInfo parentAccount = accountInfoManager.get(parentAccountId);
            dest.setParentAccount(parentAccount);
        }
        
        accountInfoManager.save(dest);

        if (dest.getCode() == null) {
            dest.setCode(Long.toString(dest.getId()));
            accountInfoManager.save(dest);
        }

        if (password != null) {
            String hql = "from AccountCredential where accountInfo=? and catalog='default'";
            AccountCredential accountCredential = accountCredentialManager
                    .findUnique(hql, accountInfo);

            if (accountCredential == null) {
                accountCredential = new AccountCredential();
                accountCredential.setAccountInfo(accountInfo);
                accountCredential.setType("normal");
                accountCredential.setCatalog("default");
            }

            if (customPasswordEncoder != null) {
                accountCredential.setPassword(customPasswordEncoder
                        .encode(password));
            } else {
                accountCredential.setPassword(password);
            }

            accountCredentialManager.save(accountCredential);
        }
        
        messageHelper.addFlashMessage(redirectAttributes, "core.success.save",
                "保存成功");

        UserDTO userDto = new UserDTO();
        userDto.setId(Long.toString(dest.getId()));
        userDto.setUsername(dest.getUsername());
        userDto.setRef(dest.getCode());
        userDto.setUserRepoRef(tenantId);
        userCache.removeUser(userDto);

        if (id != null) {
            userPublisher.notifyUserUpdated(this.convertUserDto(dest));
        } else {
//            userPublisher.notifyUserCreated(this.convertUserDto(dest));
        	//PARTY_TYPE表中的数据不要改
        	/**
        	PartyType type = new PartyType(1L);
        	PartyEntity entity = new PartyEntity();
        	entity.setRef(dest.getId()+"");
        	entity.setPartyType(type);
        	entity.setName(accountInfo.getUsername());
        	entity.setTenantId(tenantId);
        	partyEntityManager.save(entity);
            */
        	
        	UserStatus status = new UserStatus();
        	status.setPassword(password);
        	status.setRef(dest.getId()+"");
        	status.setUsername(accountInfo.getUsername());
        	status.setTenantId(tenantId);
        	status.setStatus(1);
        	status.setUserRepoRef(1+"");
        	userStatusManager.save(status);
        	
        	
        	/**
            //add data in PARTY_STRUCT
        	PartyEntity childEntity = partyEntityManager.get(entity.getId());
            PartyEntity parentEntity = partyEntityManager.get(orgId);
            PartyStruct struct = new PartyStruct();
            struct.setChildEntity(childEntity);
            struct.setParentEntity(parentEntity);
            //这里暂时写死（PARTY_STRUCT_TYPE表里面id为1的不要去更改）
            struct.setPartyStructType(partyStructTypeManager.get(1L));
            partyStructManager.save(struct);
            */
            return "redirect:/party/org-list.do?partyEntityId="+orgId;
        }
        if(orgId != null){
        	return "redirect:/party/org-list.do?partyEntityId="+orgId;
        }
        return "redirect:/user/account-info-list.do";
    }

	@RequestMapping("self_account-info-save")
	public @ResponseBody Map<String,Object> save(
			HttpServletResponse response,
			Long id,
			String username,
			String displayName,
			String type,
			String cellphone,
			String telephone,
			String email,
			String address,
			Date birthday,
			String gender,
			@RequestParam(value = "userId", required = false) Long parentAccountId) {
    	response.setContentType("text/html;charset=UTF-8");
    	Map<String,Object> map = new HashMap<String,Object>();
		try {
	        if (id != null) {
	            AccountInfo dest = accountInfoManager.get(id);
	            dest.setDisplayName(displayName);
	            dest.setType(type);
	            dest.setCellphone(cellphone);
	            dest.setTelephone(telephone);
	            dest.setEmail(email);
	            dest.setAddress(address);
	            dest.setBirthday(birthday);
	            dest.setGender(gender);
	          //上级
		        if(parentAccountId != null){
		        	AccountInfo parentAccount = accountInfoManager.get(parentAccountId);
		            dest.setParentAccount(parentAccount);
		        }
		        accountInfoManager.save(dest);
	        }
	        
	        map.put("msg","success");
	        return map;
		} catch (Exception e) {
			map.put("msg",e.getMessage());
			return map;
		}
    }
	
	@RequestMapping("account-info-remove.do")
	public @ResponseBody Map<String,Object> remove(
			HttpServletResponse response,
			@RequestParam("selectedItem") List<Long> selectedItem,
			@RequestParam(value = "orgId", required = false) Long orgId) {
    	response.setContentType("text/html;charset=UTF-8");
    	Map<String,Object> map = new HashMap<String,Object>();
		try {
	        
			String tenantId = tenantHolder.getTenantId();
	        List<AccountInfo> accountInfos = accountInfoManager
	                .findByIds(selectedItem);

	        for (AccountInfo accountInfo : accountInfos) {
	        	//删除成员的密码
	            for (AccountCredential accountCredential : accountInfo
	                    .getAccountCredentials()) {
	                accountCredentialManager.remove(accountCredential);
	            }

	            //删除成员的头像
	            for (AccountAvatar accountAvatar : accountInfo.getAccountAvatars()) {
	                accountAvatarManager.remove(accountAvatar);
	            }
	            
	            //删除成员的设备
	            for(AccountDevice accountDevice:accountInfo.getAccountDevices()){
	            	accountDeviceManager.remove(accountDevice);
	            }
	            
	            //删除账号表中的数据
	            List<UserStatus> userStatus = userStatusManager.find("from UserStatus where ref=?", accountInfo.getId()+"");
	            userStatusManager.removeAll(userStatus);
	            
	            //删除考勤表中的数据
	            List<AccountAttendance> accountAttendances = accountAttendanceManager.find("from AccountAttendance where accountInfo=?", accountInfo);
	            accountAttendanceManager.removeAll(accountAttendances);
	            
	            //删除成员本身
	            accountInfoManager.remove(accountInfo);

	            UserDTO userDto = new UserDTO();
	            userDto.setId(Long.toString(accountInfo.getId()));
	            userDto.setUsername(accountInfo.getUsername());
	            userDto.setRef(accountInfo.getCode());
	            userDto.setUserRepoRef(tenantId);
	            userCache.removeUser(userDto);
//	            userPublisher.notifyUserRemoved(this.convertUserDto(accountInfo));
	        }
	        
	        map.put("msg","success");
	        return map;
		} catch (Exception e) {
			map.put("msg",e.getMessage());
			return map;
		}
    }
	

    @RequestMapping("account-info-active")
    public String active(@RequestParam("id") Long id,
            RedirectAttributes redirectAttributes) {
        AccountInfo accountInfo = accountInfoManager.get(id);
        accountInfo.setStatus("active");
        accountInfoManager.save(accountInfo);
        messageHelper.addFlashMessage(redirectAttributes,
                "core.success.update", "操作成功");

        userPublisher.notifyUserUpdated(this.convertUserDto(accountInfo));

        return "redirect:/user/account-info-list.do";
    }

    @RequestMapping("account-info-disable")
    public String disable(@RequestParam("id") Long id,
            RedirectAttributes redirectAttributes) {
        AccountInfo accountInfo = accountInfoManager.get(id);
        accountInfo.setStatus("disabled");
        accountInfoManager.save(accountInfo);
        messageHelper.addFlashMessage(redirectAttributes,
                "core.success.update", "操作成功");

        userPublisher.notifyUserUpdated(this.convertUserDto(accountInfo));

        return "redirect:/user/account-info-list.do";
    }

    @RequestMapping("account-info-checkUsername")
    @ResponseBody
    public boolean checkUsername(@RequestParam("username") String username,
            @RequestParam(value = "id", required = false) Long id)
            throws Exception {
        String tenantId = tenantHolder.getTenantId();
        String hql = "from AccountInfo where username=? and tenantId=?";
        Object[] params = { username, tenantId };

        if (id != null) {
            hql = "from AccountInfo where username=? and tenantId=? and id<>?";
            params = new Object[] { username, tenantId, id };
        }

        boolean result = accountInfoManager.findUnique(hql, params) == null;

        return result;
    }

    public UserDTO convertUserDto(AccountInfo accountInfo) {
        String hql = "from PersonInfo where code=? and tenantId=?";
        PersonInfo personInfo = personInfoManager.findUnique(hql,
                accountInfo.getCode(), accountInfo.getTenantId());

        UserDTO userDto = new UserDTO();
        userDto.setId(Long.toString(accountInfo.getId()));
        userDto.setUsername(accountInfo.getUsername());
        userDto.setDisplayName(accountInfo.getDisplayName());
        userDto.setNickName(accountInfo.getNickName());
        userDto.setUserRepoRef(accountInfo.getTenantId());

        if (personInfo != null) {
            userDto.setEmail(personInfo.getEmail());
            userDto.setMobile(personInfo.getCellphone());
        }

        return userDto;
    }

    // ~ ======================================================================
    @Resource
    public void setAccountInfoManager(AccountInfoManager accountInfoManager) {
        this.accountInfoManager = accountInfoManager;
    }

    @Resource
    public void setAccountCredentialManager(
            AccountCredentialManager accountCredentialManager) {
        this.accountCredentialManager = accountCredentialManager;
    }

    @Resource
    public void setAccountAvatarManager(
            AccountAvatarManager accountAvatarManager) {
        this.accountAvatarManager = accountAvatarManager;
    }

    @Resource
    public void setPersonInfoManager(PersonInfoManager personInfoManager) {
        this.personInfoManager = personInfoManager;
    }

    @Resource
    public void setUserCache(UserCache userCache) {
        this.userCache = userCache;
    }

    @Resource
    public void setMessageHelper(MessageHelper messageHelper) {
        this.messageHelper = messageHelper;
    }

    @Resource
    public void setCustomPasswordEncoder(
            CustomPasswordEncoder customPasswordEncoder) {
        this.customPasswordEncoder = customPasswordEncoder;
    }

    @Resource
    public void setExportor(Exportor exportor) {
        this.exportor = exportor;
    }

    @Resource
    public void setStoreConnector(StoreConnector storeConnector) {
        this.storeConnector = storeConnector;
    }

    @Resource
    public void setUserPublisher(UserPublisher userPublisher) {
        this.userPublisher = userPublisher;
    }

    @Resource
    public void setTenantHolder(TenantHolder tenantHolder) {
        this.tenantHolder = tenantHolder;
    }
    
    @Resource
    public void setPartyEntityManager(PartyEntityManager partyEntityManager) {
		this.partyEntityManager = partyEntityManager;
	}
    
    @Resource
    public void setPartyStructManager(PartyStructManager partyStructManager) {
		this.partyStructManager = partyStructManager;
	}
    
    @Resource
    public void setPartyStructTypeManager(
			PartyStructTypeManager partyStructTypeManager) {
		this.partyStructTypeManager = partyStructTypeManager;
	}
    
    @Resource
    public void setUserStatusManager(UserStatusManager userStatusManager) {
		this.userStatusManager = userStatusManager;
	}
    
    @Resource
    public void setAccountAttendanceManager(
			AccountAttendanceManager accountAttendanceManager) {
		this.accountAttendanceManager = accountAttendanceManager;
	}
    
    @Resource
    public void setAccountDeviceManager(AccountDeviceManager accountDeviceManager) {
		this.accountDeviceManager = accountDeviceManager;
	}

}
