/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.28 : Database - traininginstitutions
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`traininginstitutions` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `traininginstitutions`;

/*Table structure for table `charge` */

DROP TABLE IF EXISTS `charge`;

CREATE TABLE `charge` (
  `chargeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '收费表主键',
  `gradeId` int(11) NOT NULL COMMENT '年级主键',
  `gradeName` varchar(50) NOT NULL COMMENT '年级名称',
  `studentName` varchar(50) DEFAULT NULL COMMENT '学生姓名',
  `stuId` int(11) NOT NULL COMMENT '学生信息主键',
  PRIMARY KEY (`chargeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `charge` */

insert  into `charge`(`chargeId`,`gradeId`,`gradeName`,`studentName`,`stuId`) values (1,1,'钢琴版班','张三',1);

/*Table structure for table `children` */

DROP TABLE IF EXISTS `children`;

CREATE TABLE `children` (
  `childrenId` int(11) NOT NULL AUTO_INCREMENT COMMENT '少儿学生表主键',
  `studentName` varchar(50) NOT NULL COMMENT '学生姓名',
  `studentSex` int(11) NOT NULL COMMENT '学生性别',
  `studentBirth` datetime NOT NULL COMMENT '学生出生日期',
  `school` varchar(50) DEFAULT NULL COMMENT '就读学校',
  `parentName` varchar(50) DEFAULT NULL COMMENT '家长姓名',
  `telephone` varchar(11) NOT NULL COMMENT '联系电话',
  `familyAddress` varchar(50) DEFAULT NULL COMMENT '家庭住址',
  `registrationChannels` varchar(50) DEFAULT NULL COMMENT '报名渠道',
  `registrationConsultant` varchar(50) DEFAULT NULL COMMENT '报名老师',
  `startTime` datetime NOT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`childrenId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `children` */

insert  into `children`(`childrenId`,`studentName`,`studentSex`,`studentBirth`,`school`,`parentName`,`telephone`,`familyAddress`,`registrationChannels`,`registrationConsultant`,`startTime`,`endTime`,`remarks`) values (1,'张三',1,'2015-05-02 00:00:00','红黄蓝幼儿园','张飞','13154612154','三国','互联网','小明老师','0000-00-00 00:00:00',NULL,'聪明的小孩');

/*Table structure for table `childrenesclass` */

DROP TABLE IF EXISTS `childrenesclass`;

CREATE TABLE `childrenesclass` (
  `childrenesClassId` int(11) NOT NULL AUTO_INCREMENT COMMENT '儿童班级主键',
  `classNumber` int(11) NOT NULL COMMENT '班级班号',
  `className` varchar(50) DEFAULT NULL COMMENT '班级名称',
  `dpId` int(11) DEFAULT NULL COMMENT '班级科别主键',
  `schoolId` int(11) NOT NULL COMMENT '班级所属学校主键',
  PRIMARY KEY (`childrenesClassId`),
  UNIQUE KEY `childrenesClassId` (`childrenesClassId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `childrenesclass` */

insert  into `childrenesclass`(`childrenesClassId`,`classNumber`,`className`,`dpId`,`schoolId`) values (1,1,'钢琴班',1,1);

/*Table structure for table `childrenesclassstudnet` */

DROP TABLE IF EXISTS `childrenesclassstudnet`;

CREATE TABLE `childrenesclassstudnet` (
  `classesStudentId` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级学生主键',
  `studentName` varchar(50) NOT NULL COMMENT '学生姓名',
  `headmaster` varchar(50) NOT NULL COMMENT '班主任',
  `enrollmentTime` datetime NOT NULL COMMENT '入学时间',
  `classId` int(11) NOT NULL COMMENT '班级主键',
  `studentId` int(11) NOT NULL COMMENT '学生主键',
  `state` int(2) NOT NULL DEFAULT '1' COMMENT '状态 1正常 0毕业 2休学',
  PRIMARY KEY (`classesStudentId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `childrenesclassstudnet` */

insert  into `childrenesclassstudnet`(`classesStudentId`,`studentName`,`headmaster`,`enrollmentTime`,`classId`,`studentId`,`state`) values (1,'张三','刘备','2019-08-06 15:23:28',1,1,1);

/*Table structure for table `childsturegistration` */

DROP TABLE IF EXISTS `childsturegistration`;

CREATE TABLE `childsturegistration` (
  `rOCCId` int(11) NOT NULL AUTO_INCREMENT COMMENT '少儿班上课登记主键',
  `studentName` varchar(50) NOT NULL COMMENT '学生姓名',
  `classHours` datetime NOT NULL COMMENT '上课时间',
  `dpId` int(11) NOT NULL COMMENT '上课名称主键',
  `contentOfCourses` varchar(500) DEFAULT NULL COMMENT '教学内容',
  `classHour` float(6,2) DEFAULT NULL COMMENT '教学课时',
  `teacherInClass` varchar(50) NOT NULL COMMENT '上课老师',
  `childStuId` int(11) NOT NULL COMMENT '上课学生主键',
  `state` int(11) DEFAULT NULL COMMENT '状态 0：正常 1：请假 ',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`rOCCId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `childsturegistration` */

insert  into `childsturegistration`(`rOCCId`,`studentName`,`classHours`,`dpId`,`contentOfCourses`,`classHour`,`teacherInClass`,`childStuId`,`state`,`remarks`) values (1,'张三','2019-08-06 15:26:25',2,'小星星弹奏',1.50,'刘备',1,0,NULL);

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT COMMENT '城市表主键',
  `cityName` varchar(50) NOT NULL COMMENT '城市名称',
  `provinceId` int(11) NOT NULL COMMENT '城市所在省份主键',
  PRIMARY KEY (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`cityId`,`cityName`,`provinceId`) values (1,'郑州',1),(2,'东营',2);

/*Table structure for table `departmentofpediatrics` */

DROP TABLE IF EXISTS `departmentofpediatrics`;

CREATE TABLE `departmentofpediatrics` (
  `dpId` int(11) NOT NULL AUTO_INCREMENT COMMENT '科别主键',
  `dpTypeName` varchar(50) NOT NULL COMMENT '科别名称',
  `chargeTypeId` int(11) NOT NULL COMMENT '科别所属类别主键',
  PRIMARY KEY (`dpId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `departmentofpediatrics` */

insert  into `departmentofpediatrics`(`dpId`,`dpTypeName`,`chargeTypeId`) values (1,'钢琴',2);

/*Table structure for table `feecategory` */

DROP TABLE IF EXISTS `feecategory`;

CREATE TABLE `feecategory` (
  `chargeTypeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '收费类型表',
  `chargeTypeName` varchar(50) NOT NULL COMMENT '收费类型名称',
  `feeCategory` int(11) NOT NULL COMMENT '收费类科别 0：少儿 1：高考 2：艺考',
  PRIMARY KEY (`chargeTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `feecategory` */

insert  into `feecategory`(`chargeTypeId`,`chargeTypeName`,`feeCategory`) values (1,'报名费',0),(2,'学费',0),(3,'住宿费',0),(4,'校服费',0),(5,'床上用品',0),(6,'生活费',0),(7,'空调费',0),(8,'书费',0),(9,'试卷费',0);

/*Table structure for table `highesclass` */

DROP TABLE IF EXISTS `highesclass`;

CREATE TABLE `highesclass` (
  `highesClassId` int(11) NOT NULL AUTO_INCREMENT COMMENT '高中班级主键',
  `classNumber` int(11) NOT NULL COMMENT '班级班号',
  `className` varchar(50) DEFAULT NULL COMMENT '班级名称',
  `dpId` int(11) DEFAULT NULL COMMENT '班级科别主键',
  `schoolId` int(11) NOT NULL COMMENT '班级所属学校主键',
  PRIMARY KEY (`highesClassId`),
  UNIQUE KEY `highesClassId` (`highesClassId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `highesclass` */

/*Table structure for table `highesclassstudnet` */

DROP TABLE IF EXISTS `highesclassstudnet`;

CREATE TABLE `highesclassstudnet` (
  `classesStudentId` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级学生主键',
  `studentName` varchar(50) NOT NULL COMMENT '学生姓名',
  `headmaster` varchar(50) NOT NULL COMMENT '班主任',
  `enrollmentTime` datetime NOT NULL COMMENT '入学时间',
  `classId` int(11) NOT NULL COMMENT '班级主键',
  `studentId` int(11) NOT NULL COMMENT '学生主键',
  `state` int(2) NOT NULL DEFAULT '1' COMMENT '状态 1正常 0毕业 2休学',
  PRIMARY KEY (`classesStudentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `highesclassstudnet` */

/*Table structure for table `highessturegistration` */

DROP TABLE IF EXISTS `highessturegistration`;

CREATE TABLE `highessturegistration` (
  `highesHourId` int(11) NOT NULL AUTO_INCREMENT COMMENT '少儿班上课登记主键',
  `studentName` varchar(50) NOT NULL COMMENT '学生姓名',
  `classHours` datetime NOT NULL COMMENT '上课时间',
  `dpId` int(11) NOT NULL COMMENT '上课名称主键',
  `contentOfCourses` varchar(500) DEFAULT NULL COMMENT '教学内容',
  `classHour` float(6,2) DEFAULT NULL COMMENT '教学课时',
  `teacherInClass` varchar(50) NOT NULL COMMENT '上课老师',
  `highesStuId` int(11) NOT NULL COMMENT '上课学生主键 对应班级学生主键',
  `state` int(11) DEFAULT NULL COMMENT '状态 0：正常 1：请假 ',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`highesHourId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `highessturegistration` */

/*Table structure for table `highschool` */

DROP TABLE IF EXISTS `highschool`;

CREATE TABLE `highschool` (
  `highschoolId` int(11) NOT NULL AUTO_INCREMENT COMMENT '高中学生表主键',
  `studentName` varchar(50) NOT NULL COMMENT '学生姓名',
  `studentSex` int(11) NOT NULL COMMENT '学生性别',
  `StudentIDCard` varchar(18) DEFAULT NULL COMMENT '学生身份证号',
  `studentBirth` datetime NOT NULL COMMENT '学生出生日期',
  `school` varchar(50) DEFAULT NULL COMMENT '就读学校',
  `parentName` varchar(50) DEFAULT NULL COMMENT '家长姓名',
  `telephone` varchar(11) NOT NULL COMMENT '联系电话',
  `familyAddress` varchar(50) DEFAULT NULL COMMENT '家庭住址',
  `registrationChannels` varchar(50) DEFAULT NULL COMMENT '报名渠道',
  `registrationConsultant` varchar(50) DEFAULT NULL COMMENT '报名老师',
  `startTime` datetime NOT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `theSurrogate` varchar(50) DEFAULT NULL COMMENT '接送人',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`highschoolId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `highschool` */

/*Table structure for table `province` */

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `provinceId` int(11) NOT NULL AUTO_INCREMENT COMMENT '省份主键',
  `provinceName` varchar(50) NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`provinceId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `province` */

insert  into `province`(`provinceId`,`provinceName`) values (1,'河南'),(2,'山东');

/*Table structure for table `school` */

DROP TABLE IF EXISTS `school`;

CREATE TABLE `school` (
  `schoolId` int(11) NOT NULL AUTO_INCREMENT COMMENT '学校主键',
  `schoolName` varchar(50) NOT NULL COMMENT '学校名称',
  `cityId` int(11) NOT NULL COMMENT '学校所在城市主键',
  `schoolRemarks` varchar(200) DEFAULT NULL COMMENT '学校备注',
  PRIMARY KEY (`schoolId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `school` */

insert  into `school`(`schoolId`,`schoolName`,`cityId`,`schoolRemarks`) values (1,'郑州培训学校',1,'教育改变生活'),(2,'东营培训学校',2,'教育改变生活');

/*Table structure for table `studenthours` */

DROP TABLE IF EXISTS `studenthours`;

CREATE TABLE `studenthours` (
  `studentHoursId` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生课时表主键',
  `hours` int(11) DEFAULT NULL COMMENT '课时',
  `hoursPrice` float(6,2) DEFAULT NULL COMMENT '课时单价',
  `chargeTypeId` int(11) DEFAULT NULL COMMENT '费用类别主键 少儿 高中 艺考',
  `dpId` int(11) DEFAULT NULL COMMENT '费用科别主键',
  PRIMARY KEY (`studentHoursId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `studenthours` */

insert  into `studenthours`(`studentHoursId`,`hours`,`hoursPrice`,`chargeTypeId`,`dpId`) values (1,1,200.00,2,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  `loginName` varchar(20) NOT NULL COMMENT '登录名',
  `loginPassword` varchar(20) NOT NULL COMMENT '登陆密码',
  `schoolId` int(11) DEFAULT NULL COMMENT '用户所在学校',
  `userTypeId` int(11) DEFAULT NULL COMMENT '用户类型Id',
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uId`,`userName`,`loginName`,`loginPassword`,`schoolId`,`userTypeId`) values (1,'超级管理员','admin','admin',0,1);

/*Table structure for table `usertype` */

DROP TABLE IF EXISTS `usertype`;

CREATE TABLE `usertype` (
  `userTypeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户类型主键',
  `userTypeName` varchar(20) NOT NULL COMMENT '用户类型名称',
  PRIMARY KEY (`userTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `usertype` */

insert  into `usertype`(`userTypeId`,`userTypeName`) values (1,'超级管理员'),(2,'管理员'),(3,'教师');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
