/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : mingqian

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-29 23:24:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ea_admin_account
-- ----------------------------
DROP TABLE IF EXISTS `ea_admin_account`;
CREATE TABLE `ea_admin_account` (
  `USER_ID` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `LOGIN_NAME` varchar(20) NOT NULL COMMENT '登录名',
  `LOGIN_PWD` varchar(100) NOT NULL COMMENT '密码',
  `REAL_NAME` varchar(15) NOT NULL COMMENT '真实姓名',
  `EMAIL` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `EMP_CODE` varchar(10) DEFAULT NULL COMMENT '工号',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `STATUS` char(2) NOT NULL DEFAULT '0' COMMENT '启用状态0禁用 1启用',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='管理员账户表';

-- ----------------------------
-- Records of ea_admin_account
-- ----------------------------
INSERT INTO `ea_admin_account` VALUES ('1', 'admin', '21232F297A57A5A743894A0E4A801FC3', '鸣谦', 'ydy465258@16.com', '1001', '2018-12-20 16:08:33', '2018-12-20 16:08:35', '1');
INSERT INTO `ea_admin_account` VALUES ('2', 'zhangsan', '6512BD43D9CAA6E02C990B0A82652DCA', '张三', 'zhansan@163.com', null, '2018-12-24 10:08:35', '2018-12-24 10:08:35', '0');
INSERT INTO `ea_admin_account` VALUES ('3', '1829010120029', '511B0D5F341BDDBD9A5348923B48D14C', '12', '123@163.com', null, '2018-12-25 17:02:20', '2018-12-25 17:02:20', '1');
INSERT INTO `ea_admin_account` VALUES ('4', 'user', '21232F297A57A5A743894A0E4A801FC3', 'user', 'user', null, '2018-12-28 15:35:46', '2018-12-28 15:35:46', '1');

-- ----------------------------
-- Table structure for ea_admin_department
-- ----------------------------
DROP TABLE IF EXISTS `ea_admin_department`;
CREATE TABLE `ea_admin_department` (
  `ID` bigint(12) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `DEPARTMENT_NAME` varchar(20) NOT NULL COMMENT '部门名称',
  `DEPARTMENT_DESC` varchar(30) NOT NULL COMMENT '部门描述',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `DELETED` char(2) NOT NULL COMMENT '删除状态：0未删除1已删除',
  `CAEATOR` bigint(12) NOT NULL COMMENT '操作人id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of ea_admin_department
-- ----------------------------
INSERT INTO `ea_admin_department` VALUES ('1', '技术', 'java', '2018-12-24 09:58:04', '2018-12-24 09:58:04', '0', '0');
INSERT INTO `ea_admin_department` VALUES ('2', '建筑', 'cad', '2018-12-24 09:58:39', '2018-12-24 09:58:39', '0', '0');
INSERT INTO `ea_admin_department` VALUES ('3', '财务admin', '会计', '2018-12-24 10:00:12', '2018-12-24 10:00:12', '0', '0');
INSERT INTO `ea_admin_department` VALUES ('4', 'test', 'test', '2018-12-25 17:01:37', '2018-12-25 17:01:37', '1', '0');

-- ----------------------------
-- Table structure for ea_admin_menu_conf
-- ----------------------------
DROP TABLE IF EXISTS `ea_admin_menu_conf`;
CREATE TABLE `ea_admin_menu_conf` (
  `MENU_ID` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `MENU_NAME` varchar(20) NOT NULL COMMENT '菜单名称',
  `MENU_DESC` varchar(50) DEFAULT NULL COMMENT '菜单描述',
  `REQ_URL` varchar(120) DEFAULT NULL COMMENT '请求地址',
  `PARENT_MENU_ID` bigint(12) NOT NULL COMMENT '上级id',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `DELETED` char(1) NOT NULL DEFAULT '0' COMMENT '删除状态0未删除 1已删除',
  `CREATOR` bigint(12) NOT NULL COMMENT '操作人id',
  `FONTAWE_CSS` varchar(120) DEFAULT NULL COMMENT 'fontawesome图标样式',
  `SHOW_MENU` char(2) NOT NULL DEFAULT '1' COMMENT '是否显示0不显示 1显示',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='菜单配置表';

-- ----------------------------
-- Records of ea_admin_menu_conf
-- ----------------------------
INSERT INTO `ea_admin_menu_conf` VALUES ('1', '平台管理', '平台管理', null, '0', '2018-12-25 09:47:34', '2018-12-25 09:47:36', '0', '0', 'fa-cog', '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('2', '商城管理', '商城管理', null, '0', '2018-12-25 09:48:33', '2018-12-25 09:48:35', '0', '0', 'fa-apple', '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('3', '会员管理', '会员管理', null, '0', '2018-12-25 09:48:59', '2018-12-25 09:49:01', '0', '0', 'fa-user', '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('4', '系统角色', '系统角色', '/adminRole/toList', '1', '2018-12-25 09:50:55', '2018-12-25 09:50:58', '0', '0', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('5', '添加角色', '添加角色', '/adminRole/toAddAdminRolePage', '1', '2018-12-25 09:52:01', '2018-12-25 09:52:04', '0', '0', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('6', '员工列表', '员工列表', '/adminAccount/toList', '1', '2018-12-25 09:53:11', '2018-12-25 09:53:14', '0', '0', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('7', '会员列表', null, '/user/toList', '3', '2018-12-27 11:47:43', '2018-12-27 11:47:43', '0', '1', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('8', '查看用户信息', null, '/user/userInfo', '3', '2018-12-27 11:50:38', '2018-12-27 11:50:38', '1', '1', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('9', '会员信息展示', null, '/user/userInfo', '3', '2018-12-27 15:20:27', '2018-12-27 15:20:27', '0', '1', null, '1');

-- ----------------------------
-- Table structure for ea_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `ea_admin_role`;
CREATE TABLE `ea_admin_role` (
  `ROLE_ID` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `ROLE_NAME` varchar(15) NOT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `STATUS` char(2) NOT NULL DEFAULT '0' COMMENT '启用状态(0未启用 1启用)',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='员工角色表';

-- ----------------------------
-- Records of ea_admin_role
-- ----------------------------
INSERT INTO `ea_admin_role` VALUES ('1', '超级管理员', '超级管理员', '2018-12-24 10:07:51', '2018-12-24 10:07:53', '1');
INSERT INTO `ea_admin_role` VALUES ('2', 'admin', 'admin', '2018-12-24 16:06:30', '2018-12-24 16:06:33', '1');
INSERT INTO `ea_admin_role` VALUES ('4', 'test', 'test', '2018-12-26 11:37:15', '2018-12-26 11:37:15', '1');
INSERT INTO `ea_admin_role` VALUES ('5', '123', '123', '2018-12-26 11:40:33', '2018-12-26 11:40:33', '1');
INSERT INTO `ea_admin_role` VALUES ('7', '1232', '123123', '2018-12-26 11:45:10', '2018-12-26 11:45:10', '1');
INSERT INTO `ea_admin_role` VALUES ('8', '22', '22', '2018-12-26 11:46:58', '2018-12-26 11:46:58', '1');
INSERT INTO `ea_admin_role` VALUES ('9', '111111111', '111', '2018-12-26 11:47:51', '2018-12-26 11:47:51', '1');
INSERT INTO `ea_admin_role` VALUES ('10', 'asdasd', 'asdasd', '2018-12-26 11:49:00', '2018-12-26 11:49:00', '1');
INSERT INTO `ea_admin_role` VALUES ('11', 'asdasd2', 'asdasd3', '2018-12-26 11:49:10', '2018-12-26 11:49:10', '1');
INSERT INTO `ea_admin_role` VALUES ('12', 'awwa', 'aw', '2018-12-26 11:51:16', '2018-12-26 11:51:16', '1');
INSERT INTO `ea_admin_role` VALUES ('13', '``1222', '2121', '2018-12-26 13:17:16', '2018-12-26 13:17:16', '1');
INSERT INTO `ea_admin_role` VALUES ('14', 'sss', 'ssss', '2018-12-26 16:23:48', '2018-12-26 15:44:21', '0');
INSERT INTO `ea_admin_role` VALUES ('15', '2222222331d', '2323', '2018-12-26 16:23:44', '2018-12-26 16:09:53', '0');
INSERT INTO `ea_admin_role` VALUES ('16', '1111111dwddw', '1222dd', '2018-12-26 16:24:50', '2018-12-26 16:24:50', '1');

-- ----------------------------
-- Table structure for ea_admin_role_permission_ref
-- ----------------------------
DROP TABLE IF EXISTS `ea_admin_role_permission_ref`;
CREATE TABLE `ea_admin_role_permission_ref` (
  `ROLE_ID` bigint(12) NOT NULL COMMENT '角色id',
  `MENU_ID` bigint(12) NOT NULL COMMENT '菜单id',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `DELETED` char(2) NOT NULL DEFAULT '0' COMMENT '删除状态0未删除 1已删除',
  `CAEATOR` bigint(12) NOT NULL COMMENT '操作人id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色全系关系表';

-- ----------------------------
-- Records of ea_admin_role_permission_ref
-- ----------------------------
INSERT INTO `ea_admin_role_permission_ref` VALUES ('4', '4', '2018-12-26 11:37:15', '2018-12-26 11:37:15', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('4', '5', '2018-12-26 11:37:15', '2018-12-26 11:37:15', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('4', '6', '2018-12-26 11:37:15', '2018-12-26 11:37:15', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('5', '4', '2018-12-26 11:42:03', '2018-12-26 11:42:03', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('5', '5', '2018-12-26 11:42:03', '2018-12-26 11:42:03', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('5', '6', '2018-12-26 11:42:03', '2018-12-26 11:42:03', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('7', '4', '2018-12-26 11:45:29', '2018-12-26 11:45:29', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('7', '5', '2018-12-26 11:45:29', '2018-12-26 11:45:29', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('7', '6', '2018-12-26 11:45:29', '2018-12-26 11:45:29', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('8', '4', '2018-12-26 11:46:59', '2018-12-26 11:46:59', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('8', '5', '2018-12-26 11:46:59', '2018-12-26 11:46:59', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('8', '6', '2018-12-26 11:46:59', '2018-12-26 11:46:59', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('9', '4', '2018-12-26 11:47:51', '2018-12-26 11:47:51', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('9', '5', '2018-12-26 11:47:51', '2018-12-26 11:47:51', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('9', '6', '2018-12-26 11:47:51', '2018-12-26 11:47:51', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('10', '4', '2018-12-26 11:49:00', '2018-12-26 11:49:00', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('10', '5', '2018-12-26 11:49:00', '2018-12-26 11:49:00', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('10', '6', '2018-12-26 11:49:00', '2018-12-26 11:49:00', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('11', '4', '2018-12-26 11:49:10', '2018-12-26 11:49:10', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('11', '5', '2018-12-26 11:49:10', '2018-12-26 11:49:10', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('11', '6', '2018-12-26 11:49:10', '2018-12-26 11:49:10', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('12', '4', '2018-12-26 11:51:16', '2018-12-26 11:51:16', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('12', '5', '2018-12-26 11:51:16', '2018-12-26 11:51:16', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('12', '6', '2018-12-26 11:51:16', '2018-12-26 11:51:16', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('13', '4', '2018-12-26 13:17:16', '2018-12-26 13:17:16', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('13', '5', '2018-12-26 13:17:16', '2018-12-26 13:17:16', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('13', '6', '2018-12-26 13:17:16', '2018-12-26 13:17:16', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('14', '4', '2018-12-26 15:44:21', '2018-12-26 15:44:21', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('14', '6', '2018-12-26 15:44:21', '2018-12-26 15:44:21', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('14', '4', '2018-12-26 16:08:25', '2018-12-26 16:08:25', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('14', '5', '2018-12-26 16:08:25', '2018-12-26 16:08:25', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('14', '6', '2018-12-26 16:08:25', '2018-12-26 16:08:25', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('15', '4', '2018-12-26 16:09:53', '2018-12-26 16:09:53', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('15', '4', '2018-12-26 16:10:03', '2018-12-26 16:10:03', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('15', '5', '2018-12-26 16:10:03', '2018-12-26 16:10:03', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('15', '4', '2018-12-26 16:13:08', '2018-12-26 16:13:08', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('15', '5', '2018-12-26 16:13:08', '2018-12-26 16:13:08', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('15', '6', '2018-12-26 16:13:08', '2018-12-26 16:13:08', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('15', '4', '2018-12-26 16:13:59', '2018-12-26 16:13:59', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('15', '6', '2018-12-26 16:13:59', '2018-12-26 16:13:59', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('13', '4', '2018-12-26 16:23:54', '2018-12-26 16:23:54', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('13', '6', '2018-12-26 16:23:54', '2018-12-26 16:23:54', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('13', '4', '2018-12-26 16:24:02', '2018-12-26 16:24:02', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('13', '5', '2018-12-26 16:24:02', '2018-12-26 16:24:02', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('13', '6', '2018-12-26 16:24:02', '2018-12-26 16:24:02', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('16', '4', '2018-12-26 16:24:50', '2018-12-26 16:24:50', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('16', '5', '2018-12-26 16:24:50', '2018-12-26 16:24:50', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('16', '6', '2018-12-26 16:24:50', '2018-12-26 16:24:50', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '0', '0');

-- ----------------------------
-- Table structure for ea_admin_staff
-- ----------------------------
DROP TABLE IF EXISTS `ea_admin_staff`;
CREATE TABLE `ea_admin_staff` (
  `STAFF_ID` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `STAFF_NAME` varchar(12) NOT NULL COMMENT '员工姓名',
  `PARENT_ID` bigint(12) NOT NULL COMMENT '上级id',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `DELETED` varchar(2) NOT NULL DEFAULT '0' COMMENT '删除状态 ：0未删除 1已删除',
  PRIMARY KEY (`STAFF_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of ea_admin_staff
-- ----------------------------
INSERT INTO `ea_admin_staff` VALUES ('2', '张三', '1', '2018-12-24 10:08:35', '2018-12-24 10:08:35', '0');
INSERT INTO `ea_admin_staff` VALUES ('3', '12', '1', '2018-12-25 17:02:20', '2018-12-25 17:02:20', '0');
INSERT INTO `ea_admin_staff` VALUES ('4', 'user', '2', '2018-12-28 15:35:46', '2018-12-28 15:35:46', '0');

-- ----------------------------
-- Table structure for ea_admin_staff_role_ref
-- ----------------------------
DROP TABLE IF EXISTS `ea_admin_staff_role_ref`;
CREATE TABLE `ea_admin_staff_role_ref` (
  `ROLE_ID` bigint(12) NOT NULL COMMENT '角色id',
  `STAFF_ID` bigint(12) NOT NULL COMMENT '员工id',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime NOT NULL COMMENT '更新时间',
  `CREATOR` bigint(12) NOT NULL COMMENT '操作人id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工-角色关系表';

-- ----------------------------
-- Records of ea_admin_staff_role_ref
-- ----------------------------
INSERT INTO `ea_admin_staff_role_ref` VALUES ('2', '1', '2018-12-20 16:20:11', '2018-12-20 16:20:13', '123');
INSERT INTO `ea_admin_staff_role_ref` VALUES ('1', '2', '2018-12-24 10:08:35', '2018-12-24 10:08:35', '0');
INSERT INTO `ea_admin_staff_role_ref` VALUES ('2', '3', '2018-12-25 17:02:20', '2018-12-25 17:02:29', '0');
INSERT INTO `ea_admin_staff_role_ref` VALUES ('1', '4', '2018-12-28 15:35:46', '2018-12-28 15:35:57', '0');
