DROP TABLE IF EXISTS OFFLINE_REQUESTS;

create TABLE OFFLINE_REQUESTS (
--REQUEST_ID varchar2(50) not null,
REQUEST_ID bigint auto_increment,
USER_ID varchar2(50) not null,
CREATED_TIMESTAMP varchar2(100),
LAST_UPDATED_TIMESTAMP varchar2(100),
STATUS varchar2(50),
PATH varchar2(50),
IS_DELETED varchar2(1),
FEEDER_TYPE varchar2(50),
SEARCH_CRITERIA varchar2(500),
REPORT_TYPE varchar2(100),

primary key(REQUEST_ID)
);



