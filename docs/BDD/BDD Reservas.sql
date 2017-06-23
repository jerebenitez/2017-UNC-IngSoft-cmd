-- MySQL Script generated by MySQL Workbench
-- Thu Jun 22 20:08:50 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema basereserva
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema basereserva
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `basereserva` DEFAULT CHARACTER SET utf8 ;
USE `basereserva` ;

-- -----------------------------------------------------
-- Table `basereserva`.`aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`aula` (
  `idaula` INT NOT NULL AUTO_INCREMENT,
  `numero` INT(3) NOT NULL,
  `capacidad` INT(3) NOT NULL,
  `proyector` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idaula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`docente` (
  `idocente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `apellido` VARCHAR(20) NOT NULL,
  `acceso` VARCHAR(15) NOT NULL,
  `login` VARCHAR(15) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idocente`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`materia` (
  `idmateria` INT NOT NULL,
  `nombremat` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idmateria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`modulo` (
  `idmodulo` INT NOT NULL AUTO_INCREMENT,
  `hora_inicio` TIME(2) NOT NULL,
  `hora_fin` TIME(2) NOT NULL,
  PRIMARY KEY (`idmodulo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basereserva`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basereserva`.`reserva` (
  `idreserva` INT NOT NULL AUTO_INCREMENT,
  `idaula` INT NOT NULL,
  `idocente` INT NOT NULL,
  `idmateria` INT NOT NULL,
  `idmodulo` INT NOT NULL,
  `fecha_reserva` DATE NOT NULL,
  `fecha_reservacion` DATETIME NOT NULL,
  PRIMARY KEY (`idreserva`),
  INDEX `fk_reserva_habitacion_idx` (`idaula` ASC),
  INDEX `fk_reserva_docente1_idx` (`idocente` ASC),
  INDEX `fk_reserva_materia1_idx` (`idmateria` ASC),
  INDEX `fk_reserva_modulo1_idx` (`idmodulo` ASC),
  CONSTRAINT `fk_reserva_habitacion`
    FOREIGN KEY (`idaula`)
    REFERENCES `basereserva`.`aula` (`idaula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_docente1`
    FOREIGN KEY (`idocente`)
    REFERENCES `basereserva`.`docente` (`idocente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_materia1`
    FOREIGN KEY (`idmateria`)
    REFERENCES `basereserva`.`materia` (`idmateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_modulo1`
    FOREIGN KEY (`idmodulo`)
    REFERENCES `basereserva`.`modulo` (`idmodulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
