-- MySQL Script generated by MySQL Workbench
-- Thu Sep 19 19:29:41 2024
-- Model: New Model    Version: 1.0
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
-- Table `mydb`.`Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empresa` (
  `id_Empresa` INT GENERATED ALWAYS AS () VIRTUAL,
  `cnpj_Empresa` VARCHAR(45) NOT NULL,
  `nome_Empresa` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(50) NULL,
  PRIMARY KEY (`id_Empresa`),
  UNIQUE INDEX `cnpj_Organizacao_UNIQUE` (`cnpj_Empresa` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `id_Usuario` INT GENERATED ALWAYS AS () VIRTUAL,
  `cpf_Usuario` VARCHAR(11) NOT NULL,
  `cnpj_Usuario` VARCHAR(14) NULL,
  `nome_Usuario` VARCHAR(100) NOT NULL,
  `email_Usuario` VARCHAR(255) NOT NULL,
  `id_Empresa` INT NOT NULL,
  PRIMARY KEY (`id_Usuario`, `id_Empresa`),
  UNIQUE INDEX `cpf_Usuario_UNIQUE` (`cpf_Usuario` ASC) VISIBLE,
  UNIQUE INDEX `cnpj_Usuario_UNIQUE` (`cnpj_Usuario` ASC) VISIBLE,
  UNIQUE INDEX `email_Usuario_UNIQUE` (`email_Usuario` ASC) VISIBLE,
  INDEX `id_Empresa_idx` (`id_Empresa` ASC) VISIBLE,
  CONSTRAINT `id_Organizacao`
    FOREIGN KEY (`id_Empresa`)
    REFERENCES `mydb`.`Empresa` (`id_Empresa`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Equipamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Equipamento` (
  `id_Equipamento` INT GENERATED ALWAYS AS () VIRTUAL,
  `nome` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NULL,
  `categoria` VARCHAR(45) NULL,
  PRIMARY KEY (`id_Equipamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Agendamento` (
  `id_Agendamento` INT GENERATED ALWAYS AS () VIRTUAL,
  `id_Equipamento` INT GENERATED ALWAYS AS () VIRTUAL,
  `id_Usuario` INT NOT NULL,
  `data_hora` TIMESTAMP NOT NULL,
  `duracao_horas` FLOAT NOT NULL,
  PRIMARY KEY (`id_Agendamento`, `id_Equipamento`, `id_Usuario`),
  UNIQUE INDEX `id_Equipamento_UNIQUE` (`id_Equipamento` ASC) VISIBLE,
  UNIQUE INDEX `data_hora_UNIQUE` (`data_hora` ASC) VISIBLE,
  INDEX `id_Usuario_idx` (`id_Usuario` ASC) VISIBLE,
  CONSTRAINT `id_Aparelho`
    FOREIGN KEY (`id_Equipamento`)
    REFERENCES `mydb`.`Equipamento` (`id_Equipamento`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `id_Usuario`
    FOREIGN KEY (`id_Usuario`)
    REFERENCES `mydb`.`Usuario` (`id_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Avaliacao` (
  `id_Avaliacao` INT NULL AUTO_INCREMENT,
  `id_Equipamento` INT NOT NULL,
  `id_Usuario` INT NOT NULL,
  `nota` INT NULL DEFAULT CHECK (nota >= 1 AND nota <= 5),
  `comentario` TINYTEXT NULL,
  `data` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_Avaliacao`, `id_Usuario`, `id_Equipamento`),
  INDEX `id_Usuario_idx` (`id_Usuario` ASC) VISIBLE,
  INDEX `id_Equipamento_idx` (`id_Equipamento` ASC) VISIBLE,
  CONSTRAINT `id_Aparelho`
    FOREIGN KEY (`id_Equipamento`)
    REFERENCES `mydb`.`Equipamento` (`id_Equipamento`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `id_Usuario`
    FOREIGN KEY (`id_Usuario`)
    REFERENCES `mydb`.`Usuario` (`id_Usuario`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
