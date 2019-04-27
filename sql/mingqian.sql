/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : mingqian

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2019-04-27 16:56:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ea_admin_account`
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='管理员账户表';

-- ----------------------------
-- Records of ea_admin_account
-- ----------------------------
INSERT INTO `ea_admin_account` VALUES ('1', 'admin', '21232F297A57A5A743894A0E4A801FC3', '鸣谦', 'ydy465258@16.com', '1001', '2018-12-20 16:08:33', '2018-12-20 16:08:35', '1');
INSERT INTO `ea_admin_account` VALUES ('5', 'zhangsanfeng', '202CB962AC59075B964B07152D234B70', '张三疯', '123456789@163.com', null, '2018-12-30 20:24:06', '2018-12-30 20:24:06', '0');
INSERT INTO `ea_admin_account` VALUES ('6', 'mingqian', '21232F297A57A5A743894A0E4A801FC3', '鸣谦', 'minqian@163.com', null, '2018-12-30 20:55:47', '2018-12-30 20:55:47', '1');
INSERT INTO `ea_admin_account` VALUES ('7', 'zhangsanfeng', '4C31F5E3B63F700927E4751E0534686B', '张三疯', 'zhangsanfeng@163.com', null, '2018-12-30 21:27:52', '2018-12-30 21:27:52', '1');

-- ----------------------------
-- Table structure for `ea_admin_department`
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of ea_admin_department
-- ----------------------------
INSERT INTO `ea_admin_department` VALUES ('1', '技术开发部', 'java', '2018-12-24 09:58:04', '2018-12-24 09:58:04', '0', '0');
INSERT INTO `ea_admin_department` VALUES ('2', '建筑', 'cad', '2018-12-24 09:58:39', '2018-12-24 09:58:39', '1', '0');
INSERT INTO `ea_admin_department` VALUES ('3', '财务admin', '会计', '2018-12-24 10:00:12', '2018-12-24 10:00:12', '1', '0');
INSERT INTO `ea_admin_department` VALUES ('4', 'test', 'test', '2018-12-25 17:01:37', '2018-12-25 17:01:37', '1', '0');
INSERT INTO `ea_admin_department` VALUES ('5', '人力资源部', '人力资源部', '2018-12-30 20:26:06', '2018-12-30 20:26:06', '0', '0');
INSERT INTO `ea_admin_department` VALUES ('6', '财务部', '财务部', '2018-12-30 20:26:15', '2018-12-30 20:26:15', '0', '0');
INSERT INTO `ea_admin_department` VALUES ('7', '产品部', '产品部', '2018-12-30 20:26:27', '2018-12-30 20:26:27', '0', '0');
INSERT INTO `ea_admin_department` VALUES ('8', '战略部', '战略部', '2018-12-30 20:26:41', '2018-12-30 20:26:41', '0', '0');
INSERT INTO `ea_admin_department` VALUES ('9', '运维部', '运维部', '2018-12-30 20:26:52', '2018-12-30 20:26:52', '0', '0');
INSERT INTO `ea_admin_department` VALUES ('10', '贸易部', '贸易部', '2018-12-30 20:27:00', '2018-12-30 20:27:00', '0', '0');

-- ----------------------------
-- Table structure for `ea_admin_menu_conf`
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='菜单配置表';

-- ----------------------------
-- Records of ea_admin_menu_conf
-- ----------------------------
INSERT INTO `ea_admin_menu_conf` VALUES ('1', '平台管理', '平台管理', null, '0', '2018-12-25 09:47:34', '2018-12-25 09:47:36', '0', '0', 'fa-cog', '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('2', '商城管理', '商城管理', null, '0', '2018-12-25 09:48:33', '2018-12-25 09:48:35', '0', '0', 'fa-apple', '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('3', '会员管理', '会员管理', null, '0', '2018-12-25 09:48:59', '2018-12-25 09:49:01', '0', '0', 'fa-user', '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('4', '系统角色', '系统角色', '/adminRole/toList', '1', '2018-12-25 09:50:55', '2018-12-25 09:50:58', '0', '0', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('5', '添加角色', '添加角色', '/adminRole/toAddAdminRolePage', '1', '2018-12-25 09:52:01', '2018-12-25 09:52:04', '0', '0', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('6', '员工列表', '员工列表', '/adminAccount/toList', '1', '2018-12-25 09:53:11', '2018-12-25 09:53:14', '0', '0', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('7', '会员列表', null, '/user/userList', '3', '2018-12-27 11:47:43', '2018-12-27 11:47:43', '0', '1', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('8', '查看用户信息', null, '/user/userInfo', '3', '2018-12-27 11:50:38', '2018-12-27 11:50:38', '1', '1', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('9', '会员信息展示', null, '/user/userInfo', '3', '2018-12-27 15:20:27', '2018-12-27 15:20:27', '0', '1', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('10', '菜单管理', null, '/adminMenuConf/toList', '1', '2018-12-30 00:59:25', '2018-12-30 00:59:25', '0', '1', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('11', '部门列表', null, '/department/toList', '1', '2018-12-30 01:46:34', '2018-12-30 01:46:34', '0', '1', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('12', '角色编辑', null, '/adminRole/toEditAdminRolePermissionPage', '1', '2018-12-30 12:57:41', '2018-12-30 12:57:41', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('13', '员工编辑', null, '/adminAccount/toEditAdminAccountPage', '1', '2018-12-30 12:58:29', '2018-12-30 12:58:29', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('14', '添加部门', null, '/department/toAdd', '1', '2018-12-30 12:59:26', '2018-12-30 12:59:26', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('15', '部门编辑', null, '/department/toEditDepartmentPage/', '1', '2018-12-30 12:59:59', '2018-12-30 12:59:59', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('16', '部门删除', null, '/department/deleteDepartment', '1', '2018-12-30 13:01:24', '2018-12-30 13:01:24', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('17', '添加子菜单', null, '/adminMenuConf/addAdminMenuConf', '1', '2018-12-30 20:11:34', '2018-12-30 20:11:34', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('18', '编辑菜单', null, '/adminMenuConf/editAdminMenuConf', '1', '2018-12-30 20:12:07', '2018-12-30 20:12:07', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('19', '删除子菜单', null, '/adminMenuConf/deleteAdminMenuConf', '1', '2018-12-30 20:12:29', '2018-12-30 20:12:29', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('20', '添加员工', null, '/adminAccount/addAdminAccount', '1', '2018-12-30 20:13:49', '2018-12-30 20:13:49', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('21', '编辑员工', null, '/adminAccount/toEditAdminAccountPage', '1', '2018-12-30 20:14:53', '2018-12-30 20:14:53', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('22', '删除员工', null, '/adminAccount/deleteAdminAccount', '1', '2018-12-30 20:15:24', '2018-12-30 20:15:24', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('23', '重置员工密码', null, '/adminAccount/resetPwd', '1', '2018-12-30 20:15:53', '2018-12-30 20:15:53', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('24', '查看权限', null, '/adminRole/showRolePermission', '1', '2018-12-30 20:18:29', '2018-12-30 20:18:29', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('25', '删除角色', null, '/adminRole/deleteAdminRole', '1', '2018-12-30 20:19:21', '2018-12-30 20:19:21', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('26', '角色保存', null, '/adminRole/addAdminRole', '1', '2018-12-30 20:28:35', '2018-12-30 20:28:35', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('27', '角色权限编辑', null, '/adminRole/toEditAdminRolePermissionPage', '1', '2018-12-30 20:32:44', '2018-12-30 20:32:44', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('28', '角色授权', null, '/adminRole/editAdminRole', '1', '2018-12-30 20:36:15', '2018-12-30 20:36:15', '0', '1', null, '0');
INSERT INTO `ea_admin_menu_conf` VALUES ('30', '商城管理', '商城管理', null, '0', '2019-01-01 18:09:22', '2019-01-01 18:09:24', '0', '0', 'fa-apple', '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('31', '商品分类', null, '/goodsCategory/toList', '30', '2019-01-01 18:12:28', '2019-01-01 18:12:28', '0', '1', null, '1');
INSERT INTO `ea_admin_menu_conf` VALUES ('32', '商品列表', null, '/goots/toList', '30', '2019-01-01 18:13:25', '2019-01-01 18:13:25', '0', '1', null, '1');

-- ----------------------------
-- Table structure for `ea_admin_role`
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='员工角色表';

-- ----------------------------
-- Records of ea_admin_role
-- ----------------------------
INSERT INTO `ea_admin_role` VALUES ('1', '超级管理员', '超级管理员', '2018-12-24 10:07:51', '2018-12-24 10:07:53', '1');
INSERT INTO `ea_admin_role` VALUES ('18', '技术开发', '技术开发', '2018-12-30 20:22:11', '2018-12-30 20:07:09', '0');
INSERT INTO `ea_admin_role` VALUES ('19', '技术开发', '技术开发', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '1');
INSERT INTO `ea_admin_role` VALUES ('20', '测试人员', '测试人员', '2018-12-30 20:54:49', '2018-12-30 20:54:49', '1');

-- ----------------------------
-- Table structure for `ea_admin_role_permission_ref`
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
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-28 15:36:15', '2018-12-28 15:36:15', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-30 00:59:40', '2018-12-30 00:59:40', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-30 00:59:40', '2018-12-30 00:59:40', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-30 00:59:40', '2018-12-30 00:59:40', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2018-12-30 00:59:40', '2018-12-30 00:59:40', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-30 00:59:40', '2018-12-30 00:59:40', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-30 00:59:40', '2018-12-30 00:59:40', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-30 01:47:45', '2018-12-30 01:47:45', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-30 01:47:45', '2018-12-30 01:47:45', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-30 01:47:45', '2018-12-30 01:47:45', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2018-12-30 01:47:45', '2018-12-30 01:47:45', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '11', '2018-12-30 01:47:45', '2018-12-30 01:47:45', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-30 01:47:45', '2018-12-30 01:47:45', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-30 01:47:45', '2018-12-30 01:47:45', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '11', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '12', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '13', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '14', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '15', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-30 18:02:20', '2018-12-30 18:02:20', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '11', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '12', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '13', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '14', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '15', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '16', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-30 20:05:37', '2018-12-30 20:05:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '11', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '12', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '13', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '14', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '15', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '16', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '17', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '18', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '19', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '20', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '21', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '22', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '23', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '24', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '25', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-30 20:19:56', '2018-12-30 20:19:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '11', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '12', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '13', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '14', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '15', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '16', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '17', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '18', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '19', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '20', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '21', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '22', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '23', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '24', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '25', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '26', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-30 20:29:12', '2018-12-30 20:29:12', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '28', '2018-12-30 20:36:54', '2018-12-30 20:36:56', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '11', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '12', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '13', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '14', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '15', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '16', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '17', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '18', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '19', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '20', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '21', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '22', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '23', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '24', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '25', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '26', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '27', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '28', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-30 20:37:14', '2018-12-30 20:37:14', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '11', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '12', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '13', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '14', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '15', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '16', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '17', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '18', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '19', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '20', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '21', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '22', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '23', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '24', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '25', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '26', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '27', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '28', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2018-12-30 20:37:35', '2018-12-30 20:37:35', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '4', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '5', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '6', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '10', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '11', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '12', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '13', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '14', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '15', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '16', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '17', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '18', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '19', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '20', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '21', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '22', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '23', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '24', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '25', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '26', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '27', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '28', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '7', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('19', '9', '2018-12-30 20:53:40', '2018-12-30 20:53:40', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '4', '2018-12-30 20:54:49', '2018-12-30 20:54:49', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '6', '2018-12-30 20:54:49', '2018-12-30 20:54:49', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '10', '2018-12-30 20:54:49', '2018-12-30 20:54:49', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '11', '2018-12-30 20:54:49', '2018-12-30 20:54:49', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '7', '2018-12-30 20:54:49', '2018-12-30 20:54:49', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '4', '2018-12-30 21:24:32', '2018-12-30 21:24:32', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '6', '2018-12-30 21:24:32', '2018-12-30 21:24:32', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '10', '2018-12-30 21:24:32', '2018-12-30 21:24:32', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '11', '2018-12-30 21:24:32', '2018-12-30 21:24:32', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('20', '7', '2018-12-30 21:24:32', '2018-12-30 21:24:32', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '11', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '12', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '13', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '14', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '15', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '16', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '17', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '18', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '19', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '20', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '21', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '22', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '23', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '24', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '25', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '26', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '27', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '28', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2019-01-01 16:29:37', '2019-01-01 16:29:37', '1', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '4', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '5', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '6', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '10', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '11', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '12', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '13', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '14', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '15', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '16', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '17', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '18', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '19', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '20', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '21', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '22', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '23', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '24', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '25', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '26', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '27', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '28', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '7', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '9', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '31', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');
INSERT INTO `ea_admin_role_permission_ref` VALUES ('1', '32', '2019-01-01 18:13:55', '2019-01-01 18:13:55', '0', '0');

-- ----------------------------
-- Table structure for `ea_admin_staff`
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of ea_admin_staff
-- ----------------------------
INSERT INTO `ea_admin_staff` VALUES ('1', 'admin', '1', '2018-12-30 20:40:27', '2018-12-30 20:40:30', '0');
INSERT INTO `ea_admin_staff` VALUES ('2', '张三', '1', '2018-12-24 10:08:35', '2018-12-24 10:08:35', '0');
INSERT INTO `ea_admin_staff` VALUES ('5', '张三疯', '1', '2018-12-30 20:24:06', '2018-12-30 20:24:06', '0');
INSERT INTO `ea_admin_staff` VALUES ('6', '鸣谦', '1', '2018-12-30 20:55:47', '2018-12-30 20:55:47', '0');
INSERT INTO `ea_admin_staff` VALUES ('7', '张三疯', '6', '2018-12-30 21:27:52', '2018-12-30 21:27:52', '0');

-- ----------------------------
-- Table structure for `ea_admin_staff_role_ref`
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
INSERT INTO `ea_admin_staff_role_ref` VALUES ('1', '1', '2018-12-20 16:20:11', '2018-12-20 16:20:13', '123');
INSERT INTO `ea_admin_staff_role_ref` VALUES ('1', '2', '2018-12-24 10:08:35', '2018-12-24 10:08:35', '0');
INSERT INTO `ea_admin_staff_role_ref` VALUES ('2', '3', '2018-12-25 17:02:20', '2018-12-25 17:02:29', '0');
INSERT INTO `ea_admin_staff_role_ref` VALUES ('18', '4', '2018-12-28 15:35:46', '2018-12-30 20:07:25', '0');
INSERT INTO `ea_admin_staff_role_ref` VALUES ('1', '5', '2018-12-30 20:24:06', '2018-12-30 20:24:06', '0');
INSERT INTO `ea_admin_staff_role_ref` VALUES ('20', '6', '2018-12-30 20:55:47', '2018-12-30 20:55:47', '0');
INSERT INTO `ea_admin_staff_role_ref` VALUES ('19', '7', '2018-12-30 21:27:52', '2018-12-30 21:27:52', '0');

-- ----------------------------
-- Table structure for `ec_mall_user`
-- ----------------------------
DROP TABLE IF EXISTS `ec_mall_user`;
CREATE TABLE `ec_mall_user` (
  `ID` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名',
  `USER_CARD` varchar(19) DEFAULT NULL COMMENT '用户身份证',
  `USER_MOBILE` varchar(11) DEFAULT NULL COMMENT '用户手机哈',
  `USER_ADDRESS` varchar(50) DEFAULT NULL COMMENT '用户住址',
  `USER_SCHOOL` varchar(20) DEFAULT NULL COMMENT '用户学校',
  `USER_SPECIALTY` varchar(20) DEFAULT NULL COMMENT '用户专业',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETED` char(2) DEFAULT NULL COMMENT '删除状态 0未删除 1已删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=267 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_mall_user
-- ----------------------------
INSERT INTO `ec_mall_user` VALUES ('1', '安惠敏', '130728199712060023', null, '河北省怀安县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('2', '安萍', '130221199709112724', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('3', '白玲', '130683199809114621', null, '河北省安国市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('4', '白昕', '130733199710190044', null, '河北省崇礼县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('5', '毕欣爽', '130229199804083029', null, '河北省玉田县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('6', '蔡静双', '130729199708190024', null, '河北省万全县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('7', '曹文静', '130726199809012826', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('8', '曹亚宁', '130725199808071027', null, '河北省尚义县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('9', '柴秀平', '130131199902100626', null, '河北省平山县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('10', '常欢', '130133199901160064', null, '河北省赵县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('11', '陈利月', '130726199709163926', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('12', '陈筛', '522323199512144426', null, '贵州省普安县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('13', '陈秀敏', '130728199810022522', null, '河北省怀安县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('14', '陈月美', '130730199711185424', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('15', '程晓甜', '130732199901181224', null, '河北省赤城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('16', '代宇微', '130637199811161226', null, '河北省博野县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('17', '董佳琪', '13028319980119408X', null, '河北省迁安市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('18', '董平乐', '520202199710223062', null, '贵州省盘县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('19', '董如意', '130221199710303923', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('20', '董瑶', '130206199805060326', null, '河北省唐山市市辖区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('21', '杜春连', '130633199805305267', null, '河北省易县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('22', '杜雨茜', '130633199904163129', null, '河北省易县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('23', '段姣姣', '622827199307293525', null, '甘肃省镇原县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('24', '樊玉敏', '130722199808263847', null, '河北省张北县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('25', '范建欣', '130721199903314626', null, '河北省宣化县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('26', '冯佳雨', '130203199804200324', null, '河北省唐山市路北区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('27', '付琳琳', '232103199612060929', null, '河北省唐山市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('28', '高彬', '130125199906107545', null, '河北省行唐县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('29', '高洪菲', '130221199709213445', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('30', '高娇', '130225199712220027', null, '河北省乐亭县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('31', '高敏', '130728199712142520', null, '河北省怀安县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('32', '高婷婷', '14112319971130002X', null, '山西省兴县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('33', '左海芬', '13072419970918082X', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('34', '朱志艳', '130723199610304523', null, '河北省康保县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('35', '高振慧', '130729199606022548', null, '河北省万全县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('36', '葛冀敏', '130724199511053825', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('37', '葛希卓', '130726199811156925', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('38', '朱琳', '130702199705262125', null, '河北省张家口市桥东区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('39', '朱佳美', '130221199709112767', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('40', '周瑜蒙', '130622199906212028', null, '河北省清苑县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('41', '周影', '513433199808263122', null, '四川省冕宁县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('42', '谷秋月', '130225199709021924', null, '河北省乐亭县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('43', '周世佳', '130133199710192426', null, '河北省赵县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('44', '郭佳慧', '140225199805041820', null, '山西省浑源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('45', '周珺珺', '130726199706060446', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('46', '智月', '130131199806233920', null, '河北省平山县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('47', '郑海燕', '130728199807082524', null, '河北省怀安县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('48', '赵昭慧', '62242119970929132X', null, '甘肃省定西市市辖区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('49', '赵月星阁', '130705199807160321', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('50', '赵宇洋', '130205199806034529', null, '河北省唐山市开平区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('51', '赵雅芳', '130927199809094224', null, '河北省南皮县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('52', '赵芯雅', '130927199809094224', null, '河北省南皮县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('53', '赵芯雅', '13020319971119122X', null, '河北省唐山市路北区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('54', '赵晓瑞', '130522199710300821', null, '河北省临城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('55', '赵文璐', '152530199603300020', null, '河北省张家口市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('56', '赵珊', '130221199711033929', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('57', '赵蕊', '130633199810101920', null, '河北省易县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('58', '赵宏霄', '130481199711091966', null, '河北省武安市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('59', '赵桂枝', '130927199611282123', null, '河北省南皮县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('60', '赵桂先', '130633199809153563', null, '河北省易县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('61', '张卓', '130221199708062729', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('62', '张志新', '130730199803255223', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('63', '张雨', '130221199804235925', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('64', '张燕', '130726199711083925', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('65', '张彦慧', '13073219971025294X', null, '河北省赤城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('66', '张亚云', '130634199810050963', null, '河北省曲阳县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('67', '张雅楠', '131028199704206822', null, '河北省大厂回族自治县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('68', '张秀珍', '130723199903151225', null, '河北省康保县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('69', '张星雨', '140221199607021823', null, '河北省阳原县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('70', '张心莹', '130221199807110044', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('71', '张晓雨', '130722199812226328', null, '河北省张北县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('72', '张晓霞', '130722199711121121', null, '河北省张北县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('73', '张晓庆', '13072819991002252X', null, '河北省怀安县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('74', '张文宇', '130221199812034146', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('75', '张文静', '130726199711130023', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('76', '张伟璇', '130124199612300028', null, '河北省栾城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('77', '张秋颖', '131102199810300224', null, '河北省衡水市桃城区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('78', '张茜', '130722199611201124', null, '河北省张北县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('79', '张琦', '130733199707040045', null, '河北省崇礼县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('80', '张梦钰', '130627199906150623', null, '河北省唐县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('81', '张美玉', '130622199811166620', null, '河北省清苑县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('82', '张美', '130634199702023327', null, '河北省曲阳县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('83', '张丽媛', '130229199705020022', null, '河北省玉田县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('84', '张黎冉', '130730199712265426', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('85', '张晗', '41022119970614084X', null, '新疆布尔津县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('86', '刑葱慧', '41272119940414262X', null, '新疆阿克苏市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('87', '邬丽飞', '142229199808064320', null, '山西省神池县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('88', '王晓玲', '140621199603016420', null, '山西省山阴县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('89', '杨倩', '14018119960110184X', null, '山西省古交市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('90', '张宏伟', '13073119970720094X', null, '河北省涿鹿县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('91', '许小婧', '130731199804265649', null, '河北省涿鹿县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('92', '徐亚楠', '130704199805050325', null, '河北省涿鹿县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('93', '王宇', '130731199902150028', null, '河北省涿鹿县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('94', '张金秋', '15252719981017302X', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('95', '魏嘉玮', '130705199708280627', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('96', '王子彦', '130705199812252423', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('97', '邢凯乐', '130706199710090327', null, '河北省张家口市下花园区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('98', '姚倩倩', '130703199710300022', null, '河北省张家口市桥西区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('99', '闫之未', '130703199901190321', null, '河北省张家口市桥西区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('100', '武翠英', '130703199607272422', null, '河北省张家口市桥西区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('101', '张笛', '130702199705250941', null, '河北省张家口市桥东区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('102', '温佳琪', '130702199602182122', null, '河北省张家口市桥东区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('103', '武佳惠', '152527199808300923', null, '河北省张家口市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('104', '袁玉琴', '130722199802175125', null, '河北省张北县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('105', '杨贤茹', '130722199902192520', null, '河北省张北县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('106', '王一铭', '130722199612143026', null, '河北省张北县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('107', '袁梦伟', '130633199911046027', null, '河北省易县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('109', '岳慧芳', '130721199712194641', null, '河北省宣化县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('110', '张慧敏', '130726199710120026', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('111', '张海珍', '130726199809122523', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('112', '邢鸥', '130726199802110044', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('113', '武涛', '130726199706240068', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('114', '张海波', '130726199712070747', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('115', '吴奎仪', '130206199805142321', null, '河北省唐山市市辖区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('116', '王莹', '130206199809010924', null, '河北省唐山市市辖区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('117', '闫婧瑶', '130202199712170627', null, '河北省唐山市路南区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('118', '张宏伟', '130204199808050921', null, '河北省唐山市古冶区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('119', '王悦', '130204199806215120', null, '河北省唐山市古冶区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('120', '姚敬娴', '130221199706260027', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('121', '吴雪争', '130221199805312320', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('122', '王雨欣', '130208199806253229', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('123', '王艺璇', '130221199803126524', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('124', '吴程程', '231182199712315620', null, '河北省唐山市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('125', '魏雨晴', '130283199810275666', null, '河北省迁安市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('126', '许晓蕊', '130927199807180321', null, '河北省南皮县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('127', '翟哲静', '130124199610200920', null, '河北省栾城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('128', '吴春辉', '130225199604207423', null, '河北省乐亭县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('129', '薛亚丽', '130723199508040023', null, '河北省康保县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('130', '王颖', '130730199801094243', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('131', '杨海苹', '130728199710156021', null, '河北省怀安县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('132', '王亚平', '130728199904307027', null, '河北省怀安县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('133', '杨忠秋', '131126199710294825', null, '河北省故城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('134', '张静', '152527199604283324', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('135', '闫静茹', '130724199901270024', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('136', '薛艳华', '130724199508141146', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('137', '王泽庆', '130724199708104120', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('138', '杨环环', '130923199709140523', null, '河北省东光县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('139', '闫晓月', '130732199802012628', null, '河北省赤城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('140', '王文倩', '130124199706290043', null, '河北省栾城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('141', '王卫欣', '130221199802215322', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('142', '王硕', '130125199710218526', null, '河北省行唐县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('143', '王茜晨', '130221199804224126', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('144', '王妙一', '130724199511073826', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('145', '黄章莉', '511524199707272289', null, '新疆巴楚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('146', '韩小红', '62302319930525222X', null, '甘肃省舟曲县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('147', '何珊', '522227199609216465', null, '贵州省德江县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('148', '王芳芳', '522601199506154829', null, '贵州省凯里市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('149', '李玉', '130683199808311041', null, '河北省安国市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('150', '王菲', '130683199811085321', null, '河北省安国市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('151', '李鑫鑫', '13092119990826282X', null, '河北省沧县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('152', '孟嘉', '130322199704272026', null, '河北省昌黎县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('153', '李艳慧', '130821199511010020', null, '河北省承德县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('154', '李寒雪', '130732199801070025', null, '河北省赤城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('155', '李颖婕', '130732199703281224', null, '河北省赤城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('156', '荣雪洁', '130732199603090500', null, '河北省赤城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('157', '田文丽', '130732199609101223', null, '河北省赤城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('158', '韩月', '13073319960515042X', null, '河北省崇礼县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('159', '侯晓娇', '130733199804290425', null, '河北省崇礼县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('160', '林琳', '220182199806051328', null, '河北省大厂回族自治县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('161', '米乐', '130425199611300029', null, '河北省大名县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('162', '郭晓柯', '130428199807170069', null, '河北省肥乡县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('163', '李海明', '132627199701070023', null, '河北省丰宁满族自治县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('164', '刘孟迪', '130684199612225463', null, '河北省高碑店市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('165', '郭云霞', '130724199602114427', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('166', '贺美燕', '130724200005184123', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('167', '任彩月', '130724199902283126', null, '河北省沽源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('168', '胡露露', '131126199902090325', null, '河北省故城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('169', '胡茹玉', '131126199810142124', null, '河北省故城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('170', '刘金花', '131126199805152125', null, '河北省故城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('171', '刘娜', '131126199902083029', null, '河北省故城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('172', '刘亚琪', '131126199808260623', null, '河北省故城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('173', '米欣月', '131126199801160961', null, '河北省故城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('174', '沈燕', '500238199704130022', null, '河北省故城县 ', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('175', '李国荣', '130728199805017024', null, '河北省怀安县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('176', '侯玉茹', '130730199812191823', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('177', '李琪', '13073019971216342X', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('178', '李蕊', '130730199704105422', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('179', '刘冉', '130730200002021828', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('180', '庞靖怡', '13073019981220222X', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('181', '庞俊颜', '130730199811231424', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('182', '王贝贝', '130730199810212627', null, '河北省怀来县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('183', '韩梦迪', '130983199712013927', null, '河北省黄骅市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('184', '田鑫', '132930199709193321', null, '河北省黄骅市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('185', '贺晓丽', '130723199508013025', null, '河北省康保县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('186', '韩江涛', '130630199809204819', null, '河北省涞源县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('187', '刘蕾', '130225199802071942', null, '河北省乐亭县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('188', '刘垚', '130225199712237427', null, '河北省乐亭县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('189', '马静凡', '130225199801143326', null, '河北省乐亭县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('190', '牛浩林', '130225199709032922', null, '河北省乐亭县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('191', '史爽', '130225199707211927', null, '河北省乐亭县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('192', '王丹', '130225199808230027', null, '河北省乐亭县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('193', '李欣然', '130126199901060924', null, '河北省灵寿县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('194', '李香凝', '130223199808286140', null, '河北省滦县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('195', '刘晴', '130223199810124028', null, '河北省滦县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('196', '任华宁', '130581199802160424', null, '河北省南宫市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('197', '刘焕然', '130927199610220182', null, '河北省南皮县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('198', '陶婷婷', '130927199810112127', null, '河北省南皮县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('199', '李盼盼', '132624199606195769', null, '河北省平泉县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('200', '司佳琪', '130823199804140024', null, '河北省平泉县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('201', '靳晓旭', '13013119980307002X', null, '河北省平山县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('202', '刘少锟', '130131199710180027', null, '河北省平山县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('203', '齐玥', '130131199901110101', null, '河北省平山县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('204', '孙亚琪', '130131199902010065', null, '河北省平山县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('205', '郭佳昕', '130283199712263362', null, '河北省迁安市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('206', '郭涛', '130283199811040623', null, '河北省迁安市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('207', '韩天姿', '130283199710136060', null, '河北省迁安市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('208', '马叶秋', '13052619971012582X', null, '河北省任县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('209', '刘梦雨', '130629199807010425', null, '河北省容城县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('210', '李月皓', '130725199805020662', null, '河北省尚义县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('211', '韩颖', '230124199901257648', null, '河北省唐山市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('212', '梁媛', '622727199806125942', null, '河北省唐山市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('213', '李佳慧', '130282199703034043', null, '河北省唐山市丰南区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('214', '李雪梅', '130282199706095124', null, '河北省唐山市丰南区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('215', '李姗姗', '130221199801120081', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('216', '李欣', '130221199711037620', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('217', '李雅丽', '13022119980525006X', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('218', '李雅萍', '130221199803306365', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('219', '吕婷', '130221199707035921', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('220', '穆瑞雪', '130221199711273420', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('221', '史心雨', '130221199806070044', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('222', '孙亚男', '130221199712041621', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('223', '王兵', '130221199807083429', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('224', '王佳琦', '130221199701020067', null, '河北省唐山市丰润区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('225', '霍瑞芬', '239005199802060747', null, '河北省唐山市丰润区  ', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('226', '韩烨', '130204199804103328', null, '河北省唐山市古冶区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('227', '乔子书', '130204199803231547', null, '河北省唐山市古冶区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('228', '贾鑫悦', '130203199812245143', null, '河北省唐山市路北区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('229', '贾圆一', '130206199707020929', null, '河北省唐山市市辖区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('230', '李亚涛', '130627199804210621', null, '河北省唐县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('231', '郭晓丽', '13072919980522162X', null, '河北省万全县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('232', '李芳甜', '130729199808121624', null, '河北省万全县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('233', '李丹琪', '130726199808240042', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('234', '李梦琪', '130726199709060724', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('235', '刘宇琴', '130726199702220422', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('236', '卢雨萱', '130726199809176126', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('237', '宋亚男', '130726199911271947', null, '河北省蔚县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('238', '李雅祺', '130721199704032829', null, '河北省宣化县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('239', '田慧敏', '130721199902125129', null, '河北省宣化县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('240', '何晶晶', '140221199809037129', null, '河北省阳原县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('241', '龙红玉', '130633199807063222', null, '河北省易县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('242', '牛欢', '130633199711056829', null, '河北省易县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('243', '沈婧萱', '13072219960618602X', null, '河北省张北县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('244', '田亚茹', '152627199603083748', null, '河北省张家口市', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('245', '刘雯', '130702199609102121', null, '河北省张家口市桥东区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('246', '庞慧敏', '130702199801182125', null, '河北省张家口市桥东区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('247', '帅星月', '130702199704060628', null, '河北省张家口市桥东区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('248', '胡月', '130703199707101524', null, '河北省张家口市桥西区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('249', '梁超', '130703199706061225', null, '河北省张家口市桥西区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('250', '苏怡', '13070319970923032X', null, '河北省张家口市桥西区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('251', '华文婕', '130705199902162448', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('252', '李芳', '130705199705111545', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('253', '李华蕊', '130705199811247227', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('254', '李琰', '130705199808050327', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('255', '王坤', '130705199706130924', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('256', '王丽媛', '130705199907300627', null, '河北省张家口市宣化区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('257', '米若冰', '130133199805133381', null, '河北省赵县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('258', '刘晓瑶', '14022319960619424X', null, '山西省广灵县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('259', '贾瑞', '142227199704181028', null, '山西省宁武县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('260', '刘鹏程', '142229199803113824', null, '山西省神池县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('261', '刘艳林', '142229199609073822', null, '山西省神池县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('262', '聂瑞鑫', '140927199708200026', null, '山西省神池县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('263', '李芥南', '130727199501050064', null, '山西省阳高县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('264', '李嫘', '140428199706208023', null, '山西省长子县', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('265', '彭秋艳', '510704199804272429', null, '四川省绵阳市游仙区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
INSERT INTO `ec_mall_user` VALUES ('266', '汪旭虹', '620502199401206840', null, '甘肃省天水市秦城区', '宣化科技职业学院', '学前教育', '2018-12-30 00:46:55', '2018-12-30 00:46:55', '0');
