-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 19, 2017 at 03:03 PM
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
(1, 'Happy Animal Farm', 1212, 'Heaven street 1', 'Heaven'),
(2, 'Evil Slaughterhouse', 6666, 'Devil road 6', 'Hell'),
(3, 'Happy Animal Farm', 1212, 'Heaven street 1', 'Heaven'),
(4, 'Evil Slaughterhouse', 6666, 'Devil road 6', 'Hell'),
(5, 'Happy Animal Farm', 1212, 'Heaven street 1', 'Heaven'),
(6, 'Evil Slaughterhouse', 6666, 'Devil road 6', 'Hell'),
(7, 'Emmentaler Bauernhof', 4350, 'Im Chrache 5', 'Rindertal'),
(8, 'Schlachthaus', 3000, 'Mittelstrasse 10', 'Bern'),
(11, 'a', 0, 'b', 'c'),
(12, 'd', 0, 'e', 'f'),
(13, 'a', 0, 'b', 'c'),
(14, 'd', 0, 'e', 'f'),
(15, 'aba^', 0, 'c', 's'),
(16, 'd', 0, 's', 's'),
(17, 'Mathias Fuchs\' Farm', 3012, 'Hallerstrasse 5', 'Bern'),
(18, 'anitrans', 3012, 'Hallerstrasse 6', 'Bern'),
(19, 'Mathias Fuchs\' Farm', 3012, 'Hallerstrasse 5', 'Bern'),
(20, 'anitrans', 3012, 'Hallerstrasse 6', 'Bern'),
(21, 'Happy Animal Farm', 1212, 'Heaven street 1', 'Heaven'),
(22, 'Evil Slaughterhouse', 6666, 'Devil road 6', 'Hell'),
(23, 'Happy Animal Farm', 1212, 'Heaven street 1', 'Heaven'),
(24, 'Evil Slaughterhouse', 6666, 'Devil road 6', 'Hell'),
(25, 'Mathias Fuchs\' Farm', 3012, 'Hallerstrasse 5', 'Bern'),
(26, 'anitrans', 3012, 'Hallerstrasse 6', 'Bern'),
(27, 'Pig Farm', 2345, 'Hochstrasse 12', 'Seedorf'),
(28, 'Slaughterhouse', 3245, 'Tiefstrasse 6', 'Matten');

-- --------------------------------------------------------

--
-- Table structure for table `ani_order`
--

CREATE TABLE `ani_order` (
  `id` int(11) NOT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `number_of_animals` int(11) NOT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `status_message` varchar(255) DEFAULT NULL,
  `time_estimation` varchar(255) NOT NULL,
  `timeframe` varchar(255) NOT NULL,
  `type_of_animal` varchar(255) NOT NULL,
  `until` date NOT NULL,
  `from_addr_id` int(11) NOT NULL,
  `to_addr_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ani_order`
--

INSERT INTO `ani_order` (`id`, `driver`, `number_of_animals`, `order_status`, `start_time`, `status_message`, `time_estimation`, `timeframe`, `type_of_animal`, `until`, `from_addr_id`, `to_addr_id`) VALUES
(1, 'none', 666, 'delivered', '2017-01-06 00:00:00', '', '6 hours ', '06:00 - 18:00', 'Pigs', '2017-01-06', 23, 24),
(2, 'none', 10, 'undelivered', '2017-01-12 12:00:00', '', '2 hours', '14:00-18:00', 'Rinder', '2017-01-12', 7, 8),
(6, 'Mathias Fuchs', 10, 'undelivered', '2017-12-26 09:00:00', '', '1 hour', '10:00-12:00', 'Sheep', '2017-12-26', 25, 26),
(7, 'Fritzli Moser', 100, 'undelivered', '2017-11-20 08:00:00', '', '5 hours', '13:00 - 15:00', 'Pigs', '2017-11-20', 27, 28);

-- --------------------------------------------------------

--
-- Table structure for table `new_order`
--

CREATE TABLE `new_order` (
  `id` int(11) NOT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `from_name` varchar(255) NOT NULL,
  `from_plz` int(11) NOT NULL,
  `from_street` varchar(255) NOT NULL,
  `from_town` varchar(255) NOT NULL,
  `number_of_animals` int(11) NOT NULL,
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
  `until` date DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `boss` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `boss`, `email`, `name`, `password`) VALUES
(1, b'1', 'mathias.fuchs@anitrans.ch', 'Mathias Fuchs', 'theboss'),
(2, b'0', 'fritz.moser@anitrans.ch', 'Fritzli Moser', 'password123');

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
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `ani_order`
--
ALTER TABLE `ani_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `new_order`
--
ALTER TABLE `new_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
