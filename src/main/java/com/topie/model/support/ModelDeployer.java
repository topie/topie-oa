package com.topie.model.support;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.topie.api.form.FormConnector;
import com.topie.api.form.FormDTO;
import com.topie.api.humantask.HumanTaskConnector;
import com.topie.api.humantask.HumanTaskDefinition;
import com.topie.api.process.ProcessConnector;
import com.topie.api.tenant.TenantConnector;
import com.topie.api.tenant.TenantDTO;

import com.topie.core.mapper.JsonMapper;
import com.topie.core.page.Page;

import com.topie.model.persistence.domain.ModelField;
import com.topie.model.persistence.domain.ModelInfo;
import com.topie.model.persistence.manager.ModelFieldManager;
import com.topie.model.persistence.manager.ModelInfoManager;

import com.topie.spi.humantask.TaskDefinitionConnector;

import org.activiti.engine.repository.ProcessDefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelDeployer {
    private Logger logger = LoggerFactory.getLogger(ModelDeployer.class);
    private boolean autoDeploy;
    private ProcessConnector processConnector;
    private HumanTaskConnector humanTaskConnector;
    private TaskDefinitionConnector taskDefinitionConnector;
    private FormConnector formConnector;
    private ModelInfoManager modelInfoManager;
    private ModelFieldManager modelFieldManager;
    private JsonMapper jsonMapper = new JsonMapper();
    private String defaultTenantCode;
    private TenantConnector tenantConnector;

    @PostConstruct
    public void init() {
        if (!autoDeploy) {
            return;
        }

        TenantDTO tenantDto = tenantConnector.findByCode(defaultTenantCode);
        Page page = processConnector.findProcessDefinitions(tenantDto.getId(),
                new Page());
        List<ProcessDefinition> processDefinitions = (List<ProcessDefinition>) page
                .getResult();

        for (ProcessDefinition processDefinition : processDefinitions) {
            this.processBusiness(processDefinition);
        }
    }

    public void processBusiness(ProcessDefinition processDefinition) {
        String processDefinitionId = processDefinition.getId();
        List<HumanTaskDefinition> humanTaskDefinitions = humanTaskConnector
                .findHumanTaskDefinitions(processDefinitionId);
        ModelInfo modelInfo = modelInfoManager.findUniqueBy("code",
                processDefinitionId);

        if (modelInfo == null) {
            modelInfo = new ModelInfo();
            modelInfo.setCode(processDefinitionId);
            modelInfo.setName(processDefinition.getName());
            modelInfo.setTenantId(processDefinition.getTenantId());
            modelInfoManager.save(modelInfo);
        }

        Map<String, FormField> formFieldMap = new HashMap<String, FormField>();

        for (HumanTaskDefinition humanTaskDefinition : humanTaskDefinitions) {
            try {
                com.topie.spi.humantask.FormDTO formDto = taskDefinitionConnector
                        .findForm(humanTaskDefinition.getKey(),
                                processDefinitionId);

                if (formDto == null) {
                    continue;
                }

                String formKey = formDto.getKey();
                this.processForm(processDefinitionId, formKey,
                        modelInfo.getTenantId(), formFieldMap);
            } catch (IOException ex) {
                logger.error(ex.getMessage(), ex);
            }
        }

        for (FormField formField : formFieldMap.values()) {
            String hql = "from ModelField where name=? and modelInfo=?";
            ModelField modelField = modelFieldManager.findUnique(hql,
                    formField.getName(), modelInfo);

            if (modelField != null) {
                continue;
            }

            modelField = new ModelField();
            modelField.setModelInfo(modelInfo);
            modelField.setCode(formField.getName());
            modelField.setType(formField.getType());
            modelField.setName(formField.getLabel());
            modelField.setSearchable("true");
            modelField.setDisplayable("true");
            modelField.setViewForm("true");
            modelField.setViewList("true");
            modelField.setTenantId(modelInfo.getTenantId());
            modelFieldManager.save(modelField);
        }
    }

    public void processForm(String processDefinitionId, String formKey,
            String tenantId, Map<String, FormField> formFieldMap)
            throws IOException {
        FormDTO formDto = formConnector.findForm(formKey, tenantId);

        if (formDto == null) {
            return;
        }

        if (formDto.isRedirect()) {
            return;
        }

        Map<String, Object> formJson = jsonMapper.fromJson(
                formDto.getContent(), Map.class);
        List<Map<String, Object>> sections = (List<Map<String, Object>>) formJson
                .get("sections");

        for (Map<String, Object> section : sections) {
            if (!"grid".equals(section.get("type"))) {
                continue;
            }

            List<Map<String, Object>> fields = (List<Map<String, Object>>) section
                    .get("fields");

            for (Map<String, Object> field : fields) {
                String type = (String) field.get("type");
                String name = (String) field.get("name");
                String label = name;

                if ("label".equals(type)) {
                    continue;
                }

                FormField formField = formFieldMap.get(name);

                if (formField != null) {
                    continue;
                }

                formField = new FormField();
                formField.setName(name);
                formField.setLabel(label);
                formField.setType(type);
                formFieldMap.put(name, formField);
            }
        }
    }

    public void setAutoDeploy(boolean autoDeploy) {
        this.autoDeploy = autoDeploy;
    }

    @Resource
    public void setProcessConnector(ProcessConnector processConnector) {
        this.processConnector = processConnector;
    }

    @Resource
    public void setHumanTaskConnector(HumanTaskConnector humanTaskConnector) {
        this.humanTaskConnector = humanTaskConnector;
    }

    @Resource
    public void setTaskDefinitionConnector(
            TaskDefinitionConnector taskDefinitionConnector) {
        this.taskDefinitionConnector = taskDefinitionConnector;
    }

    @Resource
    public void setFormConnector(FormConnector formConnector) {
        this.formConnector = formConnector;
    }

    @Resource
    public void setModelInfoManager(ModelInfoManager modelInfoManager) {
        this.modelInfoManager = modelInfoManager;
    }

    @Resource
    public void setModelFieldManager(ModelFieldManager modelFieldManager) {
        this.modelFieldManager = modelFieldManager;
    }

    public void setDefaultTenantCode(String defaultTenantCode) {
        this.defaultTenantCode = defaultTenantCode;
    }

    @Resource
    public void setTenantConnector(TenantConnector tenantConnector) {
        this.tenantConnector = tenantConnector;
    }
}
