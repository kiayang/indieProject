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
  `event_fee` decimal(10,0) NOT NULL,
  PRIMARY KEY (`eventid`),
  UNIQUE KEY `event_eventid_uindex` (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'death','2018-09-10',15);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `memberid` int(11) NOT NULL AUTO_INCREMENT,
  `member_userid` varchar(40) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(35) NOT NULL,
  `suffix` varchar(15) DEFAULT NULL,
  `gender` varchar(6) NOT NULL,
  `dateofbirth` date NOT NULL,
  `address` varchar(35) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `zipcode` varchar(12) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`memberid`),
  UNIQUE KEY `member_id_uindex` (`memberid`),
  UNIQUE KEY `member_userid_uindex` (`member_userid`),
  CONSTRAINT `member_user_userid_fk` FOREIGN KEY (`member_userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'kyang@hotmail.com','kia','yang','s','female','1973-08-05','123 main st','wi','53533','608-888-8788'),(2,'ptang@hotmail.com','perry','tang','s','male','1970-06-10','523 main st','wi','53583','608-999-8700'),(3,'mjones@hotmail.com','mary','jones','s','female','1974-09-18','766 main st','wi','53590','608-997-8755'),(4,'kterry@hotmail.com','kim','terry','s','female','1977-05-08','766 main st','wi','53590','608-997-8755');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_event`
--

DROP TABLE IF EXISTS `member_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_event` (
  `event_member_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `paid_status` varchar(6) DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  PRIMARY KEY (`event_member_id`),
  UNIQUE KEY `member_event_event_member_id_uindex` (`event_member_id`),
  KEY `member_event_event_eventid_fk` (`event_id`),
  KEY `member_event_member_memberid_fk` (`member_id`),
  CONSTRAINT `member_event_event_eventid_fk` FOREIGN KEY (`event_id`) REFERENCES `event` (`eventid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `member_event_member_memberid_fk` FOREIGN KEY (`member_id`) REFERENCES `member` (`memberid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_event`
--

LOCK TABLES `member_event` WRITE;
/*!40000 ALTER TABLE `member_event` DISABLE KEYS */;
INSERT INTO `member_event` VALUES (1,1,1,'paid','2018-10-05'),(2,1,2,'paid','2018-09-17'),(3,1,3,'paid','2018-10-10'),(4,1,4,NULL,NULL);
/*!40000 ALTER TABLE `member_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `user_user_id_uindex` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('kterry@hotmail.com','tobetobe','active'),('kyang@hotmail.com','mememe','active'),('mjones@hotmail.com','sesese','inactive'),('ptang@hotmail.com','yuyuyu','inactive');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `role_userid` varchar(40) NOT NULL,
  `role` varchar(10) NOT NULL,
  UNIQUE KEY `user_role_role_userid_uindex` (`role_userid`),
  CONSTRAINT `user_role_user_userid_fk` FOREIGN KEY (`role_userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('kterry@hotmail.com','member'),('kyang@hotmail.com','admin'),('mjones@hotmail.com','registered'),('ptang@hotmail.com','member');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

