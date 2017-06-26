# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.14)
# Database: BlazeDemo
# Generation Time: 2017-06-26 18:51:21 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table arrival
# ------------------------------------------------------------

DROP TABLE IF EXISTS `arrival`;

CREATE TABLE `arrival` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `city` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `arrival` WRITE;
/*!40000 ALTER TABLE `arrival` DISABLE KEYS */;

INSERT INTO `arrival` (`id`, `city`)
VALUES
	(1,'Buenos Aires'),
	(2,'Rome'),
	(3,'London'),
	(4,'Berlin'),
	(5,'New York'),
	(6,'Dublin'),
	(7,'Cario');

/*!40000 ALTER TABLE `arrival` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table departure
# ------------------------------------------------------------

DROP TABLE IF EXISTS `departure`;

CREATE TABLE `departure` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `city` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `departure` WRITE;
/*!40000 ALTER TABLE `departure` DISABLE KEYS */;

INSERT INTO `departure` (`id`, `city`)
VALUES
	(1,'Paris'),
	(2,'Philadelphia'),
	(3,'Boston'),
	(4,'Portland'),
	(5,'San Diego'),
	(6,'Mexico City'),
	(7,'Sao Paolo');

/*!40000 ALTER TABLE `departure` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table flight
# ------------------------------------------------------------

DROP TABLE IF EXISTS `flight`;

CREATE TABLE `flight` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `airline` text,
  `departure_time` time DEFAULT NULL,
  `arrival_time` time DEFAULT NULL,
  `price` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;

INSERT INTO `flight` (`id`, `number`, `airline`, `departure_time`, `arrival_time`, `price`)
VALUES
	(1,43,'Virgin America','01:43:00','21:45:00','$472.56'),
	(2,234,'United Airlines','07:43:00','22:45:00','$432.98'),
	(3,9696,'Aer Lingus','05:27:00','20:22:00','$200.98'),
	(4,12,'Virgin America','11:23:00','13:45:00','$765.32'),
	(5,4346,'Lufthansa','01:45:00','20:34:00','$233.98');

/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `address` text NOT NULL,
  `city` text NOT NULL,
  `state` text NOT NULL,
  `zip_code` text NOT NULL,
  `card_type` text NOT NULL,
  `card_number` text NOT NULL,
  `card_expiration_month` int(11) NOT NULL,
  `card_expiration_year` int(11) NOT NULL,
  `card_name_on_card` text NOT NULL,
  `flight_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `name`, `address`, `city`, `state`, `zip_code`, `card_type`, `card_number`, `card_expiration_month`, `card_expiration_year`, `card_name_on_card`, `flight_id`)
VALUES
	(11,'Greg','somewhere','yerevan','hayastan','0006','master','2864528645765429346',9,20,'Greg',1);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;