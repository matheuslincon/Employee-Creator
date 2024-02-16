CREATE TABLE IF NOT EXISTS `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(80) NOT NULL,
  `middle_name` varchar(80),
  `last_name` varchar(80) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contract_type` varchar(80) NOT NULL,
  `start_date` varchar(80) NOT NULL,
  `finish_date` varchar(80) NOT NULL,
  `hours_type` varchar(80) NOT NULL,
  `hours_per_week` INT NOT NULL,
  PRIMARY KEY (`id`)
);