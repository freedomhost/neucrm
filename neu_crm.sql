/*
Navicat MySQL Data Transfer

Source Server         : Ma
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : neu_crm

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-12-07 10:02:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contact_record
-- ----------------------------
DROP TABLE IF EXISTS `contact_record`;
CREATE TABLE `contact_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 编号',
  `place` varchar(100) DEFAULT NULL COMMENT '地点 地点',
  `outline` varchar(200) DEFAULT NULL COMMENT '概要 概要',
  `detailed_info` varchar(300) DEFAULT NULL COMMENT '详细信息 详细信息',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注 备注',
  `contact_time` timestamp NULL DEFAULT NULL COMMENT '交往时间 交往时间',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户编号 客户编号',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_交往时ord_customer_idB3ED` (`customer_id`) USING BTREE,
  CONSTRAINT `FK_交往时ord_customer_idB3ED` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='交往记录 交往记录';

-- ----------------------------
-- Records of contact_record
-- ----------------------------
INSERT INTO `contact_record` VALUES ('1', '公司', '邀请到公司参观', '', '', '2007-07-25 00:00:00', '1');
INSERT INTO `contact_record` VALUES ('2', 'kfc', '签订合作意向', '', '', '2007-08-01 00:00:00', '1');
INSERT INTO `contact_record` VALUES ('3', '公司', '进一步合作展望', '', '', '2008-05-25 00:00:00', '1');
INSERT INTO `contact_record` VALUES ('4', '公司', '邀请到公司参观', '', '', '2008-06-10 00:00:00', '2');
INSERT INTO `contact_record` VALUES ('5', '敦煌大酒店', '签订合作合同', '', '有意进一步合作', '2018-11-28 00:00:00', '2');
INSERT INTO `contact_record` VALUES ('6', '公司', '邀请到公司参观', '', '', '2009-01-01 00:00:00', '3');
INSERT INTO `contact_record` VALUES ('7', '街角咖啡厅', '签订长期合作意向', '', '', '2009-01-25 00:00:00', '3');
INSERT INTO `contact_record` VALUES ('21', '公司', '邀请到公司参观', '', '', '2009-05-05 00:00:00', '4');
INSERT INTO `contact_record` VALUES ('22', '公司', '签订长期合作意向', '', '', '2009-05-25 00:00:00', '4');
INSERT INTO `contact_record` VALUES ('23', '公司', '邀请到公司参观', '', '', '2010-03-04 00:00:00', '5');
INSERT INTO `contact_record` VALUES ('24', '公司', '签订长期合作意向', '', '', '2010-03-29 00:00:00', '5');
INSERT INTO `contact_record` VALUES ('25', '公司', '邀请到公司参观', '', '', '2011-06-07 00:00:00', '6');
INSERT INTO `contact_record` VALUES ('26', '公司', '签订长期合作意向', '', '', '2011-06-25 00:00:00', '6');
INSERT INTO `contact_record` VALUES ('27', '公司', '邀请到公司参观', '', '', '2012-08-08 00:00:00', '7');
INSERT INTO `contact_record` VALUES ('28', '公司', '签订长期合作意向', '', '', '2012-08-18 00:00:00', '7');
INSERT INTO `contact_record` VALUES ('29', '公司', '邀请到公司参观', '', '', '2013-09-05 00:00:00', '8');
INSERT INTO `contact_record` VALUES ('30', '公司', '签订长期合作意向', '', '', '2013-09-25 00:00:00', '8');

-- ----------------------------
-- Table structure for customer_contact
-- ----------------------------
DROP TABLE IF EXISTS `customer_contact`;
CREATE TABLE `customer_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(25) DEFAULT NULL COMMENT '姓名 姓名',
  `sex` varchar(6) DEFAULT NULL COMMENT '性别 性别',
  `job` varchar(32) DEFAULT NULL COMMENT '职位 职位',
  `phone` varchar(32) DEFAULT NULL COMMENT '办公电话 办公电话',
  `tel` varchar(32) DEFAULT NULL COMMENT '手机 手机',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注 备注',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户编号 客户编号',
  `founder` varchar(100) DEFAULT NULL COMMENT '创建人 创建人',
  `found_id` int(11) DEFAULT NULL COMMENT '创建人编号 创建人编号',
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间 创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_customeact_custome_id0269` (`customer_id`) USING BTREE,
  CONSTRAINT `FK_customeact_custome_id0269` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='客户联系人 客户联系人';

-- ----------------------------
-- Records of customer_contact
-- ----------------------------
INSERT INTO `customer_contact` VALUES ('1', '李煜强', '男', '总经理', '010-68345853-365', '13622883228', '', '1', null, null, '2018-11-26 15:58:05');
INSERT INTO `customer_contact` VALUES ('2', '杨颖', '女', '总经理助理', '010-68348438-326', '13728838283', null, '1', null, null, '2018-11-26 15:58:05');
INSERT INTO `customer_contact` VALUES ('3', '李江', '男', '总经理', '010-68348438-778', '13622884585', null, '2', null, null, '2018-11-26 15:58:05');
INSERT INTO `customer_contact` VALUES ('4', '张彤', '女', '总经理助理', '010-68348438-556', '13622881254', null, '2', null, null, '2018-11-26 15:58:05');
INSERT INTO `customer_contact` VALUES ('5', '李国忠', '男', '总经理', '010-68348438-338', '13622881111', null, '3', null, null, '2018-11-26 15:58:05');
INSERT INTO `customer_contact` VALUES ('22', '李学明', '男', '总经理', '010-123654645', '12345678910', '', '4', null, null, '2018-12-03 10:31:46');
INSERT INTO `customer_contact` VALUES ('23', '梅城年', '女', '总经理助理', '0101-1234567456', '12345678910', '', '4', null, null, '2018-12-03 10:33:29');
INSERT INTO `customer_contact` VALUES ('24', '李明', '男', '总经理', '021-565464564', '12345678910', '', '5', null, null, '2018-12-03 10:34:52');
INSERT INTO `customer_contact` VALUES ('25', '杨琴', '女', '总经理助理', '021-456456455', '12345678910', '', '5', null, null, '2018-12-03 10:35:21');
INSERT INTO `customer_contact` VALUES ('26', '马菲菲', '女', '总经理', '010-123456789', '12345678910', '', '6', null, null, '2018-12-03 10:36:26');
INSERT INTO `customer_contact` VALUES ('29', '李芸', '女', '总经理助理', '010-123456858', '12345678923', '', '6', null, null, '2018-12-03 10:37:56');
INSERT INTO `customer_contact` VALUES ('30', '吴明', '男', '总经理', '010-123456789', '12345678910', '', '7', null, null, '2018-12-03 10:38:47');
INSERT INTO `customer_contact` VALUES ('31', '吴凯', '男', '总经理助理', '010-123456584', '1234567856', '', '7', null, null, '2018-12-03 10:39:13');
INSERT INTO `customer_contact` VALUES ('32', '翁菲菲', '女', '总经理', '010-123456789', '12345678910', '', '8', null, null, '2018-12-03 10:39:45');
INSERT INTO `customer_contact` VALUES ('33', '张学名', '男', '总经理助理', '010-123456756', '12345678356', '', '8', null, null, '2018-12-03 10:40:18');

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户编号 客户编号',
  `customer_name` varchar(25) DEFAULT NULL COMMENT '客户名称 客户名称',
  `city` varchar(100) DEFAULT NULL COMMENT '地区 地区',
  `customer_mgr` varchar(64) DEFAULT NULL COMMENT '客户经理 客户经理',
  `customer_mgr_id` decimal(64,0) DEFAULT NULL COMMENT '客户经理编号 客户经理编号',
  `customer_grade` varchar(64) DEFAULT NULL COMMENT '客户等级 客户等级',
  `customer_satisfaction` varchar(64) DEFAULT NULL COMMENT '客户满意度 客户满意度',
  `customer_credit` varchar(64) DEFAULT NULL COMMENT '客户信用度 客户信用度',
  `address` varchar(255) DEFAULT NULL COMMENT '地址 地址',
  `postal_code` decimal(10,0) DEFAULT NULL COMMENT '邮政编码 邮政编码',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话 电话',
  `fax` varchar(32) DEFAULT NULL COMMENT '传真 传真',
  `ulr` varchar(64) DEFAULT NULL COMMENT '网址 网址',
  `business_license` varchar(64) DEFAULT NULL COMMENT '营业执照注册号 营业执照注册号',
  `juridical_person` varchar(64) DEFAULT NULL COMMENT '法人 法人',
  `registered_capital` double(11,2) DEFAULT NULL COMMENT '注册资金 注册资金',
  `annual_sales` double(11,2) DEFAULT NULL COMMENT '年营业额 年营业额',
  `deposit_bank` varchar(64) DEFAULT NULL COMMENT '开户银行 开户银行',
  `bank_account` varchar(32) DEFAULT NULL COMMENT '银行账号 银行账号',
  `land_tax_code` varchar(32) DEFAULT NULL COMMENT '地税登记号 地税登记号',
  `central_tax` varchar(32) DEFAULT NULL COMMENT '国税登记号 国税登记号',
  `founder` varchar(100) DEFAULT NULL COMMENT '创建人 创建人',
  `found_id` int(11) DEFAULT NULL COMMENT '创建人编号 创建人编号',
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 创建时间',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='客户信息 客户信息';

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES ('1', '百度公司', '天津市', '小东', null, '重点开发客户', '☆☆☆☆', '☆☆☆☆', '中国北京海淀区上地十街10号百度大厦', '100000', '12345678910', '1231234', 'http://www.baidu.com', '12312312312312', '李彦宏', '10000.00', '5000.00', '123123123', '12312312', '123123123', '123123123123', null, null, '2018-11-26 08:48:37');
INSERT INTO `customer_info` VALUES ('2', '腾讯公司', '广东省', '小西', null, '重点开发客户', '☆☆☆☆☆', '☆☆☆☆☆', '中国广东深圳腾讯大厦', '518000', '12345678910', '010-11231254654654', 'http://qq.com', '', '马化腾', '10000.00', '5000.00', '工商银行', '6456546456546546', '', '', null, null, '2018-11-26 08:48:37');
INSERT INTO `customer_info` VALUES ('3', '网易公司', '广东省', '小北', null, '重点开发客户', '☆☆☆☆', '☆☆☆☆', '中国广东广州网易大厦', '510000', '12345678910', '010-546546546546', 'http://163.com', '', '丁磊', '10000.00', '5000.00', '中国银行', '6546546486546456', '', '', null, null, '2018-11-26 08:48:37');
INSERT INTO `customer_info` VALUES ('4', '阿里巴巴集团', '浙江省', '小北', null, '战略合作伙伴', '☆☆☆☆☆', '☆☆☆☆☆', '中国杭州阿里巴巴大厦', '310000', '12345678910', '010-45654674', 'http://www.alibaba.com', '330100400015575', '马云', '359690.00', '559690.00', '工商银行', '6523585456486546', '', '', null, null, '2018-12-03 09:38:27');
INSERT INTO `customer_info` VALUES ('5', '盛大游戏', '上海市', '小西', null, '合作伙伴', '☆☆☆☆', '☆☆☆☆', '上海 浦东新区 碧波路690号张江微电子港1号楼', '200000', '12345678910', '021-60588688', 'http://www.shandagames.com', '', '马浩广', '100000.00', '750000.00', '建设银行', '6456453123546546', '', '', null, null, '2018-12-03 09:49:24');
INSERT INTO `customer_info` VALUES ('6', '华为科技', '广东省', '小东', null, '合作伙伴', '☆☆☆☆☆', '☆☆☆☆', '中国广东省深圳市龙岗区坂田华为总部办公楼', '518000', '12345678910', '010-546546546', 'http://www.huawei.com', '440301103097413', '赵明路', '3990813.00', '6036000.00', '中国银行', '65255645648648', '', '', null, null, '2018-12-03 10:04:40');
INSERT INTO `customer_info` VALUES ('7', '中兴通讯', '广东省', '小西', null, '战略合作伙伴', '☆☆☆☆☆', '☆☆☆☆☆', '深圳市南山区高新技术产业园科技南路中兴通讯大厦', '518000', '12345678910', '021-5465436546', 'https://www.zte.com.cn', '440301103852869', '李自学', '419267.00', '41926700.00', '中国银行', '45654654654654654', '', '', null, null, '2018-12-03 10:20:31');
INSERT INTO `customer_info` VALUES ('8', '海信集团', '山东省', '小西', null, '大客户', '☆☆☆☆', '☆☆☆☆☆', '山东省青岛市市南区东海西路17号', '266000', '12345678910', '010-45645645546', 'https://www.hisense.com', '370200018019931', '周厚健', '80617.00', '10000.00', '工商银行', '6456786546546456', '', '', null, null, '2018-12-03 10:25:44');

-- ----------------------------
-- Table structure for customer_loss
-- ----------------------------
DROP TABLE IF EXISTS `customer_loss`;
CREATE TABLE `customer_loss` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 流失编号',
  `customer_name` varchar(64) DEFAULT NULL COMMENT '客户名称 客户名称',
  `customer_mgr` varchar(64) DEFAULT NULL COMMENT '客户经理 客户经理',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户编号 客户编号',
  `last_order_time` timestamp NULL DEFAULT NULL COMMENT '上次下单时间 上次下单时间',
  `pause_way` varchar(100) DEFAULT NULL COMMENT '暂缓措施 暂缓措施',
  `add_pause_way` varchar(100) DEFAULT NULL COMMENT '追加暂缓措施 暂缓措施',
  `loss_time` timestamp NULL DEFAULT NULL COMMENT '确认流失时间 确认流失时间',
  `loss_reason` varchar(300) DEFAULT NULL COMMENT '流失原因 流失原因',
  `status` int(2) DEFAULT '2' COMMENT '状态（0：暂缓流失，1：确认流失,2:流失预警）',
  PRIMARY KEY (`id`),
  KEY `FK_customeoss_custome_idBFA9` (`customer_id`),
  CONSTRAINT `FK_customeoss_custome_idBFA9` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='客户流失 客户流失';

-- ----------------------------
-- Records of customer_loss
-- ----------------------------
INSERT INTO `customer_loss` VALUES ('1', '阿里巴巴集团', '小北', '4', '2017-09-15 08:37:05', '打电话联系客户，询问客户近况', '给客户介绍该产品的最新版本或者最新的功能', '2018-12-06 23:13:10', '客户有了更好的选择，我们只能忍痛流失了', '1');
INSERT INTO `customer_loss` VALUES ('2', '华为科技', '小东', '6', '2016-08-30 08:37:05', '打电话给客户了解不再购买产品的原因', null, null, null, '0');
INSERT INTO `customer_loss` VALUES ('3', '盛大游戏', '小西', '5', '2017-10-12 14:29:52', '电话联系', '介绍我司新产品', '2018-12-06 22:35:56', '无需求购买产品', '1');
INSERT INTO `customer_loss` VALUES ('4', '中兴通讯', '小西', '7', '2017-06-20 08:37:05', null, null, null, null, '0');
INSERT INTO `customer_loss` VALUES ('8', '腾讯公司', '小西', '2', '2018-05-16 14:33:27', null, null, null, null, '2');

-- ----------------------------
-- Table structure for data_dict
-- ----------------------------
DROP TABLE IF EXISTS `data_dict`;
CREATE TABLE `data_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL COMMENT '类别',
  `title` varchar(255) DEFAULT NULL COMMENT '条目',
  `value` int(11) DEFAULT NULL COMMENT '值',
  `status` int(11) DEFAULT '0' COMMENT '状态码（0：可编辑，1：不可编辑）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_dict
-- ----------------------------
INSERT INTO `data_dict` VALUES ('1', '企业客户等级', '普通客户', '1', '0');
INSERT INTO `data_dict` VALUES ('2', '企业客户等级', '重点开发客户', '2', '0');
INSERT INTO `data_dict` VALUES ('3', '企业客户等级', '大客户', '3', '0');
INSERT INTO `data_dict` VALUES ('4', '企业客户等级', '合作伙伴', '4', '0');
INSERT INTO `data_dict` VALUES ('5', '企业客户等级', '战略合作伙伴', '5', '0');
INSERT INTO `data_dict` VALUES ('6', '服务类型', '咨询', '1', '0');
INSERT INTO `data_dict` VALUES ('7', '服务类型', '建议', '2', '0');
INSERT INTO `data_dict` VALUES ('8', '服务类型', '投诉', '3', '0');
INSERT INTO `data_dict` VALUES ('9', '服务管理状态', '新创建', '0', '0');
INSERT INTO `data_dict` VALUES ('10', '服务管理状态', '已分配', '1', '0');
INSERT INTO `data_dict` VALUES ('11', '服务管理状态', '已处理', '2', '0');
INSERT INTO `data_dict` VALUES ('12', '服务管理状态', '已归档', '3', '0');

-- ----------------------------
-- Table structure for draw_plan
-- ----------------------------
DROP TABLE IF EXISTS `draw_plan`;
CREATE TABLE `draw_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `opportunity_id` int(11) DEFAULT NULL COMMENT '销售机会编号 销售机会编号',
  `plan_time` timestamp NULL DEFAULT NULL COMMENT '计划时间 计划时间',
  `plan_item` varchar(300) DEFAULT NULL COMMENT '计划项 计划项',
  `result` varchar(4000) DEFAULT NULL COMMENT '执行效果 执行效果',
  `founder` varchar(100) DEFAULT NULL COMMENT '创建人 创建人',
  `found_id` int(11) DEFAULT NULL COMMENT '创建人编号 创建人编号',
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 创建时间',
  PRIMARY KEY (`id`),
  KEY `FK_draw_plan_opportun_id6BB1` (`opportunity_id`),
  CONSTRAINT `draw_plan_ibfk_1` FOREIGN KEY (`opportunity_id`) REFERENCES `sales_opportunity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='制定计划 制定计划';

-- ----------------------------
-- Records of draw_plan
-- ----------------------------
INSERT INTO `draw_plan` VALUES ('3', '3', '2018-12-01 09:24:33', '饭局约谈 ', '购买 ', '小东', '3', '2018-12-04 09:24:57');
INSERT INTO `draw_plan` VALUES ('4', '4', '2019-01-27 09:25:33', '电话+面谈', '未执行', '小东', '3', '2018-12-04 09:26:06');
INSERT INTO `draw_plan` VALUES ('5', '3', '2018-12-13 12:40:38', '电话交流 ', '有意向 ', '小东', '3', '2018-12-04 10:09:18');
INSERT INTO `draw_plan` VALUES ('6', '5', '2018-12-04 11:05:16', '见面沟通', '有意向', '小红', '2', '2018-12-04 11:05:26');
INSERT INTO `draw_plan` VALUES ('7', '6', '2018-12-04 11:06:01', '电话沟通', '考虑中', '小红', '2', '2018-12-04 11:06:09');
INSERT INTO `draw_plan` VALUES ('8', '7', '2018-12-20 15:04:00', '面谈', '未执行', '小红', '2', '2018-12-04 11:06:59');
INSERT INTO `draw_plan` VALUES ('9', '1', '2018-12-04 13:38:28', '搜集客户需求相关信息', '了解客户需求和实现', '白白', '7', '2018-12-04 13:38:39');
INSERT INTO `draw_plan` VALUES ('10', '2', '2018-12-04 13:39:35', '电话沟通', '可以进行深一步交流', '白白', '7', '2018-12-04 13:39:41');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 编号',
  `meun_name` varchar(64) DEFAULT NULL COMMENT '菜单名称 菜单名称',
  `menu_icon` varchar(64) DEFAULT NULL COMMENT '菜单图标 菜单图表',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级编号 上级编号',
  `href` varchar(255) DEFAULT NULL COMMENT '地址',
  `level` decimal(6,0) DEFAULT NULL COMMENT '级别 级别',
  `is_spread` decimal(2,0) DEFAULT NULL COMMENT '是否展开 是否展开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='菜单表 菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '营销管理', '&#xe621;', '0', null, null, '1');
INSERT INTO `menu` VALUES ('2', '销售机会管理', '&#xe621;', '1', '/pages/sale/list.html', null, '0');
INSERT INTO `menu` VALUES ('3', '客户开发计划', '&#xe621;', '1', '/pages/marketingManagement/list.html', null, '0');
INSERT INTO `menu` VALUES ('4', '客户管理', '&#xe770;', '0', null, null, '1');
INSERT INTO `menu` VALUES ('5', '客户信息管理', '&#xe770;', '4', 'customer/list.html', null, '0');
INSERT INTO `menu` VALUES ('6', '客户流失管理', '&#xe770;', '4', 'customer/loss.html', null, '0');
INSERT INTO `menu` VALUES ('7', '服务管理', '&#xe606;', '0', null, null, '1');
INSERT INTO `menu` VALUES ('8', '服务创建', '&#xe606;', '7', 'serviceManagement/newService.html', null, '0');
INSERT INTO `menu` VALUES ('9', '服务分配', '&#xe606;', '7', 'serviceManagement/assignService.html', null, '0');
INSERT INTO `menu` VALUES ('10', '服务处理', '&#xe606;', '7', 'serviceManagement/handleService.html', null, '0');
INSERT INTO `menu` VALUES ('11', '服务反馈', '&#xe606;', '7', 'service/list.html', null, '0');
INSERT INTO `menu` VALUES ('12', '服务归档', '&#xe606;', '7', 'service/list2.html', null, '0');
INSERT INTO `menu` VALUES ('13', '统计报表', '&#xe609;', '0', null, null, '1');
INSERT INTO `menu` VALUES ('14', '客户贡献分析', 'icon-text', '13', '/pages/analyse/analContribution.html', null, '0');
INSERT INTO `menu` VALUES ('15', '客户构成分析', 'icon-text', '13', '/pages/analyse/analConstitute.html', null, '0');
INSERT INTO `menu` VALUES ('16', '客户服务分析', 'icon-text', '13', '/pages/analyse/analService.html', null, '0');
INSERT INTO `menu` VALUES ('17', '客户流失分析', 'icon-text', '13', '/pages/analyse/analLoss.html', null, '0');
INSERT INTO `menu` VALUES ('18', '基础数据', '&#xe620;', '0', null, null, '1');
INSERT INTO `menu` VALUES ('19', '数据字典管理', '&#xe620;', '18', '/pages/baseDate/dataDict.html', null, '0');
INSERT INTO `menu` VALUES ('20', '查询产品信息', '&#xe620;', '18', '/pages/baseDate/product.html', null, '0');
INSERT INTO `menu` VALUES ('21', '查询库存', '&#xe620;', '18', '/pages/baseDate/stock.html', null, '0');

-- ----------------------------
-- Table structure for order_history
-- ----------------------------
DROP TABLE IF EXISTS `order_history`;
CREATE TABLE `order_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `order_time` timestamp NULL DEFAULT NULL COMMENT '订单时间 订单时间',
  `deliver_goods` varchar(300) DEFAULT NULL COMMENT '送货地址 送货地址',
  `status` int(11) DEFAULT '0' COMMENT '状态(0:未回款,1：已汇款)',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户编号 客户编号',
  `total_amount` double(100,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_hory_custome_idD8EB` (`customer_id`),
  CONSTRAINT `FK_order_hory_custome_idD8EB` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='历史订单 历史订单';

-- ----------------------------
-- Records of order_history
-- ----------------------------
INSERT INTO `order_history` VALUES ('1', '2017-10-12 14:29:52', '上海 浦东新区 碧波路690号张江微电子港1号楼', '1', '5', '1000000');
INSERT INTO `order_history` VALUES ('2', '2018-11-14 14:30:45', '中国北京海淀区上地十街10号百度大厦', '1', '1', '5000000');
INSERT INTO `order_history` VALUES ('3', '2018-05-16 14:33:27', '中国广东深圳腾讯大厦', '1', '2', '5000000');
INSERT INTO `order_history` VALUES ('4', '2018-11-22 14:34:00', '中国广东广州网易大厦', '0', '3', '5000000');
INSERT INTO `order_history` VALUES ('5', '2017-06-20 08:37:05', '深圳市南山区高新技术产业园科技南路中兴通讯大厦', '1', '7', '7150000');
INSERT INTO `order_history` VALUES ('6', '2016-08-30 08:37:05', '中国广东省深圳市龙岗区坂田华为总部办公楼', '1', '6', '7150000');
INSERT INTO `order_history` VALUES ('7', '2017-09-15 08:37:05', '中国杭州阿里巴巴大厦', '1', '4', '7500000');
INSERT INTO `order_history` VALUES ('8', '2018-06-15 14:37:05', '山东省青岛市市南区东海西路17号', '1', '8', '7500000');
INSERT INTO `order_history` VALUES ('9', '2016-04-27 08:37:05', '中国杭州阿里巴巴大厦', '1', '4', '7150000');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 编号',
  `order_id` int(11) DEFAULT NULL COMMENT '订单编号 订单编号',
  `product_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `num` decimal(6,0) DEFAULT NULL COMMENT '数量 数量',
  `units` varchar(6) DEFAULT NULL COMMENT '单位 单位（个、块，条）',
  `price` double(200,2) DEFAULT NULL COMMENT '单价 单价',
  `money` double(200,2) DEFAULT NULL COMMENT '金额 金额',
  PRIMARY KEY (`id`),
  KEY `FK_order_info_order_id` (`order_id`),
  CONSTRAINT `FK_order_info_order_id` FOREIGN KEY (`order_id`) REFERENCES `order_history` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='订单明细 订单明细';

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('1', '2', '集团财务管理与控制系统', '1', '个', '5000000.00', '5000000.00');
INSERT INTO `order_info` VALUES ('2', '3', '集团财务管理与控制系统', '1', '个', '5000000.00', '5000000.00');
INSERT INTO `order_info` VALUES ('3', '1', '客户关系管理系统', '1', '个', '1000000.00', '1000000.00');
INSERT INTO `order_info` VALUES ('4', '4', '集团财务管理与控制系统', '1', '个', '5000000.00', '5000000.00');
INSERT INTO `order_info` VALUES ('5', '5', 'SaCa®云应用平台', '1', '个', '7150000.00', '7150000.00');
INSERT INTO `order_info` VALUES ('6', '6', 'SaCa®云应用平台', '1', '个', '7150000.00', '7150000.00');
INSERT INTO `order_info` VALUES ('7', '7', 'TalentBase人力资源管理系统', '1', '个', '7500000.00', '7500000.00');
INSERT INTO `order_info` VALUES ('8', '8', 'TalentBase人力资源管理系统', '1', '个', '7500000.00', '7500000.00');
INSERT INTO `order_info` VALUES ('9', '9', 'SaCa®云应用平台', '1', '个', '7150000.00', '7150000.00');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(255) DEFAULT NULL COMMENT '型号',
  `batch` varchar(255) DEFAULT NULL COMMENT '等级/批次',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `price` double(10,2) DEFAULT NULL COMMENT '单价',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '集团财务管理与控制系统', '一代', '9683 1012', '个', '5000000.00', null);
INSERT INTO `product` VALUES ('2', '客户关系管理系统', '二代', '1812 1801', '个', '1000000.00', null);
INSERT INTO `product` VALUES ('3', 'SaCa®云应用平台', '一代', '1625 1601', '个', '7150000.00', null);
INSERT INTO `product` VALUES ('4', 'TalentBase人力资源管理系统', '三代', '0812 0902', '个', '7500000.00', null);
INSERT INTO `product` VALUES ('5', 'SoloTV数字移动电视', 'i11', '1035 1003', '台', '1200.00', null);
INSERT INTO `product` VALUES ('6', '东软后方驾驶辅助系统', 'RA-1301C', '1816 1801', '个', '20000.00', null);
INSERT INTO `product` VALUES ('7', 'NSM-S15P超导核磁共振成像机', 'S15P', '1851 1801', '台', '1000000.00', null);
INSERT INTO `product` VALUES ('8', 'NeuViz 128 精睿 CT', '128', '1852 1802', '台', '500000.00', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 编号',
  `name` varchar(64) DEFAULT NULL COMMENT '角色名称 角色名称',
  `code` int(11) DEFAULT NULL COMMENT '角色码 角色码',
  `status` int(11) DEFAULT NULL COMMENT '状态 状态',
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 创建时间',
  `creation_id` int(11) DEFAULT NULL COMMENT '创建人 创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表 角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', '0', '0', '2018-11-22 09:26:49', null);
INSERT INTO `role` VALUES ('2', '销售主管', '1', '0', '2018-11-22 09:26:49', null);
INSERT INTO `role` VALUES ('3', '客户经理', '2', '0', '2018-11-22 09:26:49', null);
INSERT INTO `role` VALUES ('4', '高管', '3', '0', '2018-11-22 10:02:18', null);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 编号',
  `role_id` int(11) DEFAULT NULL COMMENT '角色编号 角色编号',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单编号 菜单编号',
  PRIMARY KEY (`id`),
  KEY `FK_role_menu_role_id` (`role_id`),
  KEY `FK_role_menu_menu_id` (`menu_id`),
  CONSTRAINT `FK_role_menu_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `FK_role_menu_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='角色菜单关系表 角色菜单关系表';

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1');
INSERT INTO `role_menu` VALUES ('2', '1', '2');
INSERT INTO `role_menu` VALUES ('3', '1', '3');
INSERT INTO `role_menu` VALUES ('4', '1', '4');
INSERT INTO `role_menu` VALUES ('5', '1', '5');
INSERT INTO `role_menu` VALUES ('6', '1', '6');
INSERT INTO `role_menu` VALUES ('7', '1', '7');
INSERT INTO `role_menu` VALUES ('8', '1', '8');
INSERT INTO `role_menu` VALUES ('9', '1', '9');
INSERT INTO `role_menu` VALUES ('10', '1', '10');
INSERT INTO `role_menu` VALUES ('11', '1', '11');
INSERT INTO `role_menu` VALUES ('12', '1', '12');
INSERT INTO `role_menu` VALUES ('13', '1', '13');
INSERT INTO `role_menu` VALUES ('14', '1', '14');
INSERT INTO `role_menu` VALUES ('15', '1', '15');
INSERT INTO `role_menu` VALUES ('16', '1', '16');
INSERT INTO `role_menu` VALUES ('17', '1', '17');
INSERT INTO `role_menu` VALUES ('18', '1', '18');
INSERT INTO `role_menu` VALUES ('19', '1', '19');
INSERT INTO `role_menu` VALUES ('20', '1', '20');
INSERT INTO `role_menu` VALUES ('21', '1', '21');
INSERT INTO `role_menu` VALUES ('22', '2', '1');
INSERT INTO `role_menu` VALUES ('23', '2', '2');
INSERT INTO `role_menu` VALUES ('24', '2', '3');
INSERT INTO `role_menu` VALUES ('25', '2', '7');
INSERT INTO `role_menu` VALUES ('26', '2', '9');
INSERT INTO `role_menu` VALUES ('27', '2', '13');
INSERT INTO `role_menu` VALUES ('28', '2', '14');
INSERT INTO `role_menu` VALUES ('29', '2', '15');
INSERT INTO `role_menu` VALUES ('30', '2', '16');
INSERT INTO `role_menu` VALUES ('31', '2', '17');
INSERT INTO `role_menu` VALUES ('32', '2', '18');
INSERT INTO `role_menu` VALUES ('33', '2', '19');
INSERT INTO `role_menu` VALUES ('34', '2', '20');
INSERT INTO `role_menu` VALUES ('35', '2', '21');
INSERT INTO `role_menu` VALUES ('36', '3', '1');
INSERT INTO `role_menu` VALUES ('37', '3', '2');
INSERT INTO `role_menu` VALUES ('38', '3', '3');
INSERT INTO `role_menu` VALUES ('39', '3', '4');
INSERT INTO `role_menu` VALUES ('40', '3', '5');
INSERT INTO `role_menu` VALUES ('41', '3', '6');
INSERT INTO `role_menu` VALUES ('42', '3', '7');
INSERT INTO `role_menu` VALUES ('43', '3', '8');
INSERT INTO `role_menu` VALUES ('45', '3', '10');
INSERT INTO `role_menu` VALUES ('46', '3', '11');
INSERT INTO `role_menu` VALUES ('47', '3', '12');
INSERT INTO `role_menu` VALUES ('48', '3', '18');
INSERT INTO `role_menu` VALUES ('49', '3', '19');
INSERT INTO `role_menu` VALUES ('50', '3', '20');
INSERT INTO `role_menu` VALUES ('51', '3', '21');
INSERT INTO `role_menu` VALUES ('52', '4', '13');
INSERT INTO `role_menu` VALUES ('53', '4', '14');
INSERT INTO `role_menu` VALUES ('54', '4', '15');
INSERT INTO `role_menu` VALUES ('55', '4', '16');
INSERT INTO `role_menu` VALUES ('56', '4', '17');
INSERT INTO `role_menu` VALUES ('57', '2', '12');

-- ----------------------------
-- Table structure for sales_opportunity
-- ----------------------------
DROP TABLE IF EXISTS `sales_opportunity`;
CREATE TABLE `sales_opportunity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 编号',
  `opportunity_source` varchar(100) DEFAULT NULL COMMENT '机会来源 机会来源',
  `name` varchar(25) DEFAULT NULL COMMENT '客户名称 客户名称',
  `success_probability` varchar(10) DEFAULT NULL COMMENT '成功几率 成功几率',
  `outline` varchar(500) DEFAULT NULL COMMENT '概要 概要',
  `contacts` varchar(64) DEFAULT NULL COMMENT '联系人 联系人',
  `contacts_tel` decimal(11,0) DEFAULT NULL COMMENT '联系电话 联系电话',
  `opportunity_desc` varchar(500) DEFAULT NULL COMMENT '机会描述 机会描述',
  `assign_id` int(64) DEFAULT NULL COMMENT '指派人编号 指派人编号',
  `assign_name` varchar(64) DEFAULT NULL COMMENT '指派人名称 指派人名称',
  `assign_time` datetime DEFAULT NULL COMMENT '指派时间 指派时间',
  `status` int(11) DEFAULT '0' COMMENT '状态码(0:未指派，1：发开中，2：计划成功，3：计划失败)',
  `found_id` int(11) DEFAULT NULL COMMENT '创建人编号 创建人编号',
  `found_name` varchar(100) DEFAULT NULL COMMENT '创建人名称 创建人名称',
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='销售机会 销售机会';

-- ----------------------------
-- Records of sales_opportunity
-- ----------------------------
INSERT INTO `sales_opportunity` VALUES ('1', '公司主动接触', '沃尔玛', '80%', '与大型公司合作更能体现公司能力', '刘磊', '15983667788', '此次合作是一个很好的机会', '7', '白白', '2018-12-04 13:20:01', '1', null, '刘磊', '2018-12-04 09:22:32');
INSERT INTO `sales_opportunity` VALUES ('2', '对方主动寻找', '奔驰', '85%', '与大型公司合作更能体现公司能力', '刘蕾', '15989564127', '此次合作是一个很好的机会', '7', '白白', '2018-12-04 14:30:25', '2', null, '刘山', '2018-12-04 09:22:33');
INSERT INTO `sales_opportunity` VALUES ('3', '对方主动寻找', '奥迪', '80%', '与大型公司合作更能体现公司能力', '刘东', '15914785236', '此次合作是一个很好的机会', '3', '小东', '2018-12-04 14:10:12', '1', null, '刘东', '2018-12-04 09:22:35');
INSERT INTO `sales_opportunity` VALUES ('4', '公司主动接触', '大众', '75%', '与大型公司合作更能体现公司能力', '张磊', '15998632584', '此次合作是一个很好的机会', '3', '小东', '2018-12-04 20:02:09', '1', null, '张磊', '2018-12-04 09:30:38');
INSERT INTO `sales_opportunity` VALUES ('5', '对方主动寻找', '中国移动', '80%', '与大型公司合作更能体现公司能力', '张思', '15915973468', '此次合作是一个很好的机会', '4', '小西', '2018-12-04 14:10:12', '1', null, '张思', '2018-12-04 09:22:45');
INSERT INTO `sales_opportunity` VALUES ('6', '对方主动寻找', '中国联通', '80%', '与大型公司合作更能体现公司能力', '王寺', '15916874592', '此次合作是一个很好的机会', '4', '小西', '2018-12-04 12:17:36', '1', null, '王寺', '2018-12-04 08:22:33');
INSERT INTO `sales_opportunity` VALUES ('7', '对方主动寻找', '中国电信', '85%', '与大型公司合作更能体现公司能力', '谢飒', '15965489127', '此次合作是一个很好的机会', '4', '小西', '2018-12-05 12:30:27', '1', null, '谢飒', '2018-12-05 09:22:33');
INSERT INTO `sales_opportunity` VALUES ('8', '对方主动寻找', '万达地产', '80%', '与大型公司合作更能体现公司能力', '李科', '15935419782', '此次合作是一个很好的机会', '5', '小北', '2018-12-06 11:45:25', '1', null, '李科', '2018-12-05 09:22:33');
INSERT INTO `sales_opportunity` VALUES ('9', '公司主动接触', '广州市政府', '80%', '与政府合作能提升公司影响力', '何斯', '15912648751', '此次合作是一个很好的机会', '5', '小北', '2018-12-06 10:10:21', '1', null, '何斯', '2018-12-05 09:22:33');

-- ----------------------------
-- Table structure for service_management
-- ----------------------------
DROP TABLE IF EXISTS `service_management`;
CREATE TABLE `service_management` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 编号',
  `service_type` varchar(100) DEFAULT NULL COMMENT '服务类型 服务类型',
  `outline` varchar(300) DEFAULT NULL COMMENT '概要 概要',
  `customer_name` varchar(64) DEFAULT NULL COMMENT '客户名称 客户名称',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户编号 客户编号',
  `status` int(11) DEFAULT '0' COMMENT '状态(0:新创建,1：已分配,2：已处理)',
  `service_req` varchar(300) DEFAULT NULL COMMENT '服务请求 服务请求',
  `creation_id` int(11) DEFAULT NULL COMMENT '创建人编号 创建人编号',
  `creation_name` varchar(64) DEFAULT NULL COMMENT '创建人姓名 创建人姓名',
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 创建时间',
  PRIMARY KEY (`id`),
  KEY `FK_serviceent_custome_idB300` (`customer_id`),
  CONSTRAINT `FK_serviceent_custome_idB300` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='服务管理 服务管理';

-- ----------------------------
-- Records of service_management
-- ----------------------------
INSERT INTO `service_management` VALUES ('36', '1', '咨询SaCa®云应用平台的具体功能', '百度公司', '1', '3', 'SaCa®云应用平台的具体功能？', null, '白白', '2018-12-04 15:24:45');
INSERT INTO `service_management` VALUES ('37', '2', '建议SaCa®云应用平台降低运维成本', '百度公司', '1', '0', 'SaCa®云应用平台建议', null, '白白', '2018-12-04 15:26:24');
INSERT INTO `service_management` VALUES ('38', '1', '询问SoloTV数字移动电视使用寿命', '海信集团', '8', '1', 'SoloTV数字移动电视使用寿命？', null, '白白', '2018-12-04 15:27:42');
INSERT INTO `service_management` VALUES ('39', '1', '询问NSM-S15P超导核磁共振成像机运费承担方式', '阿里巴巴集团', '4', '0', 'NSM-S15P运费如何承担？', null, '小西', '2018-12-04 15:30:49');
INSERT INTO `service_management` VALUES ('40', '1', '咨询TalentBase人力资源管理系统硬件要求', '腾讯公司', '2', '2', 'TalentBase硬件要求？', null, '小西', '2018-12-04 15:32:34');
INSERT INTO `service_management` VALUES ('41', '1', '咨询客户关系管理系统详细说明书', '华为科技', '6', '1', '客户关系管理系统详细说明书？', null, '小东', '2018-12-04 15:44:51');
INSERT INTO `service_management` VALUES ('42', '1', '咨询东软有哪些服务器安全产品', '盛大游戏', '5', '0', '东软有哪些服务器安全产品？', null, '小东', '2018-12-04 15:47:03');
INSERT INTO `service_management` VALUES ('44', '2', '建议双方合作开发一些游戏项目', '网易公司', '3', '2', '如何分配项目任务', null, '白白', '2018-12-07 00:54:00');
INSERT INTO `service_management` VALUES ('46', '1', '建议双方合作开发一些项目', '腾讯公司', '2', '2', '如何分配项目任务', null, '小东', '2018-12-07 01:05:12');

-- ----------------------------
-- Table structure for service_user_allot
-- ----------------------------
DROP TABLE IF EXISTS `service_user_allot`;
CREATE TABLE `service_user_allot` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `service_id` int(11) DEFAULT NULL COMMENT '服务编号 服务编号',
  `user_id` int(11) DEFAULT NULL COMMENT '分配用户编号 分配用户编号',
  `creation_name` varchar(12) DEFAULT NULL COMMENT '创建人编号 创建人编号',
  `allot_time` timestamp NULL DEFAULT NULL COMMENT '分配时间 分配时间',
  `service_handle` varchar(300) DEFAULT NULL COMMENT '服务处理 服务处理',
  `handle_name` varchar(12) DEFAULT NULL COMMENT '处理人 处理人',
  `handle_time` timestamp NULL DEFAULT NULL COMMENT '处理时间',
  `handle_result` varchar(100) DEFAULT NULL COMMENT '处理结果 处理结果',
  `satisfaction` int(12) DEFAULT NULL COMMENT '满意度 满意度',
  PRIMARY KEY (`id`),
  KEY `FK_servicelot_service_id4CAB` (`service_id`),
  KEY `FK_servicelot_user_idC350` (`user_id`),
  CONSTRAINT `FK_servicelot_service_id4CAB` FOREIGN KEY (`service_id`) REFERENCES `service_management` (`id`),
  CONSTRAINT `FK_servicelot_user_idC350` FOREIGN KEY (`user_id`) REFERENCES `system_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='服务用户分配表 服务用户关系表';

-- ----------------------------
-- Records of service_user_allot
-- ----------------------------
INSERT INTO `service_user_allot` VALUES ('32', '36', '3', null, '2018-12-04 15:33:52', '已将SaCa®云应用平台的具体功能详细说明书发至客户邮箱', '小东', '2018-12-04 15:48:40', '客户已了解到SaCa®云应用平台具体功能', '5');
INSERT INTO `service_user_allot` VALUES ('33', '38', '4', null, '2018-12-04 15:34:20', null, null, null, null, null);
INSERT INTO `service_user_allot` VALUES ('34', '41', '3', null, '2018-12-04 15:55:53', null, null, null, null, null);
INSERT INTO `service_user_allot` VALUES ('35', '40', '5', null, '2018-12-04 15:56:05', '将TalentBase硬件要求整理成说明书发至客户邮箱', '小北', '2018-12-04 15:58:16', null, null);
INSERT INTO `service_user_allot` VALUES ('37', '44', '3', null, '2018-12-07 00:57:24', '双方公司进一步交谈', '小东', '2018-12-07 00:58:31', null, null);
INSERT INTO `service_user_allot` VALUES ('38', '46', '3', null, '2018-12-07 01:05:52', '派人具体和腾讯公司沟通商量', '小东', '2018-12-07 01:07:10', null, null);

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `product_name` varchar(255) DEFAULT '' COMMENT '产品',
  `warehouse` varchar(255) DEFAULT '' COMMENT '仓库',
  `shelf` varchar(255) DEFAULT '' COMMENT '货位',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('1', '集团财务管理与控制系统', '------', '0', '1', '');
INSERT INTO `stock` VALUES ('2', '客户关系管理系统', '------', '0', '1', '');
INSERT INTO `stock` VALUES ('3', 'SaCa®云应用平台', '------', '0', '1', '');
INSERT INTO `stock` VALUES ('4', 'TalentBase人力资源管理系统', '------', '0', '1', '');
INSERT INTO `stock` VALUES ('5', 'SoloTV数字移动电视', '广州-码头库', 'EC-D2', '1000', '');
INSERT INTO `stock` VALUES ('6', '东软后方驾驶辅助系统', '------', '0', '1', '');
INSERT INTO `stock` VALUES ('8', 'NSM-S15P超导核磁共振成像机', '广州-码头库', 'ED-C3', '100', '');
INSERT INTO `stock` VALUES ('9', 'NeuViz 128 精睿 CT', '广州-码头库', 'ED-A2', '50', '');

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号 用户编号',
  `name` varchar(64) DEFAULT NULL COMMENT '用户名称 用户名称',
  `log_name` varchar(64) DEFAULT NULL COMMENT '登录名 登录名',
  `log_pwd` varchar(64) DEFAULT NULL COMMENT '登录密码 登录密码',
  `role_id` int(11) DEFAULT NULL COMMENT '角色编号 角色编号',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_system_user_role_id` (`role_id`) USING BTREE,
  CONSTRAINT `FK_system_user_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统用户 系统用户';

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', '小明', 'xiaoming', '123123', '1');
INSERT INTO `system_user` VALUES ('2', '小红', 'xiaohong', '123123', '2');
INSERT INTO `system_user` VALUES ('3', '小东', 'xiaodong', '123123', '3');
INSERT INTO `system_user` VALUES ('4', '小西', 'xiaoxi', '123123', '3');
INSERT INTO `system_user` VALUES ('5', '小北', 'xiaobei', '123123', '3');
INSERT INTO `system_user` VALUES ('6', '小白', 'xiaobai', '123123', '4');
INSERT INTO `system_user` VALUES ('7', '白白', 'baibai', '123123', '3');
INSERT INTO `system_user` VALUES ('8', '刘磊', 'liulei', '123123', '2');
