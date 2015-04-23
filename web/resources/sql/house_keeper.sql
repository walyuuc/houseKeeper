/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : house_keeper

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2015-04-23 14:11:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `realname` varchar(255) NOT NULL COMMENT '姓名',
  `is_super` tinyint(1) DEFAULT NULL COMMENT '是否超级管理员',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------

-- ----------------------------
-- Table structure for `t_apply`
-- ----------------------------
DROP TABLE IF EXISTS `t_apply`;
CREATE TABLE `t_apply` (
  `apply_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `proposer` bigint(20) NOT NULL COMMENT '申请人',
  `receiver` bigint(20) NOT NULL COMMENT '接收人',
  `apply_date` datetime NOT NULL COMMENT '申请日期',
  `process_date` datetime DEFAULT NULL COMMENT '处理日期',
  `state` tinyint(255) NOT NULL DEFAULT '0' COMMENT '状态 0.未处理 1.接受 2.拒绝',
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `t_param`
-- ----------------------------
DROP TABLE IF EXISTS `t_param`;
CREATE TABLE `t_param` (
  `param_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '参数名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '所属服务类型 1.租车 2.洗衣 3.清洁',
  PRIMARY KEY (`param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_param
-- ----------------------------

-- ----------------------------
-- Table structure for `t_relative`
-- ----------------------------
DROP TABLE IF EXISTS `t_relative`;
CREATE TABLE `t_relative` (
  `relative_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employer` bigint(20) NOT NULL,
  `employee` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`relative_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_relative
-- ----------------------------
INSERT INTO `t_relative` VALUES ('1', '5', '6', '2015-04-20 18:11:53');
INSERT INTO `t_relative` VALUES ('2', '4', '6', '2015-04-21 10:10:52');

-- ----------------------------
-- Table structure for `t_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `employer` bigint(20) NOT NULL COMMENT '雇主',
  `employee` bigint(20) NOT NULL COMMENT '雇员，即管家',
  `type` tinyint(1) NOT NULL COMMENT '服务类型 1.租车 2.洗衣 3.清洁',
  `corpus` double(10,1) DEFAULT NULL COMMENT '成本',
  `reward` double(10,1) DEFAULT NULL COMMENT '赏金',
  `release_date` datetime DEFAULT NULL COMMENT '发布日期',
  `end_date` datetime DEFAULT NULL COMMENT '截止日期',
  `params` varchar(2000) DEFAULT NULL COMMENT '可变参数',
  `dealstate` tinyint(1) DEFAULT NULL COMMENT '处理状态 0.未处理 1.处理中 2.已处理',
  `paystate` tinyint(1) DEFAULT '0' COMMENT '支付状态 0.未支付 1.已支付',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('1', '4', '6', '1', null, '5.0', '2015-04-21 15:18:07', '2015-04-24 15:18:12', null, null, null);

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `identity_card` varchar(20) DEFAULT NULL COMMENT '身份证',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `check_state` tinyint(1) DEFAULT '0' COMMENT '审核状态 0.审核中 1.已通过',
  `address` varchar(255) DEFAULT NULL COMMENT '居住地址',
  `register_date` datetime DEFAULT NULL COMMENT '注册时间',
  `type` tinyint(1) DEFAULT NULL COMMENT '管家or雇主 0.管家 1雇主',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('4', 'guzhu2', '698d51a19d8a121ce581499d7b701668', '谁谁谁', '222', '222', null, '0', null, '2015-04-21 09:56:06', '1');
INSERT INTO `t_user` VALUES ('5', 'guzhu1', '698d51a19d8a121ce581499d7b701668', '宣传册', '232', '123', null, '0', '水电费', '2015-04-20 11:40:12', '1');
INSERT INTO `t_user` VALUES ('6', 'guanjia', '698d51a19d8a121ce581499d7b701668', '金坷垃', '222', '12333', null, '0', '嘻嘻嘻j', '2015-04-20 11:40:37', '0');
INSERT INTO `t_user` VALUES ('7', 'guzhu3', '698d51a19d8a121ce581499d7b701668', '所属', null, null, null, '0', null, '2015-04-22 17:45:03', '1');
