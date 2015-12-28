/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.25 : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatis`;

/*Table structure for table `clazz` */

DROP TABLE IF EXISTS `clazz`;

CREATE TABLE `clazz` (
  `clazzid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(32) DEFAULT NULL,
  `describtion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`clazzid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `clazz` */

insert  into `clazz`(`clazzid`,`name`,`describtion`) values (1,'计科1201','扯淡1'),(2,'软件1201','扯淡2'),(3,'数媒1201','扯淡3');

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`id`,`name`,`age`) values (1,'张三',13),(2,'李四',13),(3,'王五',13),(4,'赵六',13);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `clazz` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`studentid`,`name`,`password`,`age`,`clazz`) values (1,'测试修改sjk','xiaozhang',13,1),(2,'李四','lisi',13,2),(3,'王五','wangwu',15,3),(4,'赵六','zhaoliu',13,2),(5,'陈七','chenqi',17,1),(6,'剑八','jianba',13,3),(7,'张三','xiaozhang',13,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
