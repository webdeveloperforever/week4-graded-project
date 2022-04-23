-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2022 at 09:07 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_id` int(11) NOT NULL,
  `book_Author` varchar(255) DEFAULT NULL,
  `book_description` varchar(255) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `book_price` int(11) DEFAULT NULL,
  `book_GenereType` varchar(255) DEFAULT NULL,
  `sold_copies` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `book_Author`, `book_description`, `book_name`, `book_price`, `book_GenereType`, `sold_copies`) VALUES
(1, 'James Joyce', 'Ulysses is the Latinised name of Odysseus, the hero of Homer\'s epic poem the Odyssey, and the novel establishes a series of parallels between the poem and the novel, with structural correspondences between the characters and experiences of Bloom.', 'Ulysses', 220, 'Friction', 25),
(2, 'Miguel de Cervantes', 'Don Quixote is a gaunt, middle-aged gentleman who, having gone mad from reading too many books about chivalrous knights, determines to set off on a great adventure to win honor and glory in the name of his invented ladylove, Dulcinea', 'Don Quixote', 1250, 'Novel', 23),
(3, 'Gabriel Garcia Marquez', 'Hundred Years of Solitude tells the story of the fictional Colombian town Macondo and the rise and fall of its founders, the Buendía family.', 'One Hundred Years of Solitude', 980, 'Autobiography', 18),
(4, 'William Shakespeare', ' Hamlet is melancholy, bitter, and cynical, full of hatred for his uncle’s scheming and disgust for his mother’s sexuality. A reflective and thoughtful young man who has studied at the University of Wittenberg, Hamlet is often indecisive and hesitant.', 'Hamlet', 500, 'Melodrama', 30),
(5, 'Marcel Proust', 'In Search of Lost Time follows the narrator\'s recollections of childhood and experiences into adulthood in the late 19th-century and early 20th-century high-society France.', 'In Search of Lost Time ', 1270, 'Autobiography', 22);

-- --------------------------------------------------------

--
-- Table structure for table `logtable`
--

CREATE TABLE `logtable` (
  `Log_Id` int(11) NOT NULL,
  `Date` varchar(255) DEFAULT NULL,
  `Operation` varchar(255) DEFAULT NULL,
  `Time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `logtable`
--
ALTER TABLE `logtable`
  ADD PRIMARY KEY (`Log_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `logtable`
--
ALTER TABLE `logtable`
  MODIFY `Log_Id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
