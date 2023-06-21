-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema jogosbd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jogosbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jogosbd` DEFAULT CHARACTER SET utf8mb4 ;
USE `jogosbd` ;

-- -----------------------------------------------------
-- Table `jogosbd`.`jogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jogosbd`.`jogo` (
  `idJogo` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeJogo` VARCHAR(50) NOT NULL,
  `plataforma` VARCHAR(50) NOT NULL,
  `valor` DOUBLE NULL DEFAULT NULL,
  `qtd` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idJogo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `jogosbd`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jogosbd`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(50) NOT NULL,
  `cpfCliente` VARCHAR(50) NOT NULL,
  `telefoneCliente` VARCHAR(50) NOT NULL,
  `qtdJogosVendidos` INT(11) NULL DEFAULT NULL,
  `valorTotal` DOUBLE NULL DEFAULT NULL,
  `jogo_idJogo` INT(11) NOT NULL,
  PRIMARY KEY (`idCliente`, `jogo_idJogo`),
  CONSTRAINT `fk_cliente_jogo1`
    FOREIGN KEY (`jogo_idJogo`)
    REFERENCES `jogosbd`.`jogo` (`idJogo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `jogosbd`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jogosbd`.`funcionario` (
  `idFuncionario` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` VARCHAR(50) NOT NULL,
  `telefoneFuncionario` VARCHAR(50) NOT NULL,
  `cargoFuncionario` VARCHAR(50) NOT NULL,
  `salarioFuncionario` DOUBLE NULL DEFAULT NULL,
  `cpfFuncionario` VARCHAR(50) NOT NULL,
  `usuario` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idFuncionario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `jogosbd`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jogosbd`.`venda` (
  `idVenda` INT(11) NOT NULL AUTO_INCREMENT,
  `dataVenda` DATETIME NOT NULL,
  `valorVenda` DOUBLE NULL DEFAULT NULL,
  `idJogo` INT(11) NOT NULL,
  `idFuncionario` INT(11) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idVenda`),
  CONSTRAINT `fk_Venda_Cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `jogosbd`.`cliente` (`idCliente`),
  CONSTRAINT `fk_Venda_Funcionario`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `jogosbd`.`funcionario` (`idFuncionario`),
  CONSTRAINT `fk_Venda_Jogo`
    FOREIGN KEY (`idJogo`)
    REFERENCES `jogosbd`.`jogo` (`idJogo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
