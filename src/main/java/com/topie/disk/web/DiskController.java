package com.topie.disk.web;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topie.api.org.OrgConnector;
import com.topie.api.org.OrgDTO;
import com.topie.api.store.StoreConnector;
import com.topie.api.tenant.TenantHolder;
import com.topie.api.user.UserConnector;
import com.topie.api.user.UserDTO;

import com.topie.core.auth.CurrentUserHolder;
import com.topie.core.page.Page;
import com.topie.core.util.IoUtils;
import com.topie.core.util.ServletUtils;

import com.topie.disk.persistence.domain.DiskInfo;
import com.topie.disk.persistence.domain.DiskShare;
import com.topie.disk.persistence.manager.DiskInfoManager;
import com.topie.disk.persistence.manager.DiskShareManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("disk")
public class DiskController {
    private static Logger logger = LoggerFactory
            .getLogger(DiskController.class);
    private DiskShareManager diskShareManager;
    private DiskInfoManager diskInfoManager;
    private StoreConnector storeConnector;
    private TenantHolder tenantHolder;
    private UserConnector userConnector;
    private CurrentUserHolder currentUserHolder;
    private OrgConnector orgConnector;

	/**
     * 首页.
     */
    @RequestMapping("disk-home")
    public String home(
            @RequestParam(value = "username", required = false) String username,
            Model model) {
        if (username == null) {
        	String orgId = "";
        	List<OrgDTO> list = orgConnector.getOrgsByUserId(currentUserHolder.getUserId());
        	if(list != null && list.size() > 0){
        		orgId = list.get(0).getId();
        	}
            Page page = diskInfoManager.pagedQuery("from DiskShare where (orgId is null or orgId='') or orgId=?", 1, 10,orgId);
            List<DiskShare> diskShares = (List<DiskShare>) page.getResult();
            List<String> userIds = new ArrayList<String>();
            List<UserDTO> userDtos = new ArrayList<UserDTO>();

            for (DiskShare diskShare : diskShares) {
                String userId = diskShare.getCreator();

                if (userIds.contains(userId)) {
                    continue;
                }
                userIds.add(userId);
                UserDTO userDto = userConnector.findById(userId);
                userDtos.add(userDto);
            }

            model.addAttribute("userDtos", userDtos);
        } else {
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("filter_LIKES_username", username);

            Page page = userConnector.pagedQuery(tenantHolder.getTenantId(),
                    new Page(), parameters);
            model.addAttribute("userDtos", page.getResult());
        }

        return "disk/disk-home";
    }

    /**
     * 列表.
     */
    @RequestMapping("disk-list")
    public String list(@RequestParam("u") String u,
            @RequestParam(value = "path", required = false) String path,
            Model model) {
        if (path == null) {
            path = "";
        }

        String userId = u;

        String orgId = "";
    	List<OrgDTO> list = orgConnector.getOrgsByUserId(currentUserHolder.getUserId());
    	if(list != null && list.size() > 0){
    		orgId = list.get(0).getId();
    	}
        List<DiskShare> diskShares = diskShareManager.findBy("creator", userId);
        List<DiskShare> newDiskShares = new ArrayList<DiskShare>();
        if(diskShares != null && diskShares.size() > 0){
        	for(DiskShare share:diskShares){//过滤掉只共享给本部门且和当前登录者不是同一部门的
        		if(StringUtils.isEmpty(share.getOrgId()) || share.getOrgId().equals(orgId)){
        			newDiskShares.add(share);
        		}
        	}
        }
        model.addAttribute("diskShares", newDiskShares);
        model.addAttribute("path", path);

        return "disk/disk-list";
    }

    /**
     * 详情.
     */
    @RequestMapping("disk-view")
    public String view(@RequestParam("id") Long id, Model model) {
        DiskShare diskShare = diskShareManager.get(id);
        model.addAttribute("diskShare", diskShare);

        return "disk/disk-view";
    }

    /**
     * 下载.
     */
    @RequestMapping("disk-download")
    public void download(@RequestParam("id") Long id,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String tenantId = tenantHolder.getTenantId();
        DiskShare diskShare = diskShareManager.get(id);
        DiskInfo diskInfo = diskShare.getDiskInfo();
        InputStream is = null;

        try {
            ServletUtils.setFileDownloadHeader(request, response,
                    diskInfo.getName());
            is = storeConnector
                    .getStore("default/user/" + diskInfo.getCreator(),
                            diskInfo.getRef(), tenantId).getDataSource()
                    .getInputStream();
            IoUtils.copyStream(is, response.getOutputStream());
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    // ~ ======================================================================
    @Resource
    public void setDiskShareManager(DiskShareManager diskShareManager) {
        this.diskShareManager = diskShareManager;
    }

    @Resource
    public void setDiskInfoManager(DiskInfoManager diskInfoManager) {
        this.diskInfoManager = diskInfoManager;
    }

    @Resource
    public void setStoreConnector(StoreConnector storeConnector) {
        this.storeConnector = storeConnector;
    }

    @Resource
    public void setTenantHolder(TenantHolder tenantHolder) {
        this.tenantHolder = tenantHolder;
    }

    @Resource
    public void setUserConnector(UserConnector userConnector) {
        this.userConnector = userConnector;
    }
    
    @Resource
    public void setCurrentUserHolder(CurrentUserHolder currentUserHolder) {
		this.currentUserHolder = currentUserHolder;
	}
    
    @Resource
    public void setOrgConnector(OrgConnector orgConnector) {
		this.orgConnector = orgConnector;
	}
}
