

-------------------------------------------------------------------------------
--  account info
-------------------------------------------------------------------------------
CREATE TABLE ACCOUNT_INFO(
        ID BIGINT NOT NULL,
	CODE VARCHAR(50),
        USERNAME VARCHAR(50),
	TYPE VARCHAR(50),
	DISPLAY_NAME VARCHAR(200),
	STATUS VARCHAR(50),
	PASSWORD_REQUIRED VARCHAR(50),
	LOCKED VARCHAR(50),
	CREATE_TIME DATETIME,
	CLOSE_TIME DATETIME,
	LOGIN_TIME DATETIME,
	NICK_NAME VARCHAR(200),
	DESCRIPTION VARCHAR(200),
	LANGUAGE VARCHAR(50),
	TIMEZONE VARCHAR(50),
	CELLPHONE VARCHAR(26),
	TELEPHONE VARCHAR(26),
	EMAIL VARCHAR(100),
	ADDRESS VARCHAR(200),
	EMPLOYEE_NO VARCHAR(50),
	ORG_ID BIGINT,
	GENDER VARCHAR(10),
	BIRTHDAY DATETIME,
	ID_CARD_TYPE VARCHAR(26),
	ID_CARD_VALUE VARCHAR(100),
	PARENT_ACCOUNT_ID BIGINT,
        CONSTRAINT PK_ACCOUNT_INFO PRIMARY KEY(ID)
);

COMMENT ON TABLE ACCOUNT_INFO IS '账号信息';
COMMENT ON COLUMN ACCOUNT_INFO.ID IS '主键';
COMMENT ON COLUMN ACCOUNT_INFO.CODE IS '用户标识';
COMMENT ON COLUMN ACCOUNT_INFO.USERNAME IS '账号';
COMMENT ON COLUMN ACCOUNT_INFO.TYPE IS '类型';
COMMENT ON COLUMN ACCOUNT_INFO.DISPLAY_NAME IS '显示名';
COMMENT ON COLUMN ACCOUNT_INFO.STATUS IS '状态';
COMMENT ON COLUMN ACCOUNT_INFO.PASSWORD_REQUIRED IS '是否需要密码';
COMMENT ON COLUMN ACCOUNT_INFO.LOCKED IS '是否被锁定';
COMMENT ON COLUMN ACCOUNT_INFO.CREATE_TIME IS '创建时间';
COMMENT ON COLUMN ACCOUNT_INFO.CLOSE_TIME IS '关闭时间';
COMMENT ON COLUMN ACCOUNT_INFO.LOGIN_TIME IS '登录时间';
COMMENT ON COLUMN ACCOUNT_INFO.NICK_NAME IS '昵称';
COMMENT ON COLUMN ACCOUNT_INFO.DESCRIPTION IS '备注';
COMMENT ON COLUMN ACCOUNT_INFO.LANGUAGE IS '语言';
COMMENT ON COLUMN ACCOUNT_INFO.TIMEZONE IS '时区';
