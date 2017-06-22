DROP DATABASE IF EXISTS hotel;
CREATE DATABASE hotel;
USE hotel;


-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 17 Juin 2017 à 23:12
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `hotel`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE IF NOT EXISTS `agence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(250) NOT NULL,
  `telephone` int(10) NOT NULL,
  `email` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `agence`
--

INSERT INTO `agence` (`id`, `nom`, `telephone`, `email`) VALUES
(1, 'AZUR_DIFFUSION', 675621538, 'azur_diffusion@gmail.com'),
(2, 'CAPITAL EVASION', 698585463, 'capital_evasion@gmail.com'),
(3, 'SUD EVASION', 612365485, 'sud_evasion@gmail.com'),
(4, 'EURO MER AVIGNON', 645695874, 'euro_mer@gmail.com'),
(5, 'SOLOWAYS', 605238759, 'soloways@gmail.com'),
(6, 'SELECTOUR MASSILIA VOYAGES', 698811311, 'selectour@gmail.com'),
(7, 'Move Around Provence', 629424352, 'move@gmail.com'),
(8, 'CLUB MED', 621252635, 'club_med@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `aliment`
--

CREATE TABLE IF NOT EXISTS `aliment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `aliment_commande_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_aliment` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `quantite` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_aliment` (`id_aliment`),
  KEY `id_commande` (`id_commande`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `boisson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `quantite` double NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `chambre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_chambre` int(11) NOT NULL,
  `prix` double NOT NULL,
  `capacite` int(11) NOT NULL,
  `etage` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_chambre` (`numero_chambre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `chambre`
--

INSERT INTO `chambre` (`id`, `numero_chambre`, `prix`, `capacite`, `etage`) VALUES
(1, 1, 55, 4, 1),
(2, 2, 45, 2, 1),
(3, 3, 65, 2, 2),
(4, 4, 80, 4, 2),
(5, 5, 75, 2, 3),
(6, 6, 85, 4, 3),
(7, 7, 145, 2, 4),
(8, 8, 330, 4, 4);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `adresse_rue`, `adresse_ville`, `code_postal`, `telephone`, `date_naissance`, `allergies`) VALUES
(1, 'Perkins', 'Thomas', 'Lodewijk De Raetlaan 303', 'Clermont', '56505650', '0471786439', '2017-06-22', 'gluten'),
(2, 'Audet edit', 'Shelley edit', 'Blancefloerlaan 217 edit', 'Borsbeek edit', '2150 edit', '0481452833 edit', '2017-06-08', 'fruit de mer edit'),
(3, 'Bassett', 'Margaret', 'Ctra. Hornos, 54', 'Hormilla', '26223', '762309866', '2017-06-22', ''),
(4, 'Edwards', 'Kevin', 'Ctra. de Fuentenueva, 40', 'Fresnedillas de la Oliva', '28214', '727467873', '2017-06-22', ''),
(5, 'Stone', 'Kelly', '84, Rue de Verdun', 'MONTFERMEIL', '93370', '0114864961', '2017-06-22', ''),
(6, 'Peters', 'Swen', '26, Place de la Madeleine', 'PARIS', '75009 ', '0225784936', '2017-06-22', ''),
(7, 'Schiffer', 'Uta', '1440 Peck Court', 'El Toro', 'CA 92630', '9495804455', '2017-06-22', 'féculent'),
(8, 'Balducci', 'Hanna', '2757 Timber Oak Drive', 'Montecito,', 'CA 93108', '8059696474', '2017-06-22', ''),
(11, 'nom', 'prenom', 'adresse', 'ville', '69230', '06', '2017-06-04', 'allergique au gluthene');

-- --------------------------------------------------------

--
-- Structure de la table `client_agence_assoc`
--

CREATE TABLE IF NOT EXISTS `client_agence_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `id_agence` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_client` (`id_client`),
  KEY `id_agence` (`id_agence`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_commande` date NOT NULL,
  `prix_total` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `commande_assoc`
--

CREATE TABLE IF NOT EXISTS `commande_assoc` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `commande_piece_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_commande` int(11) NOT NULL,
  `id_piece` int(11) NOT NULL,
  `quantite` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_commande` (`id_commande`),
  KEY `id_piece` (`id_piece`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `criticite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `temps_maximum` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `criticite`
--

INSERT INTO `criticite` (`id`, `libelle`, `temps_maximum`) VALUES
(1, 'trés_faible', '00:20:00'),
(2, 'faible', '00:30:00'),
(3, 'moyen', '01:00:00'),
(4, 'haute', '01:30:00'),
(5, 'trés haute', '02:00:00'),
(6, 'critique', '02:30:00');

-- --------------------------------------------------------

--
-- Structure de la table `demande_intervention`
--

CREATE TABLE IF NOT EXISTS `demande_intervention` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `demande_intervention`
--

INSERT INTO `demande_intervention` (`id`, `date_creation`, `objet`, `description`, `valide`, `id_criticite`, `id_equipement_spa`, `id_equipement_hotel`, `id_equipement_restaurant`, `id_piece_rechange`) VALUES
(1, '2017-07-12', 'réparation de la lampe', 'description', 0, 2, NULL, 1, NULL, 1),
(2, '2017-07-11', 'réparation de la table', 'description', 1, 3, NULL, 2, NULL, 2),
(3, '2017-07-10', 'réparation de la douche', 'description', 0, 1, 3, NULL, NULL, 3),
(4, '2017-07-09', 'changement du frigo', 'description', 1, 4, 4, NULL, NULL, 4),
(5, '2017-07-08', 'réparation de la cafetière', 'description', 0, 6, NULL, NULL, 5, 5),
(6, '2017-07-07', 'réparation de la baignoire', 'description', 1, 2, NULL, NULL, 6, 6),
(7, '2017-07-06', 'réparation de la fenêtre', 'description', 0, 3, NULL, 5, NULL, 7),
(8, '2017-07-05', 'réparation de la vitre', 'description', 1, 5, NULL, 4, NULL, 8);

-- --------------------------------------------------------

--
-- Structure de la table `demande_utilisateur`
--

CREATE TABLE IF NOT EXISTS `demande_utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int(11) NOT NULL,
  `id_demande` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_demande` (`id_demande`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `droit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `description` varchar(250) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  `modifiable` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `droit`
--

INSERT INTO `droit` (`id`, `code`, `description`, `visible`, `modifiable`) VALUES
(1, 'ADD', 'Droit d''ajout', 1, 0),
(2, 'DELETE', 'Droit de suppression', 1, 0),
(3, 'WRITE_ONLY', 'Droit d''écriture', 1, 0),
(4, 'READ_ONLY', 'Droit de lecture', 1, 0),
(5, 'READ_WRITE', 'Droit lecture/écriture', 1, 0),
(6, 'ALL', 'Droit d''admin', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `droit_role_assoc`
--

CREATE TABLE IF NOT EXISTS `droit_role_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_droit` int(11) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_droit` (`id_droit`),
  KEY `id_role` (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `equipement_hotel`
--

CREATE TABLE IF NOT EXISTS `equipement_hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `est_equipement_jardin` tinyint(1) NOT NULL DEFAULT '0',
  `id_chambre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_chambre` (`id_chambre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `equipement_hotel`
--

INSERT INTO `equipement_hotel` (`id`, `libelle`, `description`, `photo`, `est_equipement_jardin`, `id_chambre`) VALUES
(1, 'lit_1', 'lit 1 place', 'image/hotel/lit_1.jpg', 0, 1),
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

CREATE TABLE IF NOT EXISTS `equipement_restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `id_table` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_table` (`id_table`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `equipement_spa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `id_spa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_spa` (`id_spa`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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
-- Structure de la table `facturation_assoc`
--

CREATE TABLE IF NOT EXISTS `facturation_assoc` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fichier` varchar(250) NOT NULL,
  `payee` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

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

CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `piece_de_rechange` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `plat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `plat_aliment_assoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_plat` int(11) NOT NULL,
  `id_aliment` int(11) NOT NULL,
  `quantite` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_plat` (`id_plat`),
  KEY `id_aliment` (`id_aliment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `rapport`
--

CREATE TABLE IF NOT EXISTS `rapport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `description` varchar(250) NOT NULL,
  `id_demande_intervention` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_demande_intervention` (`id_demande_intervention`),
  KEY `id_demande_intervention_2` (`id_demande_intervention`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `reservation_hotel`
--

CREATE TABLE IF NOT EXISTS `reservation_hotel` (
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
  PRIMARY KEY (`id`),
  KEY `id_chambre` (`id_chambre`),
  KEY `id_tva` (`id_tva`),
  KEY `id_tva_2` (`id_tva`),
  KEY `id_chambre_2` (`id_chambre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `reservation_hotel`
--

INSERT INTO `reservation_hotel` (`id`, `date_fin`, `date_debut`, `nb_enfants`, `nb_adultes`, `valide`, `infos_complementaires`, `id_tva`, `id_chambre`, `id_client`) VALUES
(1, '2017-07-14', '2017-07-12', 2, 2, 0, '', 1, 1, 1),
(2, '2017-06-15', '2017-06-12', 2, 2, 0, '', 1, 2, 1),
(3, '2017-08-17', '2017-08-12', 1, 1, 0, '', 1, 1, 3),
(4, '2017-07-18', '2017-07-16', 2, 2, 0, '', 1, 2, 4),
(5, '2017-08-21', '2017-08-17', 0, 0, 1, '', 1, 1, 4),
(6, '2017-06-17', '2017-06-15', 2, 2, 0, '', 1, 2, 2),
(7, '2017-07-12', '2017-07-10', 0, 15, 0, '', 1, 1, 5),
(8, '2017-08-29', '2017-08-27', 2, 2, 0, '', 1, 2, 6);

-- --------------------------------------------------------

--
-- Structure de la table `reservation_restaurant`
--

CREATE TABLE IF NOT EXISTS `reservation_restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_arrivee` date NOT NULL,
  `date_depart` date NOT NULL,
  `id_tva` int(11) NOT NULL,
  `id_table` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tva` (`id_tva`),
  KEY `id_table` (`id_table`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `reservation_spa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_debut` date NOT NULL,
  `date_arrivee` date NOT NULL,
  `id_tva` int(11) NOT NULL,
  `id_spa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tva` (`id_tva`),
  KEY `id_spa` (`id_spa`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `restaurant_assoc` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`id`, `libelle`) VALUES
(1, 'admin'),
(2, 'direction'),
(3, 'loisir'),
(4, 'reception'),
(5, 'Responsable salle'),
(6, 'gouvernante'),
(7, 'maintenance'),
(8, 'cuisine');

-- --------------------------------------------------------

--
-- Structure de la table `spa`
--

CREATE TABLE IF NOT EXISTS `spa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `table_restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nbCouverts` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `tva` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

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

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(250) NOT NULL,
  `prenom` varchar(250) NOT NULL,
  `login` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_role` (`id_role`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `login`, `password`, `id_role`) VALUES
(1, 'Joan', 'tassel', 'joan', '', 1),
(2, 'Kevin', 'tro', 'kevtro', 'breton', 1),
(3, 'Thibault', 'tmv', 'tmv', '', 1),
(4, 'BBB', 'BBB', 'bbb', '', 1),
(5, 'Thomas', 'Vincent', 'thv', '', 1),
(6, 'Directeur', 'hotel', 'hotel', 'root', 2),
(7, 'Directeur', 'restaurant', 'resto', 'root', 2),
(8, 'Directeur', 'spa', 'spa', 'root', 2),
(9, 'a', 'a', 'a', 'a', 3);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
