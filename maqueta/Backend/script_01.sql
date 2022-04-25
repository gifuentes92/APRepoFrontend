-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` VARCHAR(45) NULL,
  `CUIL` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Contacto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `GitHub` VARCHAR(45) NULL,
  `Facebook` VARCHAR(45) NULL,
  `Discord` VARCHAR(45) NULL,
  `Twitter` VARCHAR(45) NULL,
  `Instagram` VARCHAR(45) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Contacto_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Contacto_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Educacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NOT NULL,
  `Institucion` VARCHAR(45) NOT NULL,
  `Inicio` VARCHAR(45) NOT NULL,
  `Egreso` VARCHAR(45) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Educacion_Persona_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Educacion_Persona`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Habilidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Habilidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Framework` VARCHAR(45) NOT NULL,
  `Nivel` VARCHAR(45) NOT NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Habilidades_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Habilidades_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Experiencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Experiencia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Posicion` VARCHAR(45) NULL,
  `Lugar` VARCHAR(45) NULL,
  `Inicio` VARCHAR(45) NULL,
  `Fin` VARCHAR(45) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Experiencia_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Experiencia_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Extra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Extra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Habilidad` VARCHAR(45) NOT NULL,
  `Programa` VARCHAR(45) NOT NULL,
  `Nivel` VARCHAR(45) NOT NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Extra_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Extra_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Provincia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Localidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Provincia_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Localidad_Provincia1_idx` (`Provincia_id` ASC) VISIBLE,
  CONSTRAINT `fk_Localidad_Provincia1`
    FOREIGN KEY (`Provincia_id`)
    REFERENCES `mydb`.`Provincia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Domicilio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Domicilio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Calle` VARCHAR(45) NOT NULL,
  `Numero` VARCHAR(45) NOT NULL,
  `Piso` VARCHAR(45) NULL,
  `Barrio` VARCHAR(45) NOT NULL,
  `Persona_id` INT NOT NULL,
  `Localidad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Domicilio_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  INDEX `fk_Domicilio_Localidad1_idx` (`Localidad_id` ASC) VISIBLE,
  CONSTRAINT `fk_Domicilio_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `mydb`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Domicilio_Localidad1`
    FOREIGN KEY (`Localidad_id`)
    REFERENCES `mydb`.`Localidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Telefono` (
  `idTelefono` INT NOT NULL,
  `Numero` INT NULL,
  `Contacto_id` INT NOT NULL,
  PRIMARY KEY (`idTelefono`),
  INDEX `fk_Telefono_Contacto1_idx` (`Contacto_id` ASC) VISIBLE,
  CONSTRAINT `fk_Telefono_Contacto1`
    FOREIGN KEY (`Contacto_id`)
    REFERENCES `mydb`.`Contacto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Nivel_educativo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Nivel_educativo` (
  `id` INT NOT NULL,
  `nivel` VARCHAR(45) NULL,
  `Educacion_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Nivel_educativo_Educacion1_idx` (`Educacion_id` ASC) VISIBLE,
  CONSTRAINT `fk_Nivel_educativo_Educacion1`
    FOREIGN KEY (`Educacion_id`)
    REFERENCES `mydb`.`Educacion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
