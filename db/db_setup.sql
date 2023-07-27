--
-- Set up the database and the user first:
--

create database if not exists `datatables`;

use datatables;
create user 'datatables'@'%' identified with mysql_native_password by 'datatablespass';
grant all privileges on datatables.* to 'datatables'@'%';

flush privileges;

---------------------------------------------------------

-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: datatables
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `name` varchar(100) NOT NULL,
  `position` varchar(100) DEFAULT NULL,
  `office` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('Airi Satou','Accountant','Tokyo',33,'2008-11-28','$162,700'),('Angelica Ramos','Chief Executive Officer (CEO)','London',47,'2009-10-09','$1,200,000'),('Ashton Cox','Junior Technical Author','San Francisco',66,'2009-01-12','$86,000'),('Bradley Greer','Software Engineer','London',41,'2012-10-13','$132,000'),('Brenden Wagner','Software Engineer','San Francisco',28,'2011-06-07','$206,850'),('Brielle Williamson','Integration Specialist','New York',61,'2012-12-02','$372,000'),('Bruno Nash','Software Engineer','London',38,'2011-05-03','$163,500'),('Caesar Vance','Pre-Sales Support','New York',21,'2011-12-12','$106,450'),('Cara Stevens','Sales Assistant','New York',46,'2011-12-06','$145,600'),('Cédric Huppert','Developer','London',35,'2011-04-22','$96,000'),('Cedric Kelly','Senior Javascript Developer','Edinburgh',22,'2012-03-29','$433,060'),('Charde Marshall','Regional Director','San Francisco',36,'2008-10-16','$470,600'),('Colleen Hurst','Javascript Developer','San Francisco',39,'2009-09-15','$205,500'),('Dai Rios','Personnel Lead','Edinburgh',35,'2012-09-26','$217,500'),('Donna Snider','Customer Support','New York',27,'2011-01-25','$112,000'),('Doris Wilder','Sales Assistant','Sydney',23,'2010-09-20','$85,600'),('Édouard Russo','Software Engineer','New York',23,'2012-07-02','$102,100'),('Finn Camacho','Support Engineer','San Francisco',47,'2009-07-07','$87,500'),('Fiona Green','Chief Operating Officer (COO)','San Francisco',48,'2010-03-11','$850,000'),('Garrett Winters','Accountant','Tokyo',63,'2011-07-25','$170,750'),('Gavin Cortez','Team Leader','San Francisco',22,'2008-10-26','$235,500'),('Gavin Joyce','Developer','Edinburgh',42,'2010-12-22','$92,575'),('Gloria Little','Systems Administrator','New York',59,'2009-04-10','$237,500'),('Haley Kennedy','Senior Marketing Designer','London',43,'2012-12-18','$313,500'),('Hermione Butler','Regional Director','London',47,'2011-03-21','$356,250'),('Herrod Chandler','Sales Assistant','San Francisco',59,'2012-08-06','$137,500'),('Hope Fuentes','Secretary','San Francisco',41,'2010-02-12','$109,850'),('Howard Hatfield','Office Manager','San Francisco',51,'2008-12-16','$164,500'),('Jackson Bradshaw','Director','New York',65,'2008-09-26','$645,750'),('Jena Gaines','Office Manager','London',30,'2008-12-19','$90,560'),('Jenette Caldwell','Development Lead','New York',30,'2011-09-03','$345,000'),('Jennifer Acosta','Junior Javascript Developer','Edinburgh',43,'2013-02-01','$75,650'),('Jennifer Chang','Regional Director','Singapore',28,'2010-11-14','$357,650'),('Jonas Alexander','Developer','San Francisco',30,'2010-07-14','$86,500'),('Lael Greer','Systems Administrator','London',21,'2009-02-27','$103,500'),('Martena Mccray','Post-Sales support','Edinburgh',46,'2011-03-09','$324,050'),('Michael Bruce','Javascript Developer','Singapore',29,'2011-06-27','$183,000'),('Michael Silva','Marketing Designer','London',66,'2012-11-27','$198,500'),('Michelle House','Integration Specialist','Sydney',37,'2011-06-02','$95,400'),('Olivia Liang','Support Engineer','Singapore',64,'2011-02-03','$234,500'),('Paul Byrd','Chief Financial Officer (CFO)','New York',64,'2010-06-09','$725,000'),('Prescott Bartlett','Technical Author','London',27,'2011-05-07','$145,000'),('Quinn Flynn','Support Lead','Edinburgh',22,'2013-03-03','$342,000'),('Rhona Davidson','Integration Specialist','Tokyo',55,'2010-10-14','$327,900'),('Sakura Yamamoto','Support Engineer','Tokyo',37,'2009-08-19','$139,575'),('Serge Baldwin','Data Coordinator','Singapore',64,'2012-04-09','$138,575'),('Shad Decker','Regional Director','Edinburgh',51,'2008-11-13','$183,000'),('Shou Itou','Regional Marketing','Tokyo',20,'2011-08-14','$163,000'),('Sonya Frost','Software Engineer','Edinburgh',23,'2008-12-13','$103,600'),('Suki Burks','Developer','London',53,'2009-10-22','$114,500'),('Tatyana Fitzpatrick','Regional Director','London',19,'2010-03-17','$385,750'),('Thor Walton','Developer','New York',61,'2013-08-11','$98,540'),('Tiger Nixon','System Architect','Edinburgh',61,'2011-04-25','$320,800'),('Timothy Mooney','Office Manager','London',37,'2008-12-11','$136,200'),('Unity Butler','Marketing Designer','San Francisco',47,'2009-12-09','$85,675'),('Vivian Harrell','Financial Controller','San Francisco',62,'2009-02-14','$452,500'),('Yuri Berry','Chief Marketing Officer (CMO)','New York',40,'2009-06-25','$675,000'),('Zenaida Frank','Software Engineer','New York',63,'2010-01-04','$125,250'),('Zorita Serrano','Software Engineer','San Francisco',56,'2012-06-01','$115,000');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

