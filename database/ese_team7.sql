-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 13, 2017 at 04:58 PM
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
-- Table structure for table `ani_order`
--

CREATE TABLE `ani_order` (
  `id` int(11) NOT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `from_addr` varchar(255) NOT NULL,
  `number_of_animals` int(11) NOT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `status_message` varchar(255) DEFAULT NULL,
  `time_estimation` varchar(255) NOT NULL,
  `timeframe` varchar(255) NOT NULL,
  `to_addr` varchar(255) NOT NULL,
  `type_of_animal` varchar(255) NOT NULL,
  `until` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ani_order`
--

INSERT INTO `ani_order` (`id`, `driver`, `from_addr`, `number_of_animals`, `order_status`, `start_time`, `status_message`, `time_estimation`, `timeframe`, `to_addr`, `type_of_animal`, `until`) VALUES
(1, 'Housi Meyer', 'Lyss', 10, 'undelivered', '2017-12-12 12:00:00', '', '1 hour', '13:00 - 17:00', 'Bern', 'Cows', '2017-12-12');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `name`, `password`) VALUES
(1, 'housi.meyer@anitrans.ch', 'Housi Meyer', 'password123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ani_order`
--
ALTER TABLE `ani_order`
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
-- AUTO_INCREMENT for table `ani_order`
--
ALTER TABLE `ani_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
