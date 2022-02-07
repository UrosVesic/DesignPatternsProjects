/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.18 : Database - abstractfactory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`abstractfactory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `abstractfactory`;

/*Table structure for table `counter` */

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `TableName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `Counter` int(11) DEFAULT '0',
  PRIMARY KEY (`TableName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `counter` */

insert  into `counter`(`TableName`,`Counter`) values 
('dkSkikarta',6);

/*Table structure for table `dkskikarta` */

DROP TABLE IF EXISTS `dkskikarta`;

CREATE TABLE `dkskikarta` (
  `sifraSkiKarte` int(11) NOT NULL DEFAULT '0',
  `imePrezimeKupca` varchar(50) DEFAULT NULL,
  `cena` int(11) DEFAULT '0',
  `sifraSkiCentra` int(11) DEFAULT '0',
  `datumIzdavanja` date DEFAULT NULL,
  PRIMARY KEY (`sifraSkiKarte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `dkskikarta` */

insert  into `dkskikarta`(`sifraSkiKarte`,`imePrezimeKupca`,`cena`,`sifraSkiCentra`,`datumIzdavanja`) values 
(1,'Uros Vesic',35000,3,'2021-11-24'),
(3,'Mika Mikic',16000,7,'2021-11-24'),
(4,'Petar Petrovic',2500,3,'2021-11-26'),
(5,'Mina Minic',13000,4,'2021-11-26'),
(6,'Jelena Jovanovic',15000,5,'2021-12-02');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
