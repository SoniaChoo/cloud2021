/*
Navicat MySQL Data Transfer

Source Server         : sonia Ubuntu
Source Server Version : 50734
Source Host           : 10.0.0.155:3306
Source Database       : springcloud

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2021-06-22 23:45:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
 `serial` varchar(200) DEFAULT '',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', 'tony');
INSERT INTO `payment` VALUES ('2', 'sonia');
INSERT INTO `payment` VALUES ('3', 'alice');
INSERT INTO `payment` VALUES ('4', 'bob');