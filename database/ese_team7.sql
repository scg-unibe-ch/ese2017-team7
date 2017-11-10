-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 10, 2017 at 08:20 AM
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
(1, 'Happy Animals Farm', 1212, 'Heavenstreet 12', 'Heaven'),
(2, 'Evil Slaughterhouse', 6666, 'Devilroad 666', 'Hell'),
(3, 'Dragonstone Castle', 1234, 'On the Sea', 'Dragonstone'),
(4, 'The Wall', 4567, 'In the North', 'The Wall'),
(5, 'Harry Potter', 1111, 'Privet Drive 4', 'Little Whinging'),
(6, 'Hogwarts', 2222, 'Hogwarts', 'Hogwarts'),
(7, 'Happy Animals Farm', 1212, 'Heavenstreet 12', 'Heaven'),
(8, 'Evil Slaughterhouse', 6666, 'Devilroad 666', 'Hell'),
(9, 'Happy Animals Farm', 1212, 'Heavenstreet 12', 'Heaven'),
(10, 'Evil Slaughterhouse', 6666, 'Devilroad 666', 'Hell'),
(11, 'Farmer', 1234, 'First Street', 'Special Town'),
(12, 'Manager', 5678, 'C Road', 'One City');

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
  `time_estimation` float NOT NULL,
  `timeframe` varchar(255) DEFAULT NULL,
  `type_of_animal` varchar(255) DEFAULT NULL,
  `until` date DEFAULT NULL,
  `vehicle` varchar(255) DEFAULT NULL,
  `from_addr_id` int(11) DEFAULT NULL,
  `to_addr_id` int(11) DEFAULT NULL,
  `driver_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ani_order`
--

INSERT INTO `ani_order` (`id`, `driver`, `number_of_animals`, `order_status`, `start_time`, `status_message`, `time_estimation`, `timeframe`, `type_of_animal`, `until`, `vehicle`, `from_addr_id`, `to_addr_id`, `driver_id`) VALUES
(1, 'Mathias Fuchs', 666, 'undelivered', '6666-06-06 06:00:00', 'Exploded on the way, sorry..', 6.6, '06:00 - 18:00', 'Sheep', '6666-06-06', 'Big Transporter', 9, 10, 1),
(2, 'John Snow', 10, 'undelivered', '2017-11-12 00:00:00', '', 7, '10:00-12:00', 'Horse', '2017-11-12', 'Medium Transporter', 3, 4, 2),
(3, 'Harry Potter', 2, 'undelivered', '2017-12-22 10:00:00', '', 4, '14:00-18:00', 'Owls', '2017-12-22', 'Tiny Transporter', 5, 6, 3),
(4, 'Mathias Fuchs', 4, 'undelivered', '2017-11-09 08:00:00', '', 2, '10:00 - 12:00', 'Cows', '2017-11-09', 'Big Transporter', 11, 12, 1);

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
  `time_estimation` float NOT NULL,
  `timeframe` varchar(255) NOT NULL,
  `to_name` varchar(255) NOT NULL,
  `to_plz` int(11) NOT NULL,
  `to_street` varchar(255) NOT NULL,
  `to_town` varchar(255) NOT NULL,
  `type_of_animal` varchar(255) NOT NULL,
  `until` date NOT NULL,
  `vehicle` varchar(255) DEFAULT NULL
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
(2, 'john.snow@anitrans.ch', b'1', 'John Snow', 'Winter1sC0ming', 'ROLE_USER'),
(3, 'harry.poter@anitrans.ch', b'1', 'Harry Potter', 'L0rdV0ldem0ord', 'ROLE_USER'),
(4, 'arya.stark@anitrans.ch', b'1', 'Arya Stark', 'N00ne', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `number_of_vehicles` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`id`, `image`, `name`, `number_of_vehicles`) VALUES
(1, 'images/bigTransporter.jpg', 'Big Transporter', 3),
(2, 'images/mediumTransporter.jpg', 'Medium Transporter', 3),
(3, 'images/smallTransporter.jpg', 'Small Transporter', 5),
(4, 'images/tinyTransporter.jpg', 'Tiny Transporter', 7);

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
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `ani_order`
--
ALTER TABLE `ani_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `new_order`
--
ALTER TABLE `new_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
