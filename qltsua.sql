-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2022 at 07:21 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qltsua`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`ID`, `Name`, `code`) VALUES
(1, 'Cà phê', 'ca-phe'),
(2, 'Trà Sữa', 'tra-sua'),
(3, 'Nước ngọt', 'nuoc-ngọt'),
(5, 'Sinh tố', 'sinh-to'),
(6, 'Topping\r\n', 'topping'),
(7, 'Đồ ăn nhanh', 'do-an-nhanh');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `PhoneNumber` varchar(12) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `ID` int(11) NOT NULL,
  `FullOfName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `PhoneNumber` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`ID`, `FullOfName`, `Username`, `Password`, `PhoneNumber`, `DateOfBirth`, `isAdmin`, `isDeleted`) VALUES
(1, 'Phan Thành Đoan', 'admin', 'admin', '0862083141', '2000-12-16', 1, 0),
(2, 'Nguyễn Công Dự', 'du', '12345', '0862083141', '2021-12-25', 0, 0),
(11, 'Phan Thành Đoan', 'doan', '12345', '0862083141', '2000-12-16', 0, 0),
(12, 'Phạm Minh Nguyên', 'nguyen', '12345', '0924482359', '2000-03-10', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `OrderID` int(11) NOT NULL,
  `TeamilkID` int(11) NOT NULL,
  `ToppingID` int(11) NOT NULL DEFAULT 1,
  `Quantity` int(11) NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`OrderID`, `TeamilkID`, `ToppingID`, `Quantity`, `Total`) VALUES
(11, 1, 1, 5, 75000),
(12, 2, 1, 7, 105000),
(12, 1, 1, 6, 90000),
(13, 1, 1, 4, 60000),
(13, 2, 1, 5, 75000),
(14, 1, 1, 6, 90000),
(14, 3, 1, 6, 90000),
(15, 1, 1, 7, 105000),
(16, 2, 1, 5, 75000),
(17, 2, 1, 5, 75000),
(17, 3, 1, 9, 135000),
(18, 2, 1, 4, 60000),
(19, 3, 1, 5, 75000),
(20, 3, 1, 6, 90000),
(21, 1, 1, 6, 90000),
(22, 2, 1, 4, 60000),
(22, 22, 1, 6, 180000),
(23, 9, 1, 10, 500000),
(23, 8, 1, 3, 75000),
(24, 1, 1, 30, 450000),
(24, 3, 1, 1, 15000),
(25, 19, 1, 63, 1575000),
(25, 20, 1, 3, 45000),
(25, 21, 1, 33, 6600000),
(26, 2, 1, 5, 75000);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `ID` int(11) NOT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `EmployeeID` int(11) NOT NULL,
  `CreatedDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`ID`, `CustomerID`, `EmployeeID`, `CreatedDate`, `Total`) VALUES
(11, NULL, 2, '2022-01-19 07:15:51', 75000),
(12, NULL, 2, '2021-01-19 07:15:51', 195000),
(13, NULL, 2, '2021-01-19 07:15:51', 135000),
(14, NULL, 2, '2021-06-19 07:15:51', 180000),
(15, NULL, 2, '2021-12-19 08:16:56', 105000),
(16, NULL, 2, '2022-01-19 07:15:51', 75000),
(17, NULL, 2, '2022-01-19 07:15:51', 210000),
(18, NULL, 2, '2022-01-19 07:15:51', 60000),
(19, NULL, 2, '2021-01-15 07:22:58', 75000),
(20, NULL, 2, '2022-01-19 08:14:37', 90000),
(21, NULL, 1, '2022-01-21 05:48:57', 90000),
(22, NULL, 1, '2022-01-21 05:51:50', 240000),
(23, NULL, 1, '2022-01-21 06:39:53', 575000),
(24, NULL, 2, '2022-01-21 07:57:27', 465000),
(25, NULL, 1, '2022-01-21 08:01:01', 8220000),
(26, NULL, 2, '2022-01-21 08:23:05', 75000);

-- --------------------------------------------------------

--
-- Table structure for table `teamilk`
--

CREATE TABLE `teamilk` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Price` double NOT NULL,
  `CategoryID` int(11) NOT NULL,
  `Unit` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `teamilk`
--

INSERT INTO `teamilk` (`ID`, `Name`, `Price`, `CategoryID`, `Unit`, `Quantity`, `isDeleted`) VALUES
(1, 'Trà Sữa Ô Long', 15000, 2, 'Ly', 50, 0),
(2, 'Hồng Trà Vải', 15000, 2, 'Ly', 50, 0),
(3, 'Hồng Trà Đào', 15000, 2, 'Ly', 50, 0),
(4, 'Sữa tươi trân châu đường đen', 15000, 2, 'Ly', 50, 0),
(5, 'Trà sữa Socola', 15000, 2, 'Ly', 50, 0),
(6, 'Hồng trà trân châu', 15000, 2, 'Ly', 50, 0),
(7, 'Nâu đá', 25000, 1, 'Ly', 50, 0),
(8, 'Nâu nóng', 25000, 1, 'Ly', 50, 0),
(9, 'Cafe Sữa', 50000, 1, 'Ly', 50, 0),
(10, 'Lọc đá vắt chanh', 40000, 2, 'Chậu', 50, 0),
(11, 'Nâu lắc', 69000, 1, 'Ly', 50, 0),
(12, 'Trà Xanh ', 25000, 3, 'Chai', 50, 0),
(13, 'Trà C2', 20000, 3, 'Chai', 50, 0),
(14, 'Chanh muối', 20000, 2, 'Chai', 50, 0),
(15, 'Coca Cola', 25000, 3, 'Lon', 50, 0),
(16, 'RedBull', 25000, 3, 'Lon', 50, 0),
(17, 'Pepsi', 20000, 3, 'Lon', 50, 0),
(18, 'Trà Gừng', 25000, 2, 'Ly', 50, 0),
(19, 'Trà Dilmah', 25000, 2, 'Ly', 50, 0),
(20, 'Trà chanh', 15000, 2, 'Ly', 50, 0),
(21, 'Trà My', 200000, 2, 'Bát', 50, 0),
(22, 'Sinh tố Xoài', 30000, 5, 'Ly', 50, 1),
(23, 'Sinh tố bơ', 35000, 5, 'Ly', 50, 0),
(24, 'Sinh tố Dưa Hấu', 30000, 5, 'Ly', 50, 0),
(25, 'Sinh tố Mãng Cầu', 35000, 5, 'Ly', 50, 0),
(26, 'Sinh tố chanh leo', 30000, 5, 'Ly', 50, 0),
(27, 'Sinh tố dưa chuột', 35000, 5, 'Ly', 50, 0),
(29, 'Hướng Dương', 15000, 7, 'Gói', 50, 0),
(30, 'Khoai chiên', 15000, 7, 'Dĩa', 0, 0),
(34, 'Cao cao nóng', 25000, 1, 'Ly', 50, 0),
(35, 'Ca cao nguội', 25000, 1, 'Ly', 50, 0),
(36, 'Đen đá', 25000, 1, 'Ly', 50, 0),
(37, 'Đen nóng ', 25000, 1, 'Ly', 50, 0),
(57, 'Mỳ tôm', 15000, 7, 'Gói', 50, 0),
(61, 'No topping', 0, 6, '', NULL, 0),
(62, 'Trân Châu Đen', 5000, 6, 'Phần', NULL, 0),
(63, 'Trân Châu Trắng', 5000, 6, 'Phần', NULL, 0),
(64, 'Trân Châu Bạch Kim', 5000, 6, 'Phần', NULL, 0),
(65, 'Thạch Phô Mai', 5000, 6, 'Phần', NULL, 0),
(66, 'Thạch Socola', 5000, 6, 'Phần', NULL, 0),
(67, 'Trân Châu Tuyết Sợi', 5000, 6, 'Phần', NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD KEY `fk_orderID` (`OrderID`),
  ADD KEY `fk_teamilkID` (`TeamilkID`),
  ADD KEY `fk_toppingID` (`ToppingID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_employee` (`EmployeeID`);

--
-- Indexes for table `teamilk`
--
ALTER TABLE `teamilk`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_categoryID` (`CategoryID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `teamilk`
--
ALTER TABLE `teamilk`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `fk_orderID` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`ID`),
  ADD CONSTRAINT `fk_teamilkID` FOREIGN KEY (`TeamilkID`) REFERENCES `teamilk` (`ID`),
  ADD CONSTRAINT `fk_toppingID` FOREIGN KEY (`ToppingID`) REFERENCES `teamilk` (`ID`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_employee` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`);

--
-- Constraints for table `teamilk`
--
ALTER TABLE `teamilk`
  ADD CONSTRAINT `fk_categoryID` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
