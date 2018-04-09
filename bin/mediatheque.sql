-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 07 Avril 2018 à 20:27
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

CREATE TABLE `adherent` (
  `idAdherent` int(11) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL,
  `Prenom` varchar(25) DEFAULT NULL,
  `DateNaissance` date DEFAULT NULL,
  `Adresse` varchar(150) DEFAULT NULL,
  `eMail` varchar(50) DEFAULT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  `nbRetard` int(11) DEFAULT NULL,
  `MotDePasse` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `adherent`
--

INSERT INTO `adherent` (`idAdherent`, `Nom`, `Prenom`, `DateNaissance`, `Adresse`, `eMail`, `Actif`, `nbRetard`, `MotDePasse`) VALUES
(0, 'nom', 'prénom', '1975-02-19', 'a', 'a', 1, 0, 'a'),
(1, 'peter', 'falson', '2015-10-14', '13 rue de la mort', 'jasuis@gmail.com', 0, 0, '123'),
(2, 'Poutre', 'Ajuit', '2017-04-17', '13 mort de chien', 'jkoi@ouki.com', 1, 1, '456'),
(3, 'theo', 'gueguen', '1996-06-18', '249 avenue de saint louis', 'theo13015@gmail.com', 1, 1, 'jaimelessebs'),
(4, 'lamblin', 'sebastien', '1990-11-26', '54 avenue de la clairiere', 'lamblinou@gmail.com', 1, 5, 'espadon'),
(5, 'pinatel', 'anthony', '1997-11-11', '2 stade velodrome violet', 'pinatelou@gmail.com', 1, 12, 'jesuispasunrageux'),
(6, 'belami', 'armed', '1995-06-09', '78 en face de chez son voisin', 'amine.boudraa@etu.univ-amu.fr', 0, 34, 'passwordin2k18'),
(7, 'laguens', 'brandon', '1997-01-30', '24 avenue de rognac', 'd4rkplay3r@gmail.com', 1, 11, 'azerty'),
(8, 'barthez', 'pierre', '1995-11-06', '1 a coté de lagréable', 'pierrotwow@gmail.com', 1, 11, 'lalliancecestnull');

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

CREATE TABLE `auteur` (
  `idAuteur` int(11) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `auteur`
--

INSERT INTO `auteur` (`idAuteur`, `Nom`) VALUES
(1, 'Post Malone'),
(2, 'Lil Pump'),
(3, '6ix9ine'),
(4, 'Lil Uzi Vert'),
(5, 'Booba'),
(6, 'Kaaris'),
(7, 'Julustre le rouge'),
(8, 'Captain Cook');

-- --------------------------------------------------------

--
-- Structure de la table `compose`
--

CREATE TABLE `compose` (
  `idCompositeur` int(11) NOT NULL,
  `idMusique` int(11) NOT NULL,
  `idProduit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compose`
--

INSERT INTO `compose` (`idCompositeur`, `idMusique`, `idProduit`) VALUES
(1, 1, 1),
(1, 1, 11),
(2, 2, 2),
(2, 2, 12),
(3, 3, 3),
(3, 3, 13),
(4, 4, 4),
(4, 4, 14),
(5, 5, 5),
(5, 5, 15),
(6, 6, 6),
(6, 6, 16),
(7, 7, 7),
(7, 7, 17),
(8, 8, 8),
(8, 8, 18),
(9, 9, 9),
(9, 9, 19),
(10, 10, 10),
(10, 10, 20);

-- --------------------------------------------------------

--
-- Structure de la table `compositeur`
--

CREATE TABLE `compositeur` (
  `idCompositeur` int(11) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compositeur`
--

INSERT INTO `compositeur` (`idCompositeur`, `Nom`) VALUES
(1, 'pvnova'),
(2, 'mistermv'),
(3, 'Mozart'),
(4, 'Vivaldi'),
(5, 'Bach'),
(6, 'Ravel'),
(7, 'Stravinsky'),
(8, 'Lennon'),
(9, 'John'),
(10, 'Debussy');

-- --------------------------------------------------------

--
-- Structure de la table `creer`
--

CREATE TABLE `creer` (
  `idEcrivain` int(11) NOT NULL,
  `idLIvre` int(11) NOT NULL,
  `idProduit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `creer`
--

INSERT INTO `creer` (`idEcrivain`, `idLIvre`, `idProduit`) VALUES
(1, 1, 21),
(2, 2, 22),
(3, 3, 23),
(4, 4, 24),
(5, 5, 25),
(6, 6, 26),
(7, 7, 27),
(8, 8, 28),
(9, 9, 29),
(10, 10, 30),
(1, 11, 31),
(2, 12, 32),
(3, 13, 33),
(4, 14, 34),
(5, 15, 35),
(6, 16, 36),
(7, 17, 37),
(8, 18, 38),
(9, 19, 39),
(10, 20, 40);

-- --------------------------------------------------------

--
-- Structure de la table `ecrire`
--

CREATE TABLE `ecrire` (
  `idMusique` int(11) NOT NULL,
  `idProduit` int(11) NOT NULL,
  `idAuteur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ecrire`
--

INSERT INTO `ecrire` (`idMusique`, `idProduit`, `idAuteur`) VALUES
(1, 1, 7),
(2, 2, 1),
(3, 3, 2),
(4, 4, 3),
(5, 5, 4),
(6, 6, 5),
(7, 7, 6),
(8, 8, 7),
(9, 9, 8),
(10, 10, 1),
(11, 11, 8),
(12, 12, 1),
(13, 13, 2),
(14, 14, 3),
(15, 15, 4),
(16, 16, 5),
(17, 17, 6),
(18, 18, 7),
(19, 19, 8),
(20, 20, 2);

-- --------------------------------------------------------

--
-- Structure de la table `ecrirescenario`
--

CREATE TABLE `ecrirescenario` (
  `idScenariste` int(11) NOT NULL,
  `idFilm` int(11) NOT NULL,
  `idProduit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ecrirescenario`
--

INSERT INTO `ecrirescenario` (`idScenariste`, `idFilm`, `idProduit`) VALUES
(1, 1, 41),
(1, 11, 51),
(2, 2, 42),
(2, 12, 52),
(3, 3, 43),
(3, 13, 53),
(4, 4, 44),
(4, 14, 54),
(5, 5, 45),
(5, 15, 55),
(6, 6, 46),
(6, 16, 56),
(7, 7, 47),
(7, 17, 57),
(8, 8, 48),
(8, 18, 58),
(9, 9, 49),
(9, 19, 59),
(10, 10, 50),
(10, 20, 60);

-- --------------------------------------------------------

--
-- Structure de la table `ecrivain`
--

CREATE TABLE `ecrivain` (
  `idEcrivain` int(11) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ecrivain`
--

INSERT INTO `ecrivain` (`idEcrivain`, `Nom`) VALUES
(1, 'Hugo'),
(2, 'Paris'),
(3, 'Tolkien'),
(4, 'Rowling'),
(5, 'Papouasien'),
(6, 'Proust'),
(7, 'Zola'),
(8, 'Mauriac'),
(9, 'Vargas'),
(10, 'Christie');

-- --------------------------------------------------------

--
-- Structure de la table `editeur`
--

CREATE TABLE `editeur` (
  `idEditeur` int(11) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `editeur`
--

INSERT INTO `editeur` (`idEditeur`, `Nom`) VALUES
(1, 'Le petit cheval de manege'),
(2, 'Editis'),
(3, 'Actissia'),
(4, 'Madrigall'),
(5, 'Lagardere'),
(6, 'Frojal'),
(7, 'Eyrolles'),
(8, 'David Stut'),
(9, 'Brossolet'),
(10, 'Aceascop');

-- --------------------------------------------------------

--
-- Structure de la table `emprunter`
--

CREATE TABLE `emprunter` (
  `DateEmprunt` date NOT NULL,
  `DateLimite` date DEFAULT NULL,
  `DateRetour` date DEFAULT NULL,
  `idAdherent` int(11) NOT NULL,
  `idExemplaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `emprunter`
--

INSERT INTO `emprunter` (`DateEmprunt`, `DateLimite`, `DateRetour`, `idAdherent`, `idExemplaire`) VALUES
('2015-01-01', '2015-02-01', '2015-01-07', 1, 1),
('2015-01-01', '2015-02-01', '2015-01-07', 2, 10),
('2015-01-01', '2015-02-01', '2015-01-07', 3, 11),
('2015-01-01', '2015-02-01', '2015-01-07', 5, 12),
('2015-01-01', '2015-02-01', '2015-01-07', 8, 9),
('2015-02-01', '2015-03-01', '2015-02-07', 1, 16),
('2015-02-01', '2015-03-01', '2015-02-07', 2, 2),
('2015-02-01', '2015-03-01', '2015-02-07', 4, 14),
('2015-02-01', '2015-03-01', '2015-02-07', 6, 13),
('2015-02-01', '2015-03-01', '2015-02-07', 7, 15),
('2015-03-01', '2015-04-01', '2015-03-07', 3, 3),
('2015-03-01', '2015-04-01', '2015-03-07', 3, 17),
('2015-03-01', '2015-04-01', '2015-03-07', 6, 18),
('2015-03-01', '2015-04-01', '2015-03-07', 6, 19),
('2015-04-01', '2015-05-01', '2015-04-07', 4, 4),
('2015-05-01', '2015-06-01', '2015-05-07', 5, 5),
('2015-06-01', '2015-07-01', '2015-06-07', 6, 6),
('2015-07-01', '2015-08-01', '2015-07-07', 6, 7),
('2015-08-01', '2015-09-01', '2015-08-07', 6, 21),
('2015-08-01', '2015-09-01', '2015-08-07', 7, 8),
('2015-08-01', '2015-09-01', '2015-08-07', 8, 20),
('2016-01-01', '2016-02-01', '2016-01-07', 1, 1),
('2016-01-01', '2016-02-01', '2016-01-07', 2, 10),
('2016-01-01', '2016-02-01', '2016-01-07', 3, 11),
('2016-01-01', '2016-02-01', '2016-01-07', 5, 12),
('2016-01-01', '2016-02-01', '2016-01-07', 8, 9),
('2016-02-01', '2016-03-01', '2016-02-07', 1, 16),
('2016-02-01', '2016-03-01', '2016-02-07', 2, 2),
('2016-02-01', '2016-03-01', '2016-02-07', 6, 13),
('2016-02-01', '2016-03-01', '2016-02-07', 7, 14),
('2016-02-01', '2016-03-01', '2016-02-07', 7, 15),
('2016-03-01', '2016-04-01', '2016-03-07', 3, 3),
('2016-03-01', '2016-04-01', '2016-03-07', 3, 17),
('2016-03-01', '2016-04-01', '2016-03-07', 6, 18),
('2016-03-01', '2016-04-01', '2016-03-07', 6, 19),
('2016-04-01', '2016-05-01', '2016-04-07', 4, 4),
('2016-05-01', '2016-06-01', '2016-05-07', 5, 5),
('2016-06-01', '2016-07-01', '2016-06-07', 6, 6),
('2016-07-01', '2016-08-01', '2016-07-07', 6, 7),
('2016-08-01', '2016-09-01', '2016-08-07', 6, 21),
('2016-08-01', '2016-09-01', '2016-08-07', 7, 8),
('2016-08-01', '2016-09-01', '2016-08-07', 8, 20),
('2017-01-01', '2017-02-01', '2017-01-07', 1, 1),
('2017-01-01', '2017-02-01', '2017-01-07', 2, 10),
('2017-01-01', '2017-02-01', '2017-01-07', 3, 11),
('2017-01-01', '2017-02-01', '2017-01-07', 5, 12),
('2017-01-01', '2017-02-01', '2017-01-07', 8, 9),
('2017-02-01', '2017-03-01', '2017-02-07', 0, 14),
('2017-02-01', '2017-03-01', '2017-02-07', 1, 16),
('2017-02-01', '2017-03-01', '2017-02-07', 2, 2),
('2017-02-01', '2017-03-01', '2017-02-07', 6, 13),
('2017-02-01', '2017-03-01', '2017-02-07', 7, 15),
('2017-03-01', '2017-04-01', '2017-03-07', 3, 3),
('2017-03-01', '2017-04-01', '2017-03-07', 3, 17),
('2017-03-01', '2017-04-01', '2017-03-07', 6, 18),
('2017-03-01', '2017-04-01', '2017-03-07', 6, 19),
('2017-04-01', '2017-05-01', '2017-04-07', 4, 4),
('2017-05-01', '2017-06-01', '2017-05-07', 5, 5),
('2017-06-01', '2017-07-01', '2017-06-07', 6, 6),
('2017-07-01', '2017-08-01', '2017-07-07', 6, 7),
('2017-08-01', '2017-09-01', '2017-08-07', 6, 21),
('2017-08-01', '2017-09-01', '2017-08-07', 7, 8),
('2017-08-01', '2017-09-01', '2017-08-07', 8, 20),
('2018-01-01', '2018-02-01', '2018-01-07', 1, 1),
('2018-01-01', '2018-02-01', '2018-01-07', 2, 10),
('2018-01-01', '2018-02-01', '2018-01-07', 3, 11),
('2018-01-01', '2018-02-01', '2018-01-07', 5, 12),
('2018-01-01', '2018-02-01', '2018-01-07', 8, 9),
('2018-02-01', '2018-03-01', '2018-02-07', 0, 14),
('2018-02-01', '2018-03-01', '2018-02-07', 1, 16),
('2018-02-01', '2018-03-01', '2018-02-07', 2, 2),
('2018-02-01', '2018-03-01', '2018-02-07', 6, 13),
('2018-02-01', '2018-03-01', '2018-02-07', 7, 15),
('2018-03-01', '2018-04-01', '2018-03-07', 3, 3),
('2018-03-01', '2018-04-01', '2018-03-07', 3, 17),
('2018-03-01', '2018-04-01', '2018-03-07', 6, 18),
('2018-03-01', '2018-04-01', '2018-03-07', 6, 19),
('2018-04-01', '2018-05-01', '2018-04-07', 4, 4),
('2018-04-07', '2018-05-07', NULL, 0, 9),
('2018-05-01', '2018-06-01', '2018-05-07', 5, 5),
('2018-06-01', '2018-07-01', '2018-06-07', 6, 6),
('2018-07-01', '2018-08-01', '2018-07-07', 6, 7),
('2018-08-01', '2018-09-01', '2018-08-07', 6, 21),
('2018-08-01', '2018-09-01', '2018-08-07', 7, 8),
('2018-08-01', '2018-09-01', '2018-08-07', 8, 20);

-- --------------------------------------------------------

--
-- Structure de la table `estdegenre`
--

CREATE TABLE `estdegenre` (
  `idProduit` int(11) NOT NULL,
  `idGenre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `estdegenre`
--

INSERT INTO `estdegenre` (`idProduit`, `idGenre`) VALUES
(1, 1),
(6, 1),
(11, 1),
(16, 1),
(2, 2),
(7, 2),
(12, 2),
(17, 2),
(3, 3),
(8, 3),
(13, 3),
(18, 3),
(4, 4),
(9, 4),
(14, 4),
(19, 4),
(5, 5),
(10, 5),
(15, 5),
(20, 5),
(21, 6),
(26, 6),
(31, 6),
(36, 6),
(22, 7),
(27, 7),
(32, 7),
(37, 7),
(23, 8),
(28, 8),
(33, 8),
(38, 8),
(24, 9),
(29, 9),
(34, 9),
(39, 9),
(25, 10),
(30, 10),
(35, 10),
(40, 10),
(41, 11),
(46, 11),
(51, 11),
(56, 11),
(42, 12),
(47, 12),
(52, 12),
(57, 12),
(43, 13),
(48, 13),
(53, 13),
(58, 13),
(44, 14),
(49, 14),
(54, 14),
(59, 14),
(45, 15),
(50, 15),
(55, 15),
(60, 15);

-- --------------------------------------------------------

--
-- Structure de la table `exemplaire`
--

CREATE TABLE `exemplaire` (
  `idExemplaire` int(11) NOT NULL,
  `DateAchat` date DEFAULT NULL,
  `idProduit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `exemplaire`
--

INSERT INTO `exemplaire` (`idExemplaire`, `DateAchat`, `idProduit`) VALUES
(1, '2015-03-04', 20),
(2, '2015-03-05', 21),
(3, '2015-03-06', 22),
(4, '2015-03-06', 23),
(5, '2015-03-06', 24),
(6, '2015-03-07', 25),
(7, '2015-04-04', 26),
(8, '2015-05-04', 27),
(9, '2015-06-03', 28),
(10, '2015-06-12', 39),
(11, '2015-03-04', 20),
(12, '2015-03-05', 21),
(13, '2015-03-06', 22),
(14, '2015-03-06', 23),
(15, '2015-03-06', 24),
(16, '2015-03-07', 25),
(17, '2015-04-04', 26),
(18, '2015-05-04', 27),
(19, '2015-06-03', 28),
(20, '2015-06-12', 29),
(21, '2015-03-04', 20),
(22, '2015-03-05', 21),
(23, '2015-03-06', 22),
(24, '2015-03-06', 23),
(25, '2015-03-06', 24),
(26, '2015-03-07', 25),
(27, '2015-04-04', 26),
(28, '2015-05-04', 27),
(29, '2015-06-03', 28),
(30, '2015-06-12', 29),
(31, '2015-03-04', 20),
(32, '2015-03-05', 21),
(33, '2015-03-06', 22),
(34, '2015-03-06', 23),
(35, '2015-03-06', 24),
(36, '2015-03-07', 25),
(37, '2015-04-04', 26),
(38, '2015-05-04', 27),
(39, '2015-06-03', 28),
(40, '2015-06-12', 29),
(41, '2015-03-04', 30),
(42, '2015-03-05', 31),
(43, '2015-03-06', 32),
(44, '2015-03-06', 33),
(45, '2015-03-06', 34),
(46, '2015-03-07', 35),
(47, '2015-04-04', 36),
(48, '2015-05-04', 37),
(49, '2015-06-03', 38),
(50, '2015-06-12', 39),
(51, '2015-03-04', 30),
(52, '2015-03-05', 31),
(53, '2015-03-06', 32),
(54, '2015-03-06', 33),
(55, '2015-03-06', 34),
(56, '2015-03-07', 35),
(57, '2015-04-04', 36),
(58, '2015-05-04', 37),
(59, '2015-06-03', 38),
(60, '2015-06-12', 39),
(61, '2015-03-04', 10),
(62, '2015-03-05', 11),
(63, '2015-03-06', 12),
(64, '2015-03-06', 13),
(65, '2015-03-06', 14),
(66, '2015-03-07', 15),
(67, '2015-04-04', 16),
(68, '2015-05-04', 17),
(69, '2015-06-03', 18),
(70, '2015-06-12', 19),
(71, '2015-03-04', 10),
(72, '2015-03-05', 11),
(73, '2015-03-06', 12),
(74, '2015-03-06', 13),
(75, '2015-03-06', 14),
(76, '2015-03-07', 15),
(77, '2015-04-04', 16),
(78, '2015-05-04', 17),
(79, '2015-06-03', 18),
(80, '2015-06-12', 19),
(81, '2015-03-04', 50),
(82, '2015-03-05', 51),
(83, '2015-03-06', 52),
(84, '2015-03-06', 53),
(85, '2015-03-06', 54),
(86, '2015-03-07', 55),
(87, '2015-04-04', 56),
(88, '2015-05-04', 57),
(89, '2015-06-03', 58),
(90, '2015-06-12', 59),
(91, '2015-03-04', 50),
(92, '2015-03-05', 51),
(93, '2015-03-06', 52),
(94, '2015-03-06', 53),
(95, '2015-03-06', 54),
(96, '2015-03-07', 55),
(97, '2015-04-04', 56),
(98, '2015-05-04', 57),
(99, '2015-06-03', 58),
(100, '2015-06-12', 59),
(101, '2015-03-04', 30),
(102, '2015-03-05', 31),
(103, '2015-03-06', 32),
(104, '2015-03-06', 33),
(105, '2015-03-06', 34),
(106, '2015-03-07', 35),
(107, '2015-04-04', 36),
(108, '2015-05-04', 37),
(109, '2015-06-03', 38),
(110, '2015-06-12', 39);

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
  `idFilm` int(11) NOT NULL,
  `Duree` int(11) DEFAULT NULL,
  `idProduit` int(11) NOT NULL,
  `idProd` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `film`
--

INSERT INTO `film` (`idFilm`, `Duree`, `idProduit`, `idProd`) VALUES
(1, 124, 41, 1),
(2, 120, 42, 2),
(3, 130, 43, 3),
(4, 135, 44, 4),
(5, 120, 45, 5),
(6, 124, 46, 6),
(7, 125, 47, 7),
(8, 125, 48, 8),
(9, 126, 49, 9),
(10, 127, 50, 10),
(11, 60, 51, 1),
(12, 300, 52, 2),
(13, 216, 53, 3),
(14, 135, 54, 4),
(15, 136, 55, 5),
(16, 137, 56, 6),
(17, 138, 57, 7),
(18, 139, 58, 8),
(19, 140, 59, 9),
(20, 141, 60, 10);

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

CREATE TABLE `genre` (
  `idGenre` int(11) NOT NULL,
  `type` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `genre`
--

INSERT INTO `genre` (`idGenre`, `type`) VALUES
(1, 'Policier'),
(2, 'Fantastique'),
(3, 'Romance'),
(4, 'Horreur'),
(5, 'Drame'),
(6, 'Sci-Fi'),
(7, 'Action'),
(8, 'Comedie'),
(9, 'péplum'),
(10, 'thriller'),
(11, 'Rap'),
(12, 'rock'),
(13, 'country'),
(14, 'RnB'),
(15, 'Kpop');

-- --------------------------------------------------------

--
-- Structure de la table `interprete`
--

CREATE TABLE `interprete` (
  `idInterprete` int(11) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `interprete`
--

INSERT INTO `interprete` (`idInterprete`, `Nom`) VALUES
(1, 'Ahmed'),
(2, 'Theodore'),
(3, 'Anthony'),
(4, 'Sebastien'),
(5, 'Pierre'),
(6, 'Brandon'),
(7, 'Alexandre'),
(8, 'Max'),
(9, 'Patrick'),
(10, 'Jean');

-- --------------------------------------------------------

--
-- Structure de la table `interpreter`
--

CREATE TABLE `interpreter` (
  `idMusique` int(11) NOT NULL,
  `idProduit` int(11) NOT NULL,
  `idInterprete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `interpreter`
--

INSERT INTO `interpreter` (`idMusique`, `idProduit`, `idInterprete`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 1),
(12, 12, 2),
(13, 13, 3),
(14, 14, 4),
(15, 15, 5),
(16, 16, 6),
(17, 17, 7),
(18, 18, 8),
(19, 19, 9),
(20, 20, 10);

-- --------------------------------------------------------

--
-- Structure de la table `label`
--

CREATE TABLE `label` (
  `idLabel` int(11) NOT NULL,
  `Nom` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `label`
--

INSERT INTO `label` (`idLabel`, `Nom`) VALUES
(1, 'Universal Music Group'),
(2, 'PolyGram'),
(3, 'porteafaut'),
(4, 'Disko'),
(5, 'Warner Electra Atlantic Records'),
(6, 'BMG Entertainment'),
(7, 'pillule'),
(8, 'CBS Records'),
(9, 'EMI Group '),
(10, 'Poupoule');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `idLIvre` int(11) NOT NULL,
  `Langue` varchar(25) DEFAULT NULL,
  `LongueurDuLivre` int(11) DEFAULT NULL,
  `idProduit` int(11) NOT NULL,
  `idEditeur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `livre`
--

INSERT INTO `livre` (`idLIvre`, `Langue`, `LongueurDuLivre`, `idProduit`, `idEditeur`) VALUES
(1, 'français', 140, 21, 1),
(2, 'français', 1500, 22, 2),
(3, 'anglais', 1457, 23, 3),
(4, 'français', 325, 24, 4),
(5, 'polonais', 320, 25, 5),
(6, 'français', 410, 26, 6),
(7, 'anglais', 478, 27, 7),
(8, 'français', 789, 28, 8),
(9, 'anglais', 320, 29, 9),
(10, 'français', 142, 30, 10),
(11, 'français', 140, 31, 1),
(12, 'français', 1500, 32, 2),
(13, 'anglais', 1457, 33, 3),
(14, 'français', 325, 34, 4),
(15, 'polonais', 320, 35, 5),
(16, 'français', 410, 36, 6),
(17, 'anglais', 478, 37, 7),
(18, 'français', 789, 38, 8),
(19, 'anglais', 320, 39, 9),
(20, 'français', 142, 40, 10);

-- --------------------------------------------------------

--
-- Structure de la table `musique`
--

CREATE TABLE `musique` (
  `idMusique` int(11) NOT NULL,
  `Duree` int(11) DEFAULT NULL,
  `idProduit` int(11) NOT NULL,
  `idLabel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `musique`
--

INSERT INTO `musique` (`idMusique`, `Duree`, `idProduit`, `idLabel`) VALUES
(1, 2, 1, 1),
(2, 2, 2, 2),
(3, 2, 3, 3),
(4, 2, 4, 4),
(5, 2, 5, 5),
(6, 2, 6, 6),
(7, 2, 7, 7),
(8, 2, 8, 8),
(9, 2, 9, 9),
(10, 3, 10, 10),
(11, 2, 11, 1),
(12, 2, 12, 2),
(13, 2, 13, 3),
(14, 2, 14, 4),
(15, 2, 15, 5),
(16, 2, 16, 6),
(17, 2, 17, 7),
(18, 2, 18, 8),
(19, 2, 19, 9),
(20, 3, 20, 10);

-- --------------------------------------------------------

--
-- Structure de la table `production`
--

CREATE TABLE `production` (
  `idProd` int(11) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `production`
--

INSERT INTO `production` (`idProd`, `Nom`) VALUES
(1, 'La Fabrique 2'),
(2, 'Les Films 13'),
(3, 'AJOZ Films'),
(4, 'CreaSyn Studio'),
(5, 'Cine Nomine'),
(6, 'Mandarin Films'),
(7, 'Miroir Magique!'),
(8, 'Wallpaper Productions'),
(9, 'Les Productions du Trésor'),
(10, 'No Money Productions');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `idProduit` int(11) NOT NULL,
  `Titre` varchar(75) DEFAULT NULL,
  `DatePublication` date DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`idProduit`, `Titre`, `DatePublication`, `Description`) VALUES
(1, 'M-Le terrier du feu', '2010-05-01', 'Vel rectum vel simus sed sunt rectum statuerimus loquimur amicis statuerimus maxime quidquid habeat perfecta'),
(2, 'M-La procession du tatoué', '2010-06-02', 'Ut amicitia quidam se qui contingit ob modo se qui sic levandi verbis verbis opinione'),
(3, 'M-La démarche des circuits', '2010-07-03', 'Latrones undique nostris undique quidem Pamphyliam se tramitibus parte congressione magnis milite fore cum undique'),
(4, 'M-La régularité de lhistoire', '2010-08-04', 'Qui eam metiamur reperiuntur Scipiones vita ut nec communis omittamus consuetudine eos vita contenta ex'),
(5, 'M-La colère du chirurgien', '2010-09-05', 'Reverenda cum sunt Romani set partes et verecundum et suscipitur ubique certamina et temporis cum'),
(6, 'M-Lempreinte des incorrigibles', '2010-01-06', 'Ignaviae cultibus hydraulica tibiaeque ritu vocali sepulcrorum antea organa sepulcrorum resultantes perpetuum sit domus organa'),
(7, 'M-Le vestiaire dun capitaliste', '2010-02-07', 'Hoc uni conciderit modo leviorem Gabini Pisonis hoc conciderit hac Pisonis senatus hanc solacio senatus'),
(8, 'M-La légèreté dun coquin', '2010-03-08', 'Graves principem in consarcinantibus ignotus et apud infudisset medium siquid ut principem et Constantium sui'),
(9, 'M-Le plan des pierres ', '2010-04-09', 'Consilio semper rerum patentes factu Vrsicinum se et rumoribus et id id honore minantium taliaque'),
(10, 'M-La position des débutantes ', '2010-05-01', 'In quae tollit aliquid semel non sensibus ut ponit dicitur iudicium sublatum nudus iudicia putat'),
(11, 'M-La métamorphose des nuages', '2010-06-02', 'Iaculatores ab incesserit praepositis cum retorquens adegerit cursu cum fors mutilorum cursu quae plebeiis postrema'),
(12, 'M-La ville de lidiot', '2010-07-03', 'Quid amicitiam quid et ne neque paribus aequo vocare ne enim vera acceptorum videtur aut'),
(13, 'M-Le sel de lenvers', '2010-08-04', 'Cum praestrictis morbosque contempto cum processit sed diu moliebatur sollemni diu ad publicum pompa addens'),
(14, 'M-La victime du cygne', '2010-09-05', 'Ab sententias modo amicis adfecti facit erga amicis quisque ut amicis probo tanti fiat amicos'),
(15, 'M-Photographies des promeneuses', '2010-10-06', 'Fines quisque tanti ipsos unam in fines qui simus De amicis ut nullam quibus benevolentia'),
(16, 'M-Létreinte des lémuriens', '2010-11-05', 'Adfligebat gravia sunt perciti adfligebat pernicies excursibus est raris in cuncta sola Namque vehementer latrociniis'),
(17, 'M-La trace dune héroïne', '2010-12-04', 'Libere pareatur amicorum ad rogemur honesta non libere consilium bene etiam suadentium quidem auctoritas aperte'),
(18, 'M-Lenvers du désastre', '2010-01-03', 'Maxime beati inopes eo amicitiarum benevolentiae et paulo neque qui causa minimumque autem ex putentur.'),
(19, 'M-Lélégance des critiques', '2010-02-02', 'Miretur labores deverti deverti placidiora longos congestosque labores labores ductante pagos exsudatos post consilio congestosque'),
(20, 'M-La dépression des poupées', '2010-03-01', 'Posita me utilitates sibi illius ipso meis eius me suaque virtute maxime sunt tamen in'),
(21, 'L-La destinée dombres', '2010-04-02', 'Vias subsidiales familiae iungitur faciunt quae retorquens quae quisquam prima mares in ut ab posteritatis'),
(22, 'L-Le cri des poils', '2010-05-03', 'Dicta luctuosa norat percita percita ea expeditionibus Mediolanum Mediolanum cum quod ea hiberna expeditionibus pacem'),
(23, 'L-Le passage des soucoupes', '2010-06-04', 'Telis telis et magnis cum convolantibus inpossibile obrutis navium et Alamanna multitudine ubi obrutis est'),
(24, 'L-La promise du schizophrène', '2010-07-05', 'Ponderibus placuerat et antequam incumberet nimis codicem tractatus ponderibus per publici auxilio effundendis placuerat rebus'),
(25, 'L-Vocabulaire de la mort', '2010-08-03', 'Saltatricum ne ab urbe veri cum urbe ad cum totidemque inopiam disciplinarum id ulla sine'),
(26, 'L-Le privilège des élus', '2010-09-04', 'Erat vixerat odio hominum Pompeio erat qui amantissime admodum memini dissideret pauci solebat esset sermonem'),
(27, 'L-Manifestations du météore', '2010-10-05', 'Latenter prope a ripam fiducia vel conserendas vel prope a scutorum gurgitis parant signis isdem'),
(28, 'L-La vermine des neiges', '2010-11-03', 'Quosdam quamobrem vilitates deflexerit haec oratio vilitates lecturos a quosdam haec ad seditiones lecturos et'),
(29, 'L-Lespace-temps du dédale', '2010-12-02', 'Conpulsus non celerari praepositum Graeco appellant Tyrii vitae quidam vexatus litterae scriptae quam ut tuniculam'),
(30, 'L-Vidéos des invisibles', '2010-01-01', 'Tamquam confidentia nisu auxilio scriptis curarum auxilio incumberet abiectis destitutus destitutus pertinacius ullo nocturnis pertinacius'),
(31, 'L-Fragments de linfirme', '2010-02-05', 'Est quem Scipio felices si putabat aliquando si eum possemus amicitiis inimicitiarum in inciperemus diligendo'),
(32, 'L-Les lunettes du pianiste', '2010-03-08', 'Conspiraret subtraxit largitionum illi Scutariis solisque verecunde sollicitari in cum Caesarem ad esse et et'),
(33, 'L-Journal des cochons', '2010-04-02', 'Ut quale amantur illa magis facile est Quod nisi et nacti amicitia earum et etiam'),
(34, 'L-La chambre des pieuvres', '2010-05-03', 'Omnibus est deorum homines nec nullus si nulla amicitia locus cognitam qua fidem qui tyrannorum'),
(35, 'L-Le ricanement dun spectre', '2010-06-04', 'Praestituto nec quidve die et iudex praedoctis adsistebant iudex cuius adhibitis agenda inde funestis resedit'),
(36, 'L-La danse du rabbin', '2010-07-06', 'Nec vicissim circo nec indicium latens nec circo obscurum et circo vetitis autem certaminibus delectabatur'),
(37, 'L-Laube dun capitaliste', '2010-08-07', 'Fugiendas unus amicitiae sibi necesse possit esse vivendum satis esse habitos quos nimis sapientes parturiat'),
(38, 'L-La pratique des étoiles', '2010-09-01', 'Latus ullum maiora commeatus nunc Isauriae inedia geri adflictabantur et igitur Paleas gravi nunc posset'),
(39, 'L-Les vices des écrivains', '2010-10-02', 'Omni haudquaquam in severitas amicitia atque quidem omnem amicitia et remissior liberior re suavitas gravitatem'),
(40, 'L-La transformation des sorciers', '2010-11-01', 'Commeatus itinerum fiducia adfatim repente deverti commeatus deverti pagos exsudatos ductante quaeso adventans post deverti'),
(41, 'F-La vérité du soir ', '2010-12-03', 'Quoque in Veternensi aetatis et e pertaesus anno trabeae vita trabeae et Constantini nono imperatoris'),
(42, 'F-Latelier des barbares', '2010-01-04', 'Cyprii nec deessent veterem superbiam ut inmobilis ita renidens tamquam tandem insultans temporum oculos temporum'),
(43, 'F-Le royaume dailleurs ', '2010-02-05', 'Ipsis si intractato vetustas vetustatis est et utatur sed adferunt in delectemur consuetudo quam autem'),
(44, 'F-Livresse du vainqueur', '2010-03-05', 'Cognomentum eos tribunis inpegit instabat ad quibus pluribus tribunis adoritur dirus e sortem eum defensantem'),
(45, 'F-La trajectoire des amants', '2010-04-04', 'Atque affervescentem Asiam erumpentem Quae cervicibus quis vero Byzantii postea erumpentem inquam urbem sanctissime impetus'),
(46, 'F-Obsessions du père ', '2010-05-03', 'Virtute remuneratione est eo delectari admodum aedificio praedito enim honore nihil studiorum animante iucundius aedificio'),
(47, 'F-Loreille de lespace', '2010-06-02', 'Cavendi in divites vilitate per fingerent peius peragranter in adsistendo in his malorum cognita duplicarent'),
(48, 'F-Le langage du crocodile', '2010-07-01', 'Incitationem creberrime eum quoddam actus aliquotiens ipse ut vero tempestate vel quibus efferatus praefectus incertum'),
(49, 'F-Le roman des lémuriens', '2010-08-02', 'Opibus amittunt lingua Assyria enim construxit multis viribus licet tamen institutores indiderunt eis in Graecis'),
(50, 'F-Le garçon de minuit', '2010-09-03', 'Terrarum iracundae cuius exclamabant principis inminuta vel blanditiae inpendio proximorum principis periclitetur principis cruentae cuius'),
(51, 'F-Lappel des sauvages', '2010-10-04', 'Conpage apud arborum magnitudine ad quae parant quaerunt nandi angusti impetu orto quoque locatis ad'),
(52, 'F-Laurore du pardon', '2010-11-05', 'Ii (quem amicitias et causa magis locum minimum mulierculae itaque dicere ut inhumanius et ut'),
(53, 'F-Lémerveillement dun meurtrier', '2010-12-06', 'Vatibus timebantur acciderat Marcio paterfamilias susurrasset praesente ideoque postridie vitae ministro velut in ut vatibus'),
(54, 'F-La félicité des alchimistes', '2010-01-05', 'Temptatum stationibus tractus stationibus si extimas tractus crebro itinere tractus agrariis sueti Mesopotamiae erat parumque'),
(55, 'F-Le délire des chauve-souris', '2010-02-04', 'Tantum continuo Crassi deinde etiam ipsius deditšnihil domo M disciplinaque dicam deditšnihil vidit etiam dicam'),
(56, 'F-Le royaume dun raté', '2010-03-04', 'Contentionum passibus conficiendi victoriis peragrari usurpare gentium tuis populorum contentionum sed imperatorum nec saepe terras'),
(57, 'F-Les griffes de Londres', '2010-04-03', 'Intempestivam unum quod occidi vertices uno elogio ad comes tunc cum ideo fixa celebrari fixa'),
(58, 'F-La convenance des colombes', '2010-05-02', 'Vel omni habet de resistendum fuisse pietatis pietati nec vel descendisset necessitati spei si cui'),
(59, 'F-Le viol du village', '2010-06-01', 'Pascebantur se opibus praetenturis contulerunt in inveniretur Lycaoniam tempore Lycaoniam in tempore tempore Lycaoniam adnexam'),
(60, 'F-La dame des pierres', '2010-12-12', 'Edictus Romana herbidas Aboraeque amnis absque celebritati solitudines solitudines exagitati metu invadere egressus immobilis deinde');

-- --------------------------------------------------------

--
-- Structure de la table `realisateur`
--

CREATE TABLE `realisateur` (
  `idRealisateur` int(11) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `realisateur`
--

INSERT INTO `realisateur` (`idRealisateur`, `Nom`) VALUES
(1, 'Leone'),
(2, 'Kurosawa'),
(3, 'Truffaut'),
(4, 'Coppola'),
(5, 'Ford'),
(6, 'Bergman'),
(7, 'Nolan'),
(8, 'Burton'),
(9, 'Scott'),
(10, 'Welles');

-- --------------------------------------------------------

--
-- Structure de la table `realiser`
--

CREATE TABLE `realiser` (
  `idFilm` int(11) NOT NULL,
  `idProduit` int(11) NOT NULL,
  `idRealisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `realiser`
--

INSERT INTO `realiser` (`idFilm`, `idProduit`, `idRealisateur`) VALUES
(1, 41, 1),
(2, 42, 2),
(3, 43, 3),
(4, 44, 4),
(5, 45, 5),
(6, 46, 6),
(7, 47, 7),
(8, 48, 8),
(9, 49, 9),
(10, 50, 10),
(11, 51, 1),
(12, 52, 2),
(13, 53, 3),
(14, 54, 4),
(15, 55, 5),
(16, 56, 6),
(17, 57, 7),
(18, 58, 8),
(19, 59, 9),
(20, 60, 10);

-- --------------------------------------------------------

--
-- Structure de la table `reserver`
--

CREATE TABLE `reserver` (
  `dateReservation` date NOT NULL,
  `idAdherent` int(11) NOT NULL,
  `idProduit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reserver`
--

INSERT INTO `reserver` (`dateReservation`, `idAdherent`, `idProduit`) VALUES
('2015-04-26', 6, 4),
('2017-05-26', 3, 5),
('2018-09-26', 5, 6),
('2016-09-04', 3, 9),
('2016-09-02', 4, 15),
('2018-09-26', 5, 16),
('2016-05-04', 0, 18),
('2016-09-04', 3, 20),
('2017-07-02', 7, 20),
('2018-01-02', 8, 24),
('2015-05-02', 2, 25),
('2016-09-02', 4, 25),
('2018-04-26', 1, 26),
('2018-04-26', 1, 27),
('2015-01-02', 0, 31),
('2015-07-02', 3, 33),
('2018-01-02', 8, 34),
('2015-04-02', 6, 35),
('2018-07-26', 0, 35),
('2018-07-26', 2, 35),
('2018-07-02', 2, 38),
('2016-05-02', 7, 39),
('2017-01-26', 1, 40),
('2017-01-26', 4, 40),
('2017-07-02', 7, 40),
('2015-01-02', 0, 41),
('2015-04-26', 6, 41),
('2018-01-02', 3, 42),
('2015-04-02', 6, 45),
('2015-05-02', 2, 45),
('2017-01-26', 1, 46),
('2017-09-02', 6, 47),
('2018-07-02', 2, 48),
('2016-05-02', 7, 49),
('2017-01-26', 4, 50),
('2018-01-02', 3, 52),
('2015-07-02', 3, 53),
('2017-09-02', 6, 57),
('2016-05-04', 0, 58),
('2017-05-26', 3, 59);

-- --------------------------------------------------------

--
-- Structure de la table `scenariste`
--

CREATE TABLE `scenariste` (
  `idScenariste` int(11) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `scenariste`
--

INSERT INTO `scenariste` (`idScenariste`, `Nom`) VALUES
(1, 'Tarantino'),
(2, 'Spielberg'),
(3, 'Kubrik'),
(4, 'Audiard'),
(5, 'Allen'),
(6, 'Lavandier'),
(7, 'Godard'),
(8, 'Besson'),
(9, 'Hitchcock'),
(10, 'Lynch');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD PRIMARY KEY (`idAdherent`);

--
-- Index pour la table `auteur`
--
ALTER TABLE `auteur`
  ADD PRIMARY KEY (`idAuteur`);

--
-- Index pour la table `compose`
--
ALTER TABLE `compose`
  ADD PRIMARY KEY (`idCompositeur`,`idMusique`,`idProduit`),
  ADD KEY `FK_Compose_idMusique` (`idMusique`),
  ADD KEY `FK_Compose_idProduit` (`idProduit`);

--
-- Index pour la table `compositeur`
--
ALTER TABLE `compositeur`
  ADD PRIMARY KEY (`idCompositeur`);

--
-- Index pour la table `creer`
--
ALTER TABLE `creer`
  ADD PRIMARY KEY (`idEcrivain`,`idLIvre`,`idProduit`),
  ADD KEY `FK_Creer_idLIvre` (`idLIvre`),
  ADD KEY `FK_Creer_idProduit` (`idProduit`);

--
-- Index pour la table `ecrire`
--
ALTER TABLE `ecrire`
  ADD PRIMARY KEY (`idMusique`,`idProduit`,`idAuteur`),
  ADD KEY `FK_Ecrire_idProduit` (`idProduit`),
  ADD KEY `FK_Ecrire_idAuteur` (`idAuteur`);

--
-- Index pour la table `ecrirescenario`
--
ALTER TABLE `ecrirescenario`
  ADD PRIMARY KEY (`idScenariste`,`idFilm`,`idProduit`);

--
-- Index pour la table `ecrivain`
--
ALTER TABLE `ecrivain`
  ADD PRIMARY KEY (`idEcrivain`);

--
-- Index pour la table `editeur`
--
ALTER TABLE `editeur`
  ADD PRIMARY KEY (`idEditeur`);

--
-- Index pour la table `emprunter`
--
ALTER TABLE `emprunter`
  ADD PRIMARY KEY (`DateEmprunt`,`idAdherent`,`idExemplaire`),
  ADD KEY `FK_Emprunter_idExemplaire` (`idExemplaire`),
  ADD KEY `FK_Emprunter_idAdherent` (`idAdherent`);

--
-- Index pour la table `estdegenre`
--
ALTER TABLE `estdegenre`
  ADD PRIMARY KEY (`idProduit`,`idGenre`),
  ADD KEY `FK_Est_de_type_idGenre` (`idGenre`);

--
-- Index pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  ADD PRIMARY KEY (`idExemplaire`),
  ADD KEY `FK_Exemplaire_idProduit` (`idProduit`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`idFilm`,`idProduit`),
  ADD KEY `FK_Film_idProduit` (`idProduit`),
  ADD KEY `FK_Film_idProd` (`idProd`);

--
-- Index pour la table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`idGenre`);

--
-- Index pour la table `interprete`
--
ALTER TABLE `interprete`
  ADD PRIMARY KEY (`idInterprete`);

--
-- Index pour la table `interpreter`
--
ALTER TABLE `interpreter`
  ADD PRIMARY KEY (`idMusique`,`idProduit`,`idInterprete`);

--
-- Index pour la table `label`
--
ALTER TABLE `label`
  ADD PRIMARY KEY (`idLabel`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`idLIvre`,`idProduit`),
  ADD KEY `FK_Livre_idProduit` (`idProduit`),
  ADD KEY `FK_Livre_idEditeur` (`idEditeur`);

--
-- Index pour la table `musique`
--
ALTER TABLE `musique`
  ADD PRIMARY KEY (`idMusique`,`idProduit`),
  ADD KEY `FK_Musique_idProduit` (`idProduit`),
  ADD KEY `FK_Musique_idLabel` (`idLabel`);

--
-- Index pour la table `production`
--
ALTER TABLE `production`
  ADD PRIMARY KEY (`idProd`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`idProduit`);

--
-- Index pour la table `realisateur`
--
ALTER TABLE `realisateur`
  ADD PRIMARY KEY (`idRealisateur`);

--
-- Index pour la table `realiser`
--
ALTER TABLE `realiser`
  ADD PRIMARY KEY (`idFilm`,`idProduit`,`idRealisateur`),
  ADD KEY `FK_Realiser_idProduit` (`idProduit`),
  ADD KEY `FK_Realiser_idRealisateur` (`idRealisateur`);

--
-- Index pour la table `reserver`
--
ALTER TABLE `reserver`
  ADD PRIMARY KEY (`dateReservation`,`idAdherent`,`idProduit`),
  ADD KEY `FK_Reserver_idExemplaire` (`idProduit`),
  ADD KEY `FK_Reserver_idAdherent` (`idAdherent`);

--
-- Index pour la table `scenariste`
--
ALTER TABLE `scenariste`
  ADD PRIMARY KEY (`idScenariste`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `adherent`
--
ALTER TABLE `adherent`
  MODIFY `idAdherent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `auteur`
--
ALTER TABLE `auteur`
  MODIFY `idAuteur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `compositeur`
--
ALTER TABLE `compositeur`
  MODIFY `idCompositeur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14286;
--
-- AUTO_INCREMENT pour la table `ecrivain`
--
ALTER TABLE `ecrivain`
  MODIFY `idEcrivain` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78946;
--
-- AUTO_INCREMENT pour la table `editeur`
--
ALTER TABLE `editeur`
  MODIFY `idEditeur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123655;
--
-- AUTO_INCREMENT pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  MODIFY `idExemplaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;
--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
  MODIFY `idFilm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT pour la table `genre`
--
ALTER TABLE `genre`
  MODIFY `idGenre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `interprete`
--
ALTER TABLE `interprete`
  MODIFY `idInterprete` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `label`
--
ALTER TABLE `label`
  MODIFY `idLabel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `idLIvre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT pour la table `musique`
--
ALTER TABLE `musique`
  MODIFY `idMusique` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT pour la table `production`
--
ALTER TABLE `production`
  MODIFY `idProd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78946;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `idProduit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=147259;
--
-- AUTO_INCREMENT pour la table `realisateur`
--
ALTER TABLE `realisateur`
  MODIFY `idRealisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `scenariste`
--
ALTER TABLE `scenariste`
  MODIFY `idScenariste` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `compose`
--
ALTER TABLE `compose`
  ADD CONSTRAINT `FK_Compose_idCompositeur` FOREIGN KEY (`idCompositeur`) REFERENCES `compositeur` (`idCompositeur`),
  ADD CONSTRAINT `FK_Compose_idMusique` FOREIGN KEY (`idMusique`) REFERENCES `musique` (`idMusique`),
  ADD CONSTRAINT `FK_Compose_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);

--
-- Contraintes pour la table `creer`
--
ALTER TABLE `creer`
  ADD CONSTRAINT `FK_Creer_idEcrivain` FOREIGN KEY (`idEcrivain`) REFERENCES `ecrivain` (`idEcrivain`),
  ADD CONSTRAINT `FK_Creer_idLIvre` FOREIGN KEY (`idLIvre`) REFERENCES `livre` (`idLIvre`),
  ADD CONSTRAINT `FK_Creer_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);

--
-- Contraintes pour la table `ecrire`
--
ALTER TABLE `ecrire`
  ADD CONSTRAINT `FK_Ecrire_idAuteur` FOREIGN KEY (`idAuteur`) REFERENCES `auteur` (`idAuteur`),
  ADD CONSTRAINT `FK_Ecrire_idMusique` FOREIGN KEY (`idMusique`) REFERENCES `musique` (`idMusique`),
  ADD CONSTRAINT `FK_Ecrire_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);

--
-- Contraintes pour la table `emprunter`
--
ALTER TABLE `emprunter`
  ADD CONSTRAINT `FK_Emprunter_idAdherent` FOREIGN KEY (`idAdherent`) REFERENCES `adherent` (`idAdherent`),
  ADD CONSTRAINT `FK_Emprunter_idExemplaire` FOREIGN KEY (`idExemplaire`) REFERENCES `exemplaire` (`idExemplaire`);

--
-- Contraintes pour la table `estdegenre`
--
ALTER TABLE `estdegenre`
  ADD CONSTRAINT `FK_Est_de_type_idGenre` FOREIGN KEY (`idGenre`) REFERENCES `genre` (`idGenre`),
  ADD CONSTRAINT `FK_Est_de_type_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);

--
-- Contraintes pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  ADD CONSTRAINT `FK_Exemplaire_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FK_Film_idProd` FOREIGN KEY (`idProd`) REFERENCES `production` (`idProd`),
  ADD CONSTRAINT `FK_Film_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);

--
-- Contraintes pour la table `interpreter`
--
ALTER TABLE `interpreter`
  ADD CONSTRAINT `FK_Interpreter_idMusique` FOREIGN KEY (`idMusique`) REFERENCES `musique` (`idMusique`);

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `FK_Livre_idEditeur` FOREIGN KEY (`idEditeur`) REFERENCES `editeur` (`idEditeur`),
  ADD CONSTRAINT `FK_Livre_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);

--
-- Contraintes pour la table `musique`
--
ALTER TABLE `musique`
  ADD CONSTRAINT `FK_Musique_idLabel` FOREIGN KEY (`idLabel`) REFERENCES `label` (`idLabel`),
  ADD CONSTRAINT `FK_Musique_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);

--
-- Contraintes pour la table `realiser`
--
ALTER TABLE `realiser`
  ADD CONSTRAINT `FK_Realiser_idFilm` FOREIGN KEY (`idFilm`) REFERENCES `film` (`idFilm`),
  ADD CONSTRAINT `FK_Realiser_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`),
  ADD CONSTRAINT `FK_Realiser_idRealisateur` FOREIGN KEY (`idRealisateur`) REFERENCES `realisateur` (`idRealisateur`);

--
-- Contraintes pour la table `reserver`
--
ALTER TABLE `reserver`
  ADD CONSTRAINT `FK_Reserver_idAdherent` FOREIGN KEY (`idAdherent`) REFERENCES `adherent` (`idAdherent`),
  ADD CONSTRAINT `FK_Reserver_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
