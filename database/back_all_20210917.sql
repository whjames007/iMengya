/*
 Navicat Premium Data Transfer

 Source Server         : 20227
 Source Server Type    : MariaDB
 Source Server Version : 100309
 Source Host           : 192.168.20.227:23306
 Source Schema         : mengya

 Target Server Type    : MariaDB
 Target Server Version : 100309
 File Encoding         : 65001

 Date: 17/09/2021 08:53:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aaa_bbb_info
-- ----------------------------
DROP TABLE IF EXISTS `aaa_bbb_info`;
CREATE TABLE `aaa_bbb_info`  (
  `aaa_bbb_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模板主键',
  `aaa_bbb_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板类型',
  `aaa_bbb_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板名称',
  `first_create_by` int(11) NOT NULL DEFAULT 10 COMMENT '初始创建人员',
  `first_create_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '初始创建日期',
  `data_status_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'VALID' COMMENT '数据状态标识',
  `data_region_id` int(11) NOT NULL DEFAULT 0 COMMENT '数据区域ID',
  `data_change_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DCT10000' COMMENT '数据变化类型',
  `data_change_desc` varchar(900) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '数据变化描述' COMMENT '数据变化描述',
  `last_update_by` int(11) NOT NULL DEFAULT 10 COMMENT '最后修改人员',
  `last_update_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '最后修改日期',
  PRIMARY KEY (`aaa_bbb_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '过程定义模板信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_config_info
-- ----------------------------
DROP TABLE IF EXISTS `system_config_info`;
CREATE TABLE `system_config_info`  (
  `system_config_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `system_config_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数代码',
  `system_config_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类型',
  `system_config_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数名称',
  `system_config_integer` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '整数型参数',
  `system_config_decimal` double(10, 4) NULL DEFAULT NULL COMMENT '小数型参数',
  `system_config_string` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字符型参数',
  `system_config_datetime` datetime(0) NULL DEFAULT NULL COMMENT '日期型参数',
  `system_config_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数简介',
  `first_create_by` int(11) NOT NULL DEFAULT 10 COMMENT '初始创建人员',
  `first_create_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '初始创建日期',
  `data_status_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'VALID' COMMENT '数据状态标识',
  `data_region_id` int(11) NOT NULL DEFAULT 0 COMMENT '数据区域ID',
  `data_change_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DCT10000' COMMENT '数据变化类型',
  `data_change_desc` varchar(900) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '数据变化描述' COMMENT '数据变化描述',
  `last_update_by` int(11) NOT NULL DEFAULT 10 COMMENT '最后修改人员',
  `last_update_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '最后修改日期',
  PRIMARY KEY (`system_config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_cron_info
-- ----------------------------
DROP TABLE IF EXISTS `system_cron_info`;
CREATE TABLE `system_cron_info`  (
  `system_cron_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务主键',
  `system_cron_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务编码',
  `system_cron_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `system_cron_express` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '周期频率表达式',
  `running_time_last` datetime(0) NOT NULL COMMENT '本次运行时间',
  `system_switch_status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务运行开关',
  `running_time_next` datetime(0) NOT NULL COMMENT '下次运行时间',
  `system_cron_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务简介',
  `first_create_by` int(11) NOT NULL DEFAULT 10 COMMENT '初始创建人员',
  `first_create_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '初始创建日期',
  `data_status_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'VALID' COMMENT '数据状态标识',
  `data_region_id` int(11) NOT NULL DEFAULT 0 COMMENT '数据区域ID',
  `data_change_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DCT10000' COMMENT '数据变化类型',
  `data_change_desc` varchar(900) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '数据变化描述' COMMENT '数据变化描述',
  `last_update_by` int(11) NOT NULL DEFAULT 10 COMMENT '最后修改人员',
  `last_update_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '最后修改日期',
  PRIMARY KEY (`system_cron_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务周期表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `system_menu_info`;
CREATE TABLE `system_menu_info`  (
  `system_menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单主键',
  `system_menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `system_menu_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单类型【BRANCH=枝节点/LEAF=叶节点】',
  `system_menu_icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `system_menu_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单路由',
  `system_parent_id` int(11) NOT NULL COMMENT '上级主键',
  `system_menu_close` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单关闭开关【YES=允许/NO=禁止】',
  `system_menu_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单描述',
  `first_create_by` int(11) NOT NULL DEFAULT 10 COMMENT '初始创建人员',
  `first_create_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '初始创建日期',
  `data_status_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'VALID' COMMENT '数据状态标识',
  `data_region_id` int(11) NOT NULL DEFAULT 0 COMMENT '数据区域ID',
  `data_change_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DCT10000' COMMENT '数据变化类型',
  `data_change_desc` varchar(900) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '数据变化描述' COMMENT '数据变化描述',
  `last_update_by` int(11) NOT NULL DEFAULT 10 COMMENT '最后修改人员',
  `last_update_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '最后修改日期',
  PRIMARY KEY (`system_menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1001 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_menu_info
-- ----------------------------
INSERT INTO `system_menu_info` VALUES (1, '工作台', 'ROOT', 'el-icon-eleme', 'root', 0, 'NO', '菜单根节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:23:05');
INSERT INTO `system_menu_info` VALUES (10, '首页展示', 'BRANCH', 'el-icon-star-off', 'show', 1, 'NO', '菜单分支节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:25:47');
INSERT INTO `system_menu_info` VALUES (20, '萌萌队', 'BRANCH', 'el-icon-house', 'group', 1, 'NO', '菜单分支节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:25:16');
INSERT INTO `system_menu_info` VALUES (30, '心情笔记', 'BRANCH', 'el-icon-reading', 'goodtime', 1, 'NO', '菜单分支节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:36:21');
INSERT INTO `system_menu_info` VALUES (40, '系统报表', 'BRANCH', 'el-icon-data-analysis', 'report', 1, 'NO', '菜单分支节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:37:09');
INSERT INTO `system_menu_info` VALUES (90, '系统管理', 'BRANCH', 'el-icon-cpu', 'system', 1, 'NO', '菜单分支节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:27:26');
INSERT INTO `system_menu_info` VALUES (101, '系统简介', 'LEAF', 'el-icon-monitor', 'summary', 10, 'NO', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:33:55');
INSERT INTO `system_menu_info` VALUES (102, '待办事项', 'LEAF', 'el-icon-mouse', 'todo', 10, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:36:07');
INSERT INTO `system_menu_info` VALUES (103, '系统公告', 'LEAF', 'el-icon-c-scale-to-original', 'todo', 10, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:38:52');
INSERT INTO `system_menu_info` VALUES (104, '系统通知', 'LEAF', 'el-icon-tickets', 'summary34', 10, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:38:26');
INSERT INTO `system_menu_info` VALUES (201, '萌萌建立', 'LEAF', 'el-icon-finished', 'build', 20, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:46:28');
INSERT INTO `system_menu_info` VALUES (202, '芽芽加入', 'LEAF', 'el-icon-view', 'join', 20, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:47:25');
INSERT INTO `system_menu_info` VALUES (301, '萌芽大杂烩', 'LEAF', 'el-icon-video-camera', 'summary7', 30, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:48:04');
INSERT INTO `system_menu_info` VALUES (302, '萌芽小秘密', 'LEAF', 'el-icon-camera', 'summary8', 30, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:48:21');
INSERT INTO `system_menu_info` VALUES (401, '萌芽报表', 'LEAF', 'el-icon-data-line', 'summary55', 40, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:49:52');
INSERT INTO `system_menu_info` VALUES (402, '告警报表', 'LEAF', 'el-icon-pie-chart', 'summaryaa', 40, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:49:32');
INSERT INTO `system_menu_info` VALUES (901, '用户管理', 'LEAF', 'el-icon-user', 'user', 90, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:30:15');
INSERT INTO `system_menu_info` VALUES (902, '角色管理', 'LEAF', 'el-icon-aim', 'role', 90, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:31:11');
INSERT INTO `system_menu_info` VALUES (903, '菜单管理', 'LEAF', 'el-icon-paperclip', 'menu', 90, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:32:37');
INSERT INTO `system_menu_info` VALUES (904, '参数配置', 'LEAF', 'el-icon-wind-power', 'config', 90, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:32:57');
INSERT INTO `system_menu_info` VALUES (905, '定时任务', 'LEAF', 'el-icon-timer', 'cron', 90, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:33:11');
INSERT INTO `system_menu_info` VALUES (906, '意见反馈', 'LEAF', 'el-icon-sort', 'fankui', 90, 'YES', '菜单叶子节点', 10, '2021-09-14 11:08:36', 'VALID', 0, 'DCT10000', '修改菜单数据', 30, '2021-09-16 15:50:30');

-- ----------------------------
-- Table structure for system_role_info
-- ----------------------------
DROP TABLE IF EXISTS `system_role_info`;
CREATE TABLE `system_role_info`  (
  `system_role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `system_role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `system_role_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色代码',
  `system_role_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色简介',
  `first_create_by` int(11) NOT NULL DEFAULT 10 COMMENT '初始创建人员',
  `first_create_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '初始创建日期',
  `data_status_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'VALID' COMMENT '数据状态标识',
  `data_region_id` int(11) NOT NULL DEFAULT 0 COMMENT '数据区域ID',
  `data_change_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DCT10000' COMMENT '数据变化类型',
  `data_change_desc` varchar(900) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '数据变化描述' COMMENT '数据变化描述',
  `last_update_by` int(11) NOT NULL DEFAULT 10 COMMENT '最后修改人员',
  `last_update_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '最后修改日期',
  PRIMARY KEY (`system_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_role_info
-- ----------------------------
INSERT INTO `system_role_info` VALUES (10, 'aaaa', 'aa', 'aa', 10, '2021-09-14 11:05:29', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:05:29');
INSERT INTO `system_role_info` VALUES (20, 'aaaa', 'aa', 'aa', 10, '2021-09-14 11:05:29', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:05:29');
INSERT INTO `system_role_info` VALUES (30, 'aaaa', 'aa', 'aa', 10, '2021-09-14 11:05:29', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:05:29');
INSERT INTO `system_role_info` VALUES (40, 'aaaa', 'aa', 'aa', 10, '2021-09-14 11:05:29', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:05:29');

-- ----------------------------
-- Table structure for system_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `system_role_relation`;
CREATE TABLE `system_role_relation`  (
  `role_relation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关联主键',
  `system_role_id` int(11) NOT NULL COMMENT '角色主键',
  `system_menu_id` int(11) NOT NULL COMMENT '菜单主键',
  `first_create_by` int(11) NOT NULL DEFAULT 10 COMMENT '初始创建人员',
  `first_create_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '初始创建日期',
  `data_status_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'VALID' COMMENT '数据状态标识',
  `data_region_id` int(11) NOT NULL DEFAULT 0 COMMENT '数据区域ID',
  `data_change_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DCT10000' COMMENT '数据变化类型',
  `data_change_desc` varchar(900) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '数据变化描述' COMMENT '数据变化描述',
  `last_update_by` int(11) NOT NULL DEFAULT 10 COMMENT '最后修改人员',
  `last_update_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '最后修改日期',
  PRIMARY KEY (`role_relation_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_role_relation
-- ----------------------------
INSERT INTO `system_role_relation` VALUES (101, 10, 1, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (102, 10, 10, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (103, 10, 20, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (104, 10, 30, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (105, 10, 40, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (106, 10, 90, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (107, 10, 101, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (108, 10, 102, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (109, 10, 103, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (110, 10, 104, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (111, 10, 201, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (112, 10, 202, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (113, 10, 301, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (114, 10, 302, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (115, 10, 401, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (116, 10, 402, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (117, 10, 901, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (118, 10, 902, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (119, 10, 903, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (120, 10, 904, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (121, 10, 905, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');
INSERT INTO `system_role_relation` VALUES (122, 10, 906, 10, '2021-09-14 11:23:49', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 11:23:49');

-- ----------------------------
-- Table structure for system_user_info
-- ----------------------------
DROP TABLE IF EXISTS `system_user_info`;
CREATE TABLE `system_user_info`  (
  `system_user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `system_user_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户类型【SUPER=超级用户/SYSTEM=系统用户/NORMAL=普通用户】',
  `system_user_account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `system_user_nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `system_role_id` int(11) NOT NULL COMMENT '角色ID',
  `system_user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `system_user_image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',
  `check_question_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问答校验标识',
  `check_question_first` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预设问题1',
  `check_question_second` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预设问题2',
  `check_question_third` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预设问题3',
  `last_login_time` datetime(0) NOT NULL COMMENT '最后登录时间',
  `check_answer_first` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预设答案1',
  `check_answer_second` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预设答案2',
  `check_answer_third` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预设答案3',
  `first_create_by` int(11) NOT NULL DEFAULT 10 COMMENT '初始创建人员',
  `first_create_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '初始创建日期',
  `data_status_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'VALID' COMMENT '数据状态标识',
  `data_region_id` int(11) NOT NULL DEFAULT 0 COMMENT '数据区域ID',
  `data_change_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DCT10000' COMMENT '数据变化类型',
  `data_change_desc` varchar(900) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '数据变化描述' COMMENT '数据变化描述',
  `last_update_by` int(11) NOT NULL DEFAULT 10 COMMENT '最后修改人员',
  `last_update_date` datetime(0) NOT NULL DEFAULT current_timestamp COMMENT '最后修改日期',
  PRIMARY KEY (`system_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_user_info
-- ----------------------------
INSERT INTO `system_user_info` VALUES (10, 'SYSTEM', 'system', '系统账户', 10, 'SNULL', '111', 'NO', '111', '222', '333', '2021-09-14 10:57:42', '555', '666', '555', 10, '2021-09-14 10:54:08', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 10:54:08');
INSERT INTO `system_user_info` VALUES (20, 'SYSTEM', 'scheduler', '任务账户', 10, 'SNULL', '111', 'NO', '111', '222', '333', '2021-09-14 10:57:42', '555', '666', '555', 10, '2021-09-14 10:54:08', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 10:54:08');
INSERT INTO `system_user_info` VALUES (30, 'SYSTEM', 'administrator', '土地公公', 10, '123456', '111', 'NO', '111', '222', '333', '2021-09-16 15:49:56', '555', '666', '555', 10, '2021-09-14 10:54:08', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 10:54:08');
INSERT INTO `system_user_info` VALUES (40, 'SUPER', 'superadmin', '超级管理员', 10, 'SNULL', '111', 'NO', '111', '222', '333', '2021-09-14 10:57:42', '555', '666', '555', 10, '2021-09-14 10:54:08', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 10:54:08');
INSERT INTO `system_user_info` VALUES (101, 'NORMAL', 'aaa', '阿华', 10, '123456', '111', 'NO', '111', '222', '333', '2021-09-14 10:57:42', '555', '666', '555', 10, '2021-09-14 10:54:08', 'VALID', 0, 'DCT10000', '数据变化描述', 10, '2021-09-14 10:54:08');

SET FOREIGN_KEY_CHECKS = 1;
