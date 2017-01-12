我才疏学浅，忘记加一个sql文件了,所以这样吧，我直接贴上来。
/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : servlet

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2017-01-12 19:59:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `own_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('1', '1', '馄饨', '3', '2017-01-05 20:31:38', '1');
INSERT INTO `bill` VALUES ('2', '2', '房租', '5', '2017-01-05 20:32:30', '1');
INSERT INTO `bill` VALUES ('4', '4', '耐克Air', '666', '2017-01-05 20:33:46', '1');
INSERT INTO `bill` VALUES ('51', '2', '房租', '1111', '2017-01-12 10:59:11', '2');
INSERT INTO `bill` VALUES ('52', '4', '他', '545', '2017-01-12 10:34:15', '1');
INSERT INTO `bill` VALUES ('53', '1', '德尔惠', '867', '2017-01-12 10:53:09', '2');
INSERT INTO `bill` VALUES ('54', '3', 'Topfeeling', '43', '2017-01-12 10:53:50', '2');
INSERT INTO `bill` VALUES ('55', '1', '辣啡', '54', '2017-01-12 10:49:34', '2');
INSERT INTO `bill` VALUES ('56', '5', '大四', '12', '2017-01-12 10:35:29', '2');
INSERT INTO `bill` VALUES ('57', '2', 'fd', '3', '2017-01-12 12:48:15', '2');
INSERT INTO `bill` VALUES ('58', '4', '辅导费', '3', '2017-01-12 12:48:23', '2');
INSERT INTO `bill` VALUES ('59', '2', '4', '53', '2017-01-12 12:48:32', '2');
INSERT INTO `bill` VALUES ('60', '2', '份', '34', '2017-01-12 12:48:43', '2');
INSERT INTO `bill` VALUES ('61', '2', '放个', '24', '2017-01-12 12:48:51', '2');
INSERT INTO `bill` VALUES ('62', '1', '份', '234', '2017-01-12 12:49:02', '2');
INSERT INTO `bill` VALUES ('63', '2', '发送', '34', '2017-01-12 12:49:13', '2');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL DEFAULT '0',
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '吃');
INSERT INTO `type` VALUES ('2', '住');
INSERT INTO `type` VALUES ('3', '衣服');
INSERT INTO `type` VALUES ('4', '鞋子');
INSERT INTO `type` VALUES ('5', '通讯');
INSERT INTO `type` VALUES ('6', '玩');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `tele` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '陈亚兰', 'chenyalan', '24', '1515935895839');
INSERT INTO `t_user` VALUES ('2', 'caoxi', 'caoxi', '38', '1784738549574');
INSERT INTO `t_user` VALUES ('3', '卫隆', 'weilong', '43', '1565645635346');
INSERT INTO `t_user` VALUES ('4', '阿监', 'ajian', '12', '3246153453452');
INSERT INTO `t_user` VALUES ('5', '艾洛', 'ailuo', '32', '1531535461');
INSERT INTO `t_user` VALUES ('6', '陈佳', 'chenjia', '23', '189321935478');
INSERT INTO `t_user` VALUES ('7', '六四', 'liusi7', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('8', '六四', 'liusi8', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('9', '六四', 'liusi9', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('10', '六四', 'liusi10', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('11', '六四', 'liusi11', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('12', '六四', 'liusi12', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('13', '六四', 'liusi13', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('14', '六四', 'liusi14', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('15', '六四', 'liusi15', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('16', '六四', 'liusi16', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('17', '六四', 'liusi17', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('18', '六四', 'liusi18', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('19', '六四', 'liusi19', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('20', '六四', 'liusi20', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('21', '六四', 'liusi21', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('22', '六四', 'liusi22', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('23', '六四', 'liusi23', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('24', '六四', 'liusi24', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('25', '六四', 'liusi25', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('26', '六四', 'liusi26', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('27', '六四', 'liusi27', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('28', '六四', 'liusi28', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('29', '六四', 'liusi29', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('30', '六四', 'liusi30', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('31', '六四', 'liusi31', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('32', '六四', 'liusi32', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('33', '六四', 'liusi33', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('34', '六四', 'liusi34', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('35', '六四', 'liusi35', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('36', '六四', 'liusi36', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('37', '六四', 'liusi37', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('38', '六四', 'liusi38', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('39', '六四', 'liusi39', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('40', '六四', 'liusi40', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('41', '六四', 'liusi41', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('42', '六四', 'liusi42', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('43', '六四', 'liusi43', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('44', '六四', 'liusi44', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('45', '六四', 'liusi45', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('46', '六四', 'liusi46', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('47', '六四', 'liusi47', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('48', '六四', 'liusi48', '24', '1823434935478');
INSERT INTO `t_user` VALUES ('49', 'caoxi', null, '33', '152352452');
