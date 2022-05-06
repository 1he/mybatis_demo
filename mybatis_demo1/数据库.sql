/*
MySQL Backup
Database: test
Backup Time: 2022-05-06 11:49:52
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `test`.`user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `test`.`user` WRITE;
DELETE FROM `test`.`user`;
INSERT INTO `test`.`user` (`id`,`username`,`birthday`,`sex`,`address`) VALUES (41, '老王', '2018-02-27 17:47:08', '男', '北京'),(42, '小二王', '2018-03-02 15:09:37', '女', '北京金燕龙'),(43, '小二王', '2018-03-04 11:34:34', '女', '北京金燕龙'),(45, '传智播客', '2018-03-04 12:04:06', '男', '北京金燕龙'),(46, '老王', '2018-03-07 17:37:26', '男', '北京'),(48, '小马宝莉', '2018-03-08 11:44:00', '女', '北京修正');
UNLOCK TABLES;
COMMIT;
