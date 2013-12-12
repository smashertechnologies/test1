CREATE DATABASE  IF NOT EXISTS `esal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `esal`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: esal
-- ------------------------------------------------------
-- Server version	5.6.13-enterprise-commercial-advanced

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
-- Table structure for table `appointment_master`
--

DROP TABLE IF EXISTS `appointment_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment_master` (
  `customer_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `appointment_id` int(10) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `duration` int(4) NOT NULL COMMENT 'Duration in minutes',
  `service_name` varchar(25) NOT NULL,
  `status` varchar(255) NOT NULL COMMENT 'The status column shows for whether the appoinment has been confirmed,updated,moved or cancelled.\r\n',
  PRIMARY KEY (`appointment_id`),
  KEY `customer_app_fk` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_master`
--

LOCK TABLES `appointment_master` WRITE;
/*!40000 ALTER TABLE `appointment_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_detail`
--

DROP TABLE IF EXISTS `audit_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_detail` (
  `audit_id` varchar(100) NOT NULL,
  `event_id` varchar(10) NOT NULL,
  `eventtime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_detail`
--

LOCK TABLES `audit_detail` WRITE;
/*!40000 ALTER TABLE `audit_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_address_info`
--

DROP TABLE IF EXISTS `customer_address_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_address_info` (
  `customer_id` int(10) NOT NULL,
  `address_1` varchar(100) NOT NULL,
  `address_2` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `zipcode` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `FK_CUSTOMER_ID` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_address_info`
--

LOCK TABLES `customer_address_info` WRITE;
/*!40000 ALTER TABLE `customer_address_info` DISABLE KEYS */;
INSERT INTO `customer_address_info` VALUES (1,'5722 West Street, Park Avenue','North Corner','Bombay','MH','299123'),(2,'49913 North East','Parallen Park,West Local','Bengaluru','KA','244241'),(3,'5722 West Street','Park Avenue,North Corner','New Delhi','DL','299123');
/*!40000 ALTER TABLE `customer_address_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_calendar_master`
--

DROP TABLE IF EXISTS `customer_calendar_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_calendar_master` (
  `customer_id` int(10) NOT NULL,
  `start_time_day` time NOT NULL,
  `working_hours` int(2) NOT NULL,
  `end_time_day` time NOT NULL,
  `working_days_of_week` varchar(7) NOT NULL,
  `service_name` varchar(25) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='The working day of the week is defineds as string of working days starting from Monday.\r\nie. if the Friday is the holiday then the data inserted would be like : MTWT-SS';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_calendar_master`
--

LOCK TABLES `customer_calendar_master` WRITE;
/*!40000 ALTER TABLE `customer_calendar_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_calendar_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_info`
--

DROP TABLE IF EXISTS `customer_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_info` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_title` varchar(100) NOT NULL,
  `uprating` int(5) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `downrating` int(5) DEFAULT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`,`email`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_info`
--

LOCK TABLES `customer_info` WRITE;
/*!40000 ALTER TABLE `customer_info` DISABLE KEYS */;
INSERT INTO `customer_info` VALUES (1,'Just For You Place! New Look Place',20,'contact@justforyou.com',30,'just_for_you.png'),(2,'X Cutting',18,'contact@xcutting.com',4,'x_cutting.jpg'),(3,'Best Stylers In Town!!',14,'contact@beststylers.com',7,'best_stylers.jpg');
/*!40000 ALTER TABLE `customer_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_login_info`
--

DROP TABLE IF EXISTS `customer_login_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_login_info` (
  `customer_id` int(10) NOT NULL,
  `loginname` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `reset_password` int(1) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_login_info`
--

LOCK TABLES `customer_login_info` WRITE;
/*!40000 ALTER TABLE `customer_login_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_login_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_reset_password`
--

DROP TABLE IF EXISTS `customer_reset_password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_reset_password` (
  `customer_id` int(10) NOT NULL,
  `reset_password_link` varchar(500) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_reset_password`
--

LOCK TABLES `customer_reset_password` WRITE;
/*!40000 ALTER TABLE `customer_reset_password` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_reset_password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_service`
--

DROP TABLE IF EXISTS `customer_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_service` (
  `customer_id` int(10) NOT NULL,
  `service_id` int(11) NOT NULL,
  `service_name` varchar(25) NOT NULL,
  `uprating` int(5) NOT NULL,
  `downrating` int(5) DEFAULT NULL,
  PRIMARY KEY (`customer_id`,`service_id`),
  KEY `FK_SERVICE_ID_idx` (`service_id`),
  KEY `FK_SERVICE_NAME_idx` (`service_name`),
  CONSTRAINT `FK_SERVICE_ID` FOREIGN KEY (`service_id`) REFERENCES `service_master` (`service_id`),
  CONSTRAINT `FK_SERVICE_NAME` FOREIGN KEY (`service_name`) REFERENCES `service_master` (`service_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_service`
--

LOCK TABLES `customer_service` WRITE;
/*!40000 ALTER TABLE `customer_service` DISABLE KEYS */;
INSERT INTO `customer_service` VALUES (1,1,'Facial',3,1),(1,2,'Hair Style',5,1),(1,3,'Hair Cutting',3,1),(1,5,'Full Body Massage',10,0),(2,1,'Facial',1,44),(2,3,'Hair Cutting',1,1),(2,5,'Full Body Massage',3,0),(3,1,'Facial',111,31),(3,3,'Hair Cutting',1,1);
/*!40000 ALTER TABLE `customer_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_master`
--

DROP TABLE IF EXISTS `event_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_master` (
  `event_id` int(10) NOT NULL,
  `event_name` varchar(255) NOT NULL,
  `event_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_master`
--

LOCK TABLES `event_master` WRITE;
/*!40000 ALTER TABLE `event_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_master`
--

DROP TABLE IF EXISTS `service_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_master` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Unique Service Id making it PK of the table.',
  `service_name` varchar(100) NOT NULL COMMENT 'Service Name of the table.',
  PRIMARY KEY (`service_id`),
  UNIQUE KEY `service_name_UNIQUE` (`service_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Table which holds information for Service Master, service provided by Customers.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_master`
--

LOCK TABLES `service_master` WRITE;
/*!40000 ALTER TABLE `service_master` DISABLE KEYS */;
INSERT INTO `service_master` VALUES (1,'Facial'),(5,'Full Body Massage'),(3,'Hair Cutting'),(2,'Hair Style'),(4,'Waxing');
/*!40000 ALTER TABLE `service_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address_info`
--

DROP TABLE IF EXISTS `user_address_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_address_info` (
  `user_id` int(10) NOT NULL,
  `address_1` varchar(250) DEFAULT NULL,
  `address_2` varchar(250) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `zipcode` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='One of City/State/Pincode must be inserted. Or else record should be abandoned from getting inserted.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address_info`
--

LOCK TABLES `user_address_info` WRITE;
/*!40000 ALTER TABLE `user_address_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_address_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `mobileno` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`email`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'Users1','Patel','rgpatel@live.com','8711241233'),(2,'Users2','Francis','francis@gmail.com','3113424414'),(3,'Users3','Mishra','myownmail@mycompany.com','9898442311'),(4,'Users4','John','john@yahoo.co.au','9099872432'),(7,'Ronak','Patel','rgpatel','8128809843'),(8,'TestUser1','UserLast1','test1','824421853241');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login_info`
--

DROP TABLE IF EXISTS `user_login_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login_info` (
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `activated` int(1) NOT NULL,
  `user_id` int(10) NOT NULL,
  `reset_password` int(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login_info`
--

LOCK TABLES `user_login_info` WRITE;
/*!40000 ALTER TABLE `user_login_info` DISABLE KEYS */;
INSERT INTO `user_login_info` VALUES ('ronak','password',1,1,0),('rgpatel','',0,7,0),('test1','',0,8,0);
/*!40000 ALTER TABLE `user_login_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_reset_password`
--

DROP TABLE IF EXISTS `user_reset_password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_reset_password` (
  `user_id` int(10) NOT NULL,
  `reset_password_link` varchar(500) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_reset_password`
--

LOCK TABLES `user_reset_password` WRITE;
/*!40000 ALTER TABLE `user_reset_password` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_reset_password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vw_customer_info`
--

DROP TABLE IF EXISTS `vw_customer_info`;
/*!50001 DROP VIEW IF EXISTS `vw_customer_info`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_customer_info` (
  `customer_id` tinyint NOT NULL,
  `customer_title` tinyint NOT NULL,
  `uprating` tinyint NOT NULL,
  `downrating` tinyint NOT NULL,
  `img_name` tinyint NOT NULL,
  `email` tinyint NOT NULL,
  `address_1` tinyint NOT NULL,
  `address_2` tinyint NOT NULL,
  `city` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `zipcode` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_customer_info`
--

/*!50001 DROP TABLE IF EXISTS `vw_customer_info`*/;
/*!50001 DROP VIEW IF EXISTS `vw_customer_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_customer_info` AS select `info`.`customer_id` AS `customer_id`,`info`.`customer_title` AS `customer_title`,`info`.`uprating` AS `uprating`,`info`.`downrating` AS `downrating`,`info`.`img_name` AS `img_name`,`info`.`email` AS `email`,`address`.`address_1` AS `address_1`,`address`.`address_2` AS `address_2`,`address`.`city` AS `city`,`address`.`state` AS `state`,`address`.`zipcode` AS `zipcode` from (`customer_info` `info` join `customer_address_info` `address`) where (`info`.`customer_id` = `address`.`customer_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-01  0:10:33
