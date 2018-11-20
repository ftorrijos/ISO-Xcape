-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dbx
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `eventos` (
  `evento_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  `fecha` varchar(20) DEFAULT NULL,
  `listas` int(11) DEFAULT NULL,
  PRIMARY KEY (`evento_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,'Ski Welcome Party','La pista nº2','andorra','24/01/2019',51),(2,'Ski Welcome Party Night 2','La pista nº2','andorra','25/01/2019',54);
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grupo` (
  `grupo_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(10) DEFAULT NULL,
  `responsable_id` int(11) DEFAULT NULL,
  `viaje_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`grupo_id`),
  KEY `responsable_id` (`responsable_id`),
  KEY `viaje_id` (`viaje_id`),
  CONSTRAINT `grupo_ibfk_1` FOREIGN KEY (`responsable_id`) REFERENCES `responsables` (`responsable_id`),
  CONSTRAINT `grupo_ibfk_2` FOREIGN KEY (`viaje_id`) REFERENCES `info_viaje` (`viaje_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,'AND-01',1,1),(2,'AND-02',NULL,NULL),(3,'CAN-01',NULL,NULL),(6,'CAN-02',3,1),(7,'ARG-01',2,2),(8,'AUS-01',1,2);
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidencias`
--

DROP TABLE IF EXISTS `incidencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `incidencias` (
  `incidencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) DEFAULT NULL,
  `grupo_id` int(11) DEFAULT NULL,
  `mensaje` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`incidencia_id`),
  KEY `grupo_id` (`grupo_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `incidencias_ibfk_1` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`grupo_id`),
  CONSTRAINT `incidencias_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidencias`
--

LOCK TABLES `incidencias` WRITE;
/*!40000 ALTER TABLE `incidencias` DISABLE KEYS */;
INSERT INTO `incidencias` VALUES (1,3,2,'El viaje es la ****, este anno repito!'),(2,3,2,'El viaje es la ****, este anno repito!'),(10,3,7,'me faltan las pilas del....'),(11,10,1,'No me gusta esto');
/*!40000 ALTER TABLE `incidencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info_viaje`
--

DROP TABLE IF EXISTS `info_viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `info_viaje` (
  `viaje_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel` varchar(50) DEFAULT NULL,
  `direccion_hotel` varchar(100) DEFAULT NULL,
  `regimen` varchar(50) DEFAULT NULL,
  `estacion_forfait` varchar(50) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  PRIMARY KEY (`viaje_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_viaje`
--

LOCK TABLES `info_viaje` WRITE;
/*!40000 ALTER TABLE `info_viaje` DISABLE KEYS */;
INSERT INTO `info_viaje` VALUES (1,'SPA RESORT ANDORRA','123,GrandValira,Andorra','desayuno','grandvalira',5),(2,'TiesoHotel','TiesoLandia, Andorra','niWifi','grandvalira',2),(3,'Alpes Ski Hotel','Los Alpes, Alpes','todo incluido','Serre Chevalier',7);
/*!40000 ALTER TABLE `info_viaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pagos` (
  `pago_id` int(11) NOT NULL AUTO_INCREMENT,
  `metodo_pago` varchar(15) DEFAULT NULL,
  `primer_pago` varchar(15) DEFAULT NULL,
  `segundo_pago` varchar(15) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `DNI` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pago_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
INSERT INTO `pagos` VALUES (1,'Bitcoin','ok',NULL,3,'47228811C'),(2,'no paga','ok','ok',10,'18918811K'),(7,'tarjeta','ok','ok',5,'81818181K'),(8,'Visa','ok','ok',3,'47228819K');
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsables`
--

DROP TABLE IF EXISTS `responsables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `responsables` (
  `responsable_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `movil` int(11) DEFAULT NULL,
  PRIMARY KEY (`responsable_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsables`
--

LOCK TABLES `responsables` WRITE;
/*!40000 ALTER TABLE `responsables` DISABLE KEYS */;
INSERT INTO `responsables` VALUES (1,'Javier','Sancerni',111222333),(2,'Alvaro','Cordoba',111222313),(3,'Ignacio','Goiriena',12222313),(4,'Juanan','Merino',612626272);
/*!40000 ALTER TABLE `responsables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_login` (
  `user_id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(500) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_login_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `usuarios` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES (3,'FernandoTorrijos','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8'),(1,'AlejandroGutierrez','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8'),(10,'admin','d033e22ae348aeb5660fc2140aec35850c4da997'),(8,'JoseManuelGuerrero','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8'),(4,'EduardoBenzo','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8');
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_grupo`
--

DROP TABLE IF EXISTS `usuario_grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario_grupo` (
  `user_id` int(11) DEFAULT NULL,
  `grupo_id` int(11) DEFAULT NULL,
  `fecha` varchar(15) DEFAULT NULL,
  KEY `grupo_id` (`grupo_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `usuario_grupo_ibfk_1` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`grupo_id`),
  CONSTRAINT `usuario_grupo_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `usuarios` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_grupo`
--

LOCK TABLES `usuario_grupo` WRITE;
/*!40000 ALTER TABLE `usuario_grupo` DISABLE KEYS */;
INSERT INTO `usuario_grupo` VALUES (1,1,NULL),(2,1,NULL),(3,1,NULL),(4,1,NULL),(5,1,NULL),(7,1,NULL);
/*!40000 ALTER TABLE `usuario_grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `dni` varchar(10) DEFAULT NULL,
  `correo` varchar(40) DEFAULT NULL,
  `movil` int(9) DEFAULT NULL,
  PRIMARY KEY (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Alejandro Gutierrez',NULL,NULL,'05467810C',NULL,NULL),(2,'Javier Sancerni',NULL,NULL,NULL,NULL,NULL),(3,'Fernando','Torrijos',NULL,'47228819K','fer@fer.com',18181818),(4,'Eduardo Benzo',NULL,NULL,NULL,NULL,NULL),(5,'Javier',NULL,NULL,NULL,NULL,NULL),(7,'Carlos',NULL,NULL,NULL,NULL,NULL),(8,'Jose Manuel','Guerrero','1997-03-21','23452104D','guerre@cojo.com',666888999),(9,'Angel','Nu�ez','1994-05-03','11223344v','angelnt@manco.es',669667887),(10,'admin',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-20 10:43:05
