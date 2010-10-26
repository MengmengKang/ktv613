-- MySQL dump 10.13  Distrib 5.1.39-ndb-7.0.9, for Win32 (ia32)
--
-- Host: localhost    Database: ktv613
-- ------------------------------------------------------
-- Server version	5.1.39-ndb-7.0.9-cluster-gpl

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admins` (
  `Admin` varchar(50) CHARACTER SET utf8 NOT NULL,
  `PassWord` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Admin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES ('admin','21232F297A57A5A743894A0E4A801FC3');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `songs` (
  `SongID` int(11) NOT NULL,
  `SongName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `SongType` varchar(50) CHARACTER SET utf8 NOT NULL,
  `SoNumber` int(50) NOT NULL,
  `SoPinYin` varchar(50) CHARACTER SET utf8 NOT NULL,
  `StarID` int(11) NOT NULL,
  `URL` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`SongID`),
  KEY `SongName` (`SongName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songs`
--

LOCK TABLES `songs` WRITE;
/*!40000 ALTER TABLE `songs` DISABLE KEYS */;
INSERT INTO `songs` VALUES (1,'这该死的爱','流行歌曲',5,'ZHEGAISIDEAI',1,'Media\\这该死的爱.rmvb'),(2,'我愿意','经典老歌',3,'WOYUANYI',5,'Media\\我愿意.rmvb'),(3,'忘情水','经典老歌',3,'WANGQINGSHUI',3,'Media\\忘情水.rmvb'),(5,'青花瓷','流行歌曲',3,'QINGHUACI',4,'Media\\青花瓷.rmvb'),(6,'千里之外','流行歌曲',4,'QIANLIZHIWAI',4,'Media\\千里之外.rmvb'),(8,'谢谢你的爱','经典老歌',5,'XIEXIENIDEAI',3,'Media\\谢谢你的爱.rmvb'),(9,'我相信','流行歌曲',3,'WOXIANGXIN ',1,'Media\\我相信.rmvb'),(10,'传奇','流行歌曲',2,'CHUANQI',5,'Media\\传奇.rmvb'),(11,'容易受伤的女人','流行歌曲',7,'RONGYISHOUSHANGDENVREN',5,'Media\\容易受伤的女人.rmvb'),(12,'爱','经典老歌',1,'AI',6,'Media\\爱.rmvb'),(13,'真心英雄','经典老歌',4,'ZHENXINYINGXIONG',7,'Media\\真心英雄.rmvb'),(14,'大城小爱','流行',4,'DACHENGXIAOAI',9,'Media\\大城小爱.rmvb'),(15,'花田错','流行',3,'HUATIANCUO',9,'Media\\花田错.rmvb'),(16,'日不落','流行',3,'RIBULUO',8,'Media\\日不落.rmvb'),(17,'爱无赦','流行',3,'AIWUSHE',8,'Media\\爱无赦.rmvb'),(18,'心跳','流行',2,'XINTIAO',9,'Media\\心跳.rmvb');
/*!40000 ALTER TABLE `songs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stars`
--

DROP TABLE IF EXISTS `stars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stars` (
  `StarID` int(11) NOT NULL,
  `StarName` varchar(255) CHARACTER SET utf8 NOT NULL,
  `Gender` bit(1) NOT NULL,
  `ComeFrom` varchar(255) CHARACTER SET utf8 NOT NULL,
  `Team` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`StarID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stars`
--

LOCK TABLES `stars` WRITE;
/*!40000 ALTER TABLE `stars` DISABLE KEYS */;
INSERT INTO `stars` VALUES (1,'张靓颖','\0','内地','无'),(2,'张学友','','香港','无'),(3,'刘德华','','香港','无'),(4,'周杰伦','','台湾','无'),(5,'王菲','\0','内地','无'),(6,'小虎队','','台湾','小虎队'),(7,'成龙','','香港','无'),(8,'蔡依林','','港台','无'),(9,'王力宏','','港台','无');
/*!40000 ALTER TABLE `stars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserID` int(11) NOT NULL,
  `UserName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `PassWord` varchar(50) CHARACTER SET utf8 NOT NULL,
  `RealName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Gender` bit(1) DEFAULT NULL,
  `Interest` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','21232F297A57A5A743894A0E4A801FC3','xc','xc@xch.pp.ru','','computer'),(2,'luolei','ECC2334467ED410B50501DA7140B7B33','luolei','ddd','','ddd');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-10-26 18:57:55
