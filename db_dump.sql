CREATE DATABASE IF NOT EXISTS tournament_wizard;
USE tournament_wizard;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS api_keys;
DROP TABLE IF EXISTS tournaments;

CREATE TABLE IF NOT EXISTS `user` (
`id` INT AUTO_INCREMENT NOT NULL,
`username` VARCHAR(255) NOT NULL,
`password` VARCHAR(255) NOT NULL,
`recovery_question` INT NOT NULL,
`recovery_answer` VARCHAR(255) NOT NULL,
PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `api_keys` (
`id` INT AUTO_INCREMENT NOT NULL,
`value` VARCHAR(255) NOT NULL,
PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `tournaments` (
`id` INT AUTO_INCREMENT NOT NULL,
`Name` VARCHAR(255) NOT NULL,
`Description` VARCHAR(255) NOT NULL,
`Status` VARCHAR(255) NOT NULL,
`Format` VARCHAR(255) NOT NULL,
`Starting_date` DATE NOT NULL,
`Finishing_date` DATE NOT NULL,
`Game` VARCHAR(255) NOT NULL,
`Location` VARCHAR(255) NOT NULL,
`Supervisor` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`)
);

INSERT INTO user (id, username, password, recovery_question, recovery_answer)
VALUES
(null, 'Carlos', '74df4764895198bc1c2379e94ff92ae4e58c2137b8ab8f96d81d7025345ccb6e', 2, 'mi mama'),
(null, 'Freeze', '74df4764895198bc1c2379e94ff92ae4e58c2137b8ab8f96d81d7025345ccb6e', 3, 'mi papa');

INSERT INTO api_keys (id, value)
VALUES
(null, '6872eee4-6c81-4625-a7ae-9c85d14033b9'),
(null, 'dc635b62-8f4b-4bb7-ac77-0bb3c67c4fbc'),
(null, '78f10d8f-6048-474d-96df-16b7339650f7');

INSERT INTO tournaments (id, Name, Description, Status, Format, Starting_date, Finishing_date, Game, Location, Supervisor)
VALUES
(null, 'Circuito Tormenta', 'Lol tournament for anyone', 'Open', 'Swiss', '2024-02-22', '2024-02-27', 'League of Legends', 'Barcelona', 'Freeze'),
(null, 'TryHard Cup', 'CSGO only face it lvl 10', 'Open', 'League', '2024-02-22', '2024-02-27', 'CSGO', 'Barcelona', 'Carlos');

SELECT * FROM user;
SELECT * FROM api_keys;
SELECT * FROM tournaments;