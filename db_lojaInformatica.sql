CREATE DATABASE IF NOT EXISTS db_lojainformatica;
USE db_lojainformatica;

CREATE TABLE IF NOT EXISTS tb_computador (
	ID int PRIMARY KEY AUTO_INCREMENT,
    Marca varchar(40) NOT NULL,
    HD varchar(40) NOT NULL,
    Processador varchar(40) NOT NULL
);