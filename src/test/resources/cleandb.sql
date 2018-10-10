delete from member;
delete from user_role;
delete from user;

INSERT INTO `user` VALUES ('kyang@hotmail.com','mememe','active');
INSERT INTO `user` VALUES ('ptang@hotmail.com','yuyuyu','inactive');
INSERT INTO `user` VALUES ('mjones@hotmail.com','sesese','inactive');
INSERT INTO `user` VALUES ('kterry@hotmail.com','tobetobe','active');

INSERT INTO `user_role` VALUES ('kyang@hotmail.com','admin');
INSERT INTO `user_role` VALUES ('ptang@hotmail.com','member');
INSERT INTO `user_role` VALUES ('mjones@hotmail.com','registered');
INSERT INTO `user_role` VALUES ('kterry@hotmail.com','member');

INSERT INTO `member` VALUES (1,'kyang@hotmail.com','kia','yang','s','female','1973-08-05','123 main st','wi','53533','608-888-8788');
INSERT INTO `member` VALUES (2,'ptang@hotmail.com','perry','tang','s','male','1970-06-10','523 main st','wi','53583','608-999-8700');
INSERT INTO `member` VALUES (3,'mjones@hotmail.com','mary','jones','s','female','1974-09-18','766 main st','wi','53590','608-997-8755');
INSERT INTO `member` VALUES (4,'kterry@hotmail.com','kim','terry','s','female','1977-05-08','766 main st','wi','53590','608-997-8755');

delete from event;
INSERT INTO `event` VALUES (1,'death','2018-09-10',15);

delete from member_event;
INSERT INTO `member_event` VALUES (1,1,1,'paid','2018-10-05');
INSERT INTO `member_event` VALUES (2,1,2,'paid','2018-09-17');
INSERT INTO `member_event` VALUES (3,1,3,'paid','2018-10-10');
INSERT INTO `member_event` VALUES (4,1,4,null,null );
