-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 20, 2017 at 09:59 AM
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
(1, 'Mathias Fuchs', 3000, 'Hallerstrasse 5', 'Bern'),
(2, 'Arya Stark', 1111, 'Castle', 'Winterfell'),
(3, 'John Snow', 1111, 'Castle', 'Winterfell'),
(4, 'Tyrion Lannister', 3333, 'Castel', 'Casterly Rock'),
(5, 'Zürich Flughafen', 6000, 'Flughafenstrasse 1', 'Zürich'),
(6, 'Zirkus Knie', 1111, 'on the Road', 'Anywhere'),
(7, 'Zürich Flughafen', 6000, 'Flughafenstrasse 1', 'Zürich'),
(8, 'Zirkus Knie', 1111, 'on the Road', 'Anywhere'),
(9, 'Casterly Rock', 3333, 'Castle', 'Casterly Rock'),
(10, 'King\'s Landing', 6666, 'Red  Keep', 'King\'s Landing'),
(11, 'Casterly Rock', 3333, 'Castle', 'Casterly Rock'),
(12, 'King\'s Landing', 6666, 'Red  Keep', 'King\'s Landing'),
(13, 'Dragonstone', 8888, 'On the sea', 'Dragonstone'),
(14, 'Winterfell', 1111, 'Castle', 'Winterfell'),
(15, 'Happy Animals Farm', 2345, 'Firststreet 4', 'Somewhere'),
(16, 'Evil Slaughterhouse', 6666, 'Hell Road', 'Hell'),
(17, 'Mathias Fuchs', 3000, 'Hallerstrasse 5', 'Bern'),
(18, 'Arya Stark', 1111, 'Castle', 'Winterfell'),
(19, 'John Snow', 1111, 'Castle', 'Winterfell'),
(20, 'Tyrion Lannister', 2222, 'Castle', 'Casterly Rock'),
(21, 'Zürich Flughafen', 6000, 'Flughafenstrasse 1', 'Zürich'),
(22, 'Zirkus Knie', 1111, 'on the Road', 'Anywhere');

-- --------------------------------------------------------

--
-- Table structure for table `ani_order`
--

CREATE TABLE `ani_order` (
  `id` int(11) NOT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `driver_id` int(11) NOT NULL,
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
  `to_addr_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ani_order`
--

INSERT INTO `ani_order` (`id`, `driver`, `driver_id`, `number_of_animals`, `order_status`, `start_time`, `status_message`, `time_estimation`, `timeframe`, `type_of_animal`, `until`, `vehicle`, `from_addr_id`, `to_addr_id`) VALUES
(1, 'Mathias Fuchs', 5, 1, 'undelivered', '2017-12-23 12:00:00', '', 4, '10:00-18:00', 'Elephant', '2017-12-23', 'Big Transporter', 21, 22),
(2, 'Tyrion Lannister', 8, 3, 'undelivered', '2017-11-17 03:00:00', 'exploded on the way, sorry boss!', 5, '10:00-12:00', 'Horses', '2017-11-17', 'Medium Transporter', 11, 12),
(3, 'John Snow', 7, 3, 'undelivered', '2017-12-22 03:00:00', '', 8, '14:00-16:00', 'Dragons', '2017-12-22', 'Big Transporter', 13, 14),
(4, 'Arya Stark', 6, 10, 'delivered', '2017-11-06 06:00:00', 'all good', 6, '06:00 - 18:00', 'Sheep', '2017-11-06', 'Big Transporter', 15, 16);

-- --------------------------------------------------------

--
-- Table structure for table `edited_order`
--

CREATE TABLE `edited_order` (
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
-- Table structure for table `new_user`
--

CREATE TABLE `new_user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `plz` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `street` varchar(255) NOT NULL,
  `town` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` binary(60) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `phone`, `role`, `address_id`) VALUES
(5, 'mathias.fuchs@anitrans.ch', b'1', 'Mathias', 'Fuchs', 0x2432612431302451327763426c2e767a70534262765245774c424f5a4f556d2e6f4e46315934416346397a646f58737464445733674a2f584c74714f, '0795556677', 'ROLE_ADMIN', 17),
(6, 'arya.stark@anitrans.ch', b'1', 'Arya', 'Stark', 0x243261243130244d38685153444c4533637653643255676a53376679756f434856345a44476e514e4d4a3168586773664d3844626937444341413179, '0776667788', 'ROLE_USER', 18),
(7, 'john.snow@anitrans.ch', b'1', 'John', 'Snow', 0x243261243130245053425576534a7847486347642f45306752656d392e617555794c646a3149716b6e63416b33697152316d71636d504c4963457947, '0324445566', 'ROLE_USER', 19),
(8, 'tyrion.lannister@anitrans.ch', b'1', 'Tyrion', 'Lannister', 0x243261243130246575523963496a59636475523472314c563553396d2e624578675049697776716539594e55352f7644523072567447764c484c3457, '0554446677', 'ROLE_USER', 20);

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
-- Indexes for table `edited_order`
--
ALTER TABLE `edited_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `new_order`
--
ALTER TABLE `new_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `new_user`
--
ALTER TABLE `new_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKddefmvbrws3hvl5t0hnnsv8ox` (`address_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `ani_order`
--
ALTER TABLE `ani_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `edited_order`
--
ALTER TABLE `edited_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `new_order`
--
ALTER TABLE `new_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `new_user`
--
ALTER TABLE `new_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKddefmvbrws3hvl5t0hnnsv8ox` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
