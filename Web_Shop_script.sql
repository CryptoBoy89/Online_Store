-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema webshop
-- -----------------------------------------------------
-- This is Web Shop model for J2EE project

-- -----------------------------------------------------
-- Schema webshop
--
-- This is Web Shop model for J2EE project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `webshop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `webshop` ;

-- -----------------------------------------------------
-- Table `webshop`.`goods_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webshop`.`goods_category` (
  `category_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(50) NULL COMMENT '',
  PRIMARY KEY (`category_id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webshop`.`goods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webshop`.`goods` (
  `goods_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(100) NULL COMMENT '',
  `category_id1` INT UNSIGNED NOT NULL COMMENT '',
  PRIMARY KEY (`goods_id`)  COMMENT '',
  INDEX `category_id1_idx` (`category_id1` ASC)  COMMENT '',
  CONSTRAINT `category_id1`
    FOREIGN KEY (`category_id1`)
    REFERENCES `webshop`.`goods_category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webshop`.`goods_category_attr`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webshop`.`goods_category_attr` (
  `category_id2` INT UNSIGNED NOT NULL COMMENT '',
  `key` VARCHAR(50) NOT NULL COMMENT '',
  INDEX `category_id_idx` (`category_id2` ASC)  COMMENT '',
  UNIQUE INDEX `key_UNIQUE` (`key` ASC)  COMMENT '',
  CONSTRAINT `category_id2`
    FOREIGN KEY (`category_id2`)
    REFERENCES `webshop`.`goods_category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webshop`.`attr_value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webshop`.`attr_value` (
  `goods_id1` INT UNSIGNED NOT NULL COMMENT '',
  `value` VARCHAR(50) NULL COMMENT '',
  `key1` VARCHAR(50) NOT NULL COMMENT '',
  INDEX `goods_id_idx` (`goods_id1` ASC)  COMMENT '',
  UNIQUE INDEX `key_UNIQUE` (`key1` ASC)  COMMENT '',
  CONSTRAINT `goods_id`
    FOREIGN KEY (`goods_id1`)
    REFERENCES `webshop`.`goods` (`goods_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `key`
    FOREIGN KEY (`key1`)
    REFERENCES `webshop`.`goods_category_attr` (`key`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
