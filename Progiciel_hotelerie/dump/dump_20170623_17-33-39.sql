use hotel;
-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `agence`
--

DROP TABLE IF EXISTS `agence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(250) NOT NULL,
  `telephone` int(10) NOT NULL,
  `email` varchar(250) NOT NULL,
  `image` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agence`
--

/*!40000 ALTER TABLE `agence` DISABLE KEYS */;
INSERT INTO `agence` VALUES (1,'AZUR_DIFFUSION',675621538,'azur_diffusion@gmail.com',NULL),(2,'CAPITAL EVASION',698585463,'capital_evasion@gmail.com',NULL),(3,'SUD EVASION',612365485,'sud_evasion@gmail.com',NULL),(4,'EURO MER AVIGNON',645695874,'euro_mer@gmail.com',NULL),(5,'SOLOWAYS',605238759,'soloways@gmail.com',NULL),(6,'SELECTOUR MASSILIA VOYAGES',698811311,'selectour@gmail.com',NULL),(7,'Move Around Provence',629424352,'move@gmail.com',NULL),(8,'CLUB MED',621252635,'club_med@gmail.com',NULL);
/*!40000 ALTER TABLE `agence` ENABLE KEYS */;

--
-- Table structure for table `aliment`
--

DROP TABLE IF EXISTS `aliment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aliment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aliment`
--

/*!40000 ALTER TABLE `aliment` DISABLE KEYS */;
INSERT INTO `aliment` VALUES (1,'tomate',0),(2,'salade',0),(3,'oignon',0),(4,'poireaux',1),(5,'magret de canard',20),(6,'truffe',45),(7,'cote de boeuf',25),(8,'foie gras',15);
/*!40000 ALTER TABLE `aliment` ENABLE KEYS */;

--
-- Table structure for table `aliment_commande_assoc`
--

DROP TABLE IF EXISTS `aliment_commande_assoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aliment_commande_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_aliment` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `quantite` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_aliment` (`id_aliment`),
  KEY `id_commande` (`id_commande`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aliment_commande_assoc`
--

/*!40000 ALTER TABLE `aliment_commande_assoc` DISABLE KEYS */;
INSERT INTO `aliment_commande_assoc` VALUES (1,1,1,10),(2,1,2,20),(3,1,3,30),(4,2,4,5),(5,2,5,6),(6,2,6,120),(7,3,1,10),(8,3,2,8);
/*!40000 ALTER TABLE `aliment_commande_assoc` ENABLE KEYS */;

--
-- Table structure for table `boisson`
--

DROP TABLE IF EXISTS `boisson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boisson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `quantite` double NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boisson`
--

/*!40000 ALTER TABLE `boisson` DISABLE KEYS */;
INSERT INTO `boisson` VALUES (1,'coca-cola',33,3),(2,'limonade',33,3),(3,'sirop',33,3),(4,'Bière_demi',33,3),(5,'bière_pinte',50,6),(6,'vin',75,25),(7,'gin',25,10),(8,'whisky',15,10);
/*!40000 ALTER TABLE `boisson` ENABLE KEYS */;

--
-- Table structure for table `chambre`
--

DROP TABLE IF EXISTS `chambre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chambre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_chambre` int(11) NOT NULL,
  `prix` double NOT NULL,
  `capacite` int(11) NOT NULL,
  `etage` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_chambre` (`numero_chambre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chambre`
--

/*!40000 ALTER TABLE `chambre` DISABLE KEYS */;
INSERT INTO `chambre` VALUES (1,1,55,4,1),(2,2,45,2,1),(3,3,65,2,2),(4,4,80,4,2),(5,5,75,2,3),(6,6,85,4,3),(7,7,145,2,4),(8,8,330,4,4);
/*!40000 ALTER TABLE `chambre` ENABLE KEYS */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(250) NOT NULL,
  `prenom` varchar(250) NOT NULL,
  `adresse_rue` varchar(250) NOT NULL,
  `adresse_ville` varchar(250) NOT NULL,
  `code_postal` varchar(20) NOT NULL,
  `telephone` varchar(25) NOT NULL,
  `date_naissance` date NOT NULL,
  `allergies` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Perkins','Thomas','Lodewijk De Raetlaan 303','Clermont','56505650','0471786439','2017-06-22','gluten'),(2,'Audet edit','Shelley edit','Blancefloerlaan 217 edit','Borsbeek edit','2150 edit','0481452833 edit','2017-06-08','fruit de mer edit'),(3,'Bassett','Margaret','Ctra. Hornos, 54','Hormilla','26223','762309866','2017-06-22',''),(4,'Edwards','Kevin','Ctra. de Fuentenueva, 40','Fresnedillas de la Oliva','28214','727467873','2017-06-22',''),(5,'Stone','Kelly','84, Rue de Verdun','MONTFERMEIL','93370','0114864961','2017-06-22',''),(6,'Peters','Swen','26, Place de la Madeleine','PARIS','75009 ','0225784936','2017-06-22',''),(7,'Schiffer','Uta','1440 Peck Court','El Toro','CA 92630','9495804455','2017-06-22','féculent'),(8,'Balducci','Hanna','2757 Timber Oak Drive','Montecito,','CA 93108','8059696474','2017-06-22',''),(11,'nom','prenom','adresse','ville','69230','06','2017-06-04','allergique au gluthene');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

--
-- Table structure for table `client_agence_assoc`
--

DROP TABLE IF EXISTS `client_agence_assoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_agence_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `id_agence` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_client` (`id_client`),
  KEY `id_agence` (`id_agence`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_agence_assoc`
--

/*!40000 ALTER TABLE `client_agence_assoc` DISABLE KEYS */;
INSERT INTO `client_agence_assoc` VALUES (1,1,1),(2,2,1),(3,3,1),(4,2,2),(5,4,2),(6,5,2),(7,6,3),(8,7,3);
/*!40000 ALTER TABLE `client_agence_assoc` ENABLE KEYS */;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_commande` date NOT NULL,
  `prix_total` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;

--
-- Table structure for table `commande_assoc`
--

DROP TABLE IF EXISTS `commande_assoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_commande` int(11) NOT NULL,
  `id_equipement_restaurant` int(11) DEFAULT NULL,
  `quantite` double NOT NULL,
  `id_equipement_hotel` int(11) DEFAULT NULL,
  `id_equipement_spa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_commande` (`id_commande`),
  KEY `id_equipement` (`id_equipement_restaurant`),
  KEY `id_equipement_hotel` (`id_equipement_hotel`),
  KEY `id_equipement_spa` (`id_equipement_spa`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande_assoc`
--

/*!40000 ALTER TABLE `commande_assoc` DISABLE KEYS */;
INSERT INTO `commande_assoc` VALUES (1,1,1,10,NULL,NULL),(2,2,2,120,NULL,NULL),(3,2,NULL,100,1,NULL),(4,3,NULL,70,2,NULL),(5,3,NULL,60,NULL,1),(6,4,NULL,50,NULL,2),(7,5,1,30,NULL,NULL),(8,6,1,15,NULL,NULL);
/*!40000 ALTER TABLE `commande_assoc` ENABLE KEYS */;

--
-- Table structure for table `commande_piece_assoc`
--

DROP TABLE IF EXISTS `commande_piece_assoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande_piece_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_commande` int(11) NOT NULL,
  `id_piece` int(11) NOT NULL,
  `quantite` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_commande` (`id_commande`),
  KEY `id_piece` (`id_piece`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande_piece_assoc`
--

/*!40000 ALTER TABLE `commande_piece_assoc` DISABLE KEYS */;
INSERT INTO `commande_piece_assoc` VALUES (1,1,1,10),(2,2,1,20),(3,2,2,30),(4,2,3,40),(5,3,5,96),(6,3,6,18),(7,4,7,70),(8,5,8,53);
/*!40000 ALTER TABLE `commande_piece_assoc` ENABLE KEYS */;

--
-- Table structure for table `criticite`
--

DROP TABLE IF EXISTS `criticite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `criticite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `temps_maximum` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criticite`
--

/*!40000 ALTER TABLE `criticite` DISABLE KEYS */;
INSERT INTO `criticite` VALUES (1,'trés_faible','00:20:00'),(2,'faible','00:30:00'),(3,'moyen','01:00:00'),(4,'haute','01:30:00'),(5,'trés haute','02:00:00'),(6,'critique','02:30:00');
/*!40000 ALTER TABLE `criticite` ENABLE KEYS */;

--
-- Table structure for table `demande_intervention`
--

DROP TABLE IF EXISTS `demande_intervention`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `demande_intervention` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_creation` date NOT NULL,
  `objet` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `valide` tinyint(1) NOT NULL,
  `id_criticite` int(11) NOT NULL,
  `id_equipement_spa` int(11) DEFAULT NULL,
  `id_equipement_hotel` int(11) DEFAULT NULL,
  `id_equipement_restaurant` int(11) DEFAULT NULL,
  `id_piece_rechange` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_piece_rechange` (`id_piece_rechange`),
  KEY `id_equipement_restaurant` (`id_equipement_restaurant`),
  KEY `id_equipement_hotel` (`id_equipement_hotel`),
  KEY `id_equipement_spa` (`id_equipement_spa`),
  KEY `id_criticite` (`id_criticite`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demande_intervention`
--

/*!40000 ALTER TABLE `demande_intervention` DISABLE KEYS */;
INSERT INTO `demande_intervention` VALUES (1,'2017-07-12','réparation de la lampe','description',0,2,NULL,1,NULL,1),(2,'2017-07-11','réparation de la table','description',1,3,NULL,2,NULL,2),(3,'2017-07-10','réparation de la douche','description',0,1,3,NULL,NULL,3),(4,'2017-07-09','changement du frigo','description',1,4,4,NULL,NULL,4),(5,'2017-07-08','réparation de la cafetière','description',0,6,NULL,NULL,5,5),(6,'2017-07-07','réparation de la baignoire','description',1,2,NULL,NULL,6,6),(7,'2017-07-06','réparation de la fenêtre','description',0,3,NULL,5,NULL,7),(8,'2017-07-05','réparation de la vitre','description',1,5,NULL,4,NULL,8);
/*!40000 ALTER TABLE `demande_intervention` ENABLE KEYS */;

--
-- Table structure for table `demande_utilisateur`
--

DROP TABLE IF EXISTS `demande_utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `demande_utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int(11) NOT NULL,
  `id_demande` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_demande` (`id_demande`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demande_utilisateur`
--

/*!40000 ALTER TABLE `demande_utilisateur` DISABLE KEYS */;
INSERT INTO `demande_utilisateur` VALUES (1,1,1),(2,2,2),(3,2,3),(4,3,4),(5,4,5),(6,4,6),(7,5,7),(8,8,8);
/*!40000 ALTER TABLE `demande_utilisateur` ENABLE KEYS */;

--
-- Table structure for table `droit`
--

DROP TABLE IF EXISTS `droit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `droit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `description` varchar(250) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  `modifiable` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `droit`
--

/*!40000 ALTER TABLE `droit` DISABLE KEYS */;
INSERT INTO `droit` VALUES (1,'ADD','Droit d\'ajout',1,0),(2,'DELETE','Droit de suppression',1,0),(3,'WRITE_ONLY','Droit d\'écriture',1,0),(4,'READ_ONLY','Droit de lecture',1,0),(5,'READ_WRITE','Droit lecture/écriture',1,0),(6,'ALL','Droit d\'admin',1,0);
/*!40000 ALTER TABLE `droit` ENABLE KEYS */;

--
-- Table structure for table `droit_role_assoc`
--

DROP TABLE IF EXISTS `droit_role_assoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `droit_role_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_droit` int(11) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_droit` (`id_droit`),
  KEY `id_role` (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `droit_role_assoc`
--

/*!40000 ALTER TABLE `droit_role_assoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `droit_role_assoc` ENABLE KEYS */;

--
-- Table structure for table `equipement_hotel`
--

DROP TABLE IF EXISTS `equipement_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipement_hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `est_equipement_jardin` tinyint(1) NOT NULL DEFAULT '0',
  `id_chambre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_chambre` (`id_chambre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipement_hotel`
--

/*!40000 ALTER TABLE `equipement_hotel` DISABLE KEYS */;
INSERT INTO `equipement_hotel` VALUES (1,'lit_1','lit 1 place','image/hotel/lit_1.jpg',0,1),(2,'lit_2','lit 2 place','image/hotel/lit_2_place.jpg',0,1),(3,'table','table en verre','image/hotel/table_verre.jpg',0,2),(4,'lampe','lampe de chevet','image/hotel/lampe.jpg',0,3),(5,'table_de_chevet','gueridon','image/hotel/table_chevet.jpg',0,4),(6,'frigo','mini bar','image/hotel/table_chevet.jpg',0,2),(7,'rideaux','rideaux en soie','image/hotel/rideau.jpg',0,3),(8,'canapé','canapé cuir blanc','image/hotel/canape.jpg',0,3);
/*!40000 ALTER TABLE `equipement_hotel` ENABLE KEYS */;

--
-- Table structure for table `equipement_restaurant`
--

DROP TABLE IF EXISTS `equipement_restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipement_restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `id_table` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_table` (`id_table`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipement_restaurant`
--

/*!40000 ALTER TABLE `equipement_restaurant` DISABLE KEYS */;
INSERT INTO `equipement_restaurant` VALUES (1,'verre_1','verre_1','image/restaurant/verre_default.jpg',1),(2,'verre_2','verre_2','image/restaurant/verre_default.jpg',2),(3,'couverts_1','couverts_1','image/restaurant/assiette.jpg',1),(4,'couverts_2','couverts_2','image/restaurant/assiette.jpg',2),(5,'assiette_1','assiette_1','image/restaurant/assiette.jpg',1),(6,'assiette_2','assiette_2','image/restaurant/assiette.jpg',2),(7,'serviette_1','serviette_1','image/restaurant/serviette.jpg',1),(8,'serviette_2','serviette_2','image/restaurant/serviette.jpg',2);
/*!40000 ALTER TABLE `equipement_restaurant` ENABLE KEYS */;

--
-- Table structure for table `equipement_spa`
--

DROP TABLE IF EXISTS `equipement_spa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipement_spa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `id_spa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_spa` (`id_spa`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipement_spa`
--

/*!40000 ALTER TABLE `equipement_spa` DISABLE KEYS */;
INSERT INTO `equipement_spa` VALUES (1,'pre_filtre_1','pre_filtre_1','image/spa/prefiltre.jpg',1),(2,'pre_filtre_2','pre_filtre_2','image/spa/prefiltre.jpg',2),(3,'générateur_de_brome_1','générateur_de_brome_1','image/spa/genbrome.jpg',1),(4,'générateur_de_brome_2','générateur_de_brome_2','image/spa/genbrome.jpg',2),(5,'boitier_wifi_1','boitier_wifi_1','image/spa/commandewifi.jpg',1),(6,'boitier_wifi_2','boitier_wifi_2','image/spa/commandewifi.jpg',2),(7,'moteur_1','moteur_1','image/spa/pumps.png',1),(8,'moteur_2','moteur_2','image/spa/pumps.png',2);
/*!40000 ALTER TABLE `equipement_spa` ENABLE KEYS */;

--
-- Table structure for table `facturation_assoc`
--

DROP TABLE IF EXISTS `facturation_assoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturation_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_reservation_spa` int(11) DEFAULT NULL,
  `id_client` int(11) NOT NULL,
  `id_facture` int(11) NOT NULL,
  `id_reservation_hotel` int(11) DEFAULT NULL,
  `id_reservation_restaurant` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_reservation` (`id_reservation_spa`),
  KEY `id_client` (`id_client`),
  KEY `id_facture` (`id_facture`),
  KEY `id_reservation_restaurant` (`id_reservation_restaurant`),
  KEY `id_reservation_hotel` (`id_reservation_hotel`),
  KEY `id_reservation_spa` (`id_reservation_spa`),
  KEY `id_reservation_hotel_2` (`id_reservation_hotel`),
  KEY `id_reservation_restaurant_2` (`id_reservation_restaurant`),
  KEY `id_reservation_spa_2` (`id_reservation_spa`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturation_assoc`
--

/*!40000 ALTER TABLE `facturation_assoc` DISABLE KEYS */;
INSERT INTO `facturation_assoc` VALUES (1,1,1,1,NULL,NULL),(2,2,2,2,NULL,NULL),(3,NULL,2,3,2,NULL),(4,NULL,2,4,2,NULL),(5,NULL,3,5,NULL,3),(6,NULL,4,6,NULL,3),(7,NULL,4,7,NULL,4),(8,NULL,5,8,NULL,4);
/*!40000 ALTER TABLE `facturation_assoc` ENABLE KEYS */;

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fichier` varchar(250) NOT NULL,
  `payee` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facture`
--

/*!40000 ALTER TABLE `facture` DISABLE KEYS */;
INSERT INTO `facture` VALUES (1,'facture/001-MrPerkins-Thomas.pdf',0),(2,'facture/002-Mme-Audet-Shelley.pdf',0),(3,'facture/003-Mme-Bassett-Margaret.pdf',0),(4,'facture/004-Mr-Stone-Kevin.pdf',0);
/*!40000 ALTER TABLE `facture` ENABLE KEYS */;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Menu_du_jour',20),(2,'Menu_à_25',25),(3,'Menu_à_35',35),(4,'Menu_à_45',45),(5,'Menu_à_75',75),(6,'Menu_découverte',80),(7,'Menu_dégustation',85),(8,'Menu_truffe',150);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

--
-- Table structure for table `menu_plat_assoc`
--

DROP TABLE IF EXISTS `menu_plat_assoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_plat_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_plat` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_plat_assoc_menu_id_fk` (`id_menu`),
  KEY `menu_plat_assoc_plat_id_fk` (`id_plat`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_plat_assoc`
--

/*!40000 ALTER TABLE `menu_plat_assoc` DISABLE KEYS */;
INSERT INTO `menu_plat_assoc` VALUES (1,1,1),(2,1,3),(3,2,1);
/*!40000 ALTER TABLE `menu_plat_assoc` ENABLE KEYS */;

--
-- Table structure for table `piece_de_rechange`
--

DROP TABLE IF EXISTS `piece_de_rechange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piece_de_rechange` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piece_de_rechange`
--

/*!40000 ALTER TABLE `piece_de_rechange` DISABLE KEYS */;
INSERT INTO `piece_de_rechange` VALUES (1,'moteur_spa',1500,2),(2,'vis',0.15,250),(3,'table_verre',2000,1),(4,'assiette',50,50),(5,'pre_filtre',120,10),(6,'cartouche_brome',30,20),(7,'ampoule',2,160),(8,'drap',100,50);
/*!40000 ALTER TABLE `piece_de_rechange` ENABLE KEYS */;

--
-- Table structure for table `plat`
--

DROP TABLE IF EXISTS `plat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  `type` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plat`
--

/*!40000 ALTER TABLE `plat` DISABLE KEYS */;
INSERT INTO `plat` VALUES (1,'Côte d’agneau Tandoori',20,NULL),(2,'Bar du Chili feuilleté sauce coréenne',35,NULL),(3,'Homard en salade à la sauce kimchi',15,NULL),(4,'Bar mariné citron jaune / basilic',10,NULL),(5,'Fraises Gariguettes en tarte sablée ',27,NULL),(6,'Gaspacho d’artichaut à l’orange, langoustines rôties',30,NULL),(7,'Homard poché au court bouillon',50,NULL),(8,'Oeuf de poule bio au manioc truffé & jus de maracudja ',80,NULL);
/*!40000 ALTER TABLE `plat` ENABLE KEYS */;

--
-- Table structure for table `plat_aliment_assoc`
--

DROP TABLE IF EXISTS `plat_aliment_assoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plat_aliment_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_plat` int(11) NOT NULL,
  `id_aliment` int(11) NOT NULL,
  `quantite` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_plat` (`id_plat`),
  KEY `id_aliment` (`id_aliment`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plat_aliment_assoc`
--

/*!40000 ALTER TABLE `plat_aliment_assoc` DISABLE KEYS */;
INSERT INTO `plat_aliment_assoc` VALUES (1,1,2,2),(2,1,1,2),(3,2,3,4);
/*!40000 ALTER TABLE `plat_aliment_assoc` ENABLE KEYS */;

--
-- Table structure for table `rapport`
--

DROP TABLE IF EXISTS `rapport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rapport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `description` varchar(250) NOT NULL,
  `id_demande_intervention` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_demande_intervention` (`id_demande_intervention`),
  KEY `id_demande_intervention_2` (`id_demande_intervention`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rapport`
--

/*!40000 ALTER TABLE `rapport` DISABLE KEYS */;
/*!40000 ALTER TABLE `rapport` ENABLE KEYS */;

--
-- Table structure for table `reservation_hotel`
--

DROP TABLE IF EXISTS `reservation_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_fin` date NOT NULL,
  `date_debut` date NOT NULL,
  `nb_enfants` int(11) NOT NULL DEFAULT '0',
  `nb_adultes` int(11) NOT NULL DEFAULT '0',
  `valide` tinyint(1) NOT NULL DEFAULT '0',
  `infos_complementaires` varchar(250) NOT NULL,
  `id_tva` int(11) NOT NULL,
  `id_chambre` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `formule` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_chambre` (`id_chambre`),
  KEY `id_tva` (`id_tva`),
  KEY `id_tva_2` (`id_tva`),
  KEY `id_chambre_2` (`id_chambre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_hotel`
--

/*!40000 ALTER TABLE `reservation_hotel` DISABLE KEYS */;
INSERT INTO `reservation_hotel` VALUES (1,'2017-07-14','2017-07-12',2,2,0,'',1,1,1,NULL),(2,'2017-06-15','2017-06-12',2,2,0,'',1,2,1,NULL),(3,'2017-08-17','2017-08-12',1,1,0,'',1,1,3,NULL),(4,'2017-07-18','2017-07-16',2,2,0,'',1,2,4,NULL),(5,'2017-08-21','2017-08-17',0,0,1,'',1,1,4,NULL),(6,'2017-06-17','2017-06-15',2,2,0,'',1,2,2,NULL),(7,'2017-07-12','2017-07-10',0,15,0,'',1,1,5,NULL),(8,'2017-08-29','2017-08-27',2,2,0,'',1,2,6,NULL);
/*!40000 ALTER TABLE `reservation_hotel` ENABLE KEYS */;

--
-- Table structure for table `reservation_restaurant`
--

DROP TABLE IF EXISTS `reservation_restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_arrivee` date NOT NULL,
  `date_depart` date NOT NULL,
  `id_tva` int(11) NOT NULL,
  `id_table` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tva` (`id_tva`),
  KEY `id_table` (`id_table`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_restaurant`
--

/*!40000 ALTER TABLE `reservation_restaurant` DISABLE KEYS */;
INSERT INTO `reservation_restaurant` VALUES (1,'2017-07-12','0000-00-00',1,1),(2,'2017-06-12','0000-00-00',1,2),(3,'2017-08-12','0000-00-00',1,1),(4,'2017-07-16','0000-00-00',1,2),(5,'2017-08-17','0000-00-00',1,1),(6,'2017-06-25','0000-00-00',1,2),(7,'2017-07-10','0000-00-00',1,1),(8,'2017-08-27','0000-00-00',1,2);
/*!40000 ALTER TABLE `reservation_restaurant` ENABLE KEYS */;

--
-- Table structure for table `reservation_spa`
--

DROP TABLE IF EXISTS `reservation_spa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_spa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_debut` date NOT NULL,
  `date_arrivee` date NOT NULL,
  `id_tva` int(11) NOT NULL,
  `id_spa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tva` (`id_tva`),
  KEY `id_spa` (`id_spa`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_spa`
--

/*!40000 ALTER TABLE `reservation_spa` DISABLE KEYS */;
INSERT INTO `reservation_spa` VALUES (1,'2017-07-12','2017-07-12',1,1),(2,'2017-06-12','2017-07-12',1,2),(3,'2017-08-12','2017-07-12',1,1),(4,'2017-07-16','2017-07-12',1,2),(5,'2017-08-17','2017-07-12',1,1),(6,'2017-06-25','2017-07-12',1,2),(7,'2017-07-10','2017-07-12',1,1),(8,'2017-08-27','2017-07-12',1,2);
/*!40000 ALTER TABLE `reservation_spa` ENABLE KEYS */;

--
-- Table structure for table `restaurant_assoc`
--

DROP TABLE IF EXISTS `restaurant_assoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_menu` int(11) DEFAULT NULL,
  `id_boisson` int(11) DEFAULT NULL,
  `id_plat` int(11) DEFAULT NULL,
  `id_reservation_restaurant` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_menu` (`id_menu`),
  KEY `id_boisson` (`id_boisson`),
  KEY `id_plat` (`id_plat`),
  KEY `id_reservation` (`id_reservation_restaurant`),
  KEY `id_reservation_restaurant` (`id_reservation_restaurant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_assoc`
--

/*!40000 ALTER TABLE `restaurant_assoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurant_assoc` ENABLE KEYS */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'direction'),(3,'loisir'),(4,'reception'),(5,'Responsable salle'),(6,'gouvernante'),(7,'maintenance'),(8,'cuisine');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

--
-- Table structure for table `spa`
--

DROP TABLE IF EXISTS `spa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spa`
--

/*!40000 ALTER TABLE `spa` DISABLE KEYS */;
INSERT INTO `spa` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8);
/*!40000 ALTER TABLE `spa` ENABLE KEYS */;

--
-- Table structure for table `table_restaurant`
--

DROP TABLE IF EXISTS `table_restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nbCouverts` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_restaurant`
--

/*!40000 ALTER TABLE `table_restaurant` DISABLE KEYS */;
INSERT INTO `table_restaurant` VALUES (1,2),(2,4),(3,3),(4,6),(5,4),(6,4),(7,2),(8,2);
/*!40000 ALTER TABLE `table_restaurant` ENABLE KEYS */;

--
-- Table structure for table `tva`
--

DROP TABLE IF EXISTS `tva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tva` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tva`
--

/*!40000 ALTER TABLE `tva` DISABLE KEYS */;
INSERT INTO `tva` VALUES (1,'BASE',20),(2,'ALIMENT',5);
/*!40000 ALTER TABLE `tva` ENABLE KEYS */;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(250) NOT NULL,
  `prenom` varchar(250) NOT NULL,
  `login` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_role` (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'Joan','tassel','joan','',1),(2,'Kevin','tro','kevtro','breton',1),(3,'Thibault','tmv','tmv','',1),(4,'BBB','BBB','bbb','',1),(5,'Thomas','Vincent','thv','',1),(6,'Directeur','hotel','hotel','root',2),(7,'Directeur','restaurant','resto','root',2),(8,'Directeur','spa','spa','root',2),(9,'a','a','a','a',3);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-23 17:33:40
