-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: localhost
-- Χρόνος δημιουργίας: 24 Απρ 2021 στις 14:45:30
-- Έκδοση διακομιστή: 8.0.17
-- Έκδοση PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `sales`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `customer`
--

CREATE TABLE `customer` (
  `Ccode` int(10) UNSIGNED NOT NULL,
  `Cname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `customer`
--

INSERT INTO `customer` (`Ccode`, `Cname`) VALUES
(100102, 'Aleksiadis'),
(100103, 'Papadopoulos'),
(100104, 'Ioannou'),
(100105, 'Apostolou'),
(100106, 'Papamarkou'),
(100107, 'kostas'),
(100109, 'gfdgsdf'),
(100110, 'dfgdfg'),
(100111, 'xcbcvbx'),
(100112, 'Eudokia'),
(100114, 'gfdsgdsf');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `family`
--

CREATE TABLE `family` (
  `fid` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `frelationship` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `salesman` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `family`
--

INSERT INTO `family` (`fid`, `fname`, `frelationship`, `dob`, `salesman`) VALUES
(1, 'George', 'son', '1981-02-11', 101),
(2, 'Mry', 'wife', '1977-06-06', 101);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `product`
--

CREATE TABLE `product` (
  `Pcode` int(10) UNSIGNED NOT NULL,
  `Pdescr` varchar(45) NOT NULL,
  `Pprice` decimal(7,2) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `product`
--

INSERT INTO `product` (`Pcode`, `Pdescr`, `Pprice`) VALUES
(1310, 'FooBar', '50.00'),
(1311, 'Keyboard', '100.00'),
(1312, 'HDD 250MB', '60.00'),
(1313, 'Printer 24pin', '81.00'),
(1314, 'TV 17\"', '250.00'),
(1315, 'Printer inkjet', '135.00');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `sales`
--

CREATE TABLE `sales` (
  `Scode` int(10) UNSIGNED NOT NULL,
  `Pcode` int(10) UNSIGNED NOT NULL,
  `Sdate` date DEFAULT NULL,
  `Ccode` int(10) DEFAULT NULL,
  `Smcode` int(10) DEFAULT NULL,
  `Quant` int(10) UNSIGNED DEFAULT NULL,
  `Cost` decimal(7,2) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `sales`
--

INSERT INTO `sales` (`Scode`, `Pcode`, `Sdate`, `Ccode`, `Smcode`, `Quant`, `Cost`) VALUES
(10002, 1313, '1993-07-12', 100102, 101, 10, '700.00'),
(10003, 1312, '1993-03-15', 100104, 105, 16, '760.00'),
(10004, 1310, '1993-04-21', 100106, 103, 12, '400.00'),
(10005, 1310, '1992-12-02', 100103, 102, 25, '1250.00'),
(10007, 1313, '1993-05-17', 100105, 104, 20, '1600.00'),
(10009, 1310, '1992-12-02', 100102, 101, 10, '500.00'),
(10010, 1311, '1992-11-03', 100106, 103, 20, '80.00'),
(10011, 1313, '1993-04-04', 100104, 105, 15, '1150.00');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `salesman`
--

CREATE TABLE `salesman` (
  `Scode` int(10) UNSIGNED NOT NULL,
  `Sname` varchar(20) NOT NULL,
  `Scity` varchar(15) DEFAULT NULL,
  `Scomm` decimal(5,2) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `salesman`
--

INSERT INTO `salesman` (`Scode`, `Sname`, `Scity`, `Scomm`) VALUES
(101, 'Antoniou', 'Athens', '0.13'),
(102, 'Dimou', 'Athens', '0.13'),
(103, 'Vasileiou', 'Patra', '0.13'),
(104, 'Raptisffffff', 'Thessaloniki', '0.13'),
(105, 'Lamprinakis', 'Irakleio', '0.13'),
(107, 'asdfgh', 'Athens', '0.01'),
(108, 'zxcdfg', 'Athens', '0.03');

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `salesmen_keyb`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `salesmen_keyb` (
);

-- --------------------------------------------------------

--
-- Δομή για προβολή `salesmen_keyb`
--
DROP TABLE IF EXISTS `salesmen_keyb`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `salesmen_keyb`  AS  select `s`.`Sname` AS `sname` from ((`salesmen` `s` join `sales` `ss`) join `products` `p`) where ((`s`.`Scode` = `ss`.`Smcode`) and (`ss`.`Sdate` like '1992%') and (`p`.`Pdescr` = 'keyboard') and (`ss`.`Pcode` = `p`.`Pcode`)) ;

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Ευρετήρια για πίνακα `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Ccode`);

--
-- Ευρετήρια για πίνακα `family`
--
ALTER TABLE `family`
  ADD PRIMARY KEY (`fid`);

--
-- Ευρετήρια για πίνακα `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Pcode`);

--
-- Ευρετήρια για πίνακα `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`Scode`),
  ADD KEY `Icode_idx` (`Pcode`),
  ADD KEY `Ccode_idx` (`Ccode`),
  ADD KEY `FK_sales` (`Smcode`);

--
-- Ευρετήρια για πίνακα `salesman`
--
ALTER TABLE `salesman`
  ADD PRIMARY KEY (`Scode`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT για πίνακα `customer`
--
ALTER TABLE `customer`
  MODIFY `Ccode` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100115;

--
-- AUTO_INCREMENT για πίνακα `family`
--
ALTER TABLE `family`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT για πίνακα `salesman`
--
ALTER TABLE `salesman`
  MODIFY `Scode` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `Icode` FOREIGN KEY (`Pcode`) REFERENCES `product` (`Pcode`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
