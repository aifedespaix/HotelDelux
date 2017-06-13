DROP DATABASE IF EXISTS hotel;
SET foreign_key_checks = 0;
CREATE DATABASE hotel;
USE hotel;

-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 17 Mai 2017 à 13:18
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `db_finale`
--
DROP SCHEMA  IF EXISTS Hotel;
CREATE SCHEMA  Hotel;
use Hotel;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `aliment`
--

CREATE TABLE IF NOT EXISTS `aliment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE IF NOT EXISTS `chambre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prix_adulte` double NOT NULL,
  `prix_enfant` double NOT NULL,
  `capacite` int(11) NOT NULL,
  `etage` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
  `allergies` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `criticite`
--

CREATE TABLE IF NOT EXISTS `criticite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `temps_maximum` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
  `id_chambre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_chambre` (`id_chambre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `equipement_restaurant`
--

CREATE TABLE IF NOT EXISTS `equipement_restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `id_table` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_table` (`id_table`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fichier` varchar(250) NOT NULL,
  `payee` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `plat`
--

CREATE TABLE IF NOT EXISTS `plat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
  `date_arrivee` date NOT NULL,
  `date_debut` date NOT NULL,
  `id_tva` int(11) NOT NULL,
  `id_chambre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_chambre` (`id_chambre`),
  KEY `id_tva` (`id_tva`),
  KEY `id_tva_2` (`id_tva`),
  KEY `id_chambre_2` (`id_chambre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `spa`
--

CREATE TABLE IF NOT EXISTS `spa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `table`
--

CREATE TABLE IF NOT EXISTS `table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nbCouverts` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `tva`
--

CREATE TABLE IF NOT EXISTS `tva` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `aliment_commande_assoc`
--
ALTER TABLE `aliment_commande_assoc`
  ADD CONSTRAINT `aliment_commande_assoc_ibfk_1` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `assoc_aliment` FOREIGN KEY (`id_aliment`) REFERENCES `aliment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `client_agence_assoc`
--
ALTER TABLE `client_agence_assoc`
  ADD CONSTRAINT `client_agence_assoc_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `client_agence_assoc_ibfk_2` FOREIGN KEY (`id_agence`) REFERENCES `agence` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commande_assoc`
--
ALTER TABLE `commande_assoc`
  ADD CONSTRAINT `commande_assoc_ibfk_4` FOREIGN KEY (`id_equipement_spa`) REFERENCES `equipement_spa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commande_assoc_ibfk_1` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commande_assoc_ibfk_2` FOREIGN KEY (`id_equipement_restaurant`) REFERENCES `equipement_restaurant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commande_assoc_ibfk_3` FOREIGN KEY (`id_equipement_hotel`) REFERENCES `equipement_hotel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commande_piece_assoc`
--
ALTER TABLE `commande_piece_assoc`
  ADD CONSTRAINT `commande_piece_assoc_ibfk_1` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commande_piece_assoc_ibfk_2` FOREIGN KEY (`id_piece`) REFERENCES `piece_de_rechange` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demande_intervention`
--
ALTER TABLE `demande_intervention`
  ADD CONSTRAINT `demande_intervention_ibfk_1` FOREIGN KEY (`id_criticite`) REFERENCES `criticite` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demande_intervention_ibfk_2` FOREIGN KEY (`id_equipement_spa`) REFERENCES `equipement_spa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demande_intervention_ibfk_3` FOREIGN KEY (`id_equipement_hotel`) REFERENCES `equipement_hotel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demande_intervention_ibfk_4` FOREIGN KEY (`id_equipement_restaurant`) REFERENCES `equipement_restaurant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demande_intervention_ibfk_5` FOREIGN KEY (`id_piece_rechange`) REFERENCES `piece_de_rechange` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demande_utilisateur`
--
ALTER TABLE `demande_utilisateur`
  ADD CONSTRAINT `demande_utilisateur_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demande_utilisateur_ibfk_2` FOREIGN KEY (`id_demande`) REFERENCES `demande_intervention` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `droit_role_assoc`
--
ALTER TABLE `droit_role_assoc`
  ADD CONSTRAINT `droit_role_assoc_ibfk_1` FOREIGN KEY (`id_droit`) REFERENCES `droit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `droit_role_assoc_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `equipement_hotel`
--
ALTER TABLE `equipement_hotel`
  ADD CONSTRAINT `equipement_hotel_ibfk_1` FOREIGN KEY (`id_chambre`) REFERENCES `chambre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `equipement_restaurant`
--
ALTER TABLE `equipement_restaurant`
  ADD CONSTRAINT `equipement_restaurant_ibfk_1` FOREIGN KEY (`id_table`) REFERENCES `table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `equipement_spa`
--
ALTER TABLE `equipement_spa`
  ADD CONSTRAINT `equipement_spa_ibfk_1` FOREIGN KEY (`id_spa`) REFERENCES `spa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `facturation_assoc`
--
ALTER TABLE `facturation_assoc`
  ADD CONSTRAINT `facturation_assoc_ibfk_5` FOREIGN KEY (`id_reservation_hotel`) REFERENCES `reservation_hotel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `facturation_assoc_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `facturation_assoc_ibfk_2` FOREIGN KEY (`id_facture`) REFERENCES `facture` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `facturation_assoc_ibfk_3` FOREIGN KEY (`id_reservation_spa`) REFERENCES `reservation_spa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `facturation_assoc_ibfk_4` FOREIGN KEY (`id_reservation_restaurant`) REFERENCES `reservation_restaurant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `plat_aliment_assoc`
--
ALTER TABLE `plat_aliment_assoc`
  ADD CONSTRAINT `plat_aliment_assoc_ibfk_1` FOREIGN KEY (`id_plat`) REFERENCES `plat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `plat_aliment_assoc_ibfk_2` FOREIGN KEY (`id_aliment`) REFERENCES `aliment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rapport`
--
ALTER TABLE `rapport`
  ADD CONSTRAINT `rapport_ibfk_1` FOREIGN KEY (`id_demande_intervention`) REFERENCES `demande_intervention` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation_hotel`
--
ALTER TABLE `reservation_hotel`
  ADD CONSTRAINT `reservation_hotel_ibfk_1` FOREIGN KEY (`id_tva`) REFERENCES `tva` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_hotel_ibfk_2` FOREIGN KEY (`id_chambre`) REFERENCES `chambre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation_restaurant`
--
ALTER TABLE `reservation_restaurant`
  ADD CONSTRAINT `reservation_restaurant_ibfk_1` FOREIGN KEY (`id_tva`) REFERENCES `tva` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_restaurant_ibfk_2` FOREIGN KEY (`id_table`) REFERENCES `table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation_spa`
--
ALTER TABLE `reservation_spa`
  ADD CONSTRAINT `reservation_spa_ibfk_1` FOREIGN KEY (`id_tva`) REFERENCES `tva` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_spa_ibfk_2` FOREIGN KEY (`id_spa`) REFERENCES `spa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `restaurant_assoc`
--
ALTER TABLE `restaurant_assoc`
  ADD CONSTRAINT `restaurant_assoc_ibfk_1` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `restaurant_assoc_ibfk_2` FOREIGN KEY (`id_boisson`) REFERENCES `boisson` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `restaurant_assoc_ibfk_3` FOREIGN KEY (`id_plat`) REFERENCES `plat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `restaurant_assoc_ibfk_4` FOREIGN KEY (`id_reservation_restaurant`) REFERENCES `reservation_restaurant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

SET foreign_key_checks = 1;