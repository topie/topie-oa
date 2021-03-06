

ALTER TABLE FORM_TEMPLATE ADD COLUMN TENANT_ID VARCHAR(64);
ALTER TABLE FORM_TEMPLATE ADD COLUMN USER_ID VARCHAR(64);
ALTER TABLE FORM_TEMPLATE ADD COLUMN CREATE_TIME DATETIME;
ALTER TABLE FORM_SCHEMA ALTER COLUMN SCOPE_ID RENAME TO TENANT_ID;

COMMENT ON COLUMN FORM_TEMPLATE.TENANT_ID IS '租户';
COMMENT ON COLUMN FORM_TEMPLATE.USER_ID IS '用户';
COMMENT ON COLUMN FORM_TEMPLATE.CREATE_TIME IS '创建时间';

