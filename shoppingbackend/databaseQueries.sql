CREATE TABLE category(
id INT,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY (id)
);



CREATE TABLE `onlineshopping`.`Product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  `description` VARCHAR(255) NULL,
  `image_url` VARCHAR(255) NULL,
  `price` DOUBLE NULL,
  `inventory` INT NULL,
  `sold` INT NULL,
  `is_active` TINYINT(1) NULL,
  PRIMARY KEY (`id`));
