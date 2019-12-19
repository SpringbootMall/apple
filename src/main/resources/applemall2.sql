/*
 Navicat Premium Data Transfer

 Source Server         : PersonalProjectsDataBase
 Source Server Type    : MySQL
 Source Server Version : 80003
 Source Host           : localhost:3306
 Source Schema         : apple_mall

 Target Server Type    : MySQL
 Target Server Version : 80003
 File Encoding         : 65001

 Date: 19/12/2019 15:31:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `admin_user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `login_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆名称',
  `login_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员显示昵称',
  `locked` tinyint(4) NULL DEFAULT 0 COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
  PRIMARY KEY (`admin_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 648629523 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '十三', 0);
INSERT INTO `admin_user` VALUES (2, 'newbee-admin1', 'e10adc3949ba59abbe56e057f20f883e', '新蜂01', 0);
INSERT INTO `admin_user` VALUES (3, 'newbee-admin2', 'e10adc3949ba59abbe56e057f20f883e', '新蜂02', 0);
INSERT INTO `admin_user` VALUES (4, 'a', 'e10adc3949ba59abbe56e057f20f883e', '锦', 0);
INSERT INTO `admin_user` VALUES (648629522, 'admin', '440680190098f3ec6610a4936cec5031', 'admin', 0);

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`  (
  `carousel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '首页轮播图主键id',
  `carousel_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '轮播图',
  `redirect_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '\'##\'' COMMENT '点击后的跳转地址(默认不跳转)',
  `carousel_rank` int(11) NOT NULL DEFAULT 0 COMMENT '排序值(字段越大越靠前)',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_user` int(11) NOT NULL DEFAULT 0 COMMENT '创建者id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '修改者id',
  PRIMARY KEY (`carousel_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES (2, 'https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/banner1.png', 'https://juejin.im/book/5da2f9d4f265da5b81794d48/section/5da2f9d6f265da5b794f2189', 13, 0, '2019-11-29 00:00:00', 0, '2019-11-29 00:00:00', 0);
INSERT INTO `carousel` VALUES (5, 'https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/banner2.png', 'https://juejin.im/book/5da2f9d4f265da5b81794d48/section/5da2f9d6f265da5b794f2189', 0, 0, '2019-11-29 00:00:00', 0, '2019-11-29 00:00:00', 0);

-- ----------------------------
-- Table structure for cart_item
-- ----------------------------
DROP TABLE IF EXISTS `cart_item`;
CREATE TABLE `cart_item`  (
  `cart_item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物项主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  `goods_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联商品id',
  `goods_count` int(11) NOT NULL DEFAULT 1 COMMENT '数量(最大为5)',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最新修改时间',
  PRIMARY KEY (`cart_item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_item
-- ----------------------------
INSERT INTO `cart_item` VALUES (69, 9, 10694, 1, 1, '2019-11-30 16:02:51', '2019-11-30 17:21:58');
INSERT INTO `cart_item` VALUES (70, 9, 10187, 1, 1, '2019-11-30 17:22:21', '2019-11-30 17:22:21');
INSERT INTO `cart_item` VALUES (71, 9, 10693, 1, 1, '2019-12-04 14:42:25', '2019-12-04 15:20:25');
INSERT INTO `cart_item` VALUES (72, 9, 10160, 4, 1, '2019-12-04 15:16:44', '2019-12-04 15:18:57');
INSERT INTO `cart_item` VALUES (73, 9, 10187, 4, 1, '2019-12-04 23:30:25', '2019-12-07 11:03:09');
INSERT INTO `cart_item` VALUES (74, 9, 10819, 1, 1, '2019-12-04 23:30:45', '2019-12-04 23:30:45');
INSERT INTO `cart_item` VALUES (75, 9, 10693, 4, 1, '2019-12-07 00:36:41', '2019-12-07 00:36:55');
INSERT INTO `cart_item` VALUES (76, 9, 10695, 1, 1, '2019-12-07 18:46:46', '2019-12-07 18:51:14');
INSERT INTO `cart_item` VALUES (77, 9, 10690, 1, 1, '2019-12-07 21:55:06', '2019-12-07 22:12:46');
INSERT INTO `cart_item` VALUES (78, 9, 10171, 5, 1, '2019-12-08 20:58:23', '2019-12-09 15:41:23');
INSERT INTO `cart_item` VALUES (79, 9, 10691, 1, 1, '2019-12-09 15:41:16', '2019-12-09 15:41:16');
INSERT INTO `cart_item` VALUES (80, 9, 10159, 1, 1, '2019-12-16 12:50:51', '2019-12-16 13:19:31');
INSERT INTO `cart_item` VALUES (81, 9, 10159, 1, 1, '2019-12-16 21:44:14', '2019-12-16 21:44:23');
INSERT INTO `cart_item` VALUES (82, 9, 10159, 4, 1, '2019-12-17 00:09:26', '2019-12-17 00:09:38');
INSERT INTO `cart_item` VALUES (83, 10, 10161, 2, 0, '2019-12-17 12:44:24', '2019-12-17 12:44:40');
INSERT INTO `cart_item` VALUES (84, 10, 1001, 1, 1, '2019-12-17 14:03:46', '2019-12-17 15:00:34');
INSERT INTO `cart_item` VALUES (85, 10, 1002, 2, 1, '2019-12-17 15:09:42', '2019-12-17 15:19:34');
INSERT INTO `cart_item` VALUES (86, 10, 1001, 1, 0, '2019-12-17 15:40:35', '2019-12-17 15:40:35');
INSERT INTO `cart_item` VALUES (87, 9, 1002, 1, 1, '2019-12-17 15:43:05', '2019-12-17 15:43:05');
INSERT INTO `cart_item` VALUES (88, 9, 1001, 1, 1, '2019-12-17 15:43:16', '2019-12-17 15:43:16');
INSERT INTO `cart_item` VALUES (89, 11, 1009, 3, 1, '2019-12-18 17:25:08', '2019-12-18 17:25:15');
INSERT INTO `cart_item` VALUES (90, 11, 1006, 2, 0, '2019-12-18 20:55:11', '2019-12-18 20:55:23');

-- ----------------------------
-- Table structure for goods_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category`  (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `category_level` tinyint(4) NOT NULL DEFAULT 0 COMMENT '分类级别(1-一级分类 2-二级分类 3-三级分类)',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父分类id',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分类名称',
  `category_rank` int(11) NOT NULL DEFAULT 0 COMMENT '排序值(字段越大越靠前)',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_user` int(11) NOT NULL DEFAULT 0 COMMENT '创建者id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_user` int(11) NULL DEFAULT 0 COMMENT '修改者id',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_category
-- ----------------------------
INSERT INTO `goods_category` VALUES (15, 1, 0, '家电 数码 手机', 100, 0, '2019-09-11 18:45:40', 0, '2019-09-11 18:45:40', 0);
INSERT INTO `goods_category` VALUES (16, 1, 0, '女装 男装 穿搭', 99, 0, '2019-09-11 18:46:07', 0, '2019-09-11 18:46:07', 0);
INSERT INTO `goods_category` VALUES (17, 2, 15, '家电', 10, 0, '2019-09-11 18:46:32', 0, '2019-09-11 18:46:32', 0);
INSERT INTO `goods_category` VALUES (18, 2, 15, '数码', 9, 0, '2019-09-11 18:46:43', 0, '2019-09-11 18:46:43', 0);
INSERT INTO `goods_category` VALUES (19, 2, 15, '手机', 8, 0, '2019-09-11 18:46:52', 0, '2019-09-11 18:46:52', 0);
INSERT INTO `goods_category` VALUES (20, 3, 17, '生活电器', 0, 0, '2019-09-11 18:47:38', 0, '2019-09-11 18:47:38', 0);
INSERT INTO `goods_category` VALUES (21, 3, 17, '厨房电器', 0, 0, '2019-09-11 18:47:49', 0, '2019-09-11 18:47:49', 0);
INSERT INTO `goods_category` VALUES (22, 3, 17, '扫地机器人', 0, 0, '2019-09-11 18:47:58', 0, '2019-09-11 18:47:58', 0);
INSERT INTO `goods_category` VALUES (23, 3, 17, '吸尘器', 0, 0, '2019-09-11 18:48:06', 0, '2019-09-11 18:48:06', 0);
INSERT INTO `goods_category` VALUES (24, 3, 17, '取暖器', 0, 0, '2019-09-11 18:48:12', 0, '2019-09-11 18:48:12', 0);
INSERT INTO `goods_category` VALUES (25, 3, 17, '豆浆机', 0, 0, '2019-09-11 18:48:26', 0, '2019-09-11 18:48:26', 0);
INSERT INTO `goods_category` VALUES (26, 3, 17, '暖风机', 0, 0, '2019-09-11 18:48:40', 0, '2019-09-11 18:48:40', 0);
INSERT INTO `goods_category` VALUES (27, 3, 17, '加湿器', 0, 0, '2019-09-11 18:48:50', 0, '2019-09-11 18:48:50', 0);
INSERT INTO `goods_category` VALUES (28, 3, 17, '蓝牙音箱', 0, 0, '2019-09-11 18:48:57', 0, '2019-09-11 18:48:57', 0);
INSERT INTO `goods_category` VALUES (29, 3, 17, '烤箱', 0, 0, '2019-09-11 18:49:09', 0, '2019-09-11 18:49:09', 0);
INSERT INTO `goods_category` VALUES (30, 3, 17, '卷发器', 0, 0, '2019-09-11 18:49:19', 0, '2019-09-11 18:49:19', 0);
INSERT INTO `goods_category` VALUES (31, 3, 17, '空气净化器', 0, 0, '2019-09-11 18:49:30', 0, '2019-09-11 18:49:30', 0);
INSERT INTO `goods_category` VALUES (32, 3, 18, '游戏主机', 0, 0, '2019-09-11 18:49:50', 0, '2019-09-11 18:49:50', 0);
INSERT INTO `goods_category` VALUES (33, 3, 18, '数码精选', 0, 0, '2019-09-11 18:49:55', 0, '2019-09-11 18:49:55', 0);
INSERT INTO `goods_category` VALUES (34, 3, 18, '平板电脑', 0, 0, '2019-09-11 18:50:08', 0, '2019-09-11 18:50:08', 0);
INSERT INTO `goods_category` VALUES (35, 3, 18, '苹果 Apple', 0, 0, '2019-09-11 18:50:24', 0, '2019-09-11 18:50:24', 0);
INSERT INTO `goods_category` VALUES (36, 3, 18, '电脑主机', 0, 0, '2019-09-11 18:50:36', 0, '2019-09-11 18:50:36', 0);
INSERT INTO `goods_category` VALUES (37, 3, 18, '数码相机', 0, 0, '2019-09-11 18:50:57', 0, '2019-09-11 18:50:57', 0);
INSERT INTO `goods_category` VALUES (38, 3, 18, '电玩动漫', 0, 0, '2019-09-11 18:52:15', 0, '2019-09-11 18:52:15', 0);
INSERT INTO `goods_category` VALUES (39, 3, 18, '单反相机', 0, 0, '2019-09-11 18:52:26', 0, '2019-09-11 18:52:26', 0);
INSERT INTO `goods_category` VALUES (40, 3, 18, '键盘鼠标', 0, 0, '2019-09-11 18:52:46', 0, '2019-09-11 18:52:46', 0);
INSERT INTO `goods_category` VALUES (41, 3, 18, '无人机', 0, 0, '2019-09-11 18:53:01', 0, '2019-09-11 18:53:01', 0);
INSERT INTO `goods_category` VALUES (42, 3, 18, '二手电脑', 0, 0, '2019-09-11 18:53:08', 0, '2019-09-11 18:53:08', 0);
INSERT INTO `goods_category` VALUES (43, 3, 18, '二手手机', 0, 0, '2019-09-11 18:53:14', 0, '2019-09-11 18:53:14', 0);
INSERT INTO `goods_category` VALUES (44, 3, 19, 'iPhone 11', 89, 0, '2019-09-11 18:53:49', 0, '2019-09-11 18:54:38', 0);
INSERT INTO `goods_category` VALUES (45, 3, 19, '荣耀手机', 99, 0, '2019-09-11 18:53:59', 0, '2019-09-18 13:40:59', 0);
INSERT INTO `goods_category` VALUES (46, 3, 19, '华为手机', 98, 0, '2019-09-11 18:54:20', 0, '2019-09-18 13:40:51', 0);
INSERT INTO `goods_category` VALUES (47, 3, 19, 'iPhone', 88, 0, '2019-09-11 18:54:49', 0, '2019-09-18 13:40:32', 0);
INSERT INTO `goods_category` VALUES (48, 3, 19, '华为 Mate 20', 79, 0, '2019-09-11 18:55:03', 0, '2019-09-11 18:55:13', 0);
INSERT INTO `goods_category` VALUES (49, 3, 19, '华为 P30', 97, 0, '2019-09-11 18:55:22', 0, '2019-09-11 18:55:22', 0);
INSERT INTO `goods_category` VALUES (50, 3, 19, '华为 P30 Pro', 0, 1, '2019-09-11 18:55:32', 0, '2019-09-11 18:55:32', 0);
INSERT INTO `goods_category` VALUES (51, 3, 19, '小米手机', 0, 0, '2019-09-11 18:55:52', 0, '2019-09-11 18:55:52', 0);
INSERT INTO `goods_category` VALUES (52, 3, 19, '红米', 0, 0, '2019-09-11 18:55:58', 0, '2019-09-11 18:55:58', 0);
INSERT INTO `goods_category` VALUES (53, 3, 19, 'OPPO', 0, 0, '2019-09-11 18:56:06', 0, '2019-09-11 18:56:06', 0);
INSERT INTO `goods_category` VALUES (54, 3, 19, '一加', 0, 0, '2019-09-11 18:56:12', 0, '2019-09-11 18:56:12', 0);
INSERT INTO `goods_category` VALUES (55, 3, 19, '小米 MIX', 0, 0, '2019-09-11 18:56:37', 0, '2019-09-11 18:56:37', 0);
INSERT INTO `goods_category` VALUES (56, 3, 19, 'Reno', 0, 0, '2019-09-11 18:56:49', 0, '2019-09-11 18:56:49', 0);
INSERT INTO `goods_category` VALUES (57, 3, 19, 'vivo', 0, 0, '2019-09-11 18:57:01', 0, '2019-09-11 18:57:01', 0);
INSERT INTO `goods_category` VALUES (58, 3, 19, '手机以旧换新', 0, 0, '2019-09-11 18:57:09', 0, '2019-09-11 18:57:09', 0);
INSERT INTO `goods_category` VALUES (59, 1, 0, '运动 户外 乐器', 97, 0, '2019-09-12 00:08:46', 0, '2019-09-12 00:08:46', 0);
INSERT INTO `goods_category` VALUES (60, 1, 0, '游戏 动漫 影视', 96, 0, '2019-09-12 00:09:00', 0, '2019-09-12 00:09:00', 0);
INSERT INTO `goods_category` VALUES (61, 1, 0, '家具 家饰 家纺', 98, 0, '2019-09-12 00:09:27', 0, '2019-09-12 00:09:27', 0);
INSERT INTO `goods_category` VALUES (62, 1, 0, '美妆 清洁 宠物', 94, 0, '2019-09-12 00:09:51', 0, '2019-09-17 18:22:34', 0);
INSERT INTO `goods_category` VALUES (63, 1, 0, '工具 装修 建材', 93, 0, '2019-09-12 00:10:07', 0, '2019-09-12 00:10:07', 0);
INSERT INTO `goods_category` VALUES (64, 1, 0, '珠宝 金饰 眼镜', 92, 0, '2019-09-12 00:10:35', 0, '2019-09-12 00:16:30', 0);
INSERT INTO `goods_category` VALUES (65, 1, 0, '玩具 孕产 用品', 0, 0, '2019-09-12 00:11:17', 0, '2019-09-12 00:11:17', 0);
INSERT INTO `goods_category` VALUES (66, 1, 0, '鞋靴 箱包 配件', 91, 0, '2019-09-12 00:11:30', 0, '2019-09-12 00:11:30', 0);
INSERT INTO `goods_category` VALUES (67, 2, 16, '女装', 10, 0, '2019-09-12 00:15:19', 0, '2019-09-12 00:15:19', 0);
INSERT INTO `goods_category` VALUES (68, 2, 16, '男装', 9, 0, '2019-09-12 00:15:28', 0, '2019-09-12 00:15:28', 0);
INSERT INTO `goods_category` VALUES (69, 2, 16, '穿搭', 8, 0, '2019-09-12 00:15:35', 0, '2019-09-12 00:15:35', 0);
INSERT INTO `goods_category` VALUES (70, 2, 61, '家具', 10, 0, '2019-09-12 00:20:22', 0, '2019-09-12 00:20:22', 0);
INSERT INTO `goods_category` VALUES (71, 2, 61, '家饰', 9, 0, '2019-09-12 00:20:29', 0, '2019-09-12 00:20:29', 0);
INSERT INTO `goods_category` VALUES (72, 2, 61, '家纺', 8, 0, '2019-09-12 00:20:35', 0, '2019-09-12 00:20:35', 0);
INSERT INTO `goods_category` VALUES (73, 2, 59, '运动', 10, 0, '2019-09-12 00:20:49', 0, '2019-09-12 00:20:49', 0);
INSERT INTO `goods_category` VALUES (74, 2, 59, '户外', 9, 0, '2019-09-12 00:20:58', 0, '2019-09-12 00:20:58', 0);
INSERT INTO `goods_category` VALUES (75, 2, 59, '乐器', 8, 0, '2019-09-12 00:21:05', 0, '2019-09-12 00:21:05', 0);
INSERT INTO `goods_category` VALUES (76, 3, 67, '外套', 10, 0, '2019-09-12 00:21:55', 0, '2019-09-12 00:21:55', 0);
INSERT INTO `goods_category` VALUES (77, 3, 70, '沙发', 10, 0, '2019-09-12 00:22:21', 0, '2019-09-12 00:22:21', 0);
INSERT INTO `goods_category` VALUES (78, 3, 73, '跑鞋', 10, 0, '2019-09-12 00:22:42', 0, '2019-09-12 00:22:42', 0);
INSERT INTO `goods_category` VALUES (79, 2, 60, '游戏', 10, 0, '2019-09-12 00:23:13', 0, '2019-09-12 00:23:13', 0);
INSERT INTO `goods_category` VALUES (80, 2, 60, '动漫', 9, 0, '2019-09-12 00:23:21', 0, '2019-09-12 00:23:21', 0);
INSERT INTO `goods_category` VALUES (81, 2, 60, '影视', 8, 0, '2019-09-12 00:23:27', 0, '2019-09-12 00:23:27', 0);
INSERT INTO `goods_category` VALUES (82, 3, 79, 'LOL', 10, 0, '2019-09-12 00:23:44', 0, '2019-09-12 00:23:44', 0);
INSERT INTO `goods_category` VALUES (83, 2, 62, '美妆', 10, 0, '2019-09-12 00:23:58', 0, '2019-09-17 18:22:44', 0);
INSERT INTO `goods_category` VALUES (84, 2, 62, '宠物', 9, 0, '2019-09-12 00:24:07', 0, '2019-09-12 00:24:07', 0);
INSERT INTO `goods_category` VALUES (85, 2, 62, '清洁', 8, 0, '2019-09-12 00:24:15', 0, '2019-09-17 18:22:51', 0);
INSERT INTO `goods_category` VALUES (86, 3, 83, '口红', 10, 0, '2019-09-12 00:24:38', 0, '2019-09-17 18:23:08', 0);
INSERT INTO `goods_category` VALUES (87, 2, 63, '工具', 10, 0, '2019-09-12 00:24:56', 0, '2019-09-12 00:24:56', 0);
INSERT INTO `goods_category` VALUES (88, 2, 63, '装修', 9, 0, '2019-09-12 00:25:05', 0, '2019-09-12 00:25:05', 0);
INSERT INTO `goods_category` VALUES (89, 2, 63, '建材', 8, 0, '2019-09-12 00:25:12', 0, '2019-09-12 00:25:12', 0);
INSERT INTO `goods_category` VALUES (90, 3, 87, '转换器', 10, 0, '2019-09-12 00:25:45', 0, '2019-09-12 00:25:45', 0);
INSERT INTO `goods_category` VALUES (91, 2, 64, '珠宝', 10, 0, '2019-09-12 00:26:10', 0, '2019-09-12 00:26:10', 0);
INSERT INTO `goods_category` VALUES (92, 2, 64, '金饰', 9, 0, '2019-09-12 00:26:18', 0, '2019-09-12 00:26:18', 0);
INSERT INTO `goods_category` VALUES (93, 2, 64, '眼镜', 8, 0, '2019-09-12 00:26:25', 0, '2019-09-12 00:26:25', 0);
INSERT INTO `goods_category` VALUES (94, 3, 91, '钻石', 10, 0, '2019-09-12 00:26:40', 0, '2019-09-12 00:26:40', 0);
INSERT INTO `goods_category` VALUES (95, 2, 66, '鞋靴', 10, 0, '2019-09-12 00:27:09', 0, '2019-09-12 00:27:09', 0);
INSERT INTO `goods_category` VALUES (96, 2, 66, '箱包', 9, 0, '2019-09-12 00:27:17', 0, '2019-09-12 00:27:17', 0);
INSERT INTO `goods_category` VALUES (97, 2, 66, '配件', 8, 0, '2019-09-12 00:27:23', 0, '2019-09-12 00:27:23', 0);
INSERT INTO `goods_category` VALUES (98, 3, 95, '休闲鞋', 10, 0, '2019-09-12 00:27:48', 0, '2019-09-12 00:27:48', 0);
INSERT INTO `goods_category` VALUES (99, 3, 83, '气垫', 0, 0, '2019-09-17 18:24:23', 0, '2019-09-17 18:24:23', 0);
INSERT INTO `goods_category` VALUES (100, 3, 83, '美白', 0, 0, '2019-09-17 18:24:36', 0, '2019-09-17 18:24:36', 0);
INSERT INTO `goods_category` VALUES (101, 3, 83, '隔离霜', 0, 0, '2019-09-17 18:27:04', 0, '2019-09-17 18:27:04', 0);
INSERT INTO `goods_category` VALUES (102, 3, 83, '粉底', 0, 0, '2019-09-17 18:27:19', 0, '2019-09-17 18:27:19', 0);
INSERT INTO `goods_category` VALUES (103, 3, 83, '腮红', 0, 0, '2019-09-17 18:27:24', 0, '2019-09-17 18:27:24', 0);
INSERT INTO `goods_category` VALUES (104, 3, 83, '睫毛膏', 0, 0, '2019-09-17 18:27:47', 0, '2019-09-17 18:27:47', 0);
INSERT INTO `goods_category` VALUES (105, 3, 83, '香水', 0, 0, '2019-09-17 18:28:16', 0, '2019-09-17 18:28:16', 0);
INSERT INTO `goods_category` VALUES (106, 3, 83, '面膜', 0, 0, '2019-09-17 18:28:21', 0, '2019-09-17 18:28:21', 0);

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `goods_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品表主键id',
  `goods_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品名',
  `goods_intro` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品简介',
  `goods_category_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联分类id',
  `goods_cover_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '/admin/dist/img/no-img.png' COMMENT '商品主图',
  `goods_carousel` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '/admin/dist/img/no-img.png' COMMENT '商品轮播图',
  `goods_detail_content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品详情',
  `original_price` int(11) NOT NULL DEFAULT 1 COMMENT '商品价格',
  `selling_price` int(11) NOT NULL DEFAULT 1 COMMENT '商品实际售价',
  `stock_num` int(11) NOT NULL DEFAULT 0 COMMENT '商品库存数量',
  `tag` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品标签',
  `goods_sell_status` int(20) NOT NULL DEFAULT 0 COMMENT '商品上架状态 0-下架 1-上架',
  `create_user` int(20) NOT NULL DEFAULT 0 COMMENT '添加者主键id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '商品添加时间',
  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '修改者主键id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '商品修改时间',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺',
  `goods_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品类别',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10896 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES (1001, '小米8', '小米手机8代', 51, '/mall/image/goods/1001.jpg', '暂无', '暂无', 1000, 1000, 99, '推荐', 0, 0, '2019-12-11 13:52:29', 0, '2019-12-18 13:52:34', 101, '手机');
INSERT INTO `goods_info` VALUES (1002, '小米9', '小米手机9代', 51, '/mall/image/goods/1002.jpg', '暂无', '暂无', 1000, 1001, 99, '推荐', 0, 0, '2019-12-17 15:06:53', 0, '2019-12-17 15:06:59', 101, '手机');
INSERT INTO `goods_info` VALUES (1003, '小米10', '小米手机10代', 51, '/mall/image/goods/1003.jpg', '暂无', '未知屏', 8888, 8887, 100, '暂无', 0, 0, '2019-12-17 15:55:10', 0, '2019-12-17 15:55:15', 101, '手机');
INSERT INTO `goods_info` VALUES (1004, '小米Redmi', '小米Redmi系列', 51, '/mall/image/goods/1004.jpg', '暂无', '全面屏', 7777, 7776, 100, '暂无', 0, 0, '2019-12-19 15:57:14', 0, '2019-12-18 15:57:19', 101, '手机');
INSERT INTO `goods_info` VALUES (1005, '惠普光影精灵', '惠普电脑', 52, '/mall/image/goods/1005.jpg', '暂无', '发热发烫', 5999, 5888, 100, '暂无', 0, 0, '2019-12-17 15:59:47', 0, '2019-12-17 15:59:53', 103, '电脑');
INSERT INTO `goods_info` VALUES (1006, '华为10', '华为手机真的厉害', 51, '/mall/image/goods/1006.jpg', '暂无', '激光切割', 6666, 6666, 100, '推荐', 0, 0, '2019-12-17 16:01:38', 0, '2019-12-17 16:01:42', 102, '手机');
INSERT INTO `goods_info` VALUES (1007, '华为9', '真华为', 51, '/mall/image/goods/1007.jpg', '暂无', '手机中的战斗机', 5555, 5444, 100, '暂无', 0, 0, '2019-12-17 16:03:36', 0, '2019-12-17 16:03:39', 102, '手机');
INSERT INTO `goods_info` VALUES (1008, '华为-s', '最新款华为手机', 51, '/mall/image/goods/1008.jpg', '暂无', '穿越火线联名款', 7777, 7776, 100, '暂无', 0, 0, '2019-12-17 16:05:28', 0, '2019-12-17 16:05:32', 102, '手机');
INSERT INTO `goods_info` VALUES (1009, '神舟笔记本电脑', '战神', 52, '/mall/image/goods/1009.jpg', '暂无', '高配，畅快吃鸡', 12000, 11199, 97, '推荐', 0, 0, '2019-12-17 16:07:04', 0, '2019-12-17 16:07:08', 103, '电脑');
INSERT INTO `goods_info` VALUES (1010, '华硕电脑', '败家之眼', 52, '/mall/image/goods/1010.jpg', '暂无', '配置2080T', 19999, 18888, 100, '推荐', 0, 0, '2019-12-17 16:09:19', 0, '2019-12-17 16:09:24', 103, '电脑');
INSERT INTO `goods_info` VALUES (1011, '苹果8', '圆滑曲线', 51, '/mall/image/goods/1011.jpg', '暂无', '熟悉的味道', 7777, 6666, 100, '暂无', 0, 0, '2019-12-17 16:11:36', 0, '2019-12-17 16:11:39', 101, '手机');
INSERT INTO `goods_info` VALUES (1012, '苹果9', '最新苹果手机', 51, '/mall/image/goods/1012.jpg', '暂无', '值一个', 8888, 8887, 100, '暂无', 0, 0, '2019-12-17 16:14:37', 0, '2019-12-17 16:14:41', 101, '手机');
INSERT INTO `goods_info` VALUES (1013, '苹果X', '最热的苹果手机', 51, '/mall/image/goods/1013.jpg', '暂无', '也值一个', 9999, 19999, 100, '暂无', 0, 0, '2019-12-17 16:17:57', 0, '2019-12-17 16:18:02', 101, '手机');
INSERT INTO `goods_info` VALUES (1110, '华为mate30', '华为最新手机', 51, '4242', '/admin/dist/img/no-img.png', '蜂窝摄像头', 8888, 8887, 100, '暂无', 0, 0, '2019-12-17 17:09:36', 0, '2019-12-17 17:09:39', 102, '手机');
INSERT INTO `goods_info` VALUES (1111, '华为matePad', '华为最新电脑', 51, '/admin/dist/img/no-img.png', '/admin/dist/img/no-img.png', '360°折叠', 12000, 11999, 100, '暂无', 0, 0, '2019-12-17 17:11:22', 0, '2019-12-17 17:11:26', 103, '电脑');
INSERT INTO `goods_info` VALUES (1112, '花花公子鞋子', '棉鞋', 55, '/admin/dist/img/no-img.png', '/admin/dist/img/no-img.png', '绝对的保暖', 199, 198, 100, '暂无', 0, 0, '2019-12-17 17:12:27', 0, '2019-12-17 17:12:30', 107, '鞋子');

-- ----------------------------
-- Table structure for index_config
-- ----------------------------
DROP TABLE IF EXISTS `index_config`;
CREATE TABLE `index_config`  (
  `config_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '首页配置项主键id',
  `config_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '显示字符(配置搜索时不可为空，其他可为空)',
  `config_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热销商品 4-(首页)新品上线 5-(首页)为你推荐',
  `goods_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品id 默认为0',
  `redirect_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '##' COMMENT '点击后的跳转地址(默认不跳转)',
  `config_rank` int(11) NOT NULL DEFAULT 0 COMMENT '排序值(字段越大越靠前)',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_user` int(11) NOT NULL DEFAULT 0 COMMENT '创建者id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最新修改时间',
  `update_user` int(11) NULL DEFAULT 0 COMMENT '修改者id',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index_config
-- ----------------------------
INSERT INTO `index_config` VALUES (1, '热销商品 iPhone XR', 3, 10284, '##', 10, 0, '2019-09-18 17:04:56', 0, '2019-09-18 17:04:56', 0);
INSERT INTO `index_config` VALUES (2, '热销商品 华为 Mate20', 3, 10779, '##', 100, 0, '2019-09-18 17:05:27', 0, '2019-09-18 17:05:27', 0);
INSERT INTO `index_config` VALUES (3, '热销商品 荣耀8X', 3, 10700, '##', 300, 0, '2019-09-18 17:08:02', 0, '2019-09-18 17:08:02', 0);
INSERT INTO `index_config` VALUES (4, '热销商品 Apple AirPods', 3, 10159, '##', 101, 0, '2019-09-18 17:08:56', 0, '2019-09-18 17:08:56', 0);
INSERT INTO `index_config` VALUES (5, '新品上线 Macbook Pro', 4, 10269, '##', 100, 0, '2019-09-18 17:10:36', 0, '2019-09-18 17:10:36', 0);
INSERT INTO `index_config` VALUES (6, '新品上线 荣耀 9X Pro', 4, 10755, '##', 100, 0, '2019-09-18 17:11:05', 0, '2019-09-18 17:11:05', 0);
INSERT INTO `index_config` VALUES (7, '新品上线 iPhone 11', 4, 10283, '##', 102, 0, '2019-09-18 17:11:44', 0, '2019-09-18 17:11:44', 0);
INSERT INTO `index_config` VALUES (8, '新品上线 iPhone 11 Pro', 4, 10320, '##', 101, 0, '2019-09-18 17:11:58', 0, '2019-09-18 17:11:58', 0);
INSERT INTO `index_config` VALUES (9, '新品上线 华为无线耳机', 4, 10186, '##', 100, 0, '2019-09-18 17:12:29', 0, '2019-09-18 17:12:29', 0);
INSERT INTO `index_config` VALUES (10, '纪梵希高定香榭天鹅绒唇膏', 5, 10233, '##', 98, 0, '2019-09-18 17:47:23', 0, '2019-09-18 17:47:23', 0);
INSERT INTO `index_config` VALUES (11, 'MAC 磨砂系列', 5, 10237, '##', 100, 0, '2019-09-18 17:47:44', 0, '2019-09-18 17:47:44', 0);
INSERT INTO `index_config` VALUES (12, '索尼 WH-1000XM3', 5, 10195, '##', 100, 0, '2019-09-18 17:48:00', 0, '2019-09-18 17:48:00', 0);
INSERT INTO `index_config` VALUES (13, 'Apple AirPods', 5, 10180, '##', 101, 0, '2019-09-18 17:49:11', 0, '2019-09-18 17:49:11', 0);
INSERT INTO `index_config` VALUES (14, '小米 Redmi AirDots', 5, 10160, '##', 100, 0, '2019-09-18 17:49:28', 0, '2019-09-18 17:49:28', 0);
INSERT INTO `index_config` VALUES (15, '2019 MacBookAir 13', 5, 10254, '##', 100, 0, '2019-09-18 17:50:18', 0, '2019-09-18 17:50:18', 0);
INSERT INTO `index_config` VALUES (16, '女式粗棉线条纹长袖T恤', 5, 10158, '##', 99, 0, '2019-09-18 17:52:03', 0, '2019-09-18 17:52:03', 0);
INSERT INTO `index_config` VALUES (17, '塑料浴室座椅', 5, 10154, '##', 100, 0, '2019-09-18 17:52:19', 0, '2019-09-18 17:52:19', 0);
INSERT INTO `index_config` VALUES (18, '靠垫', 5, 10147, '##', 101, 0, '2019-09-18 17:52:50', 0, '2019-09-18 17:52:50', 0);
INSERT INTO `index_config` VALUES (19, '小型超声波香薰机', 5, 10113, '##', 100, 0, '2019-09-18 17:54:07', 0, '2019-09-18 17:54:07', 0);
INSERT INTO `index_config` VALUES (20, '11', 5, 1, '##', 0, 1, '2019-09-19 08:31:11', 0, '2019-09-19 08:31:20', 0);
INSERT INTO `index_config` VALUES (21, '热销商品 华为 P30', 3, 10742, '##', 200, 0, '2019-09-19 23:23:38', 0, '2019-09-19 23:23:38', 0);
INSERT INTO `index_config` VALUES (22, '新品上线 华为Mate30 Pro', 4, 10893, '##', 200, 0, '2019-09-19 23:26:05', 0, '2019-09-19 23:26:05', 0);
INSERT INTO `index_config` VALUES (23, '新品上线 华为 Mate 30', 4, 10895, '##', 199, 0, '2019-09-19 23:26:32', 0, '2019-09-19 23:26:32', 0);
INSERT INTO `index_config` VALUES (24, '华为 Mate 30 Pro', 5, 10894, '##', 101, 0, '2019-09-19 23:27:00', 0, '2019-09-19 23:27:00', 0);

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order`  (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单表主键id',
  `order_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户主键id',
  `total_price` int(11) NOT NULL DEFAULT 1 COMMENT '订单总价',
  `pay_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '支付状态:0.未支付,1.支付成功,-1:支付失败',
  `pay_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '0.无 1.支付宝支付 2.微信支付',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态:0.待支付 1.已支付 2.配货完成 3:出库成功 4.交易成功 -1.手动关闭 -2.超时关闭 -3.商家关闭',
  `extra_info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单body',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货人姓名',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货人手机号',
  `user_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货人收货地址',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最新修改时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_order
-- ----------------------------
INSERT INTO `mall_order` VALUES (21, '15751058380811610', 9, 1198, 1, 1, '2019-11-30 17:24:06', 4, '', '', '', '南昌大学前湖校区19栋', 0, '2019-11-30 17:23:58', '2019-12-07 22:44:03');
INSERT INTO `mall_order` VALUES (22, '15757158825538297', 9, 1795, 1, 1, '2019-12-07 18:51:28', 5, '', '13213', '18888888888', '南昌大学前湖校区19栋', 0, '2019-12-07 18:51:22', '2019-12-17 10:24:56');
INSERT INTO `mall_order` VALUES (23, '15757158825538296', 9, 2244, 1, 1, '2019-12-09 15:41:43', 5, '', 'zjc', '18018679845', '南昌大学前湖校区20栋120', 0, '2019-12-09 15:41:35', '2019-12-17 16:55:24');
INSERT INTO `mall_order` VALUES (24, '15764834493202217', 9, 1246, 1, 1, '2019-12-16 16:04:15', 1, '', '', '', '南昌大学前湖校区zjc18016708265', 0, '2019-12-16 16:04:09', '2019-12-16 16:04:15');
INSERT INTO `mall_order` VALUES (25, '15765688723021038', 9, 2001, 1, 1, '2019-12-17 15:47:56', 5, '', '', '', '南昌大学前湖校区zjc18016708265', 0, '2019-12-17 15:47:52', '2019-12-17 17:01:35');
INSERT INTO `mall_order` VALUES (26, '15766611197761441', 11, 33597, 1, 2, '2019-12-18 17:25:25', 1, '', '', '', '江西省南昌市新建区南昌大学前湖校区20栋', 0, '2019-12-18 17:25:19', '2019-12-18 17:25:25');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单关联购物项主键id',
  `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单主键id',
  `goods_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联商品id',
  `goods_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '下单时商品的名称(订单快照)',
  `goods_cover_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '下单时商品的主图(订单快照)',
  `selling_price` int(11) NOT NULL DEFAULT 1 COMMENT '下单时商品的价格(订单快照)',
  `goods_count` int(11) NOT NULL DEFAULT 1 COMMENT '数量(订单快照)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`order_item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (1, 1, 10180, 'Apple AirPods 配充电盒', '/goods-img/64768a8d-0664-4b29-88c9-2626578ffbd1.jpg', 1246, 2, '2019-09-18 22:53:07');
INSERT INTO `order_item` VALUES (2, 2, 10147, 'MUJI 羽毛 靠垫', '/goods-img/0f701215-b782-40c7-8bbd-97b51be56461.jpg', 65, 1, '2019-09-18 22:55:20');
INSERT INTO `order_item` VALUES (3, 2, 10158, '无印良品 女式粗棉线条纹长袖T恤', 'http://localhost:28089/goods-img/5488564b-8335-4b0c-a5a4-52f3f03ee728.jpg', 70, 1, '2019-09-18 22:55:20');
INSERT INTO `order_item` VALUES (4, 3, 10742, '华为 HUAWEI P30 Pro', '/goods-img/dda1d575-cdac-4eb4-a118-3834490166f7.jpg', 5488, 1, '2019-09-19 23:56:40');
INSERT INTO `order_item` VALUES (5, 3, 10320, 'Apple iPhone 11 Pro', '/goods-img/0025ad55-e260-4a00-be79-fa5b8c5ac0de.jpg', 9999, 1, '2019-09-19 23:56:40');
INSERT INTO `order_item` VALUES (6, 4, 10254, 'Apple 2019款 MacBook Air 13.3', '/goods-img/7810bc9d-236f-4386-a0ef-45a831b49bf2.jpg', 8499, 1, '2019-09-19 23:58:18');
INSERT INTO `order_item` VALUES (7, 5, 10104, '无印良品 MUJI 修正带', '/goods-img/98ce17e1-890e-4eaf-856a-7fce8ffebc4c.jpg', 15, 1, '2019-09-20 00:08:04');
INSERT INTO `order_item` VALUES (8, 5, 10110, '无印良品 MUJI 基础润肤乳霜', '/goods-img/30036561-a150-4ea7-9106-29bbea278909.jpg', 100, 1, '2019-09-20 00:08:04');
INSERT INTO `order_item` VALUES (9, 6, 10895, 'HUAWEI Mate 30 4000万超感光徕卡影像', '/goods-img/mate30-3.png', 3999, 2, '2019-09-22 22:57:15');
INSERT INTO `order_item` VALUES (10, 7, 10895, 'HUAWEI Mate 30 4000万超感光徕卡影像', '/goods-img/mate30-3.png', 3999, 1, '2019-09-22 23:01:44');
INSERT INTO `order_item` VALUES (11, 7, 10320, 'Apple iPhone 11 Pro', '/goods-img/0025ad55-e260-4a00-be79-fa5b8c5ac0de.jpg', 9999, 1, '2019-09-22 23:01:44');
INSERT INTO `order_item` VALUES (12, 8, 10180, 'Apple AirPods 配充电盒', '/goods-img/64768a8d-0664-4b29-88c9-2626578ffbd1.jpg', 1246, 1, '2019-09-22 23:02:45');
INSERT INTO `order_item` VALUES (13, 9, 10237, 'MAC 雾面丝绒哑光子弹头口红', 'http://localhost:28089/goods-img/1930d79b-88bd-4c5c-8510-0697c9ad2578.jpg', 165, 4, '2019-09-22 23:03:52');
INSERT INTO `order_item` VALUES (14, 9, 10254, 'Apple 2019款 MacBook Air 13.3', '/goods-img/7810bc9d-236f-4386-a0ef-45a831b49bf2.jpg', 8499, 2, '2019-09-22 23:03:52');
INSERT INTO `order_item` VALUES (15, 9, 10195, '索尼 WH-1000XM3 头戴式耳机', 'http://localhost:28089/goods-img/0dc503b2-90a2-4971-9723-c085a1844b76.jpg', 2599, 1, '2019-09-22 23:03:52');
INSERT INTO `order_item` VALUES (16, 9, 10894, 'HUAWEI Mate 30 Pro', '/goods-img/mate30p3.png', 5399, 1, '2019-09-22 23:03:52');
INSERT INTO `order_item` VALUES (17, 10, 10894, 'HUAWEI Mate 30 Pro', '/goods-img/mate30p3.png', 5399, 3, '2019-09-22 23:08:06');
INSERT INTO `order_item` VALUES (18, 11, 10279, 'Apple iPhone 11 (A2223)', '/goods-img/a0d09f94-9c46-4ee1-aaef-dfd132e7543e.jpg', 5999, 1, '2019-09-23 14:43:27');
INSERT INTO `order_item` VALUES (19, 12, 10279, 'Apple iPhone 11 (A2223)', '/goods-img/a0d09f94-9c46-4ee1-aaef-dfd132e7543e.jpg', 5999, 1, '2019-09-23 14:57:26');
INSERT INTO `order_item` VALUES (20, 12, 10159, 'Apple AirPods 配充电盒', '/goods-img/53c9f268-7cd4-4fac-909c-2dc066625655.jpg', 1246, 1, '2019-09-23 14:57:26');
INSERT INTO `order_item` VALUES (21, 13, 10742, '华为 HUAWEI P30 Pro', '/goods-img/dda1d575-cdac-4eb4-a118-3834490166f7.jpg', 5488, 1, '2019-09-23 15:08:46');
INSERT INTO `order_item` VALUES (22, 14, 10158, '无印良品 女式粗棉线条纹长袖T恤', '/goods-img/5488564b-8335-4b0c-a5a4-52f3f03ee728.jpg', 70, 1, '2019-09-23 16:59:24');
INSERT INTO `order_item` VALUES (23, 14, 10704, '华为 HUAWEI P30 超感光徕卡三摄麒麟980AI...', '/goods-img/b9e6d770-06dd-40f4-9ae5-31103cec6e5f.jpg', 3988, 1, '2019-09-23 16:59:24');
INSERT INTO `order_item` VALUES (24, 14, 10739, '华为 HUAWEI P30 Pro', '/goods-img/65c8e729-aeca-4780-977b-4d0d39d4aa2e.jpg', 4988, 1, '2019-09-23 16:59:24');
INSERT INTO `order_item` VALUES (25, 15, 10147, 'MUJI 羽毛 靠垫', '/goods-img/0f701215-b782-40c7-8bbd-97b51be56461.jpg', 65, 1, '2019-09-23 17:05:34');
INSERT INTO `order_item` VALUES (26, 16, 10742, '华为 HUAWEI P30 Pro', '/goods-img/dda1d575-cdac-4eb4-a118-3834490166f7.jpg', 5488, 1, '2019-09-23 17:10:03');
INSERT INTO `order_item` VALUES (27, 16, 10159, 'Apple AirPods 配充电盒', '/goods-img/53c9f268-7cd4-4fac-909c-2dc066625655.jpg', 1246, 1, '2019-09-23 17:10:03');
INSERT INTO `order_item` VALUES (28, 16, 10254, 'Apple 2019款 MacBook Air 13.3', '/goods-img/7810bc9d-236f-4386-a0ef-45a831b49bf2.jpg', 8499, 1, '2019-09-23 17:10:03');
INSERT INTO `order_item` VALUES (29, 17, 10180, 'Apple AirPods 配充电盒', '/goods-img/64768a8d-0664-4b29-88c9-2626578ffbd1.jpg', 1246, 1, '2019-09-26 14:09:56');
INSERT INTO `order_item` VALUES (30, 18, 10779, '华为 HUAWEI Mate 20', '/goods-img/08f9a912-f049-4cf8-a839-115fc6582398.jpg', 3199, 1, '2019-09-30 08:38:26');
INSERT INTO `order_item` VALUES (31, 19, 10742, '华为 HUAWEI P30 Pro', '/goods-img/dda1d575-cdac-4eb4-a118-3834490166f7.jpg', 5488, 1, '2019-10-05 20:20:10');
INSERT INTO `order_item` VALUES (32, 19, 10154, '无印良品 MUJI 塑料浴室座椅', '/goods-img/15395057-94e9-4545-a8ee-8aee025f40c5.jpg', 85, 1, '2019-10-05 20:20:10');
INSERT INTO `order_item` VALUES (33, 19, 10159, 'Apple AirPods 配充电盒', '/goods-img/53c9f268-7cd4-4fac-909c-2dc066625655.jpg', 1246, 1, '2019-10-05 20:20:10');
INSERT INTO `order_item` VALUES (34, 20, 10895, 'HUAWEI Mate 30 4000万超感光徕卡影像', '/goods-img/mate30-3.png', 3999, 1, '2019-10-05 22:12:47');
INSERT INTO `order_item` VALUES (35, 21, 10694, '荣耀10青春版 幻彩渐变 2400万AI自拍 全网通版4...', '/goods-img/de654f42-d58d-4336-8edd-da01c3523449.jpg', 999, 1, '2019-11-30 17:23:58');
INSERT INTO `order_item` VALUES (36, 21, 10187, '【自营仓次日达】moloke真无线蓝牙耳机双耳适用于苹果...', '/goods-img/1e5645d1-24cb-48eb-9aaa-f729fa0db195.jpg', 199, 1, '2019-11-30 17:23:58');
INSERT INTO `order_item` VALUES (37, 22, 10187, '【自营仓次日达】moloke真无线蓝牙耳机双耳适用于苹果...', '/goods-img/1e5645d1-24cb-48eb-9aaa-f729fa0db195.jpg', 199, 4, '2019-12-07 18:51:22');
INSERT INTO `order_item` VALUES (38, 22, 10695, '荣耀10青春版 幻彩渐变 2400万AI自拍 全网通版4...', '/goods-img/87254a42-9fdf-4e68-a11e-e8e2eef28d2c.jpg', 999, 1, '2019-12-07 18:51:22');
INSERT INTO `order_item` VALUES (39, 23, 10171, '小米耳机 圈铁Pro 入耳式有线运动音乐耳机耳麦', '/goods-img/f3d269a4-5317-4b30-b164-1311f6c1f058.jpg', 149, 5, '2019-12-09 15:41:35');
INSERT INTO `order_item` VALUES (40, 23, 10691, '华为 HUAWEI 畅享10 Plus', '/goods-img/21b0751b-f6ae-4a57-8fb8-61e007395c43.jpg', 1499, 1, '2019-12-09 15:41:35');
INSERT INTO `order_item` VALUES (41, 24, 10159, 'Apple AirPods 配充电盒', '/goods-img/53c9f268-7cd4-4fac-909c-2dc066625655.jpg', 1246, 1, '2019-12-16 16:04:09');
INSERT INTO `order_item` VALUES (42, 25, 1002, '小米9', '暂无', 1001, 1, '2019-12-17 15:47:52');
INSERT INTO `order_item` VALUES (43, 25, 1001, '小米8', '暂无', 1000, 1, '2019-12-17 15:47:52');
INSERT INTO `order_item` VALUES (44, 26, 1009, '神舟笔记本电脑', '/mall/image/goods/1009.jpg', 11199, 3, '2019-12-18 17:25:19');

-- ----------------------------
-- Table structure for shops_info
-- ----------------------------
DROP TABLE IF EXISTS `shops_info`;
CREATE TABLE `shops_info`  (
  `shop_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '店铺号',
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺名',
  `shop_owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺主人',
  `shop_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卖什么东西',
  `shop_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺主页图片',
  `locked_flag` tinyint(4) NOT NULL COMMENT '店铺状态，是否冻结 0-正常 1-冻结',
  `shop_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介',
  `shop_creattime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺创建时间',
  `is_deleted` tinyint(4) NOT NULL COMMENT '注销状态，是否注销 0-正常 1-注销',
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shops_info
-- ----------------------------
INSERT INTO `shops_info` VALUES (101, 'LS手机店', '李帅', '手机', '/mall/image/shops/101.jpg', 0, '手机', '今天', 0);
INSERT INTO `shops_info` VALUES (102, 'zzc手机店', 'zzc', '手机', '/mall/image/shops/102.jpg', 0, '不光小米手机，什么都卖', '今天', 0);
INSERT INTO `shops_info` VALUES (103, 'LS电脑城', 'LS', '电脑', '/mall/image/shops/103.jpg', 0, '卖电脑', '今天', 0);
INSERT INTO `shops_info` VALUES (104, '苹果手机旗舰店', 'Apple', '手机', '/mall/image/shops/104.jpg', 0, '苹果手机', '今天', 0);
INSERT INTO `shops_info` VALUES (105, 'vivo手机旗舰店', 'vivo', '手机', '/mall/image/shops/105.jpg', 0, 'vivo手机', '今天', 0);
INSERT INTO `shops_info` VALUES (106, '锤子手机旗舰店', '罗永浩', '手机', '/mall/image/shops/106.jpg', 0, '买个锤子', '今天', 0);
INSERT INTO `shops_info` VALUES (107, '花花公子旗舰店', '花花公子', '鞋子，衣服', '/mall/image/shops/107.jpg', 0, '衣服，鞋子', '今天', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键id',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
  `login_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '登陆名称(默认为手机号)',
  `password_md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'MD5加密后的密码',
  `introduce_sign` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '个性签名',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货地址',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '注销标识字段(0-正常 1-已注销)',
  `right_flag` tinyint(4) NOT NULL DEFAULT 1 COMMENT '用户类型字段(1-会员 2-商家)',
  `locked_flag` tinyint(4) NOT NULL COMMENT '锁定标识字段(1-已锁定 0-未锁定)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '十三', '13700002703', 'e10adc3949ba59abbe56e057f20f883e', '我不怕千万人阻挡，只怕自己投降', '杭州市西湖区xx小区x幢419 十三 137xxxx2703', 0, 0, 0, '2019-09-22 08:44:57');
INSERT INTO `user` VALUES (6, '测试用户1', '13711113333', 'dda01dc6d334badcd031102be6bee182', '测试用户1', '上海浦东新区XX路XX号 999 137xxxx7797', 0, 0, 0, '2019-08-29 10:51:39');
INSERT INTO `user` VALUES (7, '测试用户2测试用户2测试用户2测试用户2', '13811113333', 'dda01dc6d334badcd031102be6bee182', '测试用户2', '杭州市西湖区xx小区x幢419 十三 137xxxx2703', 0, 0, 0, '2019-08-29 10:55:08');
INSERT INTO `user` VALUES (8, '测试用户3', '13911113333', 'dda01dc6d334badcd031102be6bee182', '测试用户3', '杭州市西湖区xx小区x幢419 十三 137xxxx2703', 0, 0, 0, '2019-08-29 10:55:16');
INSERT INTO `user` VALUES (9, '18016708265', '18016708265', '871f684692e0f1d5c3f6aa66655d9a79', '', '南昌大学前湖校区zjc18016708265', 0, 0, 0, '2019-11-30 16:01:39');
INSERT INTO `user` VALUES (10, '13870985027', '13870985027', '1849bc2fa7850764fcfe45f75ae17b52', '', '努巴尼qwed1234567891', 0, 0, 0, '2019-12-09 17:55:51');
INSERT INTO `user` VALUES (11, '白晓伊', '13479583283', 'e10adc3949ba59abbe56e057f20f883e', '我曾经跨过山和大海，也穿过人山人海', '江西省南昌市新建区南昌大学前湖校区20栋', 0, 1, 0, '2019-12-18 16:56:07');

-- ----------------------------
-- Table structure for user_apply
-- ----------------------------
DROP TABLE IF EXISTS `user_apply`;
CREATE TABLE `user_apply`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
  `login_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '登陆名称(默认为手机号)',
  `password_md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'MD5加密后的密码',
  `introduce_sign` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '个性签名',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货地址',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '注销标识字段(0-正常 1-已注销)',
  `right_flag` tinyint(4) NOT NULL DEFAULT 1 COMMENT '锁定标识字段(0-已锁定 1-未锁定 2-商家用户)',
  `apply_reason` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请原因',
  `apply_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '申请修改信息时间'
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_apply
-- ----------------------------
INSERT INTO `user_apply` VALUES (1, '1', '1', 'e10adc3949ba59abbe56e057f20f883e', '1', '1', 0, 1, '1', '2019-12-18 16:57:20');
INSERT INTO `user_apply` VALUES (2, '2', '2', '22', '2', '2', 0, 1, '2', '2019-12-18 17:03:57');
INSERT INTO `user_apply` VALUES (3, '3', '3', '3', '3', '3', 0, 1, '3', '2019-12-18 17:04:09');

-- ----------------------------
-- Table structure for user_comment
-- ----------------------------
DROP TABLE IF EXISTS `user_comment`;
CREATE TABLE `user_comment`  (
  `order_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品表主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  `comment_create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '评价创建时间',
  `comment_update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '评价最新修改时间',
  `user_evaluation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '该用户还未评价' COMMENT '用户评价',
  `add_evaluation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '追加评价',
  `goods_score` int(11) NOT NULL DEFAULT 5 COMMENT '商品打分(1-5)',
  `service_score` int(11) NOT NULL DEFAULT 5 COMMENT '服务打分(1-5)',
  `logistics_score` int(11) NOT NULL DEFAULT 5 COMMENT '物流打分(1-5)',
  `submit_img` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户上传图片',
  `comment_is_deleted` tinyint(4) NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `seller_id` bigint(20) NULL DEFAULT 123456 COMMENT '卖家主键id',
  `store_id` bigint(20) NULL DEFAULT 123456 COMMENT '店铺主键id',
  `store_reply` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '商家回复',
  `reply_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '商家回复时间',
  PRIMARY KEY (`order_no`, `goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15765688723021039 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_comment
-- ----------------------------
INSERT INTO `user_comment` VALUES (15757158825538296, 10171, 9, '2019-12-17 10:28:12', '2019-12-17 16:55:24', '该用户还未评价', '135435', 4, 3, 3, NULL, 0, 123456, 123456, '', '2019-12-17 16:55:24');
INSERT INTO `user_comment` VALUES (15757158825538296, 10691, 9, '2019-12-17 10:28:17', '2019-12-17 10:28:17', '该用户还未评价', '16574987', 2, 5, 3, NULL, 0, 123456, 123456, '', '2019-12-17 10:28:17');
INSERT INTO `user_comment` VALUES (15757158825538297, 10187, 9, '2019-12-15 14:43:18', '2019-12-17 10:24:56', '123456789', '136547987', 5, 2, 3, 'upload\\images\\053.JPG', 0, 123456, 123456, '', '2019-12-17 10:24:56');
INSERT INTO `user_comment` VALUES (15757158825538297, 10695, 9, '2019-12-15 15:44:41', '2019-12-16 10:47:19', '456789123', '1654687', 5, 3, 3, 'upload\\images\\053.JPG', 0, 123456, 123456, '', '2019-12-16 10:47:19');
INSERT INTO `user_comment` VALUES (15765688723021038, 1001, 9, '2019-12-17 15:49:21', '2019-12-17 15:49:21', '456456', NULL, 5, 3, 3, NULL, 0, 123456, 123456, '', '2019-12-17 15:49:21');
INSERT INTO `user_comment` VALUES (15765688723021038, 1002, 9, '2019-12-17 15:49:08', '2019-12-17 17:01:35', '198649864', NULL, 0, 0, 0, 'upload\\images\\QQ截图20190405104634.png', 0, 123456, 123456, '', '2019-12-17 17:01:35');

SET FOREIGN_KEY_CHECKS = 1;
