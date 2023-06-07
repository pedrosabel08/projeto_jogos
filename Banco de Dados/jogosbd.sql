-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema projeto_jogos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projeto_jogos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projeto_jogos` DEFAULT CHARACTER SET utf8mb4 ;
USE `projeto_jogos` ;

-- -----------------------------------------------------
-- Table `projeto_jogos`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_jogos`.`endereco` (
  `idendereco` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `referencia` VARCHAR(45) NULL,
  PRIMARY KEY (`idendereco`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_jogos`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_jogos`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(45) NOT NULL,
  `cpfCliente` VARCHAR(45) NOT NULL,
  `telefoneCliente` VARCHAR(45) NOT NULL,
  `endereco_idendereco` INT NOT NULL,
  PRIMARY KEY (`idcliente`, `endereco_idendereco`),
  CONSTRAINT `fk_cliente_endereco1`
    FOREIGN KEY (`endereco_idendereco`)
    REFERENCES `projeto_jogos`.`endereco` (`idendereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_jogos`.`jogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_jogos`.`jogo` (
  `idjogo` INT NOT NULL,
  `nomeJogo` VARCHAR(45) NOT NULL,
  `plataformaJogo` VARCHAR(45) NOT NULL,
  `precoJogo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idjogo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_jogos`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_jogos`.`funcionario` (
  `idfuncionario` INT NOT NULL,
  `nomeFuncionario` VARCHAR(45) NOT NULL,
  `cargoFuncionario` VARCHAR(45) NOT NULL,
  `telefoneFuncionario` VARCHAR(45) NOT NULL,
  `cpfFuncionario` VARCHAR(45) NOT NULL,
  `salarioFuncionario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idfuncionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_jogos`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_jogos`.`venda` (
  `idvenda` INT NOT NULL,
  `data` DATETIME NOT NULL,
  `valor` VARCHAR(45) NOT NULL,
  `cliente_idcliente` INT NOT NULL,
  `jogo_idjogo` INT NOT NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  PRIMARY KEY (`idvenda`, `cliente_idcliente`, `jogo_idjogo`, `funcionario_idfuncionario`),
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `projeto_jogos`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_jogo1`
    FOREIGN KEY (`jogo_idjogo`)
    REFERENCES `projeto_jogos`.`jogo` (`idjogo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_funcionario1`
    FOREIGN KEY (`funcionario_idfuncionario`)
    REFERENCES `projeto_jogos`.`funcionario` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
