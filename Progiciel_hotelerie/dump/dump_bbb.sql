use hotel;
-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 27 Juin 2017 à 22:08
-- Version du serveur :  5.7.14
-- Version de PHP :  7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `hotel`
--

-- --------------------------------------------------------

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

-- --------------------------------------------------------

--
-- Structure de la table `aliment`
--

CREATE TABLE `aliment` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `aliment`
--

INSERT INTO `aliment` (`id`, `libelle`, `prix`) VALUES
(1, 'tomate', 0),
(2, 'salade', 0),
(3, 'oignon', 0),
(4, 'poireaux', 1),
(5, 'magret de canard', 20),
(6, 'truffe', 45),
(7, 'cote de boeuf', 25),
(8, 'foie gras', 15);

-- --------------------------------------------------------

--
-- Structure de la table `aliment_commande_assoc`
--

CREATE TABLE `aliment_commande_assoc` (
  `id` int(11) NOT NULL,
  `id_aliment` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `quantite` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `aliment_commande_assoc`
--

INSERT INTO `aliment_commande_assoc` (`id`, `id_aliment`, `id_commande`, `quantite`) VALUES
(1, 1, 1, 10),
(2, 1, 2, 20),
(3, 1, 3, 30),
(4, 2, 4, 5),
(5, 2, 5, 6),
(6, 2, 6, 120),
(7, 3, 1, 10),
(8, 3, 2, 8);

-- --------------------------------------------------------

--
-- Structure de la table `boisson`
--

CREATE TABLE `boisson` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `quantite` double NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `boisson`
--

INSERT INTO `boisson` (`id`, `libelle`, `quantite`, `prix`) VALUES
(1, 'coca-cola', 33, 3),
(2, 'limonade', 33, 3),
(3, 'sirop', 33, 3),
(4, 'Bière_demi', 33, 3),
(5, 'bière_pinte', 50, 6),
(6, 'vin', 75, 25),
(7, 'gin', 25, 10),
(8, 'whisky', 15, 10);

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `id` int(11) NOT NULL,
  `numero_chambre` int(11) NOT NULL,
  `prix` double NOT NULL,
  `capacite` int(11) NOT NULL,
  `etage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `chambre`
--

INSERT INTO `chambre` (`id`, `numero_chambre`, `prix`, `capacite`, `etage`) VALUES
(1, 1, 250, 4, 1),
(2, 2, 250, 4, 1),
(3, 3, 250, 4, 1),
(4, 4, 125, 2, 1),
(5, 5, 125, 2, 1),
(6, 6, 125, 2, 1),
(7, 7, 125, 2, 1),
(8, 8, 500, 8, 1),
(9, 9, 500, 8, 1),
(10, 10, 500, 8, 2),
(11, 11, 250, 4, 2),
(12, 12, 250, 4, 2),
(13, 13, 250, 4, 2),
(14, 14, 125, 2, 2),
(15, 15, 125, 2, 2),
(16, 16, 125, 2, 2),
(17, 17, 125, 2, 2),
(18, 18, 500, 8, 2),
(19, 19, 500, 8, 2),
(20, 20, 500, 8, 2),
(21, 21, 250, 4, 3),
(22, 22, 250, 4, 3),
(23, 23, 250, 4, 3),
(24, 24, 125, 2, 3),
(25, 25, 125, 2, 3),
(26, 26, 125, 2, 3),
(27, 27, 125, 2, 3),
(28, 28, 500, 8, 3),
(29, 29, 500, 8, 3),
(30, 30, 500, 8, 3);


-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(250) NOT NULL,
  `prenom` varchar(250) NOT NULL,
  `adresse_rue` varchar(250) NOT NULL,
  `adresse_ville` varchar(250) NOT NULL,
  `code_postal` varchar(20) NOT NULL,
  `telephone` varchar(25) NOT NULL,
  `date_naissance` date NOT NULL,
  `allergies` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `adresse_rue`, `adresse_ville`, `code_postal`, `telephone`, `date_naissance`, `allergies`) VALUES
(1, 'Perkins', 'Thomas', 'Lodewijk De Raetlaan 303', 'Clermont', '56505650', '0471786439', '1950-06-22', 'gluten'),
(2, 'Audet edit', 'Shelley edit', 'Blancefloerlaan 217 edit', 'Borsbeek edit', '2150 edit', '0481452833 edit', '1965-06-08', 'fruit de mer'),
(3, 'Bassett', 'Margaret', 'Ctra. Hornos, 54', 'Hormilla', '26223', '762309866', '1964-06-22', ''),
(4, 'Edwards', 'Kevin', 'Ctra. de Fuentenueva, 40', 'Fresnedillas de la Oliva', '28214', '0133224879', '1960-06-22', ''),
(5, 'Stone', 'Kelly', '84, Rue de Verdun', 'MONTFERMEIL', '93370', '0114864961', '1970-06-22', ''),
(6, 'Peters', 'Swen', '26, Place de la Madeleine', 'PARIS', '75009 ', '0225784936', '1968-06-22', ''),
(7, 'Schiffer', 'Uta', '1440 Peck Court', 'El Toro', 'CA 92630', '9495804455', '1960-06-22', 'féculent'),
(8, 'Balducci', 'Hanna', '2757 Timber Oak Drive', 'Montecito,', 'CA 93108', '8059696474', '1966-06-22', ''),
(11, 'Turman', 'Uma', '8 rue des Paillettes', 'Saint Peterzbourg', '69230', '06', '1978-06-04', 'gluthene'),
(12, 'Jean', 'Jouguy', '7 rue des steacks', 'Bouchela', '48777', '0211445587', '1999-06-14', 'Beure'),
(13, 'Jackson', 'Michel', '7 rue des blancs ,', 'Paris', ' ,  75001', '0145849658', '1945-06-14', 'Coca-Cola'),
(14, 'Super', 'Didier ', '5 rue de la Veille', 'Saint Lazarre', '69888', '0677841256', '1960-06-12', ''),
(15, 'Jonnas', 'Malcolm', '10 Avenue de la vache folle', 'Marly Gomont', '13002', '0155879501', '1960-06-14', ''),
(16, 'Briant', 'Danny', '10 rue Jean Moulin', 'St-Priest', '69800', '0605041666', '1960-06-13', 'Sel'),
(17, 'Lavoine', 'Marc', '25 rue Jean Moulin', 'St-Priest', '69800', '0658749854', '1980-12-15', ''),
(18, 'Brant', 'Mike', '4 rue du Virage', 'Nulpart-Sur-Aileur', '88752', '0648758395', '1986-04-03', ''),
(19, 'Moucha', 'Raser', '8 rue des coupures', 'Gilet', '76001', '0435675824', '1978-01-05', ''),
(20, 'Joachim', 'Boulastier', '8 rue des pleutres', 'Saint Moutarde', '33680', '0122548798', '1982-04-05', '');
-- --------------------------------------------------------

--
-- Structure de la table `client_agence_assoc`
--

CREATE TABLE `client_agence_assoc` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_agence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client_agence_assoc`
--

INSERT INTO `client_agence_assoc` (`id`, `id_client`, `id_agence`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 2, 2),
(5, 4, 2),
(6, 5, 2),
(7, 6, 3),
(8, 7, 3);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `date_commande` date NOT NULL,
  `prix_total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `commande_assoc`
--

CREATE TABLE `commande_assoc` (
  `id` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `id_equipement_restaurant` int(11) DEFAULT NULL,
  `quantite` double NOT NULL,
  `id_equipement_hotel` int(11) DEFAULT NULL,
  `id_equipement_spa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `commande_assoc`
--

INSERT INTO `commande_assoc` (`id`, `id_commande`, `id_equipement_restaurant`, `quantite`, `id_equipement_hotel`, `id_equipement_spa`) VALUES
(1, 1, 1, 10, NULL, NULL),
(2, 2, 2, 120, NULL, NULL),
(3, 2, NULL, 100, 1, NULL),
(4, 3, NULL, 70, 2, NULL),
(5, 3, NULL, 60, NULL, 1),
(6, 4, NULL, 50, NULL, 2),
(7, 5, 1, 30, NULL, NULL),
(8, 6, 1, 15, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `commande_piece_assoc`
--

CREATE TABLE `commande_piece_assoc` (
  `id` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `id_piece` int(11) NOT NULL,
  `quantite` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `commande_piece_assoc`
--

INSERT INTO `commande_piece_assoc` (`id`, `id_commande`, `id_piece`, `quantite`) VALUES
(1, 1, 1, 10),
(2, 2, 1, 20),
(3, 2, 2, 30),
(4, 2, 3, 40),
(5, 3, 5, 96),
(6, 3, 6, 18),
(7, 4, 7, 70),
(8, 5, 8, 53);

-- --------------------------------------------------------

--
-- Structure de la table `criticite`
--

CREATE TABLE `criticite` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `temps_maximum` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `criticite`
--

INSERT INTO `criticite` (`id`, `libelle`, `temps_maximum`) VALUES
(1, 'Très faible', '00:20:00'),
(2, 'Faible', '00:30:00'),
(3, 'Moyen', '01:00:00'),
(4, 'Haute', '01:30:00'),
(5, 'Très Haute', '02:00:00'),
(6, 'Critique', '02:30:00');

-- --------------------------------------------------------

--
-- Structure de la table `demande_intervention`
--

CREATE TABLE `demande_intervention` (
  `id` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `objet` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `valide` tinyint(1) NOT NULL,
  `id_criticite` int(11) NOT NULL,
  `id_equipement_spa` int(11) DEFAULT NULL,
  `id_equipement_hotel` int(11) DEFAULT NULL,
  `id_equipement_restaurant` int(11) DEFAULT NULL,
  `id_piece_rechange` int(11) DEFAULT NULL,
  `id_demandeur` int(11) NOT NULL,
  `id_etat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `demande_intervention`
--

INSERT INTO `demande_intervention` (`id`, `date_creation`, `objet`, `description`, `valide`, `id_criticite`, `id_equipement_spa`, `id_equipement_hotel`, `id_equipement_restaurant`, `id_piece_rechange`, `id_demandeur`, `id_etat`) VALUES
(1, '2017-07-12', 'réparation de la lampe', 'L\'ampoule est cassée', 0, 2, NULL, 1, NULL, 1, 2, 1),
(2, '2017-07-11', 'réparation de la table', 'Le pied ets bancal.', 1, 3, NULL, 2, NULL, 2, 1, 1),
(3, '2017-07-10', 'réparation de la douche', 'L\'eau ne coule plus', 0, 1, 3, NULL, NULL, 3, 1, 2),
(4, '2017-07-09', 'changement du frigo', 'Il ne fonctionne plus, le moteur est cassé', 1, 4, 4, NULL, NULL, 4, 8, 1),
(5, '2017-07-08', 'réparation de la cafetière', 'Il y a de la moisisure à l\'intérieur du filtre', 0, 6, NULL, NULL, 5, 5, 1, 3),
(6, '2017-07-07', 'réparation de la baignoire', 'La baignoire se vide toute seule', 1, 2, NULL, NULL, 6, 6, 1, 3),
(7, '2017-07-06', 'réparation de la fenêtre', 'La poignée est branlante', 0, 3, NULL, 5, NULL, 7, 9, 4),
(8, '2017-07-05', 'réparation de la vitre', 'Il y a un impact plus petit qu\'une pièce de deux euros', 1, 5, NULL, 4, NULL, 8, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `demande_utilisateur`
--

CREATE TABLE `demande_utilisateur` (
  `id` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_demande` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `demande_utilisateur`
--

INSERT INTO `demande_utilisateur` (`id`, `id_utilisateur`, `id_demande`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 2, 3),
(4, 3, 4),
(5, 4, 5),
(6, 4, 6),
(7, 5, 7),
(8, 8, 8);

-- --------------------------------------------------------

--
-- Structure de la table `droit`
--

CREATE TABLE `droit` (
  `id` int(11) NOT NULL,
  `code` varchar(10) NOT NULL,
  `description` varchar(250) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  `modifiable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `droit`
--

INSERT INTO `droit` (`id`, `code`, `description`, `visible`, `modifiable`) VALUES
(1, 'ADD', 'Droit d\'ajout', 1, 0),
(2, 'DELETE', 'Droit de suppression', 1, 0),
(3, 'WRITE_ONLY', 'Droit d\'écriture', 1, 0),
(4, 'READ_ONLY', 'Droit de lecture', 1, 0),
(5, 'READ_WRITE', 'Droit lecture/écriture', 1, 0),
(6, 'ALL', 'Droit d\'admin', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `droit_role_assoc`
--

CREATE TABLE `droit_role_assoc` (
  `id` int(11) NOT NULL,
  `id_droit` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `equipement_hotel`
--

CREATE TABLE `equipement_hotel` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `est_equipement_jardin` tinyint(1) NOT NULL DEFAULT '0',
  `id_chambre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `equipement_hotel`
--

INSERT INTO `equipement_hotel` (`id`, `libelle`, `description`, `photo`, `est_equipement_jardin`, `id_chambre`) VALUES
(1, 'lit_1', 'lit 1 place', 'image/hotel/lit_1.jpg', 1, 1),
(2, 'lit_2', 'lit 2 place', 'image/hotel/lit_2_place.jpg', 0, 1),
(3, 'table', 'table en verre', 'image/hotel/table_verre.jpg', 0, 2),
(4, 'lampe', 'lampe de chevet', 'image/hotel/lampe.jpg', 0, 3),
(5, 'table_de_chevet', 'gueridon', 'image/hotel/table_chevet.jpg', 0, 4),
(6, 'frigo', 'mini bar', 'image/hotel/table_chevet.jpg', 0, 2),
(7, 'rideaux', 'rideaux en soie', 'image/hotel/rideau.jpg', 0, 3),
(8, 'canapé', 'canapé cuir blanc', 'image/hotel/canape.jpg', 0, 3);

-- --------------------------------------------------------

--
-- Structure de la table `equipement_restaurant`
--

CREATE TABLE `equipement_restaurant` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `id_table` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `equipement_restaurant`
--

INSERT INTO `equipement_restaurant` (`id`, `libelle`, `description`, `photo`, `id_table`) VALUES
(1, 'verre_1', 'verre_1', 'image/restaurant/verre_default.jpg', 1),
(2, 'verre_2', 'verre_2', 'image/restaurant/verre_default.jpg', 2),
(3, 'couverts_1', 'couverts_1', 'image/restaurant/assiette.jpg', 1),
(4, 'couverts_2', 'couverts_2', 'image/restaurant/assiette.jpg', 2),
(5, 'assiette_1', 'assiette_1', 'image/restaurant/assiette.jpg', 1),
(6, 'assiette_2', 'assiette_2', 'image/restaurant/assiette.jpg', 2),
(7, 'serviette_1', 'serviette_1', 'image/restaurant/serviette.jpg', 1),
(8, 'serviette_2', 'serviette_2', 'image/restaurant/serviette.jpg', 2);

-- --------------------------------------------------------

--
-- Structure de la table `equipement_spa`
--

CREATE TABLE `equipement_spa` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `id_spa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `equipement_spa`
--

INSERT INTO `equipement_spa` (`id`, `libelle`, `description`, `photo`, `id_spa`) VALUES
(1, 'pre_filtre_1', 'pre_filtre_1', 'image/spa/prefiltre.jpg', 1),
(2, 'pre_filtre_2', 'pre_filtre_2', 'image/spa/prefiltre.jpg', 2),
(3, 'générateur_de_brome_1', 'générateur_de_brome_1', 'image/spa/genbrome.jpg', 1),
(4, 'générateur_de_brome_2', 'générateur_de_brome_2', 'image/spa/genbrome.jpg', 2),
(5, 'boitier_wifi_1', 'boitier_wifi_1', 'image/spa/commandewifi.jpg', 1),
(6, 'boitier_wifi_2', 'boitier_wifi_2', 'image/spa/commandewifi.jpg', 2),
(7, 'moteur_1', 'moteur_1', 'image/spa/pumps.png', 1),
(8, 'moteur_2', 'moteur_2', 'image/spa/pumps.png', 2);

-- --------------------------------------------------------

--
-- Structure de la table `etat`
--

CREATE TABLE `etat` (
  `id` int(11) NOT NULL,
  `libelle` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etat`
--

INSERT INTO `etat` (`id`, `libelle`) VALUES
(1, 'Prise de connaissance'),
(2, 'En cours'),
(3, 'A valider'),
(4, 'Clôturer');

-- --------------------------------------------------------

--
-- Structure de la table `facturation_assoc`
--

CREATE TABLE `facturation_assoc` (
  `id` int(11) NOT NULL,
  `id_reservation_spa` int(11) DEFAULT NULL,
  `id_client` int(11) NOT NULL,
  `id_facture` int(11) NOT NULL,
  `id_reservation_hotel` int(11) DEFAULT NULL,
  `id_reservation_restaurant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `facturation_assoc`
--

INSERT INTO `facturation_assoc` (`id`, `id_reservation_spa`, `id_client`, `id_facture`, `id_reservation_hotel`, `id_reservation_restaurant`) VALUES
(1, 1, 1, 1, NULL, NULL),
(2, 2, 2, 2, NULL, NULL),
(3, NULL, 2, 3, 2, NULL),
(4, NULL, 2, 4, 2, NULL),
(5, NULL, 3, 5, NULL, 3),
(6, NULL, 4, 6, NULL, 3),
(7, NULL, 4, 7, NULL, 4),
(8, NULL, 5, 8, NULL, 4);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id` int(11) NOT NULL,
  `fichier` varchar(250) NOT NULL,
  `payee` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `facture`
--

INSERT INTO `facture` (`id`, `fichier`, `payee`) VALUES
(1, 'facture/001-MrPerkins-Thomas.pdf', 0),
(2, 'facture/002-Mme-Audet-Shelley.pdf', 0),
(3, 'facture/003-Mme-Bassett-Margaret.pdf', 0),
(4, 'facture/004-Mr-Stone-Kevin.pdf', 0);

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `menu`
--

INSERT INTO `menu` (`id`, `libelle`, `prix`) VALUES
(1, 'Menu_du_jour', 20),
(2, 'Menu_à_25', 25),
(3, 'Menu_à_35', 35),
(4, 'Menu_à_45', 45),
(5, 'Menu_à_75', 75),
(6, 'Menu_découverte', 80),
(7, 'Menu_dégustation', 85),
(8, 'Menu_truffe', 150);

-- --------------------------------------------------------

--
-- Structure de la table `piece_de_rechange`
--

CREATE TABLE `piece_de_rechange` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `piece_de_rechange`
--

INSERT INTO `piece_de_rechange` (`id`, `libelle`, `prix`, `quantite`) VALUES
(1, 'moteur_spa', 1500, 2),
(2, 'vis', 0.15, 250),
(3, 'table_verre', 2000, 1),
(4, 'assiette', 50, 50),
(5, 'pre_filtre', 120, 10),
(6, 'cartouche_brome', 30, 20),
(7, 'ampoule', 2, 160),
(8, 'drap', 100, 50);

-- --------------------------------------------------------

--
-- Structure de la table `plat`
--

CREATE TABLE `plat` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `plat`
--

INSERT INTO `plat` (`id`, `libelle`, `prix`) VALUES
(1, 'Côte d’agneau Tandoori', 20),
(2, 'Bar du Chili feuilleté sauce coréenne', 35),
(3, 'Homard en salade à la sauce kimchi', 15),
(4, 'Bar mariné citron jaune / basilic', 10),
(5, 'Fraises Gariguettes en tarte sablée ', 27),
(6, 'Gaspacho d’artichaut à l’orange, langoustines rôties', 30),
(7, 'Homard poché au court bouillon', 50),
(8, 'Oeuf de poule bio au manioc truffé & jus de maracudja ', 80);

-- --------------------------------------------------------

--
-- Structure de la table `plat_aliment_assoc`
--

CREATE TABLE `plat_aliment_assoc` (
  `id` int(11) NOT NULL,
  `id_plat` int(11) NOT NULL,
  `id_aliment` int(11) NOT NULL,
  `quantite` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `rapport`
--

CREATE TABLE `rapport` (
  `id` int(11) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `description` varchar(250) NOT NULL,
  `id_demande_intervention` int(11) NOT NULL,
  `id_technicien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `rapport`
--

INSERT INTO `rapport` (`id`, `date_debut`, `date_fin`, `description`, `id_demande_intervention`, `id_technicien`) VALUES
(1, '2017-06-26', '2017-06-30', 'avancement des travaux...', 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `reservation_hotel`
--

CREATE TABLE `reservation_hotel` (
  `id` int(11) NOT NULL,
  `date_fin` date NOT NULL,
  `date_debut` date NOT NULL,
  `nb_enfants` int(11) NOT NULL DEFAULT '0',
  `nb_adultes` int(11) NOT NULL DEFAULT '0',
  `valide` tinyint(1) NOT NULL DEFAULT '0',
  `infos_complementaires` varchar(250) NOT NULL,
  `formule` int(11) NOT NULL DEFAULT '0',
  `id_tva` int(11) NOT NULL,
  `id_chambre` int(11) NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `reservation_hotel`
--

INSERT INTO `reservation_hotel` (`id`, `date_fin`, `date_debut`, `nb_enfants`, `nb_adultes`, `valide`, `infos_complementaires`, `formule`, `id_tva`, `id_chambre`, `id_client`) VALUES
(1, '2017-07-14', '2017-07-12', 1, 1, 0, 'test', 2, 1, 2, 6),
(2, '2017-06-24', '2017-06-12', 2, 2, 0, '', 0, 1, 1, 1),
(3, '2017-08-17', '2017-08-12', 1, 1, 0, '', 0, 1, 1, 3),
(4, '2017-07-18', '2017-07-16', 2, 2, 0, '', 0, 1, 2, 4),
(5, '2017-08-21', '2017-08-17', 0, 0, 1, '', 0, 1, 1, 4),
(6, '2017-06-17', '2017-06-15', 2, 2, 0, '', 0, 1, 2, 2),
(7, '2017-07-12', '2017-07-10', 0, 15, 0, '', 0, 1, 1, 5),
(8, '2017-08-29', '2017-08-27', 0, 0, 0, '', 2, 1, 2, 6);

-- --------------------------------------------------------

--
-- Structure de la table `reservation_restaurant`
--

CREATE TABLE `reservation_restaurant` (
  `id` int(11) NOT NULL,
  `date_arrivee` date NOT NULL,
  `date_depart` date NOT NULL,
  `id_tva` int(11) NOT NULL,
  `id_table` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `reservation_restaurant`
--

INSERT INTO `reservation_restaurant` (`id`, `date_arrivee`, `date_depart`, `id_tva`, `id_table`) VALUES
(1, '2017-07-12', '0000-00-00', 1, 1),
(2, '2017-06-12', '0000-00-00', 1, 2),
(3, '2017-08-12', '0000-00-00', 1, 1),
(4, '2017-07-16', '0000-00-00', 1, 2),
(5, '2017-08-17', '0000-00-00', 1, 1),
(6, '2017-06-25', '0000-00-00', 1, 2),
(7, '2017-07-10', '0000-00-00', 1, 1),
(8, '2017-08-27', '0000-00-00', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `reservation_spa`
--

CREATE TABLE `reservation_spa` (
  `id` int(11) NOT NULL,
  `date_debut` date NOT NULL,
  `date_arrivee` date NOT NULL,
  `id_tva` int(11) NOT NULL,
  `id_spa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `reservation_spa`
--

INSERT INTO `reservation_spa` (`id`, `date_debut`, `date_arrivee`, `id_tva`, `id_spa`) VALUES
(1, '2017-07-12', '2017-07-12', 1, 1),
(2, '2017-06-12', '2017-07-12', 1, 2),
(3, '2017-08-12', '2017-07-12', 1, 1),
(4, '2017-07-16', '2017-07-12', 1, 2),
(5, '2017-08-17', '2017-07-12', 1, 1),
(6, '2017-06-25', '2017-07-12', 1, 2),
(7, '2017-07-10', '2017-07-12', 1, 1),
(8, '2017-08-27', '2017-07-12', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `restaurant_assoc`
--

CREATE TABLE `restaurant_assoc` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) DEFAULT NULL,
  `id_boisson` int(11) DEFAULT NULL,
  `id_plat` int(11) DEFAULT NULL,
  `id_reservation_restaurant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`id`, `libelle`) VALUES
(1, 'Admin'),
(2, 'Direction'),
(3, 'Hébergement'),
(4, 'Réception'),
(5, 'Restaurant'),
(6, 'Spa'),
(7, 'Maintenance'),
(8, 'Entretien');

-- --------------------------------------------------------

--
-- Structure de la table `spa`
--

CREATE TABLE `spa` (
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `spa`
--

INSERT INTO `spa` (`id`, `numero`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8);

-- --------------------------------------------------------

--
-- Structure de la table `table_restaurant`
--

CREATE TABLE `table_restaurant` (
  `id` int(11) NOT NULL,
  `nbCouverts` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `table_restaurant`
--

INSERT INTO `table_restaurant` (`id`, `nbCouverts`) VALUES
(1, 2),
(2, 4),
(3, 3),
(4, 6),
(5, 4),
(6, 4),
(7, 2),
(8, 2);

-- --------------------------------------------------------

--
-- Structure de la table `tva`
--

CREATE TABLE `tva` (
  `id` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `tva`
--

INSERT INTO `tva` (`id`, `libelle`, `prix`) VALUES
(1, 'BASE', 20),
(2, 'ALIMENT', 5);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(250) NOT NULL,
  `prenom` varchar(250) NOT NULL,
  `login` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `login`, `password`, `id_role`) VALUES
(1, 'fdp', 'j', 'j', 'j', 1),
(2, 'Troadec', 'Kevin', 'kevtro', 'breton', 1),
(3, 'Thibault', 'tmv', 'tmv', 'tmv', 1),
(4, 'Boulad', 'B', 'b', 'b', 7),
(5, 'Thomas', 'Vincent', 'thv', '', 1),
(6, 'Richard', 'hotel', 'direction', 'a', 2),
(7, 'Michael', 'restaurant', 'restaurant', 'a', 5),
(8, 'Michel', 'spa', 'spa', 'a', 6),
(9, 'Antoni', 'hebergement', 'hebergement', 'a', 3),
(10, 'Marjorie', 'maintenance', 'maintenance', 'a', 7),
(11, 'Pénéloppe', 'reception', 'reception', 'a', 4),
(12, 'Danatol', 'entretien', 'entretien', 'a', 8);

--
-- Index pour les tables exportées
--

# --
# -- Index pour la table `agence`
# --
# ALTER TABLE `agence`
#   ADD PRIMARY KEY (`id`);

--
-- Index pour la table `aliment`
--
ALTER TABLE `aliment`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `aliment_commande_assoc`
--
ALTER TABLE `aliment_commande_assoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aliment` (`id_aliment`),
  ADD KEY `id_commande` (`id_commande`);

--
-- Index pour la table `boisson`
--
ALTER TABLE `boisson`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero_chambre` (`numero_chambre`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client_agence_assoc`
--
ALTER TABLE `client_agence_assoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_agence` (`id_agence`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande_assoc`
--
ALTER TABLE `commande_assoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_commande` (`id_commande`),
  ADD KEY `id_equipement` (`id_equipement_restaurant`),
  ADD KEY `id_equipement_hotel` (`id_equipement_hotel`),
  ADD KEY `id_equipement_spa` (`id_equipement_spa`);

--
-- Index pour la table `commande_piece_assoc`
--
ALTER TABLE `commande_piece_assoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_commande` (`id_commande`),
  ADD KEY `id_piece` (`id_piece`);

--
-- Index pour la table `criticite`
--
ALTER TABLE `criticite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `demande_intervention`
--
ALTER TABLE `demande_intervention`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_piece_rechange` (`id_piece_rechange`),
  ADD KEY `id_equipement_restaurant` (`id_equipement_restaurant`),
  ADD KEY `id_equipement_hotel` (`id_equipement_hotel`),
  ADD KEY `id_equipement_spa` (`id_equipement_spa`),
  ADD KEY `id_criticite` (`id_criticite`),
  ADD KEY `id_demandeur` (`id_demandeur`),
  ADD KEY `id_etat` (`id_etat`);

--
-- Index pour la table `demande_utilisateur`
--
ALTER TABLE `demande_utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_utilisateur` (`id_utilisateur`),
  ADD KEY `id_demande` (`id_demande`);

--
-- Index pour la table `droit`
--
ALTER TABLE `droit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `droit_role_assoc`
--
ALTER TABLE `droit_role_assoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_droit` (`id_droit`),
  ADD KEY `id_role` (`id_role`);

--
-- Index pour la table `equipement_hotel`
--
ALTER TABLE `equipement_hotel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_chambre` (`id_chambre`);

--
-- Index pour la table `equipement_restaurant`
--
ALTER TABLE `equipement_restaurant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_table` (`id_table`);

--
-- Index pour la table `equipement_spa`
--
ALTER TABLE `equipement_spa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_spa` (`id_spa`);

--
-- Index pour la table `etat`
--
ALTER TABLE `etat`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facturation_assoc`
--
ALTER TABLE `facturation_assoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_reservation` (`id_reservation_spa`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_facture` (`id_facture`),
  ADD KEY `id_reservation_restaurant` (`id_reservation_restaurant`),
  ADD KEY `id_reservation_hotel` (`id_reservation_hotel`),
  ADD KEY `id_reservation_spa` (`id_reservation_spa`),
  ADD KEY `id_reservation_hotel_2` (`id_reservation_hotel`),
  ADD KEY `id_reservation_restaurant_2` (`id_reservation_restaurant`),
  ADD KEY `id_reservation_spa_2` (`id_reservation_spa`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `piece_de_rechange`
--
ALTER TABLE `piece_de_rechange`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `plat`
--
ALTER TABLE `plat`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `plat_aliment_assoc`
--
ALTER TABLE `plat_aliment_assoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_plat` (`id_plat`),
  ADD KEY `id_aliment` (`id_aliment`);

--
-- Index pour la table `rapport`
--
ALTER TABLE `rapport`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_demande_intervention` (`id_demande_intervention`),
  ADD KEY `id_demande_intervention_2` (`id_demande_intervention`),
  ADD KEY `technicien` (`id_technicien`);

--
-- Index pour la table `reservation_hotel`
--
ALTER TABLE `reservation_hotel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_chambre` (`id_chambre`),
  ADD KEY `id_tva` (`id_tva`),
  ADD KEY `id_tva_2` (`id_tva`),
  ADD KEY `id_chambre_2` (`id_chambre`);

--
-- Index pour la table `reservation_restaurant`
--
ALTER TABLE `reservation_restaurant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tva` (`id_tva`),
  ADD KEY `id_table` (`id_table`);

--
-- Index pour la table `reservation_spa`
--
ALTER TABLE `reservation_spa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tva` (`id_tva`),
  ADD KEY `id_spa` (`id_spa`);

--
-- Index pour la table `restaurant_assoc`
--
ALTER TABLE `restaurant_assoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_menu` (`id_menu`),
  ADD KEY `id_boisson` (`id_boisson`),
  ADD KEY `id_plat` (`id_plat`),
  ADD KEY `id_reservation` (`id_reservation_restaurant`),
  ADD KEY `id_reservation_restaurant` (`id_reservation_restaurant`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `spa`
--
ALTER TABLE `spa`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `table_restaurant`
--
ALTER TABLE `table_restaurant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tva`
--
ALTER TABLE `tva`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_role` (`id_role`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agence`
# --
# ALTER TABLE `agence`
#   MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `aliment`
--
ALTER TABLE `aliment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `aliment_commande_assoc`
--
ALTER TABLE `aliment_commande_assoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `boisson`
--
ALTER TABLE `boisson`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `client_agence_assoc`
--
ALTER TABLE `client_agence_assoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `commande_assoc`
--
ALTER TABLE `commande_assoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `commande_piece_assoc`
--
ALTER TABLE `commande_piece_assoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `criticite`
--
ALTER TABLE `criticite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `demande_intervention`
--
ALTER TABLE `demande_intervention`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `demande_utilisateur`
--
ALTER TABLE `demande_utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `droit`
--
ALTER TABLE `droit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `droit_role_assoc`
--
ALTER TABLE `droit_role_assoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `equipement_hotel`
--
ALTER TABLE `equipement_hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `equipement_restaurant`
--
ALTER TABLE `equipement_restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `equipement_spa`
--
ALTER TABLE `equipement_spa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `etat`
--
ALTER TABLE `etat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `facturation_assoc`
--
ALTER TABLE `facturation_assoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `piece_de_rechange`
--
ALTER TABLE `piece_de_rechange`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `plat`
--
ALTER TABLE `plat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `plat_aliment_assoc`
--
ALTER TABLE `plat_aliment_assoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `rapport`
--
ALTER TABLE `rapport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `reservation_hotel`
--
ALTER TABLE `reservation_hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `reservation_restaurant`
--
ALTER TABLE `reservation_restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `reservation_spa`
--
ALTER TABLE `reservation_spa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `restaurant_assoc`
--
ALTER TABLE `restaurant_assoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `spa`
--
ALTER TABLE `spa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `table_restaurant`
--
ALTER TABLE `table_restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `tva`
--
ALTER TABLE `tva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `demande_intervention`
--
ALTER TABLE `demande_intervention`
  ADD CONSTRAINT `fk_demandeur` FOREIGN KEY (`id_demandeur`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_etat` FOREIGN KEY (`id_etat`) REFERENCES `etat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rapport`
--
ALTER TABLE `rapport`
  ADD CONSTRAINT `fk_demande` FOREIGN KEY (`id_demande_intervention`) REFERENCES `demande_intervention` (`id`),
  ADD CONSTRAINT `fk_technicien` FOREIGN KEY (`id_technicien`) REFERENCES `utilisateur` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
