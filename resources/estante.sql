create database estante;

create table livros (
id int not null auto_increment primary key,
titulo varchar(60),
autor varchar(60),
dataCad date);