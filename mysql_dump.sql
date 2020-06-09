CREATE TABLE `communication`.`tbl_customers` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `customerName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `internetPackage` VARCHAR(45) NOT NULL,
  `sector` VARCHAR(45) NOT NULL,
  `customerID` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `communication`.`tbl_login` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `salt` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
