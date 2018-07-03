-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: adboard
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.17.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ad_category`
--

DROP TABLE IF EXISTS `ad_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ad_category` (
  `category_id` bigint(20) NOT NULL,
  `ad_id` bigint(20) NOT NULL,
  KEY `FKcnhjc4q27skp99hy9nibwe6k0` (`ad_id`),
  KEY `FKn0q9uuntmhawvl4dsgrr5ff53` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ad_category`
--

LOCK TABLES `ad_category` WRITE;
/*!40000 ALTER TABLE `ad_category` DISABLE KEYS */;
INSERT INTO `ad_category` VALUES (1,5),(1,4),(6,8),(1,9),(8,2),(7,3);
/*!40000 ALTER TABLE `ad_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ads`
--

DROP TABLE IF EXISTS `ads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ads` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creationTimestamp` datetime DEFAULT NULL,
  `description` mediumtext,
  `expiryTimestamp` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhjy5cj20i6dn8t38as5poqt7b` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ads`
--

LOCK TABLES `ads` WRITE;
/*!40000 ALTER TABLE `ads` DISABLE KEYS */;
INSERT INTO `ads` VALUES (2,'2018-06-27 23:23:34','Sprzedam rower miejski firmy Nexus - damski. Rozmiar ramy 21 cali. Kolor jasnozielony, w bardzo dobrym stanie, lekkie zarysowania. Cena 600 PLN.','2018-07-17 23:23:34','Gliwice-Centrum','Sprzedam rower miejski',2),(3,'2018-06-27 23:23:34','Oddam w dobre rece do domu z ogrodem. Jest to pies rasy terrier, przyjazny i samodzielny. Urodzony 2 kwietnia br.','2018-07-22 23:23:34','Katowice - Panewniki','Oddam szczeniaka',3),(4,'2018-06-27 23:23:34','Bardzo szybki biznesowy laptop marki Asus dobry do prac biznesowych jaki i gier. Ogromna dwyżka mocy sprawia ze nigdy sie nie zacina. Laptop w 100% sprawny. Sprzedawany z oryginalnym przeinstalowanym windowsem. W zestawie ladowarka, pudelko i dokumenty.','2018-08-01 23:23:34','Katowice','Sprzedam laptop asus 15\\\" 8 GB RAM 4x2.50 GHz 750 GB SSD',4),(5,'2018-06-27 23:23:34','Sprzedam 22 calowy monitor marki Dell. 1920x1080 pikseli, matryca IPS zapewnia znaczny obszar widzenia.  Regulowany w bardzo duzym zakresie (w pionie, pochylenie). Cena 350 PLN','2018-07-22 23:23:34','Bytom','Sprzedam monitor Dell 22\"',4),(8,'2018-06-29 21:47:44','Szukam mieszkzania 1-pokojowego do natychmiastowego wynajmu. Najlepiej w centrum Katowic. Max cena 1500 zl.','2018-07-29 21:46:50','Katowice','Wynajme kawalerke',9),(9,'2018-06-30 19:03:17','Kupie kamere do komputera. Cena do 250 zl.','2018-07-30 19:03:17','Bialystok-Starosielce','Kupie kamere',11);
/*!40000 ALTER TABLE `ads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'ROLE_USER','jnowak'),(2,'ROLE_USER','emazur'),(3,'ROLE_USER','ekarski'),(4,'ROLE_USER','annakorcz'),(5,'ROLE_ADMIN','admin'),(6,'ROLE_USER','marian'),(7,'ROLE_USER','maj000r'),(8,'ROLE_USER','anowak'),(9,'ROLE_USER','anowak'),(12,'ROLE_USER','maj00r');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` mediumtext,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Komputery stacjonarne, laptopy, monitory, osprzet, etc.','Komputery'),(8,'Rowery nowe i uzywane, akcesoria, etc.','Rowery'),(3,'Ubrania, buty, akcesoria.','Ubranie'),(5,'Konsole do gier: nintendo, sony, etc.','Konsole do gier'),(6,'Kupno, sprzedaz, wynajem mieszkan.','Mieszkania'),(7,'Kupno, sprzedaz, oddanie w dobre rece.','Zwierzeta');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `ad_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `creationTimestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8c6328vy3jubusjo17ucraqf1` (`ad_id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'Jak leci?',2,9,'2018-07-01 09:00:00');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creationTimestamp` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(68) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (9,'2018-06-29 21:43:35','adam.nowak@wp.pl',1,'Adam Nowak','{bcrypt}$2a$10$ILvm9JNP..E8Av68FTMoWe02YQ5gtMHYzr0jB/hWbjsQofg9WwAZu','512345665','anowak'),(2,'2018-06-27 23:23:19','ewa.mazur72@gmail.com',1,'Ewa Mazur','{bcrypt}$2a$10$7d9e21LLY7eSUu7aPL1XhuPoDdqZ5./062Xhfbx5Y2ZjTqhZ5r2GG','+48 607589231','emazur'),(3,'2018-06-27 23:23:19','emil.karski@gmail.com',1,'Emil Karski','{bcrypt}$2a$10$PhlJF0.c5Ynl5taNKwqJteyyJJ7nNl7kHlCCN.NN2nveJE6hiMgF.','+48 721584621','ekarski'),(4,'2018-06-27 23:23:19','amma.korcz75k@gmail.com',1,'Anna Korcz','{bcrypt}$2a$10$3rMfawikTLdtArsSw.WM4ujynZBDzmdZatWTRaK8JHhmzbV3LlgFa','+48 524561444','annakorcz'),(5,'2018-06-27 23:23:19','jerzywilk@gmail.com',1,'Jerzy Wilk','{bcrypt}$2a$10$eeGFli75PE1BEviLmbKgvetr3yga0EzO77iZu.haRbcQinl2zKeD.','+48 771458226','admin'),(11,'2018-07-01 16:30:00','jan.kowalski@wp.pl',1,'Jan Kowalski','alamakota','512245445','jankowalski');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-02 12:00:42
