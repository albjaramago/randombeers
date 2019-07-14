-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: randombeer
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `beers`
--

DROP TABLE IF EXISTS `beers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `beers` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `alcohol` varchar(4) DEFAULT NULL,
  `brewery` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `brewery` (`brewery`),
  CONSTRAINT `beers_ibfk_1` FOREIGN KEY (`brewery`) REFERENCES `breweries` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beers`
--

LOCK TABLES `beers` WRITE;
/*!40000 ALTER TABLE `beers` DISABLE KEYS */;
INSERT INTO `beers` VALUES (1,'DEVIL’S BACKBONE','full bodied amber that is balanced to perfection; rich malt pulled back with a great level of bitterness','4.9',1),(2,'O’HARA’S LEANN FOLLÁIN','dry Irish stout and bumps it up a notch. Expect masses of chocolate and a little milky coffee','6',2),(3,'PUCK PILSNER','It pours a clean straw-like in colour, with earthy and subtle honey notes on the nose','4.5',3),(4,'BLACK BOAR','Full bodied and silken textured, malty biscuit and fistfuls of red and dark berries','10.2',4),(5,'SHMOAKE GRÂTZER','It has an intriguing blend of flavours that combine to produce a beer quite unlike any other single beer out there','4.7',3),(6,'THE FULL IRISH','Pours a lovely pale golden colour with a beautiful white head. Moderate hop bitterness, citrusy hops.  Biscuity malts, caramel.','6',1),(7,'OF FOAM AND FURY','tropical fruit mixture bang up front in the taste, with mango; taste medium sweet and bitter, pithy grapefruit','8.5',5);
/*!40000 ALTER TABLE `beers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `breweries`
--

DROP TABLE IF EXISTS `breweries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `breweries` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `breweries`
--

LOCK TABLES `breweries` WRITE;
/*!40000 ALTER TABLE `breweries` DISABLE KEYS */;
INSERT INTO `breweries` VALUES (1,'Galway Bay Brewery','Galway Bay Brewery Carrowmoneash Station Road Oranmore Galway Republic of Ireland, H91 FA31'),(2,'The White Hag Brewing Company','The White Hag Brewing Company Unit 1, Block 2, Ballymote Business Park, Ballymote, Co. Sligo'),(3,'Eight Degrees Brewing Company','Unit 4, Coolnanave Industrial Park, Coolnanave, Mitchelstown, Co. Cork'),(4,'YellowBelly Beer','YellowBelly Beer, Whiterock Hill, Pembrokestown, Wexford, Y35 HW27'),(5,'Dungarvan Brewing Company','Westgate Business Park, 5, Dungarvan, Co. Waterford, X35 HY48');
/*!40000 ALTER TABLE `breweries` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-14 18:53:40
