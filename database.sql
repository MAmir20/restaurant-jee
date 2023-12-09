-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for restaurant_jee
CREATE DATABASE IF NOT EXISTS `restaurant_jee` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `restaurant_jee`;

-- Dumping structure for table restaurant_jee.boissons
CREATE TABLE IF NOT EXISTS `boissons` (
  `nom` varchar(50) NOT NULL,
  `prix` int DEFAULT NULL,
  PRIMARY KEY (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table restaurant_jee.boissons_commande
CREATE TABLE IF NOT EXISTS `boissons_commande` (
  `id_commande` int NOT NULL,
  `nom_boisson` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `quantite` int DEFAULT NULL,
  PRIMARY KEY (`id_commande`,`nom_boisson`) USING BTREE,
  KEY `FK__boissons` (`nom_boisson`),
  CONSTRAINT `FK__boissons` FOREIGN KEY (`nom_boisson`) REFERENCES `boissons` (`nom`),
  CONSTRAINT `FK_boissons_commande_commandes` FOREIGN KEY (`id_commande`) REFERENCES `commandes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table restaurant_jee.commandes
CREATE TABLE IF NOT EXISTS `commandes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `prix_total` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table restaurant_jee.pizzas
CREATE TABLE IF NOT EXISTS `pizzas` (
  `nom` varchar(50) NOT NULL,
  `prix` int DEFAULT NULL,
  PRIMARY KEY (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table restaurant_jee.pizzas_commande
CREATE TABLE IF NOT EXISTS `pizzas_commande` (
  `id_commande` int NOT NULL,
  `nom_pizza` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `quantite` int DEFAULT NULL,
  PRIMARY KEY (`id_commande`,`nom_pizza`) USING BTREE,
  KEY `FK__pizzas` (`nom_pizza`),
  CONSTRAINT `FK__pizzas` FOREIGN KEY (`nom_pizza`) REFERENCES `pizzas` (`nom`) ON UPDATE CASCADE,
  CONSTRAINT `FK_pizzas_commande_commandes` FOREIGN KEY (`id_commande`) REFERENCES `commandes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
