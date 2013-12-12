/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : esal

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2013-09-29 18:22:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appointment_master
-- ----------------------------
DROP TABLE IF EXISTS `appointment_master`;
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

-- ----------------------------
-- Records of appointment_master
-- ----------------------------

-- ----------------------------
-- Table structure for audit_detail
-- ----------------------------
DROP TABLE IF EXISTS `audit_detail`;
CREATE TABLE `audit_detail` (
  `audit_id` varchar(100) NOT NULL,
  `event_id` varchar(10) NOT NULL,
  `eventtime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audit_detail
-- ----------------------------

-- ----------------------------
-- Table structure for customer_address_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_address_info`;
CREATE TABLE `customer_address_info` (
  `customer_id` int(10) NOT NULL,
  `address_1` varchar(100) NOT NULL,
  `address_2` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `zipcode` int(10) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_address_info
-- ----------------------------

-- ----------------------------
-- Table structure for customer_calendar_master
-- ----------------------------
DROP TABLE IF EXISTS `customer_calendar_master`;
CREATE TABLE `customer_calendar_master` (
  `customer_id` int(10) NOT NULL,
  `start_time_day` time NOT NULL,
  `working_hours` int(2) NOT NULL,
  `end_time_day` time NOT NULL,
  `working_days_of_week` varchar(7) NOT NULL,
  `service_name` varchar(25) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='The working day of the week is defineds as string of working days starting from Monday.\r\nie. if the Friday is the holiday then the data inserted would be like : MTWT-SS';

-- ----------------------------
-- Records of customer_calendar_master
-- ----------------------------

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `customer_id` int(10) NOT NULL,
  `customer_title` varchar(100) NOT NULL,
  `overall_rating` int(1) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`,`email`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_info
-- ----------------------------

-- ----------------------------
-- Table structure for customer_login_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_login_info`;
CREATE TABLE `customer_login_info` (
  `customer_id` int(10) NOT NULL,
  `loginname` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `reset_password` int(1) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_login_info
-- ----------------------------

-- ----------------------------
-- Table structure for customer_reset_password
-- ----------------------------
DROP TABLE IF EXISTS `customer_reset_password`;
CREATE TABLE `customer_reset_password` (
  `customer_id` int(10) NOT NULL,
  `reset_password_link` varchar(500) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_reset_password
-- ----------------------------

-- ----------------------------
-- Table structure for customer_service
-- ----------------------------
DROP TABLE IF EXISTS `customer_service`;
CREATE TABLE `customer_service` (
  `customer_id` int(10) NOT NULL,
  `service_name` varchar(25) NOT NULL,
  `rating` int(1) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_service
-- ----------------------------

-- ----------------------------
-- Table structure for event_master
-- ----------------------------
DROP TABLE IF EXISTS `event_master`;
CREATE TABLE `event_master` (
  `event_id` int(10) NOT NULL,
  `event_name` varchar(255) NOT NULL,
  `event_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event_master
-- ----------------------------

-- ----------------------------
-- Table structure for user_address_info
-- ----------------------------
DROP TABLE IF EXISTS `user_address_info`;
CREATE TABLE `user_address_info` (
  `user_id` int(10) NOT NULL,
  `address_1` varchar(250) DEFAULT NULL,
  `address_2` varchar(250) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `zipcode` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='One of City/State/Pincode must be inserted. Or else record should be abandoned from getting inserted.';

-- ----------------------------
-- Records of user_address_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `mobileno` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`email`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'Ronak', 'Patel', 'rgpatel@live.com', '9898556078');
INSERT INTO `user_info` VALUES ('2', 'Ronak', 'Patel', 'rgpatel@live.com', '9898556078');
INSERT INTO `user_info` VALUES ('3', 'Ronak', 'Patel', 'rgpatel@live.com', '9898556078');
INSERT INTO `user_info` VALUES ('4', 'Ronak', 'Patel', 'rgpatel@live.com', '9898556078');

-- ----------------------------
-- Table structure for user_login_info
-- ----------------------------
DROP TABLE IF EXISTS `user_login_info`;
CREATE TABLE `user_login_info` (
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `activated` int(1) NOT NULL,
  `user_id` int(10) NOT NULL,
  `reset_password` int(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_login_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_reset_password
-- ----------------------------
DROP TABLE IF EXISTS `user_reset_password`;
CREATE TABLE `user_reset_password` (
  `user_id` int(10) NOT NULL,
  `reset_password_link` varchar(500) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_reset_password
-- ----------------------------
