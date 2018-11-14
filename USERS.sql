/*
Navicat MySQL Data Transfer

Source Server         : 139.196.138.42
Source Server Version : 50722
Source Host           : 139.196.138.42:3306
Source Database       : notesharing

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-11-06 16:07:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for USERS
-- ----------------------------
DROP TABLE IF EXISTS `USERS`;
CREATE TABLE `USERS` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `GENDER` varchar(255) DEFAULT NULL,
  `HEADPORTRAIT` varchar(100) DEFAULT NULL,
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of USERS
-- ----------------------------
INSERT INTO `USERS` VALUES ('1', '男', null, 'kk', '123456', '18593271564');
INSERT INTO `USERS` VALUES ('2', '男', null, 'qq', '123456', '18978968906');
INSERT INTO `USERS` VALUES ('3', '男', null, 'qwe', '123456', '18768392556');
INSERT INTO `USERS` VALUES ('4', '男', null, 'tst', '123111', '15188521111');
INSERT INTO `USERS` VALUES ('5', '男', null, 'movww', '123456', '18177378700');
INSERT INTO `USERS` VALUES ('6', '男', null, 'kang', '701122', '18693271567');
INSERT INTO `USERS` VALUES ('7', '男', null, 'kang1', '123456', '18593271564');
INSERT INTO `USERS` VALUES ('8', '男', null, '1', '1', '18593271564');
