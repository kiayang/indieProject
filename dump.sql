delete from user_role;
delete from user_event;
delete from user;
delete from event;
INSERT INTO `user` VALUES (1,'kyang@hotmail.com','active','password1','kia','yang','s','1973-08-05','123 main st','wi','53533','608-888-8788'),(2,'rtango@hotmail.com','active','password2','ram','tango','s','1970-06-10','523 main st','wi','53583','608-999-8700'),(3,'mjones@hotmail.com','inactive','password3','mary','jones','s','1974-09-18','766 main st','wi','53590','608-997-8755'),(4,'kterry@hotmail.com','inactive','password4','kerry','terry','s','1977-05-08','339 main st','wi','53599-5402','608-997-8755'),(5,'shelm@hotmail.com','active','password2','stacy','helm','s','1977-06-13','237 main st','wi','77583','608-999-8722');
INSERT INTO `user_role` VALUES (1,1,'kyang@hotmail.com','admin'),(2,2,'rtango@hotmail.com','member'),(3,3,'mjones@hotmail.com','registered'),(4,4,'kterry@hotmail.com','member'),(5,5,'shelm@hotmail.com','member');
INSERT INTO `event` VALUES (1,'perry tang death','2018-09-10',15.00);
INSERT INTO `user_event` VALUES (1,1,1,'paid','2018-10-05'),(2,2,1,'paid','2018-09-17'),(3,5,1,NULL,NULL);

INSERT INTO `user` VALUES (1,'kyang@hotmail.com','active','password1','kia','yang','s','1973-08-05','123 main st','wi','53533','608-888-8788')
INSERT INTO `user_role` VALUES (1,1,'kyang@hotmail.com','admin')

-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: indie_test
-- ------------------------------------------------------
-- Server version	5.7.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_userid` varchar(40) NOT NULL,
  `description` varchar(80) DEFAULT NULL,
  `event_date` date NOT NULL,
  `event_fee` decimal(10,0) NOT NULL,
  PRIMARY KEY (`event_id`),
  UNIQUE KEY `event_event_id_uindex` (`event_id`),
  UNIQUE KEY `event_event_userid_uindex` (`event_userid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'tpot1@gmail.com','event 1','2018-09-10',15),(2,'tpot2@gmail.com','kool aid','2018-01-10',15),(3,'tpot3@gmail.com','tim knight','2017-10-10',15);
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
  `middlename` varchar(10) DEFAULT NULL,
  `dateofbirth` date NOT NULL,
  `address` varchar(35) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zipcode` varchar(12) NOT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `user_id_uindex` (`userid`),
  UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'kyang@hotmail.com','active','password1','kia','yang','ll','9999-12-31','123 windsor st','ca','53537','6088888788'),(2,'rtango@hotmail.com','active','password2','randy','tangelo','s','1970-06-10','523 main st','wi','53583','608-999-8700'),(3,'mjones@hotmail.com','inactive','password3','mary','jones','s','1974-09-18','766 main st','wi','53590','608-997-8755'),(4,'kterry@hotmail.com','inactive','password4','kerry','terry','s','1977-05-08','339 main st','wi','53599-5402','608-997-8755'),(5,'shelm@hotmail.com','active','password2','stacy','helm','s','1977-06-13','237 main st','wi','77583','608-999-8722'),(8,'tpot1@gmail.com','active','password1','tee','pot','ds','1998-01-01','555 main st','wi','535390','5555555'),(9,'tpot2@gmail.com','active','password1','tee','pot','ds','1998-01-01','555 main st','wi','535390','5555555'),(10,'tpot3@gmail.com','new','password1','tee','pot','ds','1998-01-01','555 main st','wi','535390','5555555'),(11,'tpot4@gmail.com','new','password1','tee','pot','ds','1998-01-01','555 main st','wi','535390','5555555'),(12,'tpot5@gmail.com','new','password1','tee','pot','ds','1998-01-01','555 main st','wi','535390','5555555'),(13,'tpot6@gmail.com','new','password1','tee','pot','ds','1998-01-01','555 main st','wi','535390','5555555'),(14,'tpot7@gmail.com','new','password1','tee','pot','ds','1998-01-01','555 main st','wi','535390','5555555'),(15,'tpot8@gmail.com','new','password1','tee','pot','ds','1998-01-01','555 main st','wi','535390','5555555');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_event`
--

DROP TABLE IF EXISTS `user_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_event` (
  `ue_id` int(11) NOT NULL AUTO_INCREMENT,
  `ue_userid` int(11) NOT NULL,
  `ue_eventid` int(11) NOT NULL,
  `paid_status` varchar(6) DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  PRIMARY KEY (`ue_id`),
  UNIQUE KEY `user_event_ue_id_uindex` (`ue_id`),
  KEY `user_event_event_event_id_fk` (`ue_eventid`),
  KEY `user_event_user_userid_fk` (`ue_userid`),
  CONSTRAINT `user_event_event_event_id_fk` FOREIGN KEY (`ue_eventid`) REFERENCES `event` (`event_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_event_user_userid_fk` FOREIGN KEY (`ue_userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_event`
--

LOCK TABLES `user_event` WRITE;
/*!40000 ALTER TABLE `user_event` DISABLE KEYS */;
INSERT INTO `user_event` VALUES (1,1,1,'paid','2018-10-05'),(18,4,2,NULL,NULL);
/*!40000 ALTER TABLE `user_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `user_role_id_uindex` (`role_id`),
  UNIQUE KEY `user_role_username_uindex` (`username`),
  KEY `user_role_user_id_fk` (`userid`),
  CONSTRAINT `user_role_user_id_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,'kyang@hotmail.com','admin'),(2,2,'rtango@hotmail.com','admin'),(3,3,'mjones@hotmail.com','registered'),(4,4,'kterry@hotmail.com','member'),(5,5,'shelm@hotmail.com','member'),(8,8,'tpot1@gmail.com','member'),(9,9,'tpot2@gmail.com','member'),(10,10,'tpot3@gmail.com','register'),(11,11,'tpot4@gmail.com','register'),(12,12,'tpot5@gmail.com','register'),(13,13,'tpot6@gmail.com','register'),(14,14,'tpot7@gmail.com','register'),(15,15,'tpot8@gmail.com','register');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-18  0:06:57


