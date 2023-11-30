-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: argentinaprograma
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cuit` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'20354879632','cliente1@example.com','Empresa ABC S.A.','555-1234'),(2,'30567890124','cliente2@example.com','Compañía XYZ Ltda.','555-5678'),(3,'40890123456','cliente3@example.com','Servicios Globales SA','555-9012'),(4,'51234567890','cliente4@example.com','Inversiones Innovadoras','555-3456'),(5,'61678901234','cliente5@example.com','Productos del Valle','555-7890'),(6,'72012345678','cliente6@example.com','Tecnologías Futuras SL','555-2345'),(7,'82456789012','cliente7@example.com','Logística Rápida SA','555-6789'),(8,'93890123456','cliente8@example.com','Consultores Asociados','555-0123'),(9,'10456789012','cliente9@example.com','Construcciones Modernas SA','555-4567'),(10,'11567890123','cliente10@example.com','Turismo Aventura Ltda.','555-8901'),(11,'12678901234','cliente11@example.com','Distribuidora Nacional','555-2345'),(12,'13789012345','cliente12@example.com','Cafetería Delicias','555-6789'),(13,'14901234567','cliente13@example.com','Servicios Médicos Integral','555-0123'),(14,'15012345678','cliente14@example.com','Imprenta Rápida SA','555-4567'),(15,'16123456789','cliente15@example.com','Comestibles del Barrio','555-8901'),(16,'17234567890','cliente16@example.com','Turismo Exótico Ltda.','555-2345'),(17,'18345678901','cliente17@example.com','Ingeniería Avanzada','555-6789'),(18,'19456789012','cliente18@example.com','Moda Elegante SRL','555-0123'),(19,'20567890123','cliente19@example.com','Automóviles del Futuro','555-4567'),(20,'21678901234','cliente20@example.com','Bienes Raíces Inversiones','555-8901');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidad` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `disponibilidad` bit(1) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tecnico_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn2t8f7qdcusnqvrnsqs9mahi9` (`tecnico_id`),
  CONSTRAINT `FKn2t8f7qdcusnqvrnsqs9mahi9` FOREIGN KEY (`tecnico_id`) REFERENCES `tecnico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` VALUES (1,_binary '','Redes',1),(2,_binary '','Desarrollo Web',2),(3,_binary '\0','Base de Datos',3),(4,_binary '','Seguridad Informática',4),(5,_binary '','Soporte Técnico',5),(6,_binary '\0','Diseño Gráfico',6),(7,_binary '','Sistemas Operativos',7),(8,_binary '','Consultoría SAP',8),(9,_binary '\0','Migración de Datos',9),(10,_binary '','Programación en Java',10),(11,_binary '','Administración de Proyectos',11),(12,_binary '\0','Desarrollo Móvil',12),(13,_binary '','Marketing Digital',13),(14,_binary '','Recursos Humanos',14),(15,_binary '\0','Implementación SAP',15),(16,_binary '','Integración de Sistemas',16),(17,_binary '','Linux',17),(18,_binary '','Moda y Estilo',18),(19,_binary '\0','Automatización de Vehículos',19),(20,_binary '','Bienes Raíces',20);
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_incidente`
--

DROP TABLE IF EXISTS `estado_incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado_incidente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_incidente`
--

LOCK TABLES `estado_incidente` WRITE;
/*!40000 ALTER TABLE `estado_incidente` DISABLE KEYS */;
INSERT INTO `estado_incidente` VALUES (1,'En progreso'),(2,'Completado'),(3,'Cancelado'),(4,'Reabierto');
/*!40000 ALTER TABLE `estado_incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidente`
--

DROP TABLE IF EXISTS `incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `fechaInicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `observaciones` varchar(255) DEFAULT NULL,
  `tiempoEstimadoResolucion` int DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  `estado_id` bigint DEFAULT NULL,
  `servicio_id` bigint DEFAULT NULL,
  `tecnicoAsignado_id` bigint DEFAULT NULL,
  `tipoProblema_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9op4o91f9rohjayhvctjxde9x` (`cliente_id`),
  KEY `FKbtfplqjan7x445av027sr3gqd` (`estado_id`),
  KEY `FKb0t8ap55daymocw1o9brcguu7` (`servicio_id`),
  KEY `FKqtqh0lw290wldsgv1u6qvbcfm` (`tecnicoAsignado_id`),
  KEY `FKaeasb7uf8hshxjk8fqv5e926p` (`tipoProblema_id`),
  CONSTRAINT `FK9op4o91f9rohjayhvctjxde9x` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKaeasb7uf8hshxjk8fqv5e926p` FOREIGN KEY (`tipoProblema_id`) REFERENCES `tipo_problema` (`id`),
  CONSTRAINT `FKb0t8ap55daymocw1o9brcguu7` FOREIGN KEY (`servicio_id`) REFERENCES `servicio` (`id`),
  CONSTRAINT `FKbtfplqjan7x445av027sr3gqd` FOREIGN KEY (`estado_id`) REFERENCES `estado_incidente` (`id`),
  CONSTRAINT `FKqtqh0lw290wldsgv1u6qvbcfm` FOREIGN KEY (`tecnicoAsignado_id`) REFERENCES `tecnico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
INSERT INTO `incidente` VALUES (1,'No anda el sap','2023-11-29 20:47:05','NO hay tecninco ',26,1,1,1,2,8);
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK78icgfs42juijhtl4qpgapvya` (`cliente_id`),
  CONSTRAINT `FK78icgfs42juijhtl4qpgapvya` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (1,'Brindamos asistencia operativa para problemas en SAP','Soporte Técnico para SAP',1),(2,'Creamos y mantenemos sitios web adaptados a sus necesidades','Desarrollo Web Personalizado',2),(3,'Asesoramiento experto en soluciones SAP','Consultoría SAP Especializada',3),(4,'Protegemos sus sistemas contra amenazas cibernéticas','Seguridad Informática Integral',4),(5,'Configuramos y mantenemos redes para su empresa','Redes Empresariales Eficientes',5),(6,'Transferimos datos de manera segura y eficiente','Migración de Datos Segura',6),(7,'Desarrollamos aplicaciones Java personalizadas','Programación en Java Avanzada',7),(8,'Creación de elementos visuales impactantes','Diseño Gráfico Creativo',8),(9,'Supervisión y coordinación de proyectos tecnológicos','Administración de Proyectos Tecnológicos',9),(10,'Conectamos y sincronizamos sus sistemas','Integración de Sistemas Experta',10),(11,'Asistencia técnica adaptada a sus necesidades','Soporte Técnico Especializado',11),(12,'Asesoramiento y gestión de personal','Recursos Humanos en Tecnología',12),(13,'Asesoramiento en imagen corporativa','Moda y Estilo en Tecnología',13),(14,'Implementación de sistemas automatizados','Automatización de Vehículos Inteligente',14),(15,'Asesoramiento en inversiones tecnológicas','Bienes Raíces Tecnológicos',15),(16,'Despliegue eficiente de soluciones SAP','Implementación SAP Empresarial',16),(17,'Asistencia técnica adaptada a sus necesidades','Soporte Técnico Personalizado',17),(18,'Creación de aplicaciones móviles modernas','Desarrollo Móvil Innovador',18),(19,'Asesoramiento en estrategias digitales','Estrategias de Marketing Digital',19),(20,'Asesoramiento en gestión de personal','Consultoría en Recursos Humanos',20);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico`
--

LOCK TABLES `tecnico` WRITE;
/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
INSERT INTO `tecnico` VALUES (1,'González','tecnico1@example.com','Juan','555-1234'),(2,'Rodríguez','tecnico2@example.com','María','555-5678'),(3,'López','tecnico3@example.com','Carlos','555-9012'),(4,'Martínez','tecnico4@example.com','Laura','555-3456'),(5,'Gómez','tecnico5@example.com','José','555-7890'),(6,'Pérez','tecnico6@example.com','Ana','555-2345'),(7,'Fernández','tecnico7@example.com','Martín','555-6789'),(8,'Díaz','tecnico8@example.com','Lucía','555-0123'),(9,'Rivera','tecnico9@example.com','Miguel','555-4567'),(10,'Alvarez','tecnico10@example.com','Paula','555-8901'),(11,'Benítez','tecnico11@example.com','Jorge','555-2345'),(12,'Romero','tecnico12@example.com','Verónica','555-6789'),(13,'Suárez','tecnico13@example.com','Diego','555-0123'),(14,'Torres','tecnico14@example.com','Silvia','555-4567'),(15,'Acosta','tecnico15@example.com','Gustavo','555-8901'),(16,'Molina','tecnico16@example.com','Natalia','555-2345'),(17,'Cabrera','tecnico17@example.com','Fernando','555-6789'),(18,'Vargas','tecnico18@example.com','Cecilia','555-0123'),(19,'Luna','tecnico19@example.com','Ricardo','555-4567'),(20,'Giménez','tecnico20@example.com','Victoria','555-8901');
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_problema`
--

DROP TABLE IF EXISTS `tipo_problema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_problema` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tiempoMaximoResolucion` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_problema`
--

LOCK TABLES `tipo_problema` WRITE;
/*!40000 ALTER TABLE `tipo_problema` DISABLE KEYS */;
INSERT INTO `tipo_problema` VALUES (1,'Problema de conexión SAP','Conexión SAP',24),(2,'Error en la interfaz de Tango','Error de Interfaz Tango',48),(3,'Problema de rendimiento en aplicación SAP','Rendimiento SAP',72),(4,'Error en la ejecución de informes Tango','Error en Informes Tango',36),(5,'Problema de instalación Windows','Instalación Windows',48),(6,'Error en actualización MacOS','Error en Actualización MacOS',72),(7,'Problema de compatibilidad Linux Ubuntu','Compatibilidad Linux Ubuntu',24),(8,'Consulta sobre configuración SAP','Consulta Configuración SAP',48),(9,'Problema en migración Tango','Migración Tango',72),(10,'Error en actualización de base de datos SAP','Error en Base de Datos SAP',36),(11,'Problema de seguridad Tango','Seguridad Tango',48),(12,'Consulta sobre desarrollo de aplicaciones móviles','Consulta Desarrollo Móvil',72),(13,'Problema en estrategias de marketing','Estrategias de Marketing',24),(14,'Consulta en recursos humanos','Consulta Recursos Humanos',48),(15,'Problema en implementación de SAP','Implementación SAP',72),(16,'Error en implementación de Tango','Error Implementación Tango',36),(17,'Problema en actualización de sistemas Windows','Actualización Windows',48),(18,'Consulta en integración de sistemas MacOS','Consulta Integración MacOS',72),(19,'Problema en integración Linux Ubuntu','Integración Linux Ubuntu',24),(20,'Consulta en soporte técnico','Consulta Soporte Técnico',48);
/*!40000 ALTER TABLE `tipo_problema` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-29 15:49:33
