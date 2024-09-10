/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.34 : Database - kosarkasni_turnir_ps
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kosarkasni_turnir_ps` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `kosarkasni_turnir_ps`;

/*Table structure for table `coach` */

DROP TABLE IF EXISTS `coach`;

CREATE TABLE `coach` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `number_of_championships` int NOT NULL,
  `team_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_team` (`team_id`),
  CONSTRAINT `fk_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `coach` */

insert  into `coach`(`id`,`firstname`,`lastname`,`number_of_championships`,`team_id`) values 
(1,'Milovan','Milinkovic',6,2),
(2,'Josef','Bungalov',3,1),
(7,'Gavran','Petkovic',1,4),
(9,'Marko','Markovic',5,3),
(11,'Zinedine','Zidane',3,1),
(12,'Zinedine','Zidane',3,1),
(13,'Zinedine','Zidane',3,1),
(14,'Zinedine','Zidane',3,1),
(15,'Zinedine','Zidane',3,1),
(16,'Zinedine','Zidane',4,1),
(17,'Zinedine','Zidane',3,1),
(18,'Zinedine','Zidane',4,1),
(19,'Zinedine','Zidane',3,1),
(20,'Zinedine','Zidane',4,1),
(21,'Zinedine','Zidane',3,1),
(22,'Zinedine','Zidane',4,1),
(23,'Zinedine','Zidane',3,1),
(24,'Zinedine','Zidane',4,1),
(25,'Zinedine','Zidane',3,1),
(26,'Zinedine','Zidane',4,1),
(27,'Zinedine','Zidane',3,1),
(28,'Zinedine','Zidane',4,1),
(29,'Zinedine','Zidane',3,1),
(30,'Zinedine','Zidane',4,1),
(31,'Zinedine','Zidane',3,1),
(32,'Zinedine','Zidane',4,1),
(33,'Zinedine','Zidane',3,1),
(34,'Zinedine','Zidane',4,1),
(35,'Zinedine','Zidane',3,1),
(36,'Zinedine','Zidane',4,1),
(37,'Zinedine','Zidane',3,1),
(38,'Zinedine','Zidane',4,1),
(39,'Zinedine','Zidane',3,1),
(40,'Zinedine','Zidane',4,1),
(41,'Zinedine','Zidane',3,1),
(42,'Zinedine','Zidane',4,1),
(43,'Zinedine','Zidane',3,1),
(44,'Zinedine','Zidane',4,1),
(45,'Zinedine','Zidane',3,1),
(46,'Zinedine','Zidane',4,1),
(47,'Zinedine','Zidane',3,1),
(48,'Zinedine','Zidane',4,1),
(49,'Zinedine','Zidane',3,1),
(50,'Zinedine','Zidane',4,1),
(51,'Zinedine','Zidane',3,1),
(52,'Zinedine','Zidane',4,1),
(53,'Zinedine','Zidane',3,1),
(54,'Zinedine','Zidane',4,1),
(55,'Zinedine','Zidane',3,1),
(56,'Zinedine','Zidane',4,1),
(57,'Zinedine','Zidane',3,1),
(58,'Zinedine','Zidane',4,1),
(59,'Zinedine','Zidane',3,1),
(60,'Zinedine','Zidane',4,1),
(61,'Zinedine','Zidane',3,1),
(62,'Zinedine','Zidane',4,1),
(63,'Zinedine','Zidane',3,1),
(64,'Zinedine','Zidane',4,1),
(65,'Zinedine','Zidane',3,1),
(66,'Zinedine','Zidane',4,1),
(67,'Zinedine','Zidane',3,1),
(68,'Zinedine','Zidane',4,1),
(69,'Zinedine','Zidane',3,1),
(70,'Zinedine','Zidane',4,1),
(71,'Zinedine','Zidane',3,1),
(72,'Zinedine','Zidane',4,1),
(73,'Zinedine','Zidane',3,1),
(74,'Zinedine','Zidane',4,1),
(75,'Zinedine','Zidane',3,1),
(76,'Zinedine','Zidane',4,1),
(77,'Zinedine','Zidane',3,1),
(78,'Zinedine','Zidane',4,1),
(79,'Zinedine','Zidane',3,1),
(80,'Zinedine','Zidane',4,1),
(81,'Zinedine','Zidane',3,1),
(82,'Zinedine','Zidane',4,1),
(83,'Zinedine','Zidane',3,1),
(84,'Zinedine','Zidane',4,1),
(85,'Zinedine','Zidane',3,1),
(86,'Zinedine','Zidane',4,1),
(87,'Zinedine','Zidane',3,1),
(88,'Zinedine','Zidane',4,1),
(89,'Zinedine','Zidane',3,1),
(90,'Zinedine','Zidane',4,1),
(91,'Zinedine','Zidane',3,1),
(92,'Zinedine','Zidane',4,1),
(93,'Zinedine','Zidane',3,1),
(94,'Zinedine','Zidane',4,1),
(95,'Zinedine','Zidane',3,1),
(96,'Zinedine','Zidane',4,1),
(97,'Zinedine','Zidane',3,1),
(98,'Zinedine','Zidane',4,1),
(99,'Zinedine','Zidane',3,1),
(100,'Zinedine','Zidane',4,1),
(101,'Zinedine','Zidane',3,1),
(102,'Zinedine','Zidane',4,1),
(103,'Zinedine','Zidane',3,1),
(104,'Zinedine','Zidane',4,1),
(105,'Zinedine','Zidane',3,1),
(106,'Zinedine','Zidane',4,1),
(107,'Zinedine','Zidane',3,1),
(108,'Zinedine','Zidane',4,1),
(109,'Zinedine','Zidane',3,1),
(110,'Zinedine','Zidane',4,1),
(111,'Zinedine','Zidane',3,1),
(112,'Zinedine','Zidane',4,1),
(113,'Zinedine','Zidane',3,1),
(114,'Zinedine','Zidane',4,1),
(115,'Zinedine','Zidane',3,1),
(116,'Zinedine','Zidane',4,1),
(117,'Zinedine','Zidane',3,1),
(118,'Zinedine','Zidane',4,1),
(119,'Zinedine','Zidane',3,1),
(120,'Zinedine','Zidane',4,1);

/*Table structure for table `game` */

DROP TABLE IF EXISTS `game`;

CREATE TABLE `game` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `game_date` date NOT NULL,
  `game_time` time NOT NULL,
  `league_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `league_id_stat` (`league_id`),
  CONSTRAINT `league_id_stat` FOREIGN KEY (`league_id`) REFERENCES `league` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `game` */

insert  into `game`(`id`,`game_date`,`game_time`,`league_id`) values 
(1,'2021-07-12','15:30:00',1),
(2,'2020-05-18','12:15:00',1),
(3,'2020-05-15','13:18:00',1),
(4,'2019-05-10','12:30:00',2),
(5,'2020-07-12','11:30:00',2),
(11,'2021-05-06','12:15:00',1),
(12,'2024-09-05','20:00:00',1),
(13,'2024-09-05','20:00:00',1),
(14,'2024-09-05','20:00:00',1),
(15,'2024-09-05','20:00:00',1),
(16,'2024-09-05','20:00:00',1),
(17,'2024-09-05','20:00:00',1),
(18,'2024-09-05','20:00:00',1),
(19,'2024-09-05','20:00:00',1),
(20,'2024-09-05','20:00:00',1),
(21,'2024-09-05','20:00:00',1),
(22,'2024-09-05','20:00:00',1),
(23,'2024-09-05','20:00:00',1),
(24,'2024-09-05','20:00:00',1),
(25,'2024-09-05','20:00:00',1),
(26,'2024-09-05','20:00:00',1),
(27,'2024-09-05','20:00:00',1),
(28,'2024-09-05','20:00:00',1),
(29,'2024-09-05','20:00:00',1),
(30,'2024-09-05','20:00:00',1),
(31,'2024-09-05','20:00:00',1),
(32,'2024-09-05','20:00:00',1),
(33,'2024-09-05','20:00:00',1),
(34,'2024-09-05','20:00:00',1),
(35,'2024-09-05','20:00:00',1),
(36,'2024-09-05','20:00:00',1),
(37,'2024-09-05','20:00:00',1),
(38,'2024-09-05','20:00:00',1),
(39,'2024-09-05','20:00:00',1),
(40,'2024-09-05','20:00:00',1),
(41,'2024-09-05','20:00:00',1),
(42,'2024-09-05','20:00:00',1),
(43,'2024-09-05','20:00:00',1),
(44,'2024-09-05','20:00:00',1),
(45,'2024-09-05','20:00:00',1),
(46,'2024-09-05','20:00:00',1),
(47,'2024-09-05','20:00:00',1),
(48,'2024-09-05','20:00:00',1),
(49,'2024-09-05','20:00:00',1),
(50,'2024-09-05','20:00:00',1),
(51,'2024-09-05','20:00:00',1),
(52,'2024-09-05','20:00:00',1),
(53,'2024-09-05','20:00:00',1),
(54,'2024-09-05','20:00:00',1),
(55,'2024-09-05','20:00:00',1),
(56,'2024-09-05','20:00:00',1),
(57,'2024-09-05','20:00:00',1),
(58,'2024-09-05','20:00:00',1),
(59,'2024-09-05','20:00:00',1),
(60,'2024-09-05','20:00:00',1),
(61,'2024-09-05','20:00:00',1),
(62,'2024-09-05','20:00:00',1);

/*Table structure for table `league` */

DROP TABLE IF EXISTS `league`;

CREATE TABLE `league` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `season` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `league` */

insert  into `league`(`id`,`name`,`season`) values 
(1,'nesto','2023-2024'),
(2,'nesto1','2022-2023');

/*Table structure for table `list_of_referees` */

DROP TABLE IF EXISTS `list_of_referees`;

CREATE TABLE `list_of_referees` (
  `head_referee_id` bigint unsigned NOT NULL,
  `first_referee_id` bigint unsigned NOT NULL,
  `second_referee_id` bigint unsigned NOT NULL,
  `game_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`head_referee_id`,`first_referee_id`,`second_referee_id`,`game_id`),
  KEY `fk_first_referee` (`first_referee_id`),
  KEY `fk_second_referee` (`second_referee_id`),
  KEY `fk_game1` (`game_id`),
  CONSTRAINT `fk_first_referee` FOREIGN KEY (`first_referee_id`) REFERENCES `referee` (`id`),
  CONSTRAINT `fk_game1` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  CONSTRAINT `fk_head_referee` FOREIGN KEY (`head_referee_id`) REFERENCES `referee` (`id`),
  CONSTRAINT `fk_second_referee` FOREIGN KEY (`second_referee_id`) REFERENCES `referee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `list_of_referees` */

insert  into `list_of_referees`(`head_referee_id`,`first_referee_id`,`second_referee_id`,`game_id`) values 
(2,1,3,1),
(2,1,3,11),
(2,1,4,1),
(3,1,2,1),
(3,1,4,1),
(4,1,2,1),
(4,1,3,1);

/*Table structure for table `played_game` */

DROP TABLE IF EXISTS `played_game`;

CREATE TABLE `played_game` (
  `home_team_id` bigint unsigned NOT NULL,
  `away_team_id` bigint unsigned NOT NULL,
  `game_id` bigint unsigned NOT NULL,
  `home_team_points` int unsigned DEFAULT NULL,
  `away_team_points` int unsigned DEFAULT NULL,
  PRIMARY KEY (`home_team_id`,`away_team_id`,`game_id`),
  KEY `fk_away_team` (`away_team_id`),
  KEY `fk_game` (`game_id`),
  CONSTRAINT `fk_away_team` FOREIGN KEY (`away_team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `fk_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  CONSTRAINT `fk_home_team` FOREIGN KEY (`home_team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `played_game` */

insert  into `played_game`(`home_team_id`,`away_team_id`,`game_id`,`home_team_points`,`away_team_points`) values 
(1,2,1,3,2),
(1,2,42,3,2),
(1,3,2,110,130),
(1,3,3,130,90),
(1,3,25,3,2),
(1,4,3,3,2),
(1,4,12,3,2),
(1,14,16,3,2),
(1,19,20,3,2),
(1,24,23,3,2),
(2,1,2,75,90),
(2,1,16,3,2),
(2,3,1,105,120),
(2,15,2,3,2),
(3,2,2,3,2),
(13,1,32,3,2),
(13,3,37,3,2),
(13,29,38,3,2),
(14,17,32,3,2),
(15,19,25,3,2),
(16,2,27,3,2),
(17,22,36,3,2),
(18,17,25,3,2),
(20,23,2,3,2),
(23,12,18,3,2),
(23,34,23,3,2),
(25,13,33,3,2),
(26,1,30,3,2),
(26,3,22,3,2),
(26,36,30,3,2),
(28,14,28,3,2),
(29,19,31,3,2),
(30,31,16,3,2),
(32,19,1,3,2),
(33,29,1,3,2),
(33,37,30,3,2),
(35,30,11,3,2),
(36,16,4,3,2),
(36,31,23,3,2);

/*Table structure for table `player` */

DROP TABLE IF EXISTS `player`;

CREATE TABLE `player` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `birthday` date NOT NULL,
  `position` varchar(50) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `team_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `team_id` (`team_id`),
  CONSTRAINT `team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `player` */

insert  into `player`(`id`,`firstname`,`lastname`,`birthday`,`position`,`height`,`weight`,`team_id`) values 
(1,'Marko','Jamal','2006-06-15','POINTGUARD',2.1,120,1),
(2,'Janes','Panes','1998-07-11','SHOOTINGGUARD',2.1,90,1),
(5,'james','james','2000-12-01','CENTER',2.1,200,2),
(6,'Tomas','Morston','1998-08-08','POINTGUARD',2,190,2),
(7,'Marko','Jovanović','1998-03-15','POINTGUARD',2.05,105,2),
(9,'Luka','Stojanović','2000-01-30','SMALLFORWARD',2.1,110,3),
(10,'Stefan','Kovačević','1996-11-05','POWERFORWARD',1.92,88,3),
(11,'Nikola','Vuković','1999-06-12','CENTER',2.11,120,3),
(14,'Tom','Tomi','2001-03-02','POWERFORWARD',2.05,100,2),
(17,'Marko','Mandic','2002-01-01','CENTER',2.2,115,3),
(18,'Milos','Nikic','1999-02-06','CENTER',2.3,125,4),
(19,'Georgije','Molic','2001-03-01','SHOOTINGGUARD',2,100,4),
(20,'Zoran','Spasic','1998-02-07','POWERFORWARD',2.02,102,4),
(21,'Vladan','Kuzmanovic','2002-01-05','SMALLFORWARD',2.07,99,4),
(22,'Boris','Micic','2001-05-04','POINTGUARD',2.04,95,4),
(26,'Stephen','Curry','1988-03-14','CENTER',191,86,18),
(27,'Klay','Thompson','1990-02-08','POINTGUARD',198,98,18),
(28,'Stephen','Curry','1988-03-14','CENTER',191,86,25),
(29,'Stephen','Curry','1988-03-14','CENTER',191,86,27),
(30,'Stephen','Curry','1988-03-14','CENTER',191,86,29),
(31,'Stephen','Curry','1988-03-14','CENTER',191,86,31),
(32,'Stephen1','Curry1','1978-03-14','CENTER',191,80,31),
(37,'New Player','New LastName','2001-01-01','GUARD',180,75,1),
(38,'New Player','New LastName','2001-01-01','GUARD',180,75,1),
(39,'New Player','New LastName','2001-01-01','GUARD',180,75,1);

/*Table structure for table `player_statistic` */

DROP TABLE IF EXISTS `player_statistic`;

CREATE TABLE `player_statistic` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `player_id` bigint unsigned NOT NULL,
  `game_id` bigint unsigned NOT NULL,
  `minutes_played` int unsigned DEFAULT NULL,
  `points_scored` int unsigned DEFAULT NULL,
  `three_pointers_made` int unsigned DEFAULT NULL,
  `three_pointers_attempted` int unsigned DEFAULT NULL,
  `free_throws_made` int unsigned DEFAULT NULL,
  `free_throws_attempted` int unsigned DEFAULT NULL,
  `rebounds_offensive` int unsigned DEFAULT NULL,
  `rebounds_defensive` int unsigned DEFAULT NULL,
  `assists` int unsigned DEFAULT NULL,
  `steals` int unsigned DEFAULT NULL,
  `blocks` int unsigned DEFAULT NULL,
  `personal_fouls` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `player_stat` (`player_id`),
  KEY `player_game_stat` (`game_id`),
  CONSTRAINT `player_game_stat` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  CONSTRAINT `player_stat` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `player_statistic` */

insert  into `player_statistic`(`id`,`player_id`,`game_id`,`minutes_played`,`points_scored`,`three_pointers_made`,`three_pointers_attempted`,`free_throws_made`,`free_throws_attempted`,`rebounds_offensive`,`rebounds_defensive`,`assists`,`steals`,`blocks`,`personal_fouls`) values 
(1,9,1,14,50,5,12,5,10,2,4,8,5,3,2),
(2,11,1,10,12,1,5,4,6,2,1,5,1,4,1),
(3,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(4,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(5,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(6,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(7,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(8,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(9,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(10,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(11,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(12,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(13,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(14,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(15,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(16,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(17,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(18,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(19,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(20,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(21,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(22,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(23,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(24,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(25,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(26,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(27,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(28,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(29,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(30,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(31,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(32,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(33,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(34,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(35,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(36,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(37,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(38,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(39,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(40,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(41,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(42,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(43,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(44,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(45,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(46,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(47,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(48,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(49,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(50,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(51,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(52,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(53,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(54,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(55,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(56,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(57,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(58,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(59,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(60,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(61,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(62,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(63,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(64,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(65,1,1,30,30,3,6,5,8,3,8,4,2,1,1),
(66,1,1,36,29,4,7,7,10,2,6,5,1,1,2),
(67,1,1,30,30,3,6,5,8,3,8,4,2,1,1);

/*Table structure for table `referee` */

DROP TABLE IF EXISTS `referee`;

CREATE TABLE `referee` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `referee` */

insert  into `referee`(`id`,`firstname`,`lastname`) values 
(1,'Michael','Johnson'),
(2,'James','Anderson'),
(3,'David','Martinez'),
(4,'Daniel','Thompson');

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `city` varchar(80) NOT NULL,
  `country` varchar(50) NOT NULL,
  `foundedIn` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `team` */

insert  into `team`(`id`,`name`,`city`,`country`,`foundedIn`) values 
(1,'Barcelona','Barcelona','Spain',1925),
(2,'Los Angeles Lakers','Los Angeles','United States',1947),
(3,'Chicago Bulls','Chicago','United States',1966),
(4,'Boston Celtics','Boston','United States',1946),
(12,'Lakers','Los Angeles','USA',1947),
(13,'Lakers','Los Angeles','USA',1947),
(14,'Warriors','San Francisco','USA',1946),
(15,'Lakers','Los Angeles','USA',1947),
(16,'Warriors','San Francisco','USA',1946),
(17,'Lakers','Los Angeles','USA',1947),
(18,'Warriors','San Francisco','USA',1946),
(19,'Lakers','Los Angeles','USA',1947),
(20,'Lakers','Los Angeles','USA',1947),
(21,'Lakers','Los Angeles','USA',1947),
(22,'Lakers','Los Angeles','USA',1947),
(23,'Lakers','Los Angeles','USA',1947),
(24,'Lakers','Los Angeles','USA',1947),
(25,'Warriors','San Francisco','USA',1946),
(26,'Lakers','Los Angeles','USA',1947),
(27,'Warriors','San Francisco','USA',1946),
(28,'Lakers','Los Angeles','USA',1947),
(29,'Warriors','San Francisco','USA',1946),
(30,'Lakers','Los Angeles','USA',1947),
(31,'Warriors','San Francisco','USA',1946),
(32,'Lakers','Los Angeles','USA',1947),
(33,'Lakers','Los Angeles','USA',1947),
(34,'Lakers','Los Angeles','USA',1947),
(35,'Lakers','Los Angeles','USA',1947),
(36,'Lakers','Los Angeles','USA',1947),
(37,'Lakers','Los Angeles','USA',1947),
(38,'Lakers','Los Angeles','USA',1947),
(39,'Lakers','Los Angeles','USA',1947),
(40,'Lakers','Los Angeles','USA',1947),
(41,'Lakers','Los Angeles','USA',1947),
(42,'Lakers','Los Angeles','USA',1947),
(43,'Lakers','Los Angeles','USA',1947),
(44,'Lakers','Los Angeles','USA',1947),
(45,'Lakers','Los Angeles','USA',1947),
(46,'Lakers','Los Angeles','USA',1947),
(47,'Lakers','Los Angeles','USA',1947),
(48,'Lakers','Los Angeles','USA',1947),
(49,'Lakers','Los Angeles','USA',1947);

/*Table structure for table `team_statistic` */

DROP TABLE IF EXISTS `team_statistic`;

CREATE TABLE `team_statistic` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `league_id` bigint unsigned NOT NULL,
  `team_id` bigint unsigned NOT NULL,
  `played_games` int NOT NULL,
  `won_games` int NOT NULL,
  `drawn_games` int NOT NULL,
  `lost_games` int NOT NULL,
  `points` int NOT NULL,
  `team_rank` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `league_fk_stat` (`league_id`),
  KEY `team_fk_stat` (`team_id`),
  CONSTRAINT `league_fk_stat` FOREIGN KEY (`league_id`) REFERENCES `league` (`id`),
  CONSTRAINT `team_fk_stat` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `team_statistic` */

insert  into `team_statistic`(`id`,`league_id`,`team_id`,`played_games`,`won_games`,`drawn_games`,`lost_games`,`points`,`team_rank`) values 
(1,1,1,3,2,0,1,6,2),
(2,1,2,6,2,0,4,6,3),
(3,1,3,4,3,0,1,9,1),
(4,1,4,3,1,0,2,3,4),
(5,1,1,82,50,0,32,100,1),
(6,1,1,82,50,0,32,100,1),
(7,1,1,82,55,0,32,110,1),
(8,1,1,82,50,0,32,100,1),
(9,1,1,82,55,0,32,110,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`firstname`,`lastname`,`username`,`password`,`role`) values 
(1,'Aleksandar','Radin','jamajka','jamajka','administrator'),
(2,'Aleksa','Petrovic','svraka','svraka','manager'),
(3,'Pavle','Pajic','kosti','kosti','user');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
