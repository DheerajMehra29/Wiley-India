-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 02, 2021 at 12:46 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `test_student_table`
--

CREATE TABLE `test_student_table` (
  `rollNo` int(10) UNSIGNED NOT NULL,
  `name` varchar(60) NOT NULL,
  `class` tinyint(2) UNSIGNED DEFAULT 1 COMMENT 'By default, a student is admitted to class 1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='This table stores student data of XYZ school';

--
-- Dumping data for table `test_student_table`
--

INSERT INTO `test_student_table` (`rollNo`, `name`, `class`) VALUES
(1, 'John', 9),
(2, 'Paul', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `test_student_table`
--
ALTER TABLE `test_student_table`
  ADD PRIMARY KEY (`rollNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `test_student_table`
--
ALTER TABLE `test_student_table`
  MODIFY `rollNo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
