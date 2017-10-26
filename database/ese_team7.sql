-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 26, 2017 at 11:18 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ese_team7`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `plz` int(11) NOT NULL,
  `street` varchar(255) NOT NULL,
  `town` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `name`, `plz`, `street`, `town`) VALUES
(1, 'Happy Animal Farm', 3250, 'Rossiweg 3', 'Lyss'),
(2, 'Evil Slaughterhouse', 3012, 'Hallerstrasse 5', 'Bern'),
(5, 'Happy Animal Farm', 3250, 'Rossiweg 3', 'Lyss'),
(6, 'Evil Slaughterhouse', 3012, 'Hallerstrasse 5', 'Bern'),
(7, 'Farm', 3294, 'Highstreet 5', 'Büren a.A.'),
(8, 'Death', 6666, 'Lowstreet 6', 'Hell'),
(9, 'Farm', 3294, 'Highstreet 5', 'Büren a.A.'),
(10, 'Death', 6666, 'Lowstreet 6', 'Hell'),
(11, 'Farm', 3294, 'Highstreet 5', 'Büren a.A.'),
(12, 'Death', 6666, 'Lowstreet 6', 'Hell'),
(13, 'Farm', 3294, 'Highstreet 5', 'Büren a.A.'),
(14, 'Death', 6666, 'Lowstreet 6', 'Hell'),
(15, 'Happy Animal Farm', 3250, 'Rossiweg 3', 'Lyss'),
(16, 'Evil Slaughterhouse', 3012, 'Hallerstrasse 5', 'Bern'),
(17, 'Farm', 3294, 'Highstreet 5', 'Büren a.A.'),
(18, 'Death', 6666, 'Lowstreet 6', 'Hell');

-- --------------------------------------------------------

--
-- Table structure for table `ani_order`
--

CREATE TABLE `ani_order` (
  `id` int(11) NOT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `number_of_animals` int(11) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `status_message` varchar(255) DEFAULT NULL,
  `time_estimation` varchar(255) DEFAULT NULL,
  `timeframe` varchar(255) DEFAULT NULL,
  `type_of_animal` varchar(255) DEFAULT NULL,
  `until` date DEFAULT NULL,
  `from_addr_id` int(11) DEFAULT NULL,
  `to_addr_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ani_order`
--

INSERT INTO `ani_order` (`id`, `driver`, `number_of_animals`, `order_status`, `start_time`, `status_message`, `time_estimation`, `timeframe`, `type_of_animal`, `until`, `from_addr_id`, `to_addr_id`) VALUES
(1, 'Mathias Fuchs', 3, 'delivered', '2017-12-23 12:00:00', 'all good', '2 hours', '14:00 - 15:00', 'Horses', '2017-12-23', 15, 16),
(3, 'Fritz Moser', 40, 'undelivered', '2017-11-27 08:00:00', 'exploded on the way', '4 hours', '08:00 - 15:00', 'Sheep', '2017-11-27', 17, 18);

-- --------------------------------------------------------

--
-- Table structure for table `new_order`
--

CREATE TABLE `new_order` (
  `id` int(11) NOT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `from_name` varchar(255) DEFAULT NULL,
  `from_plz` int(11) NOT NULL,
  `from_street` varchar(255) DEFAULT NULL,
  `from_town` varchar(255) DEFAULT NULL,
  `number_of_animals` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `status_message` varchar(255) DEFAULT NULL,
  `time_estimation` varchar(255) NOT NULL,
  `timeframe` varchar(255) NOT NULL,
  `to_name` varchar(255) NOT NULL,
  `to_plz` int(11) NOT NULL,
  `to_street` varchar(255) NOT NULL,
  `to_town` varchar(255) NOT NULL,
  `type_of_animal` varchar(255) NOT NULL,
  `until` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `enabled`, `name`, `password`, `role`) VALUES
(1, 'mathias.fuchs@anitrans.ch', b'1', 'Mathias Fuchs', 'theboss', 'ROLE_ADMIN'),
(2, 'fritz.moser@anitrans.ch', b'1', 'Fritz Moser', 'Password123', 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ani_order`
--
ALTER TABLE `ani_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqdbest6ramycfy4fo0w9h4htb` (`from_addr_id`),
  ADD KEY `FKtl40l947f9cl8wdtgq21r9ppj` (`to_addr_id`);

--
-- Indexes for table `new_order`
--
ALTER TABLE `new_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `ani_order`
--
ALTER TABLE `ani_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `new_order`
--
ALTER TABLE `new_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ani_order`
--
ALTER TABLE `ani_order`
  ADD CONSTRAINT `FKqdbest6ramycfy4fo0w9h4htb` FOREIGN KEY (`from_addr_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FKtl40l947f9cl8wdtgq21r9ppj` FOREIGN KEY (`to_addr_id`) REFERENCES `address` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
