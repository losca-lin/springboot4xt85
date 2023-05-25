-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot4xt85
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot4xt85`
--

/*!40000 DROP DATABASE IF EXISTS `springboot4xt85`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot4xt85` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot4xt85`;

--
-- Table structure for table `bumenxinxi`
--

DROP TABLE IF EXISTS `bumenxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bumenxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bumenmingcheng` varchar(200) DEFAULT NULL COMMENT '部门名称',
  `bumenfuzeren` varchar(200) DEFAULT NULL COMMENT '部门负责人',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `bangongquyu` varchar(200) DEFAULT NULL COMMENT '办公区域',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8 COMMENT='部门信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bumenxinxi`
--

LOCK TABLES `bumenxinxi` WRITE;
/*!40000 ALTER TABLE `bumenxinxi` DISABLE KEYS */;
INSERT INTO `bumenxinxi` VALUES (121,'2023-05-21 06:56:31','部门名称1','部门负责人1','联系电话1','办公区域1'),(122,'2023-05-21 06:56:31','部门名称2','部门负责人2','联系电话2','办公区域2'),(123,'2023-05-21 06:56:31','部门名称3','部门负责人3','联系电话3','办公区域3'),(124,'2023-05-21 06:56:31','部门名称4','部门负责人4','联系电话4','办公区域4'),(125,'2023-05-21 06:56:31','部门名称5','部门负责人5','联系电话5','办公区域5'),(126,'2023-05-21 06:56:31','部门名称6','部门负责人6','联系电话6','办公区域6'),(127,'2023-05-21 06:56:31','部门名称7','部门负责人7','联系电话7','办公区域7'),(128,'2023-05-21 06:56:31','部门名称8','部门负责人8','联系电话8','办公区域8');
/*!40000 ALTER TABLE `bumenxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caiwu`
--

DROP TABLE IF EXISTS `caiwu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caiwu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `caiwuzhanghao` varchar(200) NOT NULL COMMENT '财务账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `caiwuxingming` varchar(200) NOT NULL COMMENT '财务姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  PRIMARY KEY (`id`),
  UNIQUE KEY `caiwuzhanghao` (`caiwuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='财务';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caiwu`
--

LOCK TABLES `caiwu` WRITE;
/*!40000 ALTER TABLE `caiwu` DISABLE KEYS */;
INSERT INTO `caiwu` VALUES (21,'2023-05-21 06:56:31','财务账号1','123456','财务姓名1','男','13823888881'),(22,'2023-05-21 06:56:31','财务账号2','123456','财务姓名2','男','13823888882'),(23,'2023-05-21 06:56:31','财务账号3','123456','财务姓名3','男','13823888883'),(24,'2023-05-21 06:56:31','财务账号4','123456','财务姓名4','男','13823888884'),(25,'2023-05-21 06:56:31','财务账号5','123456','财务姓名5','男','13823888885'),(26,'2023-05-21 06:56:31','财务账号6','123456','财务姓名6','男','13823888886'),(27,'2023-05-21 06:56:31','财务账号7','123456','财务姓名7','男','13823888887'),(28,'2023-05-21 06:56:31','财务账号8','123456','财务姓名8','男','13823888888');
/*!40000 ALTER TABLE `caiwu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caiwushouzhi`
--

DROP TABLE IF EXISTS `caiwushouzhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caiwushouzhi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shouruleixing` varchar(200) DEFAULT NULL COMMENT '收入类型',
  `shouruneirong` varchar(200) DEFAULT NULL COMMENT '收入内容',
  `caiwuzhichu` int(11) DEFAULT NULL COMMENT '财务支出',
  `zhichuleixing` varchar(200) DEFAULT NULL COMMENT '支出类型',
  `caiwushouru` int(11) DEFAULT NULL COMMENT '财务收入',
  `zhichuneirong` varchar(200) DEFAULT NULL COMMENT '支出内容',
  `caiwujieyu` int(11) DEFAULT NULL COMMENT '财务结余',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  `caiwuzhanghao` varchar(200) DEFAULT NULL COMMENT '财务账号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='财务收支';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caiwushouzhi`
--

LOCK TABLES `caiwushouzhi` WRITE;
/*!40000 ALTER TABLE `caiwushouzhi` DISABLE KEYS */;
INSERT INTO `caiwushouzhi` VALUES (51,'2023-05-21 06:56:31','收入类型1','收入内容1',1,'支出类型1',1,'支出内容1',1,'2023-05-21','财务账号1'),(52,'2023-05-21 06:56:31','收入类型2','收入内容2',2,'支出类型2',2,'支出内容2',2,'2023-05-21','财务账号2'),(53,'2023-05-21 06:56:31','收入类型3','收入内容3',3,'支出类型3',3,'支出内容3',3,'2023-05-21','财务账号3'),(54,'2023-05-21 06:56:31','收入类型4','收入内容4',4,'支出类型4',4,'支出内容4',4,'2023-05-21','财务账号4'),(55,'2023-05-21 06:56:31','收入类型5','收入内容5',5,'支出类型5',5,'支出内容5',5,'2023-05-21','财务账号5'),(56,'2023-05-21 06:56:31','收入类型6','收入内容6',6,'支出类型6',6,'支出内容6',6,'2023-05-21','财务账号6'),(57,'2023-05-21 06:56:31','收入类型7','收入内容7',7,'支出类型7',7,'支出内容7',7,'2023-05-21','财务账号7'),(58,'2023-05-21 06:56:31','收入类型8','收入内容8',8,'支出类型8',8,'支出内容8',8,'2023-05-21','财务账号8');
/*!40000 ALTER TABLE `caiwushouzhi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chanpinleixing`
--

DROP TABLE IF EXISTS `chanpinleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chanpinleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `chanpinleixing` varchar(200) NOT NULL COMMENT '产品类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `chanpinleixing` (`chanpinleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='产品类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chanpinleixing`
--

LOCK TABLES `chanpinleixing` WRITE;
/*!40000 ALTER TABLE `chanpinleixing` DISABLE KEYS */;
INSERT INTO `chanpinleixing` VALUES (71,'2023-05-21 06:56:31','产品类型1'),(72,'2023-05-21 06:56:31','产品类型2'),(73,'2023-05-21 06:56:31','产品类型3'),(74,'2023-05-21 06:56:31','产品类型4'),(75,'2023-05-21 06:56:31','产品类型5'),(76,'2023-05-21 06:56:31','产品类型6'),(77,'2023-05-21 06:56:31','产品类型7'),(78,'2023-05-21 06:56:31','产品类型8');
/*!40000 ALTER TABLE `chanpinleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chanpinxiaoshouzhangmu`
--

DROP TABLE IF EXISTS `chanpinxiaoshouzhangmu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chanpinxiaoshouzhangmu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yejibianhao` varchar(200) DEFAULT NULL COMMENT '业绩编号',
  `xiaoshoue` float DEFAULT NULL COMMENT '销售额',
  `riqi` date DEFAULT NULL COMMENT '日期',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yejibianhao` (`yejibianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='产品销售账目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chanpinxiaoshouzhangmu`
--

LOCK TABLES `chanpinxiaoshouzhangmu` WRITE;
/*!40000 ALTER TABLE `chanpinxiaoshouzhangmu` DISABLE KEYS */;
INSERT INTO `chanpinxiaoshouzhangmu` VALUES (61,'2023-05-21 06:56:31','1111111111',1,'2023-05-21','备注1','员工工号1','员工姓名1'),(62,'2023-05-21 06:56:31','2222222222',2,'2023-05-21','备注2','员工工号2','员工姓名2'),(63,'2023-05-21 06:56:31','3333333333',3,'2023-05-21','备注3','员工工号3','员工姓名3'),(64,'2023-05-21 06:56:31','4444444444',4,'2023-05-21','备注4','员工工号4','员工姓名4'),(65,'2023-05-21 06:56:31','5555555555',5,'2023-05-21','备注5','员工工号5','员工姓名5'),(66,'2023-05-21 06:56:31','6666666666',6,'2023-05-21','备注6','员工工号6','员工姓名6'),(67,'2023-05-21 06:56:31','7777777777',7,'2023-05-21','备注7','员工工号7','员工姓名7'),(68,'2023-05-21 06:56:31','8888888888',8,'2023-05-21','备注8','员工工号8','员工姓名8');
/*!40000 ALTER TABLE `chanpinxiaoshouzhangmu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chanpinxinxi`
--

DROP TABLE IF EXISTS `chanpinxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chanpinxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `chanpinbianhao` varchar(200) DEFAULT NULL COMMENT '产品编号',
  `chanpinmingcheng` varchar(200) DEFAULT NULL COMMENT '产品名称',
  `chanpintupian` longtext COMMENT '产品图片',
  `chanpinleixing` varchar(200) DEFAULT NULL COMMENT '产品类型',
  `jiage` float DEFAULT NULL COMMENT '价格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `chanpinxiangqing` longtext COMMENT '产品详情',
  PRIMARY KEY (`id`),
  UNIQUE KEY `chanpinbianhao` (`chanpinbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COMMENT='产品信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chanpinxinxi`
--

LOCK TABLES `chanpinxinxi` WRITE;
/*!40000 ALTER TABLE `chanpinxinxi` DISABLE KEYS */;
INSERT INTO `chanpinxinxi` VALUES (81,'2023-05-21 06:56:31','1111111111','产品名称1','upload/chanpinxinxi_chanpintupian1.jpg,upload/chanpinxinxi_chanpintupian2.jpg,upload/chanpinxinxi_chanpintupian3.jpg','产品类型1',1,1,'产品详情1'),(82,'2023-05-21 06:56:31','2222222222','产品名称2','upload/chanpinxinxi_chanpintupian2.jpg,upload/chanpinxinxi_chanpintupian3.jpg,upload/chanpinxinxi_chanpintupian4.jpg','产品类型2',2,2,'产品详情2'),(83,'2023-05-21 06:56:31','3333333333','产品名称3','upload/chanpinxinxi_chanpintupian3.jpg,upload/chanpinxinxi_chanpintupian4.jpg,upload/chanpinxinxi_chanpintupian5.jpg','产品类型3',3,3,'产品详情3'),(84,'2023-05-21 06:56:31','4444444444','产品名称4','upload/chanpinxinxi_chanpintupian4.jpg,upload/chanpinxinxi_chanpintupian5.jpg,upload/chanpinxinxi_chanpintupian6.jpg','产品类型4',4,4,'产品详情4'),(85,'2023-05-21 06:56:31','5555555555','产品名称5','upload/chanpinxinxi_chanpintupian5.jpg,upload/chanpinxinxi_chanpintupian6.jpg,upload/chanpinxinxi_chanpintupian7.jpg','产品类型5',5,5,'产品详情5'),(86,'2023-05-21 06:56:31','6666666666','产品名称6','upload/chanpinxinxi_chanpintupian6.jpg,upload/chanpinxinxi_chanpintupian7.jpg,upload/chanpinxinxi_chanpintupian8.jpg','产品类型6',6,6,'产品详情6'),(87,'2023-05-21 06:56:31','7777777777','产品名称7','upload/chanpinxinxi_chanpintupian7.jpg,upload/chanpinxinxi_chanpintupian8.jpg,upload/chanpinxinxi_chanpintupian9.jpg','产品类型7',7,7,'产品详情7'),(88,'2023-05-21 06:56:31','8888888888','产品名称8','upload/chanpinxinxi_chanpintupian8.jpg,upload/chanpinxinxi_chanpintupian9.jpg,upload/chanpinxinxi_chanpintupian10.jpg','产品类型8',8,8,'产品详情8');
/*!40000 ALTER TABLE `chanpinxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2023-05-21 06:56:31','[{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"员工\",\"menuJump\":\"列表\",\"tableName\":\"yuangong\"}],\"menu\":\"员工管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"财务\",\"menuJump\":\"列表\",\"tableName\":\"caiwu\"}],\"menu\":\"财务管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\"],\"menu\":\"员工工资\",\"menuJump\":\"列表\",\"tableName\":\"yuangonggongzi\"}],\"menu\":\"员工工资管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"查看\"],\"menu\":\"员工报销\",\"menuJump\":\"列表\",\"tableName\":\"yuangongbaoxiao\"}],\"menu\":\"员工报销管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"查看\",\"首页统计\",\"首页总数\"],\"menu\":\"财务收支\",\"menuJump\":\"列表\",\"tableName\":\"caiwushouzhi\"}],\"menu\":\"财务收支管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-copy\",\"buttons\":[\"查看\"],\"menu\":\"产品销售账目\",\"menuJump\":\"列表\",\"tableName\":\"chanpinxiaoshouzhangmu\"}],\"menu\":\"产品销售账目管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"查看\"],\"menu\":\"产品类型\",\"menuJump\":\"列表\",\"tableName\":\"chanpinleixing\"}],\"menu\":\"产品类型管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"产品信息\",\"menuJump\":\"列表\",\"tableName\":\"chanpinxinxi\"}],\"menu\":\"产品信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"原料类别\",\"menuJump\":\"列表\",\"tableName\":\"yuanliaoleibie\"}],\"menu\":\"原料类别管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"menu\":\"原料采购\",\"menuJump\":\"列表\",\"tableName\":\"yuanliaocaigou\"}],\"menu\":\"原料采购管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"系统公告\",\"menuJump\":\"列表\",\"tableName\":\"xitonggonggao\"}],\"menu\":\"系统公告管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"部门信息\",\"menuJump\":\"列表\",\"tableName\":\"bumenxinxi\"}],\"menu\":\"部门信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-explore\",\"buttons\":[\"查看\",\"编辑名称\",\"编辑父级\",\"删除\"],\"menu\":\"菜单列表\",\"tableName\":\"menu\"}],\"menu\":\"系统管理\"}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\"],\"menu\":\"员工工资\",\"menuJump\":\"列表\",\"tableName\":\"yuangonggongzi\"}],\"menu\":\"员工工资管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"新增\",\"查看\",\"删除\"],\"menu\":\"员工报销\",\"menuJump\":\"列表\",\"tableName\":\"yuangongbaoxiao\"}],\"menu\":\"员工报销管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-copy\",\"buttons\":[\"新增\",\"查看\",\"删除\"],\"menu\":\"产品销售账目\",\"menuJump\":\"列表\",\"tableName\":\"chanpinxiaoshouzhangmu\"}],\"menu\":\"产品销售账目管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"查看\"],\"menu\":\"系统公告\",\"menuJump\":\"列表\",\"tableName\":\"xitonggonggao\"}],\"menu\":\"系统公告管理\"}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"员工\",\"tableName\":\"yuangong\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"支付\"],\"menu\":\"员工工资\",\"menuJump\":\"列表\",\"tableName\":\"yuangonggongzi\"}],\"menu\":\"员工工资管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"支付\"],\"menu\":\"员工报销\",\"menuJump\":\"列表\",\"tableName\":\"yuangongbaoxiao\"}],\"menu\":\"员工报销管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"首页总数\",\"首页统计\"],\"menu\":\"财务收支\",\"menuJump\":\"列表\",\"tableName\":\"caiwushouzhi\"}],\"menu\":\"财务收支管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-copy\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"报表\"],\"menu\":\"产品销售账目\",\"menuJump\":\"列表\",\"tableName\":\"chanpinxiaoshouzhangmu\"}],\"menu\":\"产品销售账目管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"支付\"],\"menu\":\"原料采购\",\"menuJump\":\"列表\",\"tableName\":\"yuanliaocaigou\"}],\"menu\":\"原料采购管理\"}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"财务\",\"tableName\":\"caiwu\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1,'admin','users','管理员','rvmxqzjjiesol5suyq3zt47boir85z8x','2023-05-21 06:59:47','2023-05-21 08:02:07'),(2,11,'员工工号1','yuangong','员工','sg2t4iiencnvbcwwj43s292i7iu96i84','2023-05-21 07:00:19','2023-05-21 08:00:19');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','管理员','2023-05-21 06:56:31');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xitonggonggao`
--

DROP TABLE IF EXISTS `xitonggonggao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xitonggonggao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `neirong` longtext COMMENT '内容',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `biaoti` varchar(200) DEFAULT NULL COMMENT '标题',
  `faburen` varchar(200) DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 COMMENT='系统公告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xitonggonggao`
--

LOCK TABLES `xitonggonggao` WRITE;
/*!40000 ALTER TABLE `xitonggonggao` DISABLE KEYS */;
INSERT INTO `xitonggonggao` VALUES (111,'2023-05-21 06:56:31','内容1','2023-05-21','标题1','发布人1'),(112,'2023-05-21 06:56:31','内容2','2023-05-21','标题2','发布人2'),(113,'2023-05-21 06:56:31','内容3','2023-05-21','标题3','发布人3'),(114,'2023-05-21 06:56:31','内容4','2023-05-21','标题4','发布人4'),(115,'2023-05-21 06:56:31','内容5','2023-05-21','标题5','发布人5'),(116,'2023-05-21 06:56:31','内容6','2023-05-21','标题6','发布人6'),(117,'2023-05-21 06:56:31','内容7','2023-05-21','标题7','发布人7'),(118,'2023-05-21 06:56:31','内容8','2023-05-21','标题8','发布人8');
/*!40000 ALTER TABLE `xitonggonggao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangong`
--

DROP TABLE IF EXISTS `yuangong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) NOT NULL COMMENT '员工工号',
  `mima` varchar(200) DEFAULT NULL COMMENT '密码',
  `yuangongxingming` varchar(200) NOT NULL COMMENT '员工姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `ruzhishijian` date DEFAULT NULL COMMENT '入职时间',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `gongzikahao` varchar(200) DEFAULT NULL COMMENT '工资卡号',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yuangonggonghao` (`yuangonggonghao`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='员工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangong`
--

LOCK TABLES `yuangong` WRITE;
/*!40000 ALTER TABLE `yuangong` DISABLE KEYS */;
INSERT INTO `yuangong` VALUES (11,'2023-05-21 06:56:31','员工工号1','123456','员工姓名1','男','部门1','职位1','2023-05-21','13823888881','工资卡号1','440300199101010001'),(12,'2023-05-21 06:56:31','员工工号2','123456','员工姓名2','男','部门2','职位2','2023-05-21','13823888882','工资卡号2','440300199202020002'),(13,'2023-05-21 06:56:31','员工工号3','123456','员工姓名3','男','部门3','职位3','2023-05-21','13823888883','工资卡号3','440300199303030003'),(14,'2023-05-21 06:56:31','员工工号4','123456','员工姓名4','男','部门4','职位4','2023-05-21','13823888884','工资卡号4','440300199404040004'),(15,'2023-05-21 06:56:31','员工工号5','123456','员工姓名5','男','部门5','职位5','2023-05-21','13823888885','工资卡号5','440300199505050005'),(16,'2023-05-21 06:56:31','员工工号6','123456','员工姓名6','男','部门6','职位6','2023-05-21','13823888886','工资卡号6','440300199606060006'),(17,'2023-05-21 06:56:31','员工工号7','123456','员工姓名7','男','部门7','职位7','2023-05-21','13823888887','工资卡号7','440300199707070007'),(18,'2023-05-21 06:56:31','员工工号8','123456','员工姓名8','男','部门8','职位8','2023-05-21','13823888888','工资卡号8','440300199808080008');
/*!40000 ALTER TABLE `yuangong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangongbaoxiao`
--

DROP TABLE IF EXISTS `yuangongbaoxiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangongbaoxiao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `baoxiaobiaoti` varchar(200) NOT NULL COMMENT '报销标题',
  `yuefen` varchar(200) NOT NULL COMMENT '月份',
  `baoxiaoneirong` longtext NOT NULL COMMENT '报销内容',
  `baoxiaowenjian` longtext COMMENT '报销文件',
  `baoxiaojine` int(11) DEFAULT NULL COMMENT '报销金额',
  `shenqingriqi` date DEFAULT NULL COMMENT '申请日期',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='员工报销';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangongbaoxiao`
--

LOCK TABLES `yuangongbaoxiao` WRITE;
/*!40000 ALTER TABLE `yuangongbaoxiao` DISABLE KEYS */;
INSERT INTO `yuangongbaoxiao` VALUES (41,'2023-05-21 06:56:31','报销标题1','1月份','报销内容1','',1,'2023-05-21','员工工号1','员工姓名1','13823888881','部门1','职位1','是','','未支付'),(42,'2023-05-21 06:56:31','报销标题2','1月份','报销内容2','',2,'2023-05-21','员工工号2','员工姓名2','13823888882','部门2','职位2','是','','未支付'),(43,'2023-05-21 06:56:31','报销标题3','1月份','报销内容3','',3,'2023-05-21','员工工号3','员工姓名3','13823888883','部门3','职位3','是','','未支付'),(44,'2023-05-21 06:56:31','报销标题4','1月份','报销内容4','',4,'2023-05-21','员工工号4','员工姓名4','13823888884','部门4','职位4','是','','未支付'),(45,'2023-05-21 06:56:31','报销标题5','1月份','报销内容5','',5,'2023-05-21','员工工号5','员工姓名5','13823888885','部门5','职位5','是','','未支付'),(46,'2023-05-21 06:56:31','报销标题6','1月份','报销内容6','',6,'2023-05-21','员工工号6','员工姓名6','13823888886','部门6','职位6','是','','未支付'),(47,'2023-05-21 06:56:31','报销标题7','1月份','报销内容7','',7,'2023-05-21','员工工号7','员工姓名7','13823888887','部门7','职位7','是','','未支付'),(48,'2023-05-21 06:56:31','报销标题8','1月份','报销内容8','',8,'2023-05-21','员工工号8','员工姓名8','13823888888','部门8','职位8','是','','未支付');
/*!40000 ALTER TABLE `yuangongbaoxiao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangonggongzi`
--

DROP TABLE IF EXISTS `yuangonggongzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangonggongzi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nianyuefen` varchar(200) NOT NULL COMMENT '年月份',
  `yuangonggonghao` varchar(200) NOT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `gongzikahao` varchar(200) DEFAULT NULL COMMENT '工资卡号',
  `dixin` float NOT NULL COMMENT '底薪',
  `quanqinjiang` float NOT NULL COMMENT '全勤奖',
  `jiabanfei` float NOT NULL COMMENT '加班费',
  `jixiaojiangjin` float NOT NULL COMMENT '绩效奖金',
  `qitakoukuan` float NOT NULL COMMENT '其它扣款',
  `jine` float DEFAULT NULL COMMENT '金额',
  `gongzibeizhu` varchar(200) DEFAULT NULL COMMENT '工资备注',
  `dengjishijian` datetime DEFAULT NULL COMMENT '登记时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='员工工资';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangonggongzi`
--

LOCK TABLES `yuangonggongzi` WRITE;
/*!40000 ALTER TABLE `yuangonggongzi` DISABLE KEYS */;
INSERT INTO `yuangonggongzi` VALUES (31,'2023-05-21 06:56:31','年月份1','员工工号1','员工姓名1','职位1','部门1','工资卡号1',1,1,1,1,1,1,'工资备注1','2023-05-21 14:56:31'),(32,'2023-05-21 06:56:31','年月份2','员工工号2','员工姓名2','职位2','部门2','工资卡号2',2,2,2,2,2,2,'工资备注2','2023-05-21 14:56:31'),(33,'2023-05-21 06:56:31','年月份3','员工工号3','员工姓名3','职位3','部门3','工资卡号3',3,3,3,3,3,3,'工资备注3','2023-05-21 14:56:31'),(34,'2023-05-21 06:56:31','年月份4','员工工号4','员工姓名4','职位4','部门4','工资卡号4',4,4,4,4,4,4,'工资备注4','2023-05-21 14:56:31'),(35,'2023-05-21 06:56:31','年月份5','员工工号5','员工姓名5','职位5','部门5','工资卡号5',5,5,5,5,5,5,'工资备注5','2023-05-21 14:56:31'),(36,'2023-05-21 06:56:31','年月份6','员工工号6','员工姓名6','职位6','部门6','工资卡号6',6,6,6,6,6,6,'工资备注6','2023-05-21 14:56:31'),(37,'2023-05-21 06:56:31','年月份7','员工工号7','员工姓名7','职位7','部门7','工资卡号7',7,7,7,7,7,7,'工资备注7','2023-05-21 14:56:31'),(38,'2023-05-21 06:56:31','年月份8','员工工号8','员工姓名8','职位8','部门8','工资卡号8',8,8,8,8,8,8,'工资备注8','2023-05-21 14:56:31');
/*!40000 ALTER TABLE `yuangonggongzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuanliaocaigou`
--

DROP TABLE IF EXISTS `yuanliaocaigou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuanliaocaigou` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `yuanliaobianhao` varchar(200) DEFAULT NULL COMMENT '原料编号',
  `yuanliaoleibie` varchar(200) DEFAULT NULL COMMENT '原料类别',
  `yuanliaomingcheng` varchar(200) DEFAULT NULL COMMENT '原料名称',
  `yuanliaoguige` varchar(200) DEFAULT NULL COMMENT '原料规格',
  `gongyingchangshang` varchar(200) DEFAULT NULL COMMENT '供应厂商',
  `caigoujiage` varchar(200) DEFAULT NULL COMMENT '采购价格',
  `caigourenyuan` varchar(200) DEFAULT NULL COMMENT '采购人员',
  `caigoushijian` datetime DEFAULT NULL COMMENT '采购时间',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dingdanbianhao` (`dingdanbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COMMENT='原料采购';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuanliaocaigou`
--

LOCK TABLES `yuanliaocaigou` WRITE;
/*!40000 ALTER TABLE `yuanliaocaigou` DISABLE KEYS */;
INSERT INTO `yuanliaocaigou` VALUES (101,'2023-05-21 06:56:31','1111111111','原料编号1','原料类别1','原料名称1','原料规格1','供应厂商1','采购价格1','采购人员1','2023-05-21 14:56:31','未支付'),(102,'2023-05-21 06:56:31','2222222222','原料编号2','原料类别2','原料名称2','原料规格2','供应厂商2','采购价格2','采购人员2','2023-05-21 14:56:31','未支付'),(103,'2023-05-21 06:56:31','3333333333','原料编号3','原料类别3','原料名称3','原料规格3','供应厂商3','采购价格3','采购人员3','2023-05-21 14:56:31','未支付'),(104,'2023-05-21 06:56:31','4444444444','原料编号4','原料类别4','原料名称4','原料规格4','供应厂商4','采购价格4','采购人员4','2023-05-21 14:56:31','未支付'),(105,'2023-05-21 06:56:31','5555555555','原料编号5','原料类别5','原料名称5','原料规格5','供应厂商5','采购价格5','采购人员5','2023-05-21 14:56:31','未支付'),(106,'2023-05-21 06:56:31','6666666666','原料编号6','原料类别6','原料名称6','原料规格6','供应厂商6','采购价格6','采购人员6','2023-05-21 14:56:31','未支付'),(107,'2023-05-21 06:56:31','7777777777','原料编号7','原料类别7','原料名称7','原料规格7','供应厂商7','采购价格7','采购人员7','2023-05-21 14:56:31','未支付'),(108,'2023-05-21 06:56:31','8888888888','原料编号8','原料类别8','原料名称8','原料规格8','供应厂商8','采购价格8','采购人员8','2023-05-21 14:56:31','未支付');
/*!40000 ALTER TABLE `yuanliaocaigou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuanliaoleibie`
--

DROP TABLE IF EXISTS `yuanliaoleibie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuanliaoleibie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuanliaoleibie` varchar(200) NOT NULL COMMENT '原料类别',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yuanliaoleibie` (`yuanliaoleibie`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COMMENT='原料类别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuanliaoleibie`
--

LOCK TABLES `yuanliaoleibie` WRITE;
/*!40000 ALTER TABLE `yuanliaoleibie` DISABLE KEYS */;
INSERT INTO `yuanliaoleibie` VALUES (91,'2023-05-21 06:56:31','原料类别1'),(92,'2023-05-21 06:56:31','原料类别2'),(93,'2023-05-21 06:56:31','原料类别3'),(94,'2023-05-21 06:56:31','原料类别4'),(95,'2023-05-21 06:56:31','原料类别5'),(96,'2023-05-21 06:56:31','原料类别6'),(97,'2023-05-21 06:56:31','原料类别7'),(98,'2023-05-21 06:56:31','原料类别8');
/*!40000 ALTER TABLE `yuanliaoleibie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-24 11:53:52
