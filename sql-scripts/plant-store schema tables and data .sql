CREATE DATABASE  IF NOT EXISTS `plantstoredb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `plantstoredb`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.2    Database: medicalplantdb
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `registration_date` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Leon','Goretzka','053-621-4421','l.gor@gmail.com','Male','New York','2022-01-11'),(2,'John','Hughes','097-555-0176','hughes.john@gmail.com','Male','Los Santos','2020-02-18'),(3,'Joe','Pesci','098-019-7484','pesci16@gmail.com','Male','Los Santos','2020-02-19'),(4,'Daniel','Stern','099-563-7011','stern.pattern@gmail.com','Male','Los Santos','2020-02-20');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `description`
--

DROP TABLE IF EXISTS `description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `description` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `family` varchar(80) DEFAULT NULL,
  `hardiness` text,
  `use` text,
  `cautions` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `description`
--

LOCK TABLES `description` WRITE;
/*!40000 ALTER TABLE `description` DISABLE KEYS */;
INSERT INTO `description` VALUES (1,'Lamiaceae','This popular herb is a perennial in zones 8 and up.','Rosemary oil has useful anti-inflammatory and anti-bacterial properties when you apply it topically. In tea form, rosemary is hailed as a valuable memory booster.','None'),(2,'Asteraceae',' Feverfew is perennial in zones 5-9.','There’s some evidence that supplementing with feverfew can reduce migraine attack frequency. As a migraine sufferer myself, I’m always skeptical of so-called natural remedies, but there’s evidence that parthenolide, which feverfew contains, is an effective preventative. Of course, results vary widely. As any migraine sufferer knows, what works for one person may not work for another, unfortunately.','Watch out for a number of unpleasant, but non-serious side-effects ranging from indigestion to nausea. Allergy sufferers should avoid consuming feverfew. Pregnant or breastfeeding women should speak to a doctor before supplementing with feverfew.'),(3,'Caprifoliaceae','This tender plant is perennial in zones 10 and up, but it also grows well indoors.','Use the slimy gel-like interior to treat a number of conditions from sunburns to stings.','None'),(4,'Liliaceae','Perennial in zones 4 through 9.','Valerian is a useful sleep aid and relaxant. It also helps relieve indigestion.','If not properly pruned and cared for, valerian has the potential to become invasive, which you especially dont want because it smells awful. People have reported mild side effects such as headaches and indigestion.'),(5,'Ranunculaceae','This pretty plant is perennial in zones 4 through 9.','You can banish period camping with a tea made from the root of this plant. Its also useful for indigestion and breathing troubles such as asthma.','None'),(6,'Ranunculaceae','Perennial in zones 2 to 9.','Aconite has sedative properties, as well as the ability to treat headaches. It is a powerful medicinal plant and should be used with extreme care.','POISONOUS  this plant is not to be used without a physicians supervision.'),(7,'Marsileaceae','Perennial in zones 8 and up.','This plant has sedative properties that are helpful for battling insomnia. It has also been shown to lower cholesterol levels.','None'),(8,'Lamiaceae','Wooly lamb’s ear is perennial in zones 4 through 9.','This plant isn’t meant to be eaten or used to make tea. Instead, the soft leaves were once used to cover and bandage cuts and scrapes, and you can still use it that way today. It’s the original band-aid!','None'),(9,'Asparagaceae','Perennial in zones 5 and 6.','This plant is useful for healing skin abrasions and relieving pain associated with wounds.','Watch out, many parts of this plant are poisonous, including the berries.'),(10,'Asteraceae','Perennial in zones 3 to 8.','Elecampane is useful as a cough suppressant, in addition to providing relief from indigestion.','None'),(11,'Lamiaceae','Allheal is perennial in zones 4 to 9.','he name says it all. Once used as a cure-all, the plant has anti-inflammatory and anti-microbial properties.','None'),(12,'Lamiaceae','This easy to grow perennial is hardy in zones 5 through 9.','As a tea, lemon balm is a great all-around soother. Use it to relax, or relieve your tummy troubles.','Grows fast and spreads quickly. Consequently, you should treat it like mint and grow it in containers or in an area where you can control it.'),(13,'Fabaceae','Perennial in zones 7 through 10.','You can heal tummy troubles and acid reflux with a bite from this plant. Additionally, many parts of the plant can be used for culinary or medicinal purposes.','None');
/*!40000 ALTER TABLE `description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_info`
--

DROP TABLE IF EXISTS `order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_info` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `status` varchar(20) DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `plant_id` bigint DEFAULT NULL,
  `date_of_order` date DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `client_id` (`client_id`),
  KEY `plant_id` (`plant_id`),
  CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE SET NULL,
  CONSTRAINT `order_info_ibfk_2` FOREIGN KEY (`plant_id`) REFERENCES `plant` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_info`
--

LOCK TABLES `order_info` WRITE;
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
INSERT INTO `order_info` VALUES (14,'ORDERED',4,12,'2022-07-24'),(15,'REJECTED',1,11,'2022-04-21'),(16,'ORDERED',4,1,'2022-05-12'),(17,'ORDERED',2,8,'2022-05-12'),(18,'ORDERED',3,5,'2022-08-11');
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plant`
--

DROP TABLE IF EXISTS `plant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plant` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description_id` bigint DEFAULT NULL,
  `price` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `plant_ibfk_1` (`description_id`),
  CONSTRAINT `plant_ibfk_1` FOREIGN KEY (`description_id`) REFERENCES `description` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant`
--

LOCK TABLES `plant` WRITE;
/*!40000 ALTER TABLE `plant` DISABLE KEYS */;
INSERT INTO `plant` VALUES (1,'Rosemary',1,300,394),(2,'Feverfew',2,100,94),(3,'Aloe Vera',3,500,21),(4,'Valerian',4,300,354),(5,'Beth root',5,300,195),(6,'Aconite',6,122,453),(7,'Sushni',7,543,394),(8,'Wooly Lamb\'s Ear',8,3000,1),(9,'Solomon\'s Seal',9,4873,0),(10,'Elecampane',10,30,322),(11,'Allheal',11,65,39),(12,'Lemon Balm',12,289,43),(13,'Licorice',13,20,1200);
/*!40000 ALTER TABLE `plant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plant_client`
--

DROP TABLE IF EXISTS `plant_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plant_client` (
  `plant_id` bigint NOT NULL,
  `client_id` bigint NOT NULL,
  PRIMARY KEY (`plant_id`,`client_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `plant_client_ibfk_1` FOREIGN KEY (`plant_id`) REFERENCES `plant` (`id`),
  CONSTRAINT `plant_client_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant_client`
--

LOCK TABLES `plant_client` WRITE;
/*!40000 ALTER TABLE `plant_client` DISABLE KEYS */;
INSERT INTO `plant_client` VALUES (5,4),(12,1);
/*!40000 ALTER TABLE `plant_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_SELLER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `date_of_birth` varchar(10) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `registration_date` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES (1,'Loren','Adams','034-553-4332','Hollywood','la.ads@gmail.com','1993-02-11','Female','2022-03-19'),(2,'Alan','Bardley','033-333-9011','Wall Street','alanbarkl@gmail.com','1989-04-22','Male','2022-01-01');
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'adminos','$2a$10$XZj0rGqZqJCGR1BADgYZvOm5YKWUBSjnggFHG6qrjJuX34oc2XRmS','Adminos','Adminos','admin@testmail.com'),(2,'noob','$2a$10$XZj0rGqZqJCGR1BADgYZvOm5YKWUBSjnggFHG6qrjJuX34oc2XRmS','Noob','Noob','nb@testmail.com'),(3,'meta-dady','$2a$10$XZj0rGqZqJCGR1BADgYZvOm5YKWUBSjnggFHG6qrjJuX34oc2XRmS','Mark','Zuckerberg','mmzucker@gmail.com');
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,1),(3,1),(1,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-12 19:44:21
