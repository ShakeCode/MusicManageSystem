/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50149
Source Host           : localhost:3306
Source Database       : onlinemusic

Target Server Type    : MYSQL
Target Server Version : 50149
File Encoding         : 65001

Date: 2017-08-26 23:32:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_album`
-- ----------------------------
DROP TABLE IF EXISTS `t_album`;
CREATE TABLE `t_album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `singer` varchar(255) NOT NULL,
  `views` int(11) NOT NULL,
  `introduction` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_album
-- ----------------------------

-- ----------------------------
-- Table structure for `t_alum`
-- ----------------------------
DROP TABLE IF EXISTS `t_alum`;
CREATE TABLE `t_alum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `introduction` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `singer` varchar(50) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_alum
-- ----------------------------

-- ----------------------------
-- Table structure for `t_lyc`
-- ----------------------------
DROP TABLE IF EXISTS `t_lyc`;
CREATE TABLE `t_lyc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lycName` varchar(50) NOT NULL,
  `songID` int(11) NOT NULL,
  `lycURL` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `songName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_lyc
-- ----------------------------

-- ----------------------------
-- Table structure for `t_manager`
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES ('1', 'root', '1234');

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contant` longtext,
  `songID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for `t_singer`
-- ----------------------------
DROP TABLE IF EXISTS `t_singer`;
CREATE TABLE `t_singer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `views` int(11) NOT NULL,
  `hobby` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_singer
-- ----------------------------

-- ----------------------------
-- Table structure for `t_song`
-- ----------------------------
DROP TABLE IF EXISTS `t_song`;
CREATE TABLE `t_song` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `songName` varchar(255) NOT NULL,
  `singer` varchar(255) NOT NULL,
  `album` varchar(255) DEFAULT NULL,
  `typeName` varchar(50) NOT NULL,
  `fileSize` varchar(50) NOT NULL,
  `fileURL` varchar(255) NOT NULL,
  `format` varchar(10) NOT NULL,
  `hits` int(11) NOT NULL,
  `download` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_song
-- ----------------------------
INSERT INTO `t_song` VALUES ('1', 'songName', 'singer', '', 'typeName', 'fileSize', 'fileURL', 'format', '0', '0');

-- ----------------------------
-- Table structure for `t_songlist`
-- ----------------------------
DROP TABLE IF EXISTS `t_songlist`;
CREATE TABLE `t_songlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`,`userID`,`songID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_songlist
-- ----------------------------

-- ----------------------------
-- Table structure for `t_songtype`
-- ----------------------------
DROP TABLE IF EXISTS `t_songtype`;
CREATE TABLE `t_songtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_songtype
-- ----------------------------
INSERT INTO `t_songtype` VALUES ('1', '儿歌');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'test1', '1234', 'abc', '男', null, null, null);
