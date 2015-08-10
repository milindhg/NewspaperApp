CREATE DATABASE  IF NOT EXISTS `bonusdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bonusdb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: bonusdb
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `internet_feed`
--

DROP TABLE IF EXISTS `internet_feed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internet_feed` (
  `id` int(11) NOT NULL,
  `headline` varchar(200) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='internet feed table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internet_feed`
--


/*!40000 ALTER TABLE `internet_feed` DISABLE KEYS */;
INSERT INTO `internet_feed` VALUES (3,'Roger Federer defeats Nadal',3),(103,'Indiana Hoosiers Win the Football Championship in Bloomington',3),(107,'Tony Stark the movie character set to launch another sequel of Iron Man Movies',2),(110,'Tata Motors acquires Jaguar from GM',1),(111,'Bollywood movies to be shooted in Universal Studios from now',2);
/*!40000 ALTER TABLE `internet_feed` ENABLE KEYS */;


--
-- Table structure for table `news_feed`
--

DROP TABLE IF EXISTS `news_feed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news_feed` (
  `id` int(11) NOT NULL,
  `headline` varchar(200) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='newspaper feed table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_feed`
--


/*!40000 ALTER TABLE `news_feed` DISABLE KEYS */;
INSERT INTO `news_feed` VALUES (3,'Roger Federer defeats Nadal',3),(103,'Indiana Hoosiers Win the Football Championship in Bloomington',3),(107,'Tony Stark the movie character set to launch another sequel of Iron Man Movies',2),(110,'Tata Motors acquires Jaguar from GM',1),(111,'Bollywood movies to be shooted in Universal Studios from now',2);
/*!40000 ALTER TABLE `news_feed` ENABLE KEYS */;


--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `id_seq` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='THis table used to get the current ongoing sequence of the feed insertions.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--


/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES (113);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;


--
-- Table structure for table `twitter_feed`
--

DROP TABLE IF EXISTS `twitter_feed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `twitter_feed` (
  `id` int(11) NOT NULL,
  `headline` varchar(200) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='twitter feed table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `twitter_feed`
--


/*!40000 ALTER TABLE `twitter_feed` DISABLE KEYS */;
INSERT INTO `twitter_feed` VALUES (3,'Roger Federer defeats Nadal',3),(103,'Indiana Hoosiers Win the Football Championship in Bloomington',3),(107,'Tony Stark the movie character set to launch another sequel of Iron Man Movies',2),(110,'Tata Motors acquires Jaguar from GM',1),(111,'Bollywood movies to be shooted in Universal Studios from now',2);
/*!40000 ALTER TABLE `twitter_feed` ENABLE KEYS */;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 NOT NULL,
  `role` tinyint(1) NOT NULL DEFAULT '0',
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--


/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'super','user','1111111111','su@su.com','root',2,NULL),(2,'Medha','Gokhale','1234567890','medhahg@gmail.com','medhahg',0,NULL),(9,'Vivek','Supe','8123697654','vsupe@umail.iu.edu','Milind1@',1,1),(11,'Medha','Gokhale','3333333333','medhahg@gmail.com','Milind1@',1,3),(12,'Milind','Gokhale','9898989898','mgokhale@indiana.edu','Milind1@',1,2),(13,'Abhishek','Rakshe','2323232323','abhi@abhi.com','Milind1@',0,0),(14,'Diana','Ciric','3313232323','diana.ciric@gmail.com','Milind1@',1,2),(15,'Vishal','Pradhan','4343434343','vp@vp.com','Milind1@',0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-30 21:03:35
