/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : springboot4xt85

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 27/05/2023 20:38:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bumenxinxi
-- ----------------------------
DROP TABLE IF EXISTS `bumenxinxi`;
CREATE TABLE `bumenxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bumenmingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `bumenfuzeren` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门负责人',
  `lianxidianhua` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `bangongquyu` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办公区域',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 129 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bumenxinxi
-- ----------------------------
INSERT INTO `bumenxinxi` VALUES (121, '2023-05-21 14:56:31', '部门名称1', '部门负责人1', '联系电话1', '办公区域1');
INSERT INTO `bumenxinxi` VALUES (122, '2023-05-21 14:56:31', '部门名称2', '部门负责人2', '联系电话2', '办公区域2');
INSERT INTO `bumenxinxi` VALUES (123, '2023-05-21 14:56:31', '部门名称3', '部门负责人3', '联系电话3', '办公区域3');
INSERT INTO `bumenxinxi` VALUES (124, '2023-05-21 14:56:31', '部门名称4', '部门负责人4', '联系电话4', '办公区域4');
INSERT INTO `bumenxinxi` VALUES (125, '2023-05-21 14:56:31', '部门名称5', '部门负责人5', '联系电话5', '办公区域5');
INSERT INTO `bumenxinxi` VALUES (126, '2023-05-21 14:56:31', '部门名称6', '部门负责人6', '联系电话6', '办公区域6');
INSERT INTO `bumenxinxi` VALUES (127, '2023-05-21 14:56:31', '部门名称7', '部门负责人7', '联系电话7', '办公区域7');
INSERT INTO `bumenxinxi` VALUES (128, '2023-05-21 14:56:31', '部门名称8', '部门负责人8', '联系电话8', '办公区域8');

-- ----------------------------
-- Table structure for caiwu
-- ----------------------------
DROP TABLE IF EXISTS `caiwu`;
CREATE TABLE `caiwu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `caiwuzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '财务账号',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `caiwuxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '财务姓名',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `shouji` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `caiwuzhanghao`(`caiwuzhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '财务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caiwu
-- ----------------------------
INSERT INTO `caiwu` VALUES (21, '2023-05-21 14:56:31', '财务账号1', '123456', '财务姓名1', '男', '13823888881');
INSERT INTO `caiwu` VALUES (22, '2023-05-21 14:56:31', '财务账号2', '123456', '财务姓名2', '男', '13823888882');
INSERT INTO `caiwu` VALUES (23, '2023-05-21 14:56:31', '财务账号3', '123456', '财务姓名3', '男', '13823888883');
INSERT INTO `caiwu` VALUES (24, '2023-05-21 14:56:31', '财务账号4', '123456', '财务姓名4', '男', '13823888884');
INSERT INTO `caiwu` VALUES (25, '2023-05-21 14:56:31', '财务账号5', '123456', '财务姓名5', '男', '13823888885');
INSERT INTO `caiwu` VALUES (26, '2023-05-21 14:56:31', '财务账号6', '123456', '财务姓名6', '男', '13823888886');
INSERT INTO `caiwu` VALUES (27, '2023-05-21 14:56:31', '财务账号7', '123456', '财务姓名7', '男', '13823888887');
INSERT INTO `caiwu` VALUES (28, '2023-05-21 14:56:31', '财务账号8', '123456', '财务姓名8', '男', '13823888888');

-- ----------------------------
-- Table structure for caiwushouru
-- ----------------------------
DROP TABLE IF EXISTS `caiwushouru`;
CREATE TABLE `caiwushouru`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shouruleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收入类型',
  `shouruneirong` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收入内容',
  `caiwushouru` float NULL DEFAULT NULL COMMENT '财务收入',
  `caiwujieyu` int(11) NULL DEFAULT NULL COMMENT '财务结余',
  `dengjiriqi` date NULL DEFAULT NULL COMMENT '登记日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '财务收入' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caiwushouru
-- ----------------------------
INSERT INTO `caiwushouru` VALUES (1, '2023-01-01 21:49:46', 'lSKWba1CEL', 'yWmGhmZIUX', 271, 355, '2007-05-25');
INSERT INTO `caiwushouru` VALUES (2, '2000-06-02 23:17:51', 'XIBaF0WzE1', 'gH8it5bM89', 66, 823, '2002-11-28');
INSERT INTO `caiwushouru` VALUES (3, '2023-05-26 12:50:30', '销售', '产品销售', 24, NULL, '2023-05-26');
INSERT INTO `caiwushouru` VALUES (7, '2023-05-26 13:07:36', '销售', '产品销售', 96, NULL, '2023-05-26');
INSERT INTO `caiwushouru` VALUES (8, '2023-05-26 13:13:39', '销售', '产品销售', 80, NULL, '2023-05-26');
INSERT INTO `caiwushouru` VALUES (10, '2023-05-26 13:23:01', '销售', '产品销售', 16, NULL, '2023-05-26');
INSERT INTO `caiwushouru` VALUES (11, '2023-05-26 13:24:30', '销售', '产品销售', 16, NULL, '2023-05-26');
INSERT INTO `caiwushouru` VALUES (12, '2023-05-26 15:22:44', '销售', '产品销售', 16, NULL, '2023-05-26');
INSERT INTO `caiwushouru` VALUES (13, '2023-05-26 15:27:10', '销售', '产品销售', 16, NULL, '2023-05-26');

-- ----------------------------
-- Table structure for caiwushouzhi
-- ----------------------------
DROP TABLE IF EXISTS `caiwushouzhi`;
CREATE TABLE `caiwushouzhi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shouruleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收入类型',
  `shouruneirong` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收入内容',
  `caiwuzhichu` int(11) NULL DEFAULT NULL COMMENT '财务支出',
  `zhichuleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支出类型',
  `caiwushouru` int(11) NULL DEFAULT NULL COMMENT '财务收入',
  `zhichuneirong` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支出内容',
  `caiwujieyu` int(11) NULL DEFAULT NULL COMMENT '财务结余',
  `dengjiriqi` date NULL DEFAULT NULL COMMENT '登记日期',
  `caiwuzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '财务账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '财务收支' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caiwushouzhi
-- ----------------------------
INSERT INTO `caiwushouzhi` VALUES (51, '2023-05-21 14:56:31', '收入类型1', '收入内容1', 1, '支出类型1', 1, '支出内容1', 1, '2023-05-21', '财务账号1');
INSERT INTO `caiwushouzhi` VALUES (52, '2023-05-21 14:56:31', '收入类型2', '收入内容2', 2, '支出类型2', 2, '支出内容2', 2, '2023-05-21', '财务账号2');
INSERT INTO `caiwushouzhi` VALUES (53, '2023-05-21 14:56:31', '收入类型3', '收入内容3', 3, '支出类型3', 3, '支出内容3', 3, '2023-05-21', '财务账号3');
INSERT INTO `caiwushouzhi` VALUES (54, '2023-05-21 14:56:31', '收入类型4', '收入内容4', 4, '支出类型4', 4, '支出内容4', 4, '2023-05-21', '财务账号4');
INSERT INTO `caiwushouzhi` VALUES (55, '2023-05-21 14:56:31', '收入类型5', '收入内容5', 5, '支出类型5', 5, '支出内容5', 5, '2023-05-21', '财务账号5');
INSERT INTO `caiwushouzhi` VALUES (56, '2023-05-21 14:56:31', '收入类型6', '收入内容6', 6, '支出类型6', 6, '支出内容6', 6, '2023-05-21', '财务账号6');
INSERT INTO `caiwushouzhi` VALUES (57, '2023-05-21 14:56:31', '收入类型7', '收入内容7', 7, '支出类型7', 7, '支出内容7', 7, '2023-05-21', '财务账号7');
INSERT INTO `caiwushouzhi` VALUES (58, '2023-05-21 14:56:31', '收入类型8', '收入内容8', 8, '支出类型8', 8, '支出内容8', 8, '2023-05-21', '财务账号8');

-- ----------------------------
-- Table structure for caiwuzhichu
-- ----------------------------
DROP TABLE IF EXISTS `caiwuzhichu`;
CREATE TABLE `caiwuzhichu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `caiwuzhichu` float NULL DEFAULT NULL COMMENT '财务支出',
  `zhichuleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支出类型',
  `zhichuneirong` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支出内容',
  `caiwujieyu` int(11) NULL DEFAULT NULL COMMENT '财务结余',
  `dengjiriqi` date NULL DEFAULT NULL COMMENT '登记日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '财务支出' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caiwuzhichu
-- ----------------------------
INSERT INTO `caiwuzhichu` VALUES (1, '2004-04-04 09:24:48', 613, '2', '2', 0, '2021-11-06');
INSERT INTO `caiwuzhichu` VALUES (2, '2002-06-15 20:05:38', 1000, '1', '1', 0, '2012-12-15');
INSERT INTO `caiwuzhichu` VALUES (3, '2023-05-26 14:14:04', 144, '采购', '原料采购', NULL, '2023-05-26');
INSERT INTO `caiwuzhichu` VALUES (4, '2023-05-26 14:27:26', 2, '报销', '员工报销', NULL, '2023-05-26');
INSERT INTO `caiwuzhichu` VALUES (5, '2023-05-26 15:52:55', 7100, '工资', '员工工资', NULL, '2023-05-26');
INSERT INTO `caiwuzhichu` VALUES (6, '2023-05-26 16:17:04', 2, '报销', '员工报销', NULL, '2023-05-26');
INSERT INTO `caiwuzhichu` VALUES (7, '2023-05-26 16:17:04', 8, '报销', '员工报销', NULL, '2023-05-26');

-- ----------------------------
-- Table structure for chanpinleixing
-- ----------------------------
DROP TABLE IF EXISTS `chanpinleixing`;
CREATE TABLE `chanpinleixing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `chanpinleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `chanpinleixing`(`chanpinleixing`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chanpinleixing
-- ----------------------------
INSERT INTO `chanpinleixing` VALUES (71, '2023-05-21 14:56:31', '产品类型1');
INSERT INTO `chanpinleixing` VALUES (72, '2023-05-21 14:56:31', '产品类型2');
INSERT INTO `chanpinleixing` VALUES (73, '2023-05-21 14:56:31', '产品类型3');
INSERT INTO `chanpinleixing` VALUES (74, '2023-05-21 14:56:31', '产品类型4');
INSERT INTO `chanpinleixing` VALUES (75, '2023-05-21 14:56:31', '产品类型5');
INSERT INTO `chanpinleixing` VALUES (76, '2023-05-21 14:56:31', '产品类型6');
INSERT INTO `chanpinleixing` VALUES (77, '2023-05-21 14:56:31', '产品类型7');
INSERT INTO `chanpinleixing` VALUES (78, '2023-05-21 14:56:31', '产品类型8');

-- ----------------------------
-- Table structure for chanpinxiaoshouzhangmu
-- ----------------------------
DROP TABLE IF EXISTS `chanpinxiaoshouzhangmu`;
CREATE TABLE `chanpinxiaoshouzhangmu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yejibianhao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业绩编号',
  `xiaoshoue` float NULL DEFAULT NULL COMMENT '销售额',
  `riqi` date NULL DEFAULT NULL COMMENT '日期',
  `beizhu` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `chanpinmingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `jiage` float NULL DEFAULT NULL COMMENT '产品单价',
  `count` int(11) NULL DEFAULT NULL COMMENT '销售数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yejibianhao`(`yejibianhao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1685086031469 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品销售账目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chanpinxiaoshouzhangmu
-- ----------------------------
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (61, '2023-05-21 14:56:31', '1111111111', 1, '2023-05-21', '备注1', '员工工号1', '员工姓名1', NULL, NULL, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (62, '2023-05-21 14:56:31', '2222222222', 2, '2023-05-21', '备注2', '员工工号2', '员工姓名2', NULL, NULL, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (63, '2023-05-21 14:56:31', '3333333333', 3, '2023-05-21', '备注3', '员工工号3', '员工姓名3', NULL, NULL, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (64, '2023-05-21 14:56:31', '4444444444', 4, '2023-05-21', '备注4', '员工工号4', '员工姓名4', NULL, NULL, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (65, '2023-05-21 14:56:31', '5555555555', 5, '2023-05-21', '备注5', '员工工号5', '员工姓名5', NULL, NULL, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (66, '2023-05-21 14:56:31', '6666666666', 6, '2023-05-21', '备注6', '员工工号6', '员工姓名6', NULL, NULL, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (67, '2023-05-21 14:56:31', '7777777777', 7, '2023-05-21', '备注7', '员工工号7', '员工姓名7', NULL, NULL, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (68, '2023-05-21 14:56:31', '8888888888', 8, '2023-05-21', '备注8', '员工工号8', '员工姓名8', NULL, NULL, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685017262728, '2023-05-25 20:21:01', '1685017250357', 10, '2023-05-25', '', '', '', NULL, NULL, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685069734004, '2023-05-26 10:55:40', '1685069512685', 12, '2023-05-26', '1', '1', '1', '12', 10, NULL);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685073675307, '2023-05-26 12:01:14', '1685073656918', 12, '2023-05-26', '11', '11', '员工姓名1', '产品名称1', 1, 12);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685076616078, '2023-05-26 12:50:18', '1685076603302', 24, '2023-05-26', '1', '11', '员工姓名1', '产品名称2', 2, 12);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685077656751, '2023-05-26 13:07:36', '1685077646762', 96, '2023-05-26', '', '11', '员工姓名1', '产品名称8', 8, 12);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685078020370, '2023-05-26 13:13:39', '1685078004064', 80, '2023-05-26', '11', '16', '员工姓名6', '产品名称8', 8, 10);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685078582044, '2023-05-26 13:23:01', '1685078545897', 16, '2023-05-26', '', '18', '员工姓名8', '产品名称8', 8, 2);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685078671710, '2023-05-26 13:24:30', '1685078662639', 16, '2023-05-26', '', '18', '员工姓名8', '产品名称8', 8, 2);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685085764636, '2023-05-26 15:22:44', '1685085752622', 16, '2023-05-26', '', '11', '员工姓名1', '产品名称8', 8, 2);
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (1685086031468, '2023-05-26 15:27:10', '1685086016556', 16, '2023-05-26', '11', '员工工号9', 'aaa', '产品名称8', 8, 2);

-- ----------------------------
-- Table structure for chanpinxinxi
-- ----------------------------
DROP TABLE IF EXISTS `chanpinxinxi`;
CREATE TABLE `chanpinxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `chanpinbianhao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品编号',
  `chanpinmingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `chanpintupian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品图片',
  `chanpinleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品类型',
  `jiage` float NULL DEFAULT NULL COMMENT '价格',
  `shuliang` int(11) NULL DEFAULT NULL COMMENT '数量',
  `chanpinxiangqing` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品详情',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `chanpinbianhao`(`chanpinbianhao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chanpinxinxi
-- ----------------------------
INSERT INTO `chanpinxinxi` VALUES (81, '2023-05-21 14:56:31', '1111111111', '产品名称1', 'upload/chanpinxinxi_chanpintupian1.jpg,upload/chanpinxinxi_chanpintupian2.jpg,upload/chanpinxinxi_chanpintupian3.jpg', '产品类型1', 1, 1, '产品详情1');
INSERT INTO `chanpinxinxi` VALUES (82, '2023-05-21 14:56:31', '2222222222', '产品名称2', 'upload/chanpinxinxi_chanpintupian2.jpg,upload/chanpinxinxi_chanpintupian3.jpg,upload/chanpinxinxi_chanpintupian4.jpg', '产品类型2', 2, 2, '产品详情2');
INSERT INTO `chanpinxinxi` VALUES (83, '2023-05-21 14:56:31', '3333333333', '产品名称3', 'upload/chanpinxinxi_chanpintupian3.jpg,upload/chanpinxinxi_chanpintupian4.jpg,upload/chanpinxinxi_chanpintupian5.jpg', '产品类型3', 3, 3, '产品详情3');
INSERT INTO `chanpinxinxi` VALUES (84, '2023-05-21 14:56:31', '4444444444', '产品名称4', 'upload/chanpinxinxi_chanpintupian4.jpg,upload/chanpinxinxi_chanpintupian5.jpg,upload/chanpinxinxi_chanpintupian6.jpg', '产品类型4', 4, 4, '产品详情4');
INSERT INTO `chanpinxinxi` VALUES (85, '2023-05-21 14:56:31', '5555555555', '产品名称5', 'upload/chanpinxinxi_chanpintupian5.jpg,upload/chanpinxinxi_chanpintupian6.jpg,upload/chanpinxinxi_chanpintupian7.jpg', '产品类型5', 5, 5, '产品详情5');
INSERT INTO `chanpinxinxi` VALUES (86, '2023-05-21 14:56:31', '6666666666', '产品名称6', 'upload/chanpinxinxi_chanpintupian6.jpg,upload/chanpinxinxi_chanpintupian7.jpg,upload/chanpinxinxi_chanpintupian8.jpg', '产品类型6', 6, 6, '产品详情6');
INSERT INTO `chanpinxinxi` VALUES (87, '2023-05-21 14:56:31', '7777777777', '产品名称7', 'upload/chanpinxinxi_chanpintupian7.jpg,upload/chanpinxinxi_chanpintupian8.jpg,upload/chanpinxinxi_chanpintupian9.jpg', '产品类型7', 7, 7, '产品详情7');
INSERT INTO `chanpinxinxi` VALUES (88, '2023-05-21 14:56:31', '8888888888', '产品名称8', 'upload/chanpinxinxi_chanpintupian8.jpg,upload/chanpinxinxi_chanpintupian9.jpg,upload/chanpinxinxi_chanpintupian10.jpg', '产品类型8', 8, 2, '产品详情8');

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/picture1.jpg');
INSERT INTO `config` VALUES (2, 'picture2', 'upload/picture2.jpg');
INSERT INTO `config` VALUES (3, 'picture3', 'upload/picture3.jpg');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '菜单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '2023-05-21 14:56:31', '[\n  {\n    \"backMenu\": [\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-send\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"员工\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuangong\"\n          }\n        ],\n        \"menu\": \"员工管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-phone\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"财务\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"caiwu\"\n          }\n        ],\n        \"menu\": \"财务管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-full\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"产品类型\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"chanpinleixing\"\n          }\n        ],\n        \"menu\": \"产品类型管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-camera\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"产品信息\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"chanpinxinxi\"\n          }\n        ],\n        \"menu\": \"产品信息管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-pic\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"原料类别\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuanliaoleibie\"\n          }\n        ],\n        \"menu\": \"原料类别管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-camera\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"原料信息\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuanliaoxinxi\"\n          }\n        ],\n        \"menu\": \"原料信息管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-pic\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"系统公告\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"xitonggonggao\"\n          }\n        ],\n        \"menu\": \"系统公告管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-wenzi\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"部门信息\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"bumenxinxi\"\n          }\n        ],\n        \"menu\": \"部门信息管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-explore\",\n            \"buttons\": [\n              \"查看\",\n              \"编辑名称\",\n              \"编辑父级\",\n              \"删除\"\n            ],\n            \"menu\": \"菜单列表\",\n            \"tableName\": \"menu\"\n          }\n        ],\n        \"menu\": \"系统管理\"\n      }\n    ],\n    \"frontMenu\": [],\n    \"hasBackLogin\": \"是\",\n    \"hasBackRegister\": \"否\",\n    \"hasFrontLogin\": \"否\",\n    \"hasFrontRegister\": \"否\",\n    \"roleName\": \"管理员\",\n    \"tableName\": \"users\"\n  },\n  {\n    \"backMenu\": [\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-send\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"员工信息\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuangongxinxi\"\n          }\n        ],\n        \"menu\": \"员工信息管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-send\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\"\n            ],\n            \"menu\": \"员工考勤\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuangongkaoqin\"\n          }\n        ],\n        \"menu\": \"员工考勤管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-addressbook\",\n            \"buttons\": [\n              \"查看\"\n            ],\n            \"menu\": \"员工工资\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuangonggongzi\"\n          }\n        ],\n        \"menu\": \"员工工资管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-goodsnew\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"删除\"\n            ],\n            \"menu\": \"员工报销\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuangongbaoxiao\"\n          }\n        ],\n        \"menu\": \"员工报销管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-pic\",\n            \"buttons\": [\n              \"查看\"\n            ],\n            \"menu\": \"系统公告\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"xitonggonggao\"\n          }\n        ],\n        \"menu\": \"系统公告管理\"\n      }\n    ],\n    \"frontMenu\": [],\n    \"hasBackLogin\": \"是\",\n    \"hasBackRegister\": \"否\",\n    \"hasFrontLogin\": \"否\",\n    \"hasFrontRegister\": \"否\",\n    \"roleName\": \"员工\",\n    \"tableName\": \"yuangong\"\n  },\n  {\n    \"backMenu\": [\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-addressbook\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\",\n              \"支付\"\n            ],\n            \"menu\": \"员工工资\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuangonggongzi\"\n          }\n        ],\n        \"menu\": \"员工工资管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-goodsnew\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\",\n              \"审核\",\n              \"支付\"\n            ],\n            \"menu\": \"员工报销\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuangongbaoxiao\"\n          }\n        ],\n        \"menu\": \"员工报销管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-link\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\",\n              \"首页总数\",\n              \"首页统计\"\n            ],\n            \"menu\": \"收入账目管理\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"caiwushouru\"\n          },\n          {\n            \"appFrontIcon\": \"cuIcon-link\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\",\n              \"首页总数\",\n              \"首页统计\"\n            ],\n            \"menu\": \"支出账目管理\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"caiwuzhichu\"\n          }\n        ],\n        \"menu\": \"财务收支管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-copy\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\",\n              \"报表\"\n            ],\n            \"menu\": \"产品销售账目\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"chanpinxiaoshouzhangmu\"\n          }\n        ],\n        \"menu\": \"产品销售账目管理\"\n      },\n      {\n        \"child\": [\n          {\n            \"appFrontIcon\": \"cuIcon-time\",\n            \"buttons\": [\n              \"新增\",\n              \"查看\",\n              \"修改\",\n              \"删除\",\n              \"支付\"\n            ],\n            \"menu\": \"原料采购\",\n            \"menuJump\": \"列表\",\n            \"tableName\": \"yuanliaocaigou\"\n          }\n        ],\n        \"menu\": \"原料采购管理\"\n      }\n    ],\n    \"frontMenu\": [],\n    \"hasBackLogin\": \"是\",\n    \"hasBackRegister\": \"否\",\n    \"hasFrontLogin\": \"否\",\n    \"hasFrontRegister\": \"否\",\n    \"roleName\": \"财务\",\n    \"tableName\": \"caiwu\"\n  }\n]');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'admin', 'users', '管理员', 'n47irjk0t5pa1kdp8alia371kd64orkl', '2023-05-21 14:59:47', '2023-05-27 19:03:38');
INSERT INTO `token` VALUES (2, 11, '员工工号1', 'yuangong', '员工', 'xsf0cv3c96mg84hk6nmggjspyxnnlq2r', '2023-05-21 15:00:19', '2023-05-25 16:35:54');
INSERT INTO `token` VALUES (3, 21, '财务账号1', 'caiwu', '财务', 'fsbrww71o0qs6anedq4tdzwxad289yl9', '2023-05-24 23:41:43', '2023-05-26 22:49:47');
INSERT INTO `token` VALUES (4, 1684999588437, '员工工号9', 'yuangong', '员工', 'dtbxmd13j26plwdw55nw4uc4o6u2inp1', '2023-05-25 15:27:23', '2023-05-26 23:03:14');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'admin', '管理员', '2023-05-21 14:56:31');

-- ----------------------------
-- Table structure for xitonggonggao
-- ----------------------------
DROP TABLE IF EXISTS `xitonggonggao`;
CREATE TABLE `xitonggonggao`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `neirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `biaoti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `faburen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xitonggonggao
-- ----------------------------
INSERT INTO `xitonggonggao` VALUES (111, '2023-05-21 14:56:31', '内容1', '2023-05-21', '标题1', '发布人1');
INSERT INTO `xitonggonggao` VALUES (112, '2023-05-21 14:56:31', '内容2', '2023-05-21', '标题2', '发布人2');
INSERT INTO `xitonggonggao` VALUES (113, '2023-05-21 14:56:31', '内容3', '2023-05-21', '标题3', '发布人3');
INSERT INTO `xitonggonggao` VALUES (114, '2023-05-21 14:56:31', '内容4', '2023-05-21', '标题4', '发布人4');
INSERT INTO `xitonggonggao` VALUES (115, '2023-05-21 14:56:31', '内容5', '2023-05-21', '标题5', '发布人5');
INSERT INTO `xitonggonggao` VALUES (116, '2023-05-21 14:56:31', '内容6', '2023-05-21', '标题6', '发布人6');
INSERT INTO `xitonggonggao` VALUES (117, '2023-05-21 14:56:31', '内容7', '2023-05-21', '标题7', '发布人7');
INSERT INTO `xitonggonggao` VALUES (118, '2023-05-21 14:56:31', '内容8', '2023-05-21', '标题8', '发布人8');

-- ----------------------------
-- Table structure for yuangong
-- ----------------------------
DROP TABLE IF EXISTS `yuangong`;
CREATE TABLE `yuangong`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工工号',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `yuangongxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `bumen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `ruzhishijian` date NULL DEFAULT NULL COMMENT '入职时间',
  `lianxifangshi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `gongzikahao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工资卡号',
  `shenfenzheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `gzsc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作时长（考勤）',
  `gzzsc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作总时长',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yuangonggonghao`(`yuangonggonghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1684999588438 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuangong
-- ----------------------------
INSERT INTO `yuangong` VALUES (11, '2023-05-21 14:56:31', '员工工号1', '123456', '员工姓名1', '男', '部门名称1', '职位1', '2023-05-21', '13823888881', '工资卡号1', '440300199101010001', '8', '12');
INSERT INTO `yuangong` VALUES (12, '2023-05-21 14:56:31', '员工工号2', '123456', '员工姓名2', '男', '部门2', '职位2', '2023-05-21', '13823888882', '工资卡号2', '440300199202020002', '8', '12');
INSERT INTO `yuangong` VALUES (13, '2023-05-21 14:56:31', '员工工号3', '123456', '员工姓名3', '男', '部门3', '职位3', '2023-05-21', '13823888883', '工资卡号3', '440300199303030003', '8', '12');
INSERT INTO `yuangong` VALUES (14, '2023-05-21 14:56:31', '员工工号4', '123456', '员工姓名4', '男', '部门4', '职位4', '2023-05-21', '13823888884', '工资卡号4', '440300199404040004', '8', '12');
INSERT INTO `yuangong` VALUES (15, '2023-05-21 14:56:31', '员工工号5', '123456', '员工姓名5', '男', '部门5', '职位5', '2023-05-21', '13823888885', '工资卡号5', '440300199505050005', '8', '12');
INSERT INTO `yuangong` VALUES (16, '2023-05-21 14:56:31', '员工工号6', '123456', '员工姓名6', '男', '部门6', '职位6', '2023-05-21', '13823888886', '工资卡号6', '440300199606060006', '8', '12');
INSERT INTO `yuangong` VALUES (17, '2023-05-21 14:56:31', '员工工号7', '123456', '员工姓名7', '男', '部门7', '职位7', '2023-05-21', '13823888887', '工资卡号7', '440300199707070007', '8', '12');
INSERT INTO `yuangong` VALUES (18, '2023-05-21 14:56:31', '员工工号8', '123456', '员工姓名8', '男', '部门8', '副部长', '2023-05-21', '13823888888', '工资卡号8', '440300199808080008', '8', '12');
INSERT INTO `yuangong` VALUES (1684999588437, '2023-05-25 15:26:28', '员工工号9', '123456', 'aaa', '男', '部门名称1', '部长', '2023-05-25', '15745342211', '111111111111111', '', '8', '12');

-- ----------------------------
-- Table structure for yuangongbaoxiao
-- ----------------------------
DROP TABLE IF EXISTS `yuangongbaoxiao`;
CREATE TABLE `yuangongbaoxiao`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `baoxiaobiaoti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报销标题',
  `yuefen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '月份',
  `baoxiaoneirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报销内容',
  `baoxiaowenjian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '报销文件',
  `baoxiaojine` int(11) NULL DEFAULT NULL COMMENT '报销金额',
  `shenqingriqi` date NULL DEFAULT NULL COMMENT '申请日期',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `bumen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '审核回复',
  `ispay` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1685014675235 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工报销' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuangongbaoxiao
-- ----------------------------
INSERT INTO `yuangongbaoxiao` VALUES (41, '2023-05-21 14:56:31', '报销标题1', '1月份', '报销内容1', '', 1, '2023-05-21', '员工工号1', '员工姓名1', '13823888881', '部门1', '职位1', '是', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (42, '2023-05-21 14:56:31', '报销标题2', '1月份', '报销内容2', '', 2, '2023-05-21', '员工工号2', '员工姓名2', '13823888882', '部门2', '职位2', '是', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (43, '2023-05-21 14:56:31', '报销标题3', '1月份', '报销内容3', '', 3, '2023-05-21', '员工工号3', '员工姓名3', '13823888883', '部门3', '职位3', '是', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (44, '2023-05-21 14:56:31', '报销标题4', '1月份', '报销内容4', '', 4, '2023-05-21', '员工工号4', '员工姓名4', '13823888884', '部门4', '职位4', '是', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (45, '2023-05-21 14:56:31', '报销标题5', '1月份', '报销内容5', '', 5, '2023-05-21', '员工工号5', '员工姓名5', '13823888885', '部门5', '职位5', '是', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (46, '2023-05-21 14:56:31', '报销标题6', '1月份', '报销内容6', '', 6, '2023-05-21', '员工工号6', '员工姓名6', '13823888886', '部门6', '职位6', '是', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (47, '2023-05-21 14:56:31', '报销标题7', '1月份', '报销内容7', '', 7, '2023-05-21', '员工工号7', '员工姓名7', '13823888887', '部门7', '职位7', '是', '', '已支付');
INSERT INTO `yuangongbaoxiao` VALUES (48, '2023-05-21 14:56:31', '报销标题8', '1月份', '报销内容8', '', 8, '2023-05-21', '员工工号8', '员工姓名8', '13823888888', '部门8', '职位8', '是', '', '已支付');
INSERT INTO `yuangongbaoxiao` VALUES (1685011935451, '2023-05-25 18:52:14', 'aa', '2月份', 'aa', '', NULL, '2023-05-25', '11', '', '', '', '', '待审核', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (1685011969669, '2023-05-25 18:52:49', 'bb', '1月份', 'aa', '', NULL, '2023-05-25', '11', '', '', '', '', '待审核', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (1685012012134, '2023-05-25 18:53:31', '11', '1月份', '11', '', NULL, '2023-05-25', '11', '', '', '', '', '待审核', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (1685012041678, '2023-05-25 18:54:01', '11', '1月份', '11', '', NULL, '2023-05-25', '11', '', '', '', '', '待审核', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (1685012291462, '2023-05-25 18:58:11', '11', '1月份', '11', '', NULL, '2023-05-25', '11', '员工姓名1', '', '', '', '是', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (1685013342283, '2023-05-25 19:15:41', '11', '1月份', '11', '', 2, '2023-05-25', '11', '员工姓名1', '13823888881', '部门名称1', '职位1', '是', '', '未支付');
INSERT INTO `yuangongbaoxiao` VALUES (1685014675234, '2023-05-25 19:37:54', '22', '2月份', '11', '', NULL, '2023-05-25', '1684999588437', 'aaa', '', '部门名称1', '部长', '是', '', '未支付');

-- ----------------------------
-- Table structure for yuangonggongzi
-- ----------------------------
DROP TABLE IF EXISTS `yuangonggongzi`;
CREATE TABLE `yuangonggongzi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nianyuefen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年月份',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `zhiwei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `bumen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `gongzikahao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工资卡号',
  `dixin` float NOT NULL COMMENT '底薪',
  `quanqinjiang` float NULL DEFAULT NULL COMMENT '全勤奖',
  `jiabanfei` float NOT NULL COMMENT '加班费',
  `jixiaojiangjin` float NOT NULL COMMENT '绩效奖金',
  `qitakoukuan` float NOT NULL COMMENT '其它扣款',
  `jine` float NULL DEFAULT NULL COMMENT '金额',
  `gongzibeizhu` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工资备注',
  `dengjishijian` datetime NULL DEFAULT NULL COMMENT '登记时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1685087576751 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工工资' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuangonggongzi
-- ----------------------------
INSERT INTO `yuangonggongzi` VALUES (31, '2023-05-21 14:56:31', '年月份1', '员工工号1', '员工姓名1', '职位1', '部门1', '工资卡号1', 1, 1, 1, 1, 1, 1, '工资备注1', '2023-05-21 14:56:31');
INSERT INTO `yuangonggongzi` VALUES (32, '2023-05-21 14:56:31', '年月份2', '员工工号2', '员工姓名2', '职位2', '部门2', '工资卡号2', 2, 2, 2, 2, 2, 2, '工资备注2', '2023-05-21 14:56:31');
INSERT INTO `yuangonggongzi` VALUES (33, '2023-05-21 14:56:31', '年月份3', '员工工号3', '员工姓名3', '职位3', '部门3', '工资卡号3', 3, 3, 3, 3, 3, 3, '工资备注3', '2023-05-21 14:56:31');
INSERT INTO `yuangonggongzi` VALUES (34, '2023-05-21 14:56:31', '年月份4', '员工工号4', '员工姓名4', '职位4', '部门4', '工资卡号4', 4, 4, 4, 4, 4, 4, '工资备注4', '2023-05-21 14:56:31');
INSERT INTO `yuangonggongzi` VALUES (35, '2023-05-21 14:56:31', '年月份5', '员工工号5', '员工姓名5', '职位5', '部门5', '工资卡号5', 5, 5, 5, 5, 5, 5, '工资备注5', '2023-05-21 14:56:31');
INSERT INTO `yuangonggongzi` VALUES (36, '2023-05-21 14:56:31', '年月份6', '员工工号6', '员工姓名6', '职位6', '部门6', '工资卡号6', 6, 6, 6, 6, 6, 6, '工资备注6', '2023-05-21 14:56:31');
INSERT INTO `yuangonggongzi` VALUES (37, '2023-05-21 14:56:31', '年月份7', '员工工号7', '员工姓名7', '职位7', '部门7', '工资卡号7', 7, 7, 7, 7, 7, 7, '工资备注7', '2023-05-21 14:56:31');
INSERT INTO `yuangonggongzi` VALUES (38, '2023-05-21 14:56:31', '年月份8', '员工工号8', '员工姓名8', '职位8', '部门8', '工资卡号8', 8, 8, 8, 8, 8, 8, '工资备注8', '2023-05-21 14:56:31');
INSERT INTO `yuangonggongzi` VALUES (1685087153736, '2023-05-26 15:45:53', '12', '员工工号9', 'aaa', '部长', '部门名称1', '', 7000, NULL, 60, 40, 23, 7077, '23', '2023-05-26 15:45:36');
INSERT INTO `yuangonggongzi` VALUES (1685087295474, '2023-05-26 15:48:15', '5', '员工工号9', 'aaa', '部长', '部门名称1', '', 7000, NULL, 60, 40, 0, 7100, '11', '2023-05-26 15:47:47');
INSERT INTO `yuangonggongzi` VALUES (1685087576750, '2023-05-26 15:52:55', '5', '员工工号9', 'aaa', '部长', '部门名称1', '', 7000, NULL, 60, 40, 0, 7100, '11', '2023-05-26 15:52:41');

-- ----------------------------
-- Table structure for yuangongkaoqin
-- ----------------------------
DROP TABLE IF EXISTS `yuangongkaoqin`;
CREATE TABLE `yuangongkaoqin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工工号',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `yuangongxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `bumen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `ruzhishijian` date NULL DEFAULT NULL COMMENT '入职时间',
  `lianxifangshi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `gongzikahao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工资卡号',
  `shenfenzheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `gzsc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作时长（考勤）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1685109806921 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工考勤' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuangongkaoqin
-- ----------------------------
INSERT INTO `yuangongkaoqin` VALUES (1685107147602, '2023-05-26 21:19:07', '员工工号1', '', '员工姓名1', '男', '部门名称1', '职位1', '2023-05-21', '13823888881', '工资卡号1', '440300199101010001', '12');
INSERT INTO `yuangongkaoqin` VALUES (1685107406938, '2023-05-26 21:23:26', '员工工号9', '', 'aaa', '男', '部门名称1', '部长', '2023-05-25', '15745342211', '111111111111111', '', '8');
INSERT INTO `yuangongkaoqin` VALUES (1685109806920, '2023-05-26 22:03:26', '员工工号1', '', '员工姓名1', '男', '部门名称1', '职位1', '2023-05-21', '13823888881', '工资卡号1', '440300199101010001', '13');

-- ----------------------------
-- Table structure for yuanliaocaigou
-- ----------------------------
DROP TABLE IF EXISTS `yuanliaocaigou`;
CREATE TABLE `yuanliaocaigou`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `yuanliaobianhao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原料编号',
  `yuanliaoleibie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原料类别',
  `yuanliaomingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原料名称',
  `yuanliaoguige` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原料规格',
  `gongyingchangshang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应厂商',
  `caigoujiage` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购价格',
  `caigourenyuan` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购人员',
  `caigoushijian` datetime NULL DEFAULT NULL COMMENT '采购时间',
  `ispay` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未支付' COMMENT '是否支付',
  `jiage` float NULL DEFAULT NULL COMMENT '原料单价',
  `count` int(11) NULL DEFAULT NULL COMMENT '采购数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dingdanbianhao`(`dingdanbianhao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1685081645302 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '原料采购' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuanliaocaigou
-- ----------------------------
INSERT INTO `yuanliaocaigou` VALUES (101, '2023-05-21 14:56:31', '1111111111', '原料编号1', '原料类别1', '原料名称1', '原料规格1', '供应厂商1', '采购价格1', '采购人员1', '2023-05-21 14:56:31', '未支付', NULL, NULL);
INSERT INTO `yuanliaocaigou` VALUES (102, '2023-05-21 14:56:31', '2222222222', '原料编号2', '原料类别2', '原料名称2', '原料规格2', '供应厂商2', '采购价格2', '采购人员2', '2023-05-21 14:56:31', '未支付', NULL, NULL);
INSERT INTO `yuanliaocaigou` VALUES (103, '2023-05-21 14:56:31', '3333333333', '原料编号3', '原料类别3', '原料名称3', '原料规格3', '供应厂商3', '采购价格3', '采购人员3', '2023-05-21 14:56:31', '未支付', NULL, NULL);
INSERT INTO `yuanliaocaigou` VALUES (104, '2023-05-21 14:56:31', '4444444444', '原料编号4', '原料类别4', '原料名称4', '原料规格4', '供应厂商4', '采购价格4', '采购人员4', '2023-05-21 14:56:31', '未支付', NULL, NULL);
INSERT INTO `yuanliaocaigou` VALUES (105, '2023-05-21 14:56:31', '5555555555', '原料编号5', '原料类别5', '原料名称5', '原料规格5', '供应厂商5', '采购价格5', '采购人员5', '2023-05-21 14:56:31', '未支付', NULL, NULL);
INSERT INTO `yuanliaocaigou` VALUES (106, '2023-05-21 14:56:31', '6666666666', '原料编号6', '原料类别6', '原料名称6', '原料规格6', '供应厂商6', '采购价格6', '采购人员6', '2023-05-21 14:56:31', '未支付', NULL, NULL);
INSERT INTO `yuanliaocaigou` VALUES (107, '2023-05-21 14:56:31', '7777777777', '原料编号7', '原料类别7', '原料名称7', '原料规格7', '供应厂商7', '采购价格7', '采购人员7', '2023-05-21 14:56:31', '未支付', NULL, NULL);
INSERT INTO `yuanliaocaigou` VALUES (108, '2023-05-21 14:56:31', '8888888888', '原料编号8', '原料类别8', '原料名称8', '原料规格8', '供应厂商8', '采购价格8', '采购人员8', '2023-05-21 14:56:31', '未支付', NULL, NULL);
INSERT INTO `yuanliaocaigou` VALUES (1685080309722, '2023-05-26 13:51:49', '1685080292012', '1684999369665', '原料类别1', 'aa', '', '11', '12', '员工姓名1', '2023-05-26 13:51:32', '未支付', 12, 1);
INSERT INTO `yuanliaocaigou` VALUES (1685081246770, '2023-05-26 14:07:26', '1685081232351', '1684999369665', '原料类别1', 'aa', '', '12', '144', '员工姓名1', '2023-05-26 14:07:12', '未支付', 12, 12);
INSERT INTO `yuanliaocaigou` VALUES (1685081645301, '2023-05-26 14:14:04', '1685081635876', '1684999369665', '原料类别1', 'aa', '', 'aa', '144', '员工姓名1', '2023-05-26 14:13:55', '未支付', 12, 12);

-- ----------------------------
-- Table structure for yuanliaoleibie
-- ----------------------------
DROP TABLE IF EXISTS `yuanliaoleibie`;
CREATE TABLE `yuanliaoleibie`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuanliaoleibie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原料类别',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yuanliaoleibie`(`yuanliaoleibie`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 99 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '原料类别' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuanliaoleibie
-- ----------------------------
INSERT INTO `yuanliaoleibie` VALUES (91, '2023-05-21 14:56:31', '原料类别1');
INSERT INTO `yuanliaoleibie` VALUES (92, '2023-05-21 14:56:31', '原料类别2');
INSERT INTO `yuanliaoleibie` VALUES (93, '2023-05-21 14:56:31', '原料类别3');
INSERT INTO `yuanliaoleibie` VALUES (94, '2023-05-21 14:56:31', '原料类别4');
INSERT INTO `yuanliaoleibie` VALUES (95, '2023-05-21 14:56:31', '原料类别5');
INSERT INTO `yuanliaoleibie` VALUES (96, '2023-05-21 14:56:31', '原料类别6');
INSERT INTO `yuanliaoleibie` VALUES (97, '2023-05-21 14:56:31', '原料类别7');
INSERT INTO `yuanliaoleibie` VALUES (98, '2023-05-21 14:56:31', '原料类别8');

-- ----------------------------
-- Table structure for yuanliaoxinxi
-- ----------------------------
DROP TABLE IF EXISTS `yuanliaoxinxi`;
CREATE TABLE `yuanliaoxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuanliaobianhao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原料编号',
  `yuanliaomingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原料名称',
  `yuanliaotupian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '原料图片',
  `yuanliaoleibie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原料类别',
  `jiage` float NULL DEFAULT NULL COMMENT '价格',
  `shuliang` int(11) NULL DEFAULT NULL COMMENT '数量',
  `yuanliaoxiangqing` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '原料详情',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yuanliaobianhao`(`yuanliaobianhao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1684999413995 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '原料信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuanliaoxinxi
-- ----------------------------
INSERT INTO `yuanliaoxinxi` VALUES (1684999387351, '2023-05-25 15:23:06', '1684999369665', 'aa', 'upload/1684999379655.jpg', '原料类别1', 12, 1, '<p>11</p>');
INSERT INTO `yuanliaoxinxi` VALUES (1684999413994, '2023-05-25 15:23:33', '1684999402810', 'bb', 'upload/1684999408328.jpg', '原料类别2', 22, 11, '<p>11</p>');

SET FOREIGN_KEY_CHECKS = 1;
