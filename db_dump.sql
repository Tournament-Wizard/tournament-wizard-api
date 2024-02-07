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

INSERT INTO user (id, username, password, recovery_question, recovery_answer)
VALUES
(null, 'Carlos', '74df4764895198bc1c2379e94ff92ae4e58c2137b8ab8f96d81d7025345ccb6e', 2, 'mi mama'),
(null, 'Freeze', '74df4764895198bc1c2379e94ff92ae4e58c2137b8ab8f96d81d7025345ccb6e', 3, 'mi papa');

SELECT * FROM user;

