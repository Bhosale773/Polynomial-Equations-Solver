-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 25, 2018 at 09:37 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `registration_details`
--

CREATE TABLE `registration_details` (
  `SrNo` int(11) NOT NULL,
  `FirstName` text,
  `LastName` text,
  `UserName` text,
  `PassWord` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration_details`
--

INSERT INTO `registration_details` (`SrNo`, `FirstName`, `LastName`, `UserName`, `PassWord`) VALUES
(1, 'Pratik', 'Bhosale', 'Pratik123', '12345678'),
(2, 'a', 'b', 'abc', 'abcdefgh'),
(3, 'hardik', 'bhanushali', 'habbby', 'hardikbhanu');

-- --------------------------------------------------------

--
-- Table structure for table `summary_table`
--

CREATE TABLE `summary_table` (
  `SrNo` int(11) NOT NULL,
  `FirstName` text,
  `LastName` text,
  `UserName` text,
  `Choice` text,
  `Equations` text,
  `Solution` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `summary_table`
--

INSERT INTO `summary_table` (`SrNo`, `FirstName`, `LastName`, `UserName`, `Choice`, `Equations`, `Solution`) VALUES
(1, 'Pratik', 'Bhosale', 'Pratik123', 'Quadratic Equations', '5X^2 + 9X + 1 = 0', 'X1 = -1.6810249675906654 and X2 = -0.1189750324093346'),
(2, 'Pratik', 'Bhosale', 'Pratik123', 'Linear Equations', '4X + 3Y = 2 and 7X + 5Y = 3', 'X = -1.0 and Y = 2.0'),
(3, 'Pratik', 'Bhosale', 'Pratik123', NULL, NULL, NULL),
(4, 'Pratik', 'Bhosale', 'Pratik123', NULL, NULL, NULL),
(5, 'a', 'b', 'abc', 'Quadratic Equations', '5X^2 + 4X + 1 = 0', 'X1 = NaN and X2 = NaN'),
(6, 'a', 'b', 'abc', NULL, NULL, NULL),
(7, 'hardik', 'bhanushali', 'habbby', 'Linear Equations', '1X + 2Y = 3 and 6X + 5Y = 5', 'X = -0.7142857142857144 and Y = 1.8571428571428572'),
(8, 'hardik', 'bhanushali', 'habbby', 'Linear Equations', '4X + 3Y = 7 and 4X + 6Y = 4', 'X = 2.5 and Y = -1.0'),
(9, 'hardik', 'bhanushali', 'habbby', 'Quadratic Equations', '8X^2 + 9X + 1 = 0', 'X1 = -1.0 and X2 = -0.125'),
(10, 'hardik', 'bhanushali', 'habbby', 'Quadratic Equations', NULL, NULL),
(11, 'Pratik', 'Bhosale', 'Pratik123', 'Linear Equations', '2X + 4Y = 6 and 3X + 5Y = 9', 'X = 3.0 and Y = 0.0'),
(12, 'Pratik', 'Bhosale', 'Pratik123', 'Quadratic Equations', '3X^2 + 5X + 6 = 0', 'X1 = NaN and X2 = NaN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registration_details`
--
ALTER TABLE `registration_details`
  ADD PRIMARY KEY (`SrNo`);

--
-- Indexes for table `summary_table`
--
ALTER TABLE `summary_table`
  ADD PRIMARY KEY (`SrNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registration_details`
--
ALTER TABLE `registration_details`
  MODIFY `SrNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `summary_table`
--
ALTER TABLE `summary_table`
  MODIFY `SrNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
