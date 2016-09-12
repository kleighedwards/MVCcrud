-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema weaponinventory
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `weaponinventory` ;

-- -----------------------------------------------------
-- Schema weaponinventory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `weaponinventory` DEFAULT CHARACTER SET utf8 ;
USE `weaponinventory` ;

-- -----------------------------------------------------
-- Table `weapon_class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weapon_class` ;

CREATE TABLE IF NOT EXISTS `weapon_class` (
  `id` INT NOT NULL,
  `class` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weapon_subclass`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weapon_subclass` ;

CREATE TABLE IF NOT EXISTS `weapon_subclass` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `weapon_class_id` INT NOT NULL,
  `weapon_type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_subclass_class_idx` (`weapon_class_id` ASC),
  CONSTRAINT `fk_subclass_class`
    FOREIGN KEY (`weapon_class_id`)
    REFERENCES `weapon_class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weapon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weapon` ;

CREATE TABLE IF NOT EXISTS `weapon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `attack_rating` INT NULL DEFAULT 0,
  `damage_Type` VARCHAR(45) NULL,
  `weapon_class_id` INT NULL,
  `weapon_subclass_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_weapon_weaponclass_idx` (`weapon_class_id` ASC),
  INDEX `fk_weapon_subclass_idx` (`weapon_subclass_id` ASC),
  CONSTRAINT `fk_weapon_weaponclass`
    FOREIGN KEY (`weapon_class_id`)
    REFERENCES `weapon_class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_weapon_subclass`
    FOREIGN KEY (`weapon_subclass_id`)
    REFERENCES `weapon_subclass` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `infusion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `infusion` ;

CREATE TABLE IF NOT EXISTS `infusion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `infusion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weapon_infusion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weapon_infusion` ;

CREATE TABLE IF NOT EXISTS `weapon_infusion` (
  `weapon_id` INT NOT NULL,
  `infusion_id` INT NOT NULL,
  PRIMARY KEY (`weapon_id`, `infusion_id`),
  INDEX `fk_wi_infusion_idx` (`infusion_id` ASC),
  CONSTRAINT `fk_wi_weapon`
    FOREIGN KEY (`weapon_id`)
    REFERENCES `weapon` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wi_infusion`
    FOREIGN KEY (`infusion_id`)
    REFERENCES `infusion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO weaponuser;
 DROP USER weaponuser;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'weaponuser' IDENTIFIED BY 'weaponuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'weaponuser';
SET SQL_MODE = '';
GRANT USAGE ON *.* TO weaponuser@localhost;
 DROP USER weaponuser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'weaponuser'@'localhost' IDENTIFIED BY 'weaponuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'weaponuser'@'localhost';

-- -----------------------------------------------------
-- Data for table `weapon_class`
-- -----------------------------------------------------
START TRANSACTION;
USE `weaponinventory`;
INSERT INTO `weapon_class` (`id`, `class`) VALUES (1, 'Swords and Daggers');
INSERT INTO `weapon_class` (`id`, `class`) VALUES (2, 'Axes and Hammers');
INSERT INTO `weapon_class` (`id`, `class`) VALUES (3, 'Spears and Halberds');
INSERT INTO `weapon_class` (`id`, `class`) VALUES (4, 'Whips');
INSERT INTO `weapon_class` (`id`, `class`) VALUES (5, 'Bows');
INSERT INTO `weapon_class` (`id`, `class`) VALUES (6, 'Catalysts');

COMMIT;


-- -----------------------------------------------------
-- Data for table `weapon_subclass`
-- -----------------------------------------------------
START TRANSACTION;
USE `weaponinventory`;
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (1, 1, 'Dagger');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (2, 1, 'Straight Sword');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (3, 1, 'Greatsword');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (4, 1, 'Ultra Greatsword');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (5, 1, 'Curved Sword');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (6, 1, 'Katana');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (7, 1, 'Piercing Sword');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (8, 2, 'Spear');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (9, 2, 'Halberd');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (10, 3, 'Axe');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (11, 3, 'Great Axe');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (12, 3, 'Great Hammer');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (13, 4, 'Whip');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (14, 5, 'Bow');
INSERT INTO `weapon_subclass` (`id`, `weapon_class_id`, `weapon_type`) VALUES (15, 6, 'Catalyst');

COMMIT;


-- -----------------------------------------------------
-- Data for table `weapon`
-- -----------------------------------------------------
START TRANSACTION;
USE `weaponinventory`;
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (1, 'Bandit\'s Knife', 56, 'Physical, Bleed', 1, 1);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (2, 'Dark Silver Tracer', 75, 'Physical', 1, 1);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (3, 'Balder Side Sword', 80, 'Physical', 1, 2);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (4, 'Claymore', 103, 'Physical', 1, 3);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (5, 'Moonlight Greatsword', 132, 'Magic', 1, 3);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (6, 'Abyss Greatsword', 160, 'Physical', 1, 3);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (7, 'Demon Great Machete', 133, 'Physical', 1, 4);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (8, 'Shotel', 82, 'Physical', 1, 5);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (9, 'Quelaag\'s Furysword', 240, 'Physical, Fire', 1, 5);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (10, 'Gold Tracer', 130, 'Physical, Bleed', 1, 5);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (11, 'Uchigatana', 90, 'Physical, Bleed', 1, 6);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (12, 'Chaos Blade', 133, 'Physical, Bleed', 1, 6);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (13, 'Velka\'s Rapier', 166, 'Physical, Magic', 1, 7);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (14, 'Crescent Axe', 230, 'Physical, Magic', 3, 10);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (15, 'Black Knight Greataxe', 229, 'Physical', 3, 11);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (16, 'Dragon King Greataxe', 380, 'Physical', 3, 11);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (17, 'Dragon Tooth', 290, 'Physical', 3, 12);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (18, 'Smough\'s Hammer', 300, 'Physical', 3, 12);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (19, 'Dragonslayer Spear', 150, 'Physical, Lightning', 2, 8);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (20, 'Channeler\'s Trident', 174, 'Physical, Magic', 2, 8);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (21, 'Four-pronged Plow', 75, 'Physical', 2, 8);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (22, 'Black Knight Halberd', 245, 'Physical', 2, 9);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (23, 'Giant\'s Halberd', 245, 'Physical, Lightning', 2, 9);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (24, 'Notched Whip', 76, 'Physical, Bleed', 4, 13);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (25, 'Guardian\'s Tail', 84, 'Physical', 4, 13);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (26, 'Black Bow of Pharis', 34, 'Physical', 5, 14);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (27, 'Darkmoon Bow', 160, 'Physical, Magic', 5, 14);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (28, 'Gough\'s Greatbow', 85, 'Physical', 5, 14);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (29, 'Sorcerer\'s Catalyst', 40, 'Magic', 6, 15);
INSERT INTO `weapon` (`id`, `name`, `attack_rating`, `damage_Type`, `weapon_class_id`, `weapon_subclass_id`) VALUES (30, 'Izalith Catalyst', 40, 'Magic', 6, 15);

COMMIT;


-- -----------------------------------------------------
-- Data for table `infusion`
-- -----------------------------------------------------
START TRANSACTION;
USE `weaponinventory`;
INSERT INTO `infusion` (`id`, `infusion`) VALUES (1, 'Physical');
INSERT INTO `infusion` (`id`, `infusion`) VALUES (2, 'Bleed');
INSERT INTO `infusion` (`id`, `infusion`) VALUES (3, 'Fire');
INSERT INTO `infusion` (`id`, `infusion`) VALUES (4, 'Chaos');
INSERT INTO `infusion` (`id`, `infusion`) VALUES (5, 'Lightning');
INSERT INTO `infusion` (`id`, `infusion`) VALUES (6, 'Magic');
INSERT INTO `infusion` (`id`, `infusion`) VALUES (7, 'Dark');

COMMIT;


-- -----------------------------------------------------
-- Data for table `weapon_infusion`
-- -----------------------------------------------------
START TRANSACTION;
USE `weaponinventory`;
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (1, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (1, 2);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (2, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (3, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (4, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (5, 6);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (6, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (7, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (8, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (9, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (9, 3);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (10, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (10, 2);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (11, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (11, 2);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (12, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (12, 2);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (13, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (13, 6);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (14, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (14, 6);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (15, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (16, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (17, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (18, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (19, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (19, 5);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (20, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (20, 6);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (21, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (22, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (23, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (23, 5);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (24, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (24, 2);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (25, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (26, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (27, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (27, 6);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (28, 1);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (29, 6);
INSERT INTO `weapon_infusion` (`weapon_id`, `infusion_id`) VALUES (30, 6);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
