--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `eventid` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(80) DEFAULT NULL,
  `event_date` date NOT NULL,
  `event_fee` double NOT NULL,
  PRIMARY KEY (`eventid`),
  UNIQUE KEY `event_eventid_uindex` (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'perry tang death','2018-09-10',15);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `user_status` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(35) NOT NULL,
  `suffix` varchar(2) DEFAULT NULL,
  `dateofbirth` date NOT NULL,
  `address` varchar(35) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zipcode` varchar(12) NOT NULL,
  `phone` varchar(12) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `user_id_uindex` (`userid`),
  UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'kyang@hotmail.com','active','password1','kia','yang','s','1973-08-05','123 main st','wi','53533','608-888-8788'),(2,'rtango@hotmail.com','active','password2','ram','tango','s','1970-06-10','523 main st','wi','53583','608-999-8700'),(3,'mjones@hotmail.com','inactive','password3','mary','jones','s','1974-09-18','766 main st','wi','53590','608-997-8755'),(4,'kterry@hotmail.com','inactive','password4','kerry','terry','s','1977-05-08','339 main st','wi','53599-5402','608-997-8755'),(5,'shelm@hotmail.com','active','password2','stacy','helm','s','1977-06-13','237 main st','wi','77583','608-999-8722');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_event`
--

DROP TABLE IF EXISTS `user_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_event` (
  `ue_userid` int(11) NOT NULL,
  `ue_eventid` int(11) NOT NULL,
  `paid_status` varchar(6) DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  KEY `user_event_event_eventid_fk` (`ue_eventid`),
  KEY `user_event_user_userid_fk` (`ue_userid`),
  CONSTRAINT `user_event_event_eventid_fk` FOREIGN KEY (`ue_eventid`) REFERENCES `event` (`eventid`),
  CONSTRAINT `user_event_user_userid_fk` FOREIGN KEY (`ue_userid`) REFERENCES `user` (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_event`
--

LOCK TABLES `user_event` WRITE;
/*!40000 ALTER TABLE `user_event` DISABLE KEYS */;
INSERT INTO `user_event` VALUES (1,1,'paid','2018-10-05'),(2,1,'paid','2018-09-17'),(5,1,NULL,NULL);
/*!40000 ALTER TABLE `user_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(10) NOT NULL,
  UNIQUE KEY `user_role_role_userid_uindex` (`role_id`),
  CONSTRAINT `user_role_user_userid_fk` FOREIGN KEY (`role_id`) REFERENCES `user` (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'admin'),(2,'member'),(3,'registered'),(4,'member'),(5,'member');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

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

delete from book;
delete from author;
INSERT INTO `author` VALUES (1,'Kathy','Sierra'),(2,'Herbert','Schilt'),(3,'Joseph','Ottinger');
INSERT INTO `book` VALUES (1,'Head First Java, 2nd Edition',1,'978-0596009205',2005),(2,'Beginning Hibernate',3,'978-1-4842-2319-2',2016),(3,'Java: A Beginner’s Guide (Sixth Edition)',2,'978-0071809252',2014);