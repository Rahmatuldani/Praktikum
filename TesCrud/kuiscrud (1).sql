-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2020 at 11:40 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kuiscrud`
--

-- --------------------------------------------------------

--
-- Table structure for table `rekapfilm`
--

CREATE TABLE `rekapfilm` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `tipe` varchar(20) NOT NULL,
  `episode` varchar(5) NOT NULL,
  `genre` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `rating` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rekapfilm`
--

INSERT INTO `rekapfilm` (`id`, `judul`, `tipe`, `episode`, `genre`, `status`, `rating`) VALUES
(1, 'rr', 'jj', '8', 'mm', 'Belum selesai', '6'),
(2, 'hh', 'll', '6', 'hj', 'Belum selesai', '6'),
(3, 'aa', 'zz', '1', 'cc', 'Belum selesai', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rekapfilm`
--
ALTER TABLE `rekapfilm`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rekapfilm`
--
ALTER TABLE `rekapfilm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
