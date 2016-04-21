package com.topie.javamail.web;

import java.util.List;

import javax.annotation.Resource;

import com.topie.core.auth.CurrentUserHolder;
import com.topie.core.mapper.BeanMapper;

import com.topie.javamail.persistence.domain.JavamailConfig;
import com.topie.javamail.persistence.domain.JavamailMessage;
import com.topie.javamail.persistence.manager.JavamailConfigManager;
import com.topie.javamail.persistence.manager.JavamailMessageManager;
import com.topie.javamail.service.JavamailQueue;
import com.topie.javamail.service.JavamailService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("javamail")
@Controller
public class JavamailController {
    private JavamailConfigManager javamailConfigManager;
    private JavamailMessageManager javamailMessageManager;
    private CurrentUserHolder currentUserHolder;
    private BeanMapper beanMapper = new BeanMapper();
    private JavamailService javamailService;
    private JavamailQueue javamailQueue;

    @RequestMapping("index")
    public String index(@RequestParam(value = "id", required = false) Long id,
            Model model) throws Exception {
        String userId = currentUserHolder.getUserId();
        JavamailConfig javamailConfig = javamailConfigManager.findUniqueBy(
                "userId", userId);

        if (javamailConfig != null) {
            // javamailService.receive(javamailConfig);
            javamailQueue.receive(userId);

            String hql = "from JavamailMessage where javamailConfig.id=? order by sendTime desc";
            List<JavamailMessage> javamailMessages = javamailMessageManager
                    .find(hql, javamailConfig.getId());
            model.addAttribute("javamailMessages", javamailMessages);
        }

        if (id != null) {
            model.addAttribute("javamailMessage",
                    javamailMessageManager.get(id));
        }

        return "javamail/index";
    }

    @RequestMapping("create")
    public String create() {
        return "javamail/create";
    }

    @RequestMapping("send")
    public String send(@RequestParam("receiver") String receiver,
            @RequestParam("subject") String subject,
            @RequestParam("content") String content) throws Exception {
        String userId = currentUserHolder.getUserId();
        JavamailConfig javamailConfig = javamailConfigManager.findUniqueBy(
                "userId", userId);
        // this.javamailService.send(receiver, subject, content, javamailConfig);
        javamailQueue.send(userId, receiver, subject, content);

        return "redirect:/javamail/index.do";
    }

    @RequestMapping("config")
    public String config(Model model) throws Exception {
        JavamailConfig javamailConfig = javamailConfigManager.findUniqueBy(
                "userId", currentUserHolder.getUserId());

        if (javamailConfig != null) {
            model.addAttribute("javamailConfig", javamailConfig);
        }

        return "javamail/config";
    }

    @RequestMapping("configSave")
    public String configSave(@ModelAttribute JavamailConfig javamailConfig,
            Model model) throws Exception {
        JavamailConfig dest = javamailConfigManager.findUniqueBy("userId",
                currentUserHolder.getUserId());

        if (dest == null) {
            javamailConfig.setUserId(currentUserHolder.getUserId());
            javamailConfig.setPriority(0);
            javamailConfigManager.save(javamailConfig);
        } else {
            beanMapper.copy(javamailConfig, dest);
            javamailConfigManager.save(dest);
        }

        return "redirect:/javamail/config.do";
    }

    @Resource
    public void setJavamailConfigManager(
            JavamailConfigManager javamailConfigManager) {
        this.javamailConfigManager = javamailConfigManager;
    }

    @Resource
    public void setJavamailMessageManager(
            JavamailMessageManager javamailMessageManager) {
        this.javamailMessageManager = javamailMessageManager;
    }

    @Resource
    public void setCurrentUserHolder(CurrentUserHolder currentUserHolder) {
        this.currentUserHolder = currentUserHolder;
    }

    @Resource
    public void setJavamailService(JavamailService javamailService) {
        this.javamailService = javamailService;
    }

    @Resource
    public void setJavamailQueue(JavamailQueue javamailQueue) {
        this.javamailQueue = javamailQueue;
    }
}
