-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 09 mai 2026 à 21:13
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mdjb_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `daily_wellnesss`
--

CREATE TABLE `daily_wellnesss` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `sleep_status` varchar(20) NOT NULL,
  `water_status` varchar(20) NOT NULL,
  `food_status` varchar(20) NOT NULL,
  `activity_status` varchar(20) NOT NULL,
  `energy_status` varchar(20) NOT NULL,
  `note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `daily_wellnesss`
--

INSERT INTO `daily_wellnesss` (`id`, `date`, `sleep_status`, `water_status`, `food_status`, `activity_status`, `energy_status`, `note`) VALUES
(8, '2026-05-02', '3', '3', '3', '3', '3', 'bonjour le jour'),
(9, '2026-05-02', '2', '2', '1', '1', '1', 'mauvaise journee'),
(10, '2026-05-06', '3', '2', '3', '3', '3', 'bonjour'),
(11, '2026-05-06', '2', '3', '1', '1', '1', 'bayrem');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `daily_wellnesss`
--
ALTER TABLE `daily_wellnesss`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `daily_wellnesss`
--
ALTER TABLE `daily_wellnesss`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
