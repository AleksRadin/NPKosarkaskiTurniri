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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `coach` */

insert  into `coach`(`id`,`firstname`,`lastname`,`number_of_championships`,`team_id`) values 
(1,'Milovan','Milinkovic',6,2),
(2,'Josef','Bungalov',3,1),
(7,'Gavran','Petkovic',1,4),
(9,'Marko','Markovic',5,3);

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `game` */

insert  into `game`(`id`,`game_date`,`game_time`,`league_id`) values 
(1,'2021-07-12','15:30:00',1),
(2,'2020-05-18','12:15:00',1),
(3,'2020-05-15','13:18:00',1),
(4,'2019-05-10','12:30:00',2),
(5,'2020-07-12','11:30:00',2),
(11,'2021-05-06','12:15:00',1);

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
(2,1,3,11),
(4,1,2,1),
(4,1,3,2),
(3,2,3,4),
(2,3,1,5),
(4,3,2,3);

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
(1,3,2,110,130),
(1,3,3,130,90),
(2,1,2,75,90),
(2,3,1,105,120),
(2,4,1,120,115),
(3,2,1,105,101),
(3,2,4,155,142),
(4,2,1,114,94),
(4,2,3,90,130);

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `player` */

insert  into `player`(`id`,`firstname`,`lastname`,`birthday`,`position`,`height`,`weight`,`team_id`) values 
(1,'Jacob','Jamal','2006-06-15','POINTGUARD',2.19,120,1),
(2,'Janes','Panes','1998-07-11','SHOOTINGGUARD',2.1,90,1),
(5,'james','james','2000-12-01','CENTER',2.1,200,2),
(6,'Tomas','Morston','1998-08-08','POINTGUARD',2,190,2),
(7,'Marko','Jovanović','1998-03-15','POINTGUARD',2.05,105,2),
(8,'Nemanja','Petrović','1997-07-22','CENTER',1.98,98,1),
(9,'Luka','Stojanović','2000-01-30','SMALLFORWARD',2.1,110,3),
(10,'Stefan','Kovačević','1996-11-05','POWERFORWARD',1.92,88,3),
(11,'Nikola','Vuković','1999-06-12','CENTER',2.11,120,3),
(14,'Tom','Tomi','2001-03-02','POWERFORWARD',2.05,100,2),
(15,'Mojin','Mojin','2001-01-01','POWERFORWARD',2.05,105,1),
(16,'Jovan','Petrovic','2000-06-08','SHOOTINGGUARD',2,100,1),
(17,'Marko','Mandic','2002-01-01','CENTER',2.2,115,3),
(18,'Milos','Nikic','1999-02-06','CENTER',2.3,125,4),
(19,'Georgije','Molic','2001-03-01','SHOOTINGGUARD',2,100,4),
(20,'Zoran','Spasic','1998-02-07','POWERFORWARD',2.02,102,4),
(21,'Vladan','Kuzmanovic','2002-01-05','SMALLFORWARD',2.07,99,4),
(22,'Boris','Micic','2001-05-04','POINTGUARD',2.04,95,4);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `player_statistic` */

insert  into `player_statistic`(`id`,`player_id`,`game_id`,`minutes_played`,`points_scored`,`three_pointers_made`,`three_pointers_attempted`,`free_throws_made`,`free_throws_attempted`,`rebounds_offensive`,`rebounds_defensive`,`assists`,`steals`,`blocks`,`personal_fouls`) values 
(1,9,1,14,50,5,12,5,10,2,4,8,5,3,2),
(2,11,1,10,12,1,5,4,6,2,1,5,1,4,1);

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `team` */

insert  into `team`(`id`,`name`,`city`,`country`,`foundedIn`) values 
(1,'Barcelona','Barcelona','Spain',1925),
(2,'Los Angeles Lakers','Los Angeles','United States',1947),
(3,'Chicago Bulls','Chicago','United States',1966),
(4,'Boston Celtics','Boston','United States',1946);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `team_statistic` */

insert  into `team_statistic`(`id`,`league_id`,`team_id`,`played_games`,`won_games`,`drawn_games`,`lost_games`,`points`,`team_rank`) values 
(1,1,1,3,2,0,1,6,2),
(2,1,2,6,2,0,4,6,3),
(3,1,3,4,3,0,1,9,1),
(4,1,4,3,1,0,2,3,4);

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
