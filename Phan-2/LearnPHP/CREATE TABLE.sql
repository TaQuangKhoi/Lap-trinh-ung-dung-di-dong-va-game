CREATE TABLE `test`.`furniture` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `detail` VARCHAR(1000) NOT NULL,
    `price` FLOAT NOT NULL,
    `image` VARCHAR(500) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;