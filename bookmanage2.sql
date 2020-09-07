/*
Navicat MySQL Data Transfer

Source Server         : maple
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : bookmanage

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-09-08 04:34:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('3', '12321', '盗墓笔记', '南派三叔', '工业出版社', '小说', '48.00', '');
INSERT INTO `book` VALUES ('4', '12211', '西游记', '吴承恩', '铁道出版社', 'update', '66.00', '');
INSERT INTO `book` VALUES ('5', '1', '阿三打撒打撒', '撒打算', '阿三打撒打撒', 'save', '55.00', '');

-- ----------------------------
-- Table structure for history
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
-- Table structure for history_log
-- ----------------------------
DROP TABLE IF EXISTS `history_log`;
CREATE TABLE `history_log` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `history_id` int(255) NOT NULL COMMENT '借阅表id',
  `status` varchar(10) NOT NULL COMMENT '借阅状态',
  `operator_id` int(20) NOT NULL COMMENT '操作人id',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_msg
-- ----------------------------
DROP TABLE IF EXISTS `sys_msg`;
CREATE TABLE `sys_msg` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '消息Id',
  `title` varchar(255) NOT NULL COMMENT '消息标题',
  `issuer_id` int(20) unsigned NOT NULL,
  `issuer` varchar(50) NOT NULL COMMENT '发布人',
  `accept` int(10) unsigned DEFAULT '1' COMMENT '接受对象',
  `content` varchar(1000) NOT NULL COMMENT '消息内容',
  `remind_way` int(10) NOT NULL COMMENT '提醒方式',
  `indate_time` datetime NOT NULL COMMENT '有效期',
  `release_time` datetime DEFAULT NULL COMMENT '发布时间',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_msg
-- ----------------------------
INSERT INTO `sys_msg` VALUES ('19', '我爱你', '1', 'admin', '0', '你愿意做我女盆友吗？', '1', '2020-09-12 03:59:16', '2020-09-08 00:19:37', '2020-09-08 00:19:37', '2020-09-08 00:19:37', '0');
INSERT INTO `sys_msg` VALUES ('20', '哈哈', '1', 'admin', '0', '呵呵呵', '1', '2020-09-12 03:59:16', '2020-09-08 00:33:56', '2020-09-08 00:33:56', '2020-09-08 00:33:56', '0');
INSERT INTO `sys_msg` VALUES ('21', 'xZX', '1', 'admin', '0', 'aasdasd', '1', '2020-09-12 03:59:16', '2020-09-08 00:39:49', '2020-09-08 00:39:49', '2020-09-08 00:39:49', '0');
INSERT INTO `sys_msg` VALUES ('22', '夫士大夫', '1', 'admin', '0', '撒发顺丰', '1', '2020-09-12 03:59:16', '2020-09-08 00:49:53', '2020-09-08 00:49:53', '2020-09-08 00:49:53', '0');
INSERT INTO `sys_msg` VALUES ('23', 'xzx', '1', 'admin', '0', 'sdsf', '1', '2020-09-12 03:59:16', '2020-09-08 01:05:35', '2020-09-08 01:05:35', '2020-09-08 01:05:35', '0');
INSERT INTO `sys_msg` VALUES ('24', 'asad', '1', 'admin', '0', 'sadsad', '1', '2020-09-12 03:59:16', '2020-09-08 01:09:52', '2020-09-08 01:09:52', '2020-09-08 01:09:52', '0');
INSERT INTO `sys_msg` VALUES ('25', '西安S', '1', 'admin', '0', '撒旦撒', '1', '2020-09-12 03:59:16', '2020-09-08 01:15:49', '2020-09-08 01:15:49', '2020-09-08 01:15:49', '0');
INSERT INTO `sys_msg` VALUES ('26', '这些ZX', '1', 'admin', '0', '阿萨S', '1', '2020-09-12 03:59:16', '2020-09-08 01:19:44', '2020-09-08 01:19:44', '2020-09-08 01:19:44', '0');
INSERT INTO `sys_msg` VALUES ('27', 'XZX', '1', 'admin', '0', 'zxzX', '1', '2020-09-12 03:59:16', '2020-09-08 01:23:16', '2020-09-08 01:23:16', '2020-09-08 01:23:16', '0');
INSERT INTO `sys_msg` VALUES ('28', '撒旦撒旦撒旦撒的', '1', 'admin', '0', '萨达萨达萨达萨达萨达', '1', '2020-09-12 03:59:16', '2020-09-08 03:57:30', '2020-09-08 03:57:30', '2020-09-08 03:57:30', '0');
INSERT INTO `sys_msg` VALUES ('29', '这些政策在', '1', 'admin', '0', '行政村自行车', '1', '2020-09-10 00:00:00', '2020-09-08 04:01:47', '2020-09-08 04:01:47', '2020-09-08 04:01:47', '0');

-- ----------------------------
-- Table structure for users
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

-- ----------------------------
-- Table structure for users_message
-- ----------------------------
DROP TABLE IF EXISTS `users_message`;
CREATE TABLE `users_message` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `user_id` int(20) NOT NULL COMMENT '用户id',
  `title` varchar(255) NOT NULL COMMENT '消息标题',
  `content` varchar(255) NOT NULL COMMENT '消息内容',
  `release_time` datetime DEFAULT NULL COMMENT '接收时间',
  `is_read` tinyint(4) NOT NULL COMMENT '是否已读',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `from_id` bigint(20) DEFAULT NULL COMMENT 'sys_msg_id',
  `read_time` datetime DEFAULT NULL COMMENT '读取时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_message
-- ----------------------------
INSERT INTO `users_message` VALUES ('75', '3', '我爱你', '你愿意做我女盆友吗？', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '19', null);
INSERT INTO `users_message` VALUES ('76', '3', '哈哈', '呵呵呵', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '20', null);
INSERT INTO `users_message` VALUES ('77', '3', 'xZX', 'aasdasd', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '21', null);
INSERT INTO `users_message` VALUES ('78', '3', '夫士大夫', '撒发顺丰', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '22', null);
INSERT INTO `users_message` VALUES ('79', '3', 'xzx', 'sdsf', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '23', null);
INSERT INTO `users_message` VALUES ('80', '3', 'asad', 'sadsad', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '24', null);
INSERT INTO `users_message` VALUES ('81', '3', '西安S', '撒旦撒', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '25', null);
INSERT INTO `users_message` VALUES ('82', '3', '这些ZX', '阿萨S', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '26', null);
INSERT INTO `users_message` VALUES ('83', '3', 'XZX', 'zxzX', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '27', null);
INSERT INTO `users_message` VALUES ('84', '3', '撒旦撒旦撒旦撒的', '萨达萨达萨达萨达萨达', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '28', null);
INSERT INTO `users_message` VALUES ('85', '3', '这些政策在', '行政村自行车', '2020-09-08 00:00:00', '0', '2020-09-08 04:15:22', '2020-09-08 04:15:22', '29', null);
