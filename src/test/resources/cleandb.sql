delete from user_role;
delete from user_event;
delete from user;
delete from event;

INSERT INTO `user` VALUES (1,'kyang@hotmail.com','active','password1','kia','yang','s','1973-08-05','123 main st','wi','53533','608-888-8788');
INSERT INTO `user` VALUES (2,'rtango@hotmail.com','active','password2','ram','tango','s','1970-06-10','523 main st','wi','53583','608-999-8700');
INSERT INTO `user` VALUES (3,'mjones@hotmail.com','inactive','password3','mary','jones','s','1974-09-18','766 main st','wi','53590','608-997-8755');
INSERT INTO `user` VALUES (4,'kterry@hotmail.com','inactive','password4','kerry','terry','s','1977-05-08','339 main st','wi','53599-5402','608-997-8755');
INSERT INTO `user` VALUES (5,'shelm@hotmail.com','active','password2','stacy','helm','s','1977-06-13','237 main st','wi','77583','608-999-8722');

INSERT INTO `user_role` VALUES (1,'admin');
INSERT INTO `user_role` VALUES (2,'member');
INSERT INTO `user_role` VALUES (3,'registered');
INSERT INTO `user_role` VALUES (4,'member');
INSERT INTO `user_role` VALUES (5,'member');

INSERT INTO `event` VALUES (1,'perry tang death','2018-09-10',15.00);

INSERT INTO `user_event` VALUES (1,1,'paid','2018-10-05');
INSERT INTO `user_event` VALUES (2,1,'paid','2018-09-17');
INSERT INTO `user_event` VALUES (5,1,null,null );
