-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: urnaeletronica
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Create and use database
--
CREATE DATABASE urnaeletronica;
USE urnaeletronica;
--
-- Table structure for table `candidato`
--
DROP TABLE IF EXISTS `candidato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidato` (
  `canid` int(11) NOT NULL AUTO_INCREMENT,
  `cannome` varchar(45) DEFAULT NULL,
  `cannumero` varchar(45) DEFAULT NULL,
  `canparid` int(11) NOT NULL,
  PRIMARY KEY (`canid`),
  KEY `fk_candidato_partido_idx` (`canparid`),
  CONSTRAINT `fk_candidato_partido` FOREIGN KEY (`canparid`) REFERENCES `partido` (`parid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidato`
--

LOCK TABLES `candidato` WRITE;
/*!40000 ALTER TABLE `candidato` DISABLE KEYS */;
INSERT INTO `candidato` VALUES (1,'João','33',1),(2,'Pedro','33',1),(3,'Fala','33',3),(4,'Gina','33',2);
/*!40000 ALTER TABLE `candidato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eleitor`
--

DROP TABLE IF EXISTS `eleitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eleitor` (
  `eleid` int(11) NOT NULL AUTO_INCREMENT,
  `elenome` varchar(100) DEFAULT NULL,
  `elecpf` varchar(14) DEFAULT NULL,
  `elecep` varchar(9) DEFAULT NULL,
  `elebairro` varchar(45) DEFAULT NULL,
  `elerua` varchar(200) DEFAULT NULL,
  `elenumero` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`eleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eleitor`
--

LOCK TABLES `eleitor` WRITE;
/*!40000 ALTER TABLE `eleitor` DISABLE KEYS */;
/*!40000 ALTER TABLE `eleitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partido` (
  `parid` int(11) NOT NULL AUTO_INCREMENT,
  `parnome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`parid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (1,'PT'),(2,'PSD'),(3,'PSC'),(4,'PSOL');
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urna`
--

DROP TABLE IF EXISTS `urna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `urna` (
  `urnid` int(11) NOT NULL,
  `urndatahora` datetime DEFAULT NULL,
  `urnvoto` int(11) DEFAULT NULL,
  `urncanid` int(11) NOT NULL,
  `urneleid` int(11) NOT NULL,
  PRIMARY KEY (`urnid`),
  KEY `fk_urna_candidato1_idx` (`urncanid`),
  KEY `fk_urna_eleitor1_idx` (`urneleid`),
  CONSTRAINT `fk_urna_candidato1` FOREIGN KEY (`urncanid`) REFERENCES `candidato` (`canid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_urna_eleitor1` FOREIGN KEY (`urneleid`) REFERENCES `eleitor` (`eleid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urna`
--

LOCK TABLES `urna` WRITE;
/*!40000 ALTER TABLE `urna` DISABLE KEYS */;
/*!40000 ALTER TABLE `urna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usuid` int(11) NOT NULL AUTO_INCREMENT,
  `usulogin` varchar(45) DEFAULT NULL,
  `ususenha` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`usuid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-18 15:43:28
