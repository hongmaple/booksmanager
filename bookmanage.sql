/*
Navicat MySQL Data Transfer

Source Server         : mysql5.0
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : bookmanage

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2020-07-16 21:00:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `isbn` varchar(250) NOT NULL DEFAULT '1' COMMENT 'isbn',
  `bookname` varchar(30) NOT NULL COMMENT '书名',
  `author` varchar(20) NOT NULL COMMENT '作者',
  `press` varchar(50) NOT NULL COMMENT '出版社',
  `type` varchar(20) NOT NULL COMMENT '类型',
  `money` double(11,2) NOT NULL COMMENT '价格',
  `remark` varchar(11) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('3', '12321', '盗墓笔记', '南派三叔', '工业出版社', '小说', '48.00', '');
INSERT INTO `book` VALUES ('4', '12211', '西游记', '吴承恩', '铁道出版社', 'save', '58.00', '');

-- ----------------------------
-- Table structure for `history`
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(30) NOT NULL COMMENT '借书人',
  `bookname` varchar(30) NOT NULL COMMENT '书名',
  `lendtime` varchar(50) NOT NULL COMMENT '借书时间',
  `backtime` varchar(50) NOT NULL COMMENT '归还时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('30', 'test', '盗墓笔记', '2020-07-15', '2020-07-19', '2020-07-15', '0');
INSERT INTO `history` VALUES ('31', 'test', '西游记', '2020-07-16', '2020-07-15', '2020-07-15', '0');
INSERT INTO `history` VALUES ('32', 'test', '西游记', '2020-07-16', '2020-07-25', '2020-07-15', '0');
INSERT INTO `history` VALUES ('34', 'test', '盗墓笔记', '2020-07-15', '2020-07-16', '2020-07-15', '0');
INSERT INTO `history` VALUES ('35', 'test', '盗墓笔记', '2020-07-02', '2020-07-14', '2020-07-15', '0');
INSERT INTO `history` VALUES ('36', 'test', '盗墓笔记', '2020-07-02', '2020-07-07', '2020-07-15', '0');
INSERT INTO `history` VALUES ('38', 'test', '西游记', '2020-07-01', '2020-07-13', '2020-07-16', '0');
INSERT INTO `history` VALUES ('44', 'test', '盗墓笔记', '2020-07-17', '2020-07-24', '2020-07-16', '0');
INSERT INTO `history` VALUES ('46', 'test', '盗墓笔记', '2020-07-02', '2020-07-17', '2020-07-16', '0');
INSERT INTO `history` VALUES ('49', 'test', '盗墓笔记', '2020-07-09', '2020-07-14', '', '1');
INSERT INTO `history` VALUES ('50', 'test', '西游记', '2020-07-11', '2020-07-18', '', '1');
INSERT INTO `history` VALUES ('51', 'test', '盗墓笔记', '2020-07-07', '2020-07-07', '', '1');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `phonenumber` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `address` varchar(20) DEFAULT NULL COMMENT '地址',
  `type` varchar(10) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '123456', '男', '13618788888', '上海市', '1');
INSERT INTO `users` VALUES ('3', '老王', '123456', '男', '13618788888', '上海', '0');
INSERT INTO `users` VALUES ('4', 'test', '123456', '男', '13619899999', '北京', '0');
INSERT INTO `users` VALUES ('6', 'test11', '123456', '男', '13611111111', '上海', '1');
