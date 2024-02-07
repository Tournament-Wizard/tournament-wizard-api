CREATE DATABASE IF NOT EXISTS tournament_wizard;
USE tournament_wizard;

CREATE TABLE IF NOT EXISTS `user` (
`id` INT AUTO_INCREMENT NOT NULL,
`username` VARCHAR(255) NOT NULL,
`password` VARCHAR(255) NOT NULL,
`recovery_question` INT NOT NULL,
`recovery_answer` VARCHAR(255) NOT NULL,
PRIMARY KEY(`id`)
);

SELECT * FROM User;