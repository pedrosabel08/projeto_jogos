create database if not exists jogosbd;
use jogosbd;

create table IF NOT EXISTS Funcionario (
idFuncionario int not null auto_increment,
nomeFuncionario varchar(50) not null,
telefoneFuncionario varchar(50) not null,
cargoFuncionario varchar(50) not null,
salarioFuncionario double null,
cpfFuncionario varchar(50) not null,
usuario varchar(50) not null,
senha  varchar(50) not null,
PRIMARY key (idFuncionario)
);

create table IF NOT EXISTS Cliente (
idCliente int not null auto_increment,
nomeCliente varchar(50) not null,
cpfCliente varchar(50) not null,
qtdJogosVendidos int,
valorTotal double,
primary key (idCliente)
);

create table if not exists Jogo (
idJogo int not null auto_increment,
nomeJogo varchar(50) not null,
plataforma varchar(50) not null, 
valor double,
qtd int,
primary key (idJogo)
);

create table if not exists Venda (
idVenda int not null auto_increment,
dataVenda datetime not null,
valorVenda double,
idJogo int not null,
idFuncionario int not null,
idCliente int not null,
primary key (idVenda),
constraint fk_Venda_Jogo foreign key (idJogo) references jogosbd.Jogo (idJogo),
constraint fk_Venda_Funcionario foreign key (idFuncionario) references jogosbd.Funcionario (idFuncionario),
constraint fk_Venda_Cliente foreign key (idCliente) references jogosbd.Cliente (idCliente)
);