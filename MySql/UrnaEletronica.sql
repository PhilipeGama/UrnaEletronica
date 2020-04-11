-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema urnaeletronica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema urnaeletronica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `urnaeletronica` DEFAULT CHARACTER SET utf8 ;
USE `urnaeletronica` ;

-- -----------------------------------------------------
-- Table `urnaeletronica`.`partido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `urnaeletronica`.`partido` (
  `parid` INT NOT NULL AUTO_INCREMENT,
  `parnome` VARCHAR(45) NULL,
  PRIMARY KEY (`parid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `urnaeletronica`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `urnaeletronica`.`usuario` (
  `usuid` INT NOT NULL AUTO_INCREMENT,
  `usulogin` VARCHAR(45) NULL,
  `ususenha` VARCHAR(45) NULL,
  PRIMARY KEY (`usuid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `urnaeletronica`.`candidato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `urnaeletronica`.`candidato` (
  `canid` INT NOT NULL AUTO_INCREMENT,
  `cannome` VARCHAR(45) NULL,
  `cannumero` VARCHAR(45) NULL,
  `canparid` INT NOT NULL,
  PRIMARY KEY (`canid`),
  INDEX `fk_candidato_partido_idx` (`canparid` ASC),
  CONSTRAINT `fk_candidato_partido`
    FOREIGN KEY (`canparid`)
    REFERENCES `urnaeletronica`.`partido` (`parid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `urnaeletronica`.`eleitor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `urnaeletronica`.`eleitor` (
  `eleid` INT NOT NULL AUTO_INCREMENT,
  `elenome` VARCHAR(100) NULL,
  `elecpf` VARCHAR(14) NULL,
  `elecep` VARCHAR(9) NULL,
  `elebairro` VARCHAR(45) NULL,
  `elerua` VARCHAR(200) NULL,
  `elenumero` VARCHAR(45) NULL,
  PRIMARY KEY (`eleid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `urnaeletronica`.`urna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `urnaeletronica`.`urna` (
  `urnid` INT NOT NULL,
  `urndatahora` DATETIME NULL,
  `urnvoto` INT NULL,
  `urncanid` INT NOT NULL,
  `urneleid` INT NOT NULL,
  PRIMARY KEY (`urnid`),
  INDEX `fk_urna_candidato1_idx` (`urncanid` ASC),
  INDEX `fk_urna_eleitor1_idx` (`urneleid` ASC),
  CONSTRAINT `fk_urna_candidato1`
    FOREIGN KEY (`urncanid`)
    REFERENCES `urnaeletronica`.`candidato` (`canid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_urna_eleitor1`
    FOREIGN KEY (`urneleid`)
    REFERENCES `urnaeletronica`.`eleitor` (`eleid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
