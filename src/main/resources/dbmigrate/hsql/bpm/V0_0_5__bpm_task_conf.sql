
CREATE TABLE BPM_TASK_CONF(
	ID BIGINT NOT NULL,
	BUSINESS_KEY VARCHAR(200),
	TASK_DEFINITION_KEY VARCHAR(200),
	ASSIGNEE VARCHAR(200),
        CONSTRAINT PK_BPM_TASK_CONF PRIMARY KEY(ID)
);

