
CREATE TABLE GROUP_INFO(
        ID BIGINT NOT NULL,
	CODE VARCHAR(50),
        NAME VARCHAR(50),
	REF VARCHAR(200),
	DESCN VARCHAR(200),
	MEMBER_COUNT INT,
	STATUS VARCHAR(50),
	TYPE_ID BIGINT,
	TENANT_ID VARCHAR(64),
        CONSTRAINT PK_GROUP_INFO PRIMARY KEY(ID),
        CONSTRAINT FK_GROUP_INFO_TYPE FOREIGN KEY(TYPE_ID) REFERENCES GROUP_TYPE(ID)
);
