delete from user_role;
delete from user;
INSERT INTO `user` VALUES (1,'kyang@hotmail.com','active','password1','kia','yang','s','1973-08-05','123 main st','wi','53533','608-888-8788'),(2,'rtango@hotmail.com','active','password2','ram','tango','s','1970-06-10','523 main st','wi','53583','608-999-8700'),(3,'mjones@hotmail.com','inactive','password3','mary','jones','s','1974-09-18','766 main st','wi','53590','608-997-8755'),(4,'kterry@hotmail.com','inactive','password4','kerry','terry','s','1977-05-08','339 main st','wi','53599-5402','608-997-8755'),(5,'shelm@hotmail.com','active','password2','stacy','helm','s','1977-06-13','237 main st','wi','77583','608-999-8722');
INSERT INTO `user_role` VALUES (1,1,'admin'),(2,2,'member'),(3,3,'registered'),(4,4,'member'),(5,5,'member');

delete from book;
delete from author;
INSERT INTO `author` VALUES (1,'Kathy','Sierra'),(2,'Herbert','Schilt'),(3,'Joseph','Ottinger');
INSERT INTO `book` VALUES (1,'Head First Java, 2nd Edition',1,'978-0596009205',2005),(2,'Beginning Hibernate',3,'978-1-4842-2319-2',2016),(3,'Java: A Beginner’s Guide (Sixth Edition)',2,'978-0071809252',2014);
