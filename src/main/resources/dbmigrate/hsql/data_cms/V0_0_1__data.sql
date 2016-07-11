
INSERT INTO CMS_CATALOG(ID,name,code,logo,type,template_index,template_list,template_detail) VALUES(1,'最新动态','news',null,0,'/default/index.html','/default/list.html','/default/detail.html');

INSERT INTO CMS_ARTICLE(ID,title,content,create_time,user_id,CATALOG_ID,hit_count,comment_count) VALUES(1,'6月6号（周一）公司所有员工到三楼大会议室开会','开会通知', '2016-06-03 00:00:00',1,1,0,0);

INSERT INTO CMS_COMMENT(ID,CONTENT,create_time,user_id,article_id) values(1,'测试','2014-12-02 00:00:01','1',1);
INSERT INTO CMS_COMMENT(ID,CONTENT,create_time,user_id,article_id) values(2,'测试','2014-12-02 00:00:02','1',1);

