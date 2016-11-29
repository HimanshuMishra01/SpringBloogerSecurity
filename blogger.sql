/*
SQLyog Community v8.61 
MySQL - 5.7.15 : Database - blogger
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blogger` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `blogger`;

/*Table structure for table `blog_profile` */

DROP TABLE IF EXISTS `blog_profile`;

CREATE TABLE `blog_profile` (
  `profile_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(30) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `zip_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`profile_id`),
  UNIQUE KEY `uix_user_id` (`user_id`),
  CONSTRAINT `FK_blog_profile_user_id` FOREIGN KEY (`user_id`) REFERENCES `blog_user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `blog_profile` */

/*Table structure for table `blog_role` */

DROP TABLE IF EXISTS `blog_role`;

CREATE TABLE `blog_role` (
  `role_id` int(3) NOT NULL AUTO_INCREMENT,
  `role_type` varchar(20) NOT NULL,
  `state` int(1) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `uix_role_type` (`role_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `blog_role` */

insert  into `blog_role`(`role_id`,`role_type`,`state`) values (1,'ADMIN',1),(2,'MODERATOR',1),(3,'USER',1);

/*Table structure for table `blog_user` */

DROP TABLE IF EXISTS `blog_user`;

CREATE TABLE `blog_user` (
  `user_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `middle_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `state` int(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `blog_user` */

insert  into `blog_user`(`user_id`,`password`,`first_name`,`middle_name`,`last_name`,`email`,`phone`,`state`) values ('admin','$2a$10$5s69hV/JCAzDFbWpXipbh.2iA4XJpOBH0hIw4CE0fHdneGFDaHJ5a','Super',NULL,'ADMIN','superadmin@myblogger.com',NULL,1),('dfgg','$2a$10$B234GVV7C/y4GndZszEcg.4RSKCNeidnlefUgaTPHZ6PlEA0EOAbW','hhhhhhh',NULL,'dfghjk','gghh@n.com',NULL,1),('dsdsds','$2a$10$VaZ04Ky/GBbGBbdBudEYHuOgILdSV2Po2gcxQ8ZdLaNhqkNd6OV8.','sdsdssdsds',NULL,'dsdsds','aaaa@dd.com',NULL,1),('Him','Man','Shu',NULL,'Mishra','baba@baba.com',NULL,2);

/*Table structure for table `persistent_logins` */

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `persistent_logins` */

/*Table structure for table `user_role_map` */

DROP TABLE IF EXISTS `user_role_map`;

CREATE TABLE `user_role_map` (
  `user_id` varchar(30) NOT NULL,
  `role_id` int(3) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_user_role_map_role_id` (`role_id`),
  CONSTRAINT `FK_user_role_map_role_id` FOREIGN KEY (`role_id`) REFERENCES `blog_role` (`role_id`) ON DELETE CASCADE,
  CONSTRAINT `FK_user_role_map_user_id` FOREIGN KEY (`user_id`) REFERENCES `blog_user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_role_map` */

insert  into `user_role_map`(`user_id`,`role_id`) values ('admin',1),('admin',2),('dfgg',2),('dsdsds',2),('Him',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
