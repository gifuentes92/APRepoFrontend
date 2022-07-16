-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb_portfolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb_portfolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb_portfolio` DEFAULT CHARACTER SET utf8 ;
USE `mydb_portfolio` ;

-- -----------------------------------------------------
-- Table `mydb_portfolio`.`Provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb_portfolio`.`Provincia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_portfolio`.`Localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb_portfolio`.`Localidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Provincia_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Localidad_Provincia2_idx` (`Provincia_id` ASC) VISIBLE,
  CONSTRAINT `fk_Localidad_Provincia2`
    FOREIGN KEY (`Provincia_id`)
    REFERENCES `mydb_portfolio`.`Provincia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_portfolio`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb_portfolio`.`Persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` VARCHAR(45) NOT NULL,
  `acerca_de` VARCHAR(55) NULL,
  `email` VARCHAR(45) NOT NULL,
  `puesto` VARCHAR(45) NULL,
  `Residencia_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Persona_Localidad1_idx` (`Residencia_id` ASC) VISIBLE,
  CONSTRAINT `fk_Persona_Localidad1`
    FOREIGN KEY (`Residencia_id`)
    REFERENCES `mydb_portfolio`.`Localidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_portfolio`.`Educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb_portfolio`.`Educacion` (
  `idEducacion` INT NOT NULL AUTO_INCREMENT,
  `institucion` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  `nota_promedio` INT(3) NULL,
  `año_inicio` INT(4) NOT NULL,
  `año_fin` INT(4) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`idEducacion`),
  INDEX `fk_Educacion_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Educacion_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb_portfolio`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_portfolio`.`Conocimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb_portfolio`.`Conocimientos` (
  `idConocimientos` INT NOT NULL AUTO_INCREMENT,
  `skill` VARCHAR(55) NOT NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`idConocimientos`),
  INDEX `fk_Conocimientos_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Conocimientos_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb_portfolio`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_portfolio`.`extra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb_portfolio`.`extra` (
  `idextra` INT NOT NULL AUTO_INCREMENT,
  `Habilidad` VARCHAR(45) NULL,
  `Programa` VARCHAR(45) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`idextra`),
  INDEX `fk_extra_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_extra_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb_portfolio`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_portfolio`.`idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb_portfolio`.`idioma` (
  `ididioma` INT NOT NULL AUTO_INCREMENT,
  `Idioma` VARCHAR(45) NULL,
  `Nivel` VARCHAR(45) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`ididioma`),
  INDEX `fk_idioma_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_idioma_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb_portfolio`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
