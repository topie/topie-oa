package com.topie.disk.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.topie.api.org.OrgConnector;
import com.topie.api.org.OrgDTO;
import com.topie.core.auth.CurrentUserHolder;

import com.topie.disk.persistence.domain.DiskInfo;
import com.topie.disk.persistence.domain.DiskShare;
import com.topie.disk.persistence.manager.DiskInfoManager;
import com.topie.disk.persistence.manager.DiskShareManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("disk")
public class DiskShareController {
    private static Logger logger = LoggerFactory
            .getLogger(DiskShareController.class);
    private DiskShareManager diskShareManager;
    private DiskInfoManager diskInfoManager;
    private CurrentUserHolder currentUserHolder;
    private OrgConnector orgConnector;

	/**
     * 列表显示.
     */
    @RequestMapping("disk-share-list")
    public String list(
            @RequestParam(value = "path", required = false) String path,
            Model model) {
        if (path == null) {
            path = "";
        }

        String userId = currentUserHolder.getUserId();

        // List<DiskShare> diskShares = diskService.listFiles(userId, path);
        List<DiskShare> diskShares = diskShareManager.findBy("creator", userId);
        model.addAttribute("diskShares", diskShares);
        model.addAttribute("path", path);

        return "disk/disk-share-list";
    }

    /**
     * 详情.
     */
    @RequestMapping("disk-share-view")
    public String view(@RequestParam("id") Long id, Model model) {
        DiskShare diskShare = diskShareManager.get(id);
        model.addAttribute("diskShare", diskShare);

        return "disk/disk-share-view";
    }

    /**
     * 分享.
     */
    @RequestMapping("disk-share-sharePublic")
    public String sharePublic(@RequestParam("id") Long id,@RequestParam("shareRange") int shareRange) {
        DiskInfo diskInfo = diskInfoManager.get(id);
        DiskShare diskShare = diskShareManager.findUniqueBy("diskInfo",
                diskInfo);

        if (diskShare != null) {
        	logger.info("this disk has aready shared!");
            return "redirect:/disk/disk-share-list.do";
        }

        diskShare = new DiskShare();
        diskShare.setShareType("public");
        diskShare.setShareTime(new Date());
        diskShare.setDiskInfo(diskInfo);
        diskShare.setName(diskInfo.getName());
        diskShare.setCreator(diskInfo.getCreator());
        diskShare.setType(diskInfo.getType());
        diskShare.setDirType(diskInfo.getDirType());
        diskShare.setCountView(0);
        diskShare.setCountSave(0);
        diskShare.setCountDownload(0);
        //只共享给本部门，在表中保存分享人的部门id
        if(shareRange == 2){
        	List<OrgDTO> list = orgConnector.getOrgsByUserId(currentUserHolder.getUserId());
        	if(list != null && list.size() > 0){
        		String orgId = list.get(0).getId();
        		diskShare.setOrgId(orgId);
        	}
        }
        
        diskShareManager.save(diskShare);

        return "redirect:/disk/disk-share-list.do";
    }

    /**
     * 取消分享.
     */
    @RequestMapping("disk-share-remove")
    public String remove(@RequestParam("id") Long id) {
        diskShareManager.removeById(id);

        return "redirect:/disk/disk-share-list.do";
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
    public void setCurrentUserHolder(CurrentUserHolder currentUserHolder) {
        this.currentUserHolder = currentUserHolder;
    }
    
    @Resource
    public void setOrgConnector(OrgConnector orgConnector) {
		this.orgConnector = orgConnector;
	}
}
