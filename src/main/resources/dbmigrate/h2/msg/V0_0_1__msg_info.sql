

-------------------------------------------------------------------------------
--  msg info
-------------------------------------------------------------------------------
CREATE TABLE MSG_INFO(
        ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	NAME VARCHAR(200),
	CONTENT VARCHAR(65535),
	TYPE INTEGER,
	CREATE_TIME TIMESTAMP NULL,
	SENDER_ID VARCHAR(64),
	RECEIVER_ID VARCHAR(64),
	STATUS INTEGER,
        CONSTRAINT PK_MSG_INFO PRIMARY KEY(ID)
);

