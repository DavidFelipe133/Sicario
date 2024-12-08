create database Sicario;
use Sicario;

ALTER TABLE User MODIFY id INT AUTO_INCREMENT;

INSERT INTO user (id,nome, senha) VALUES (111,'teste', 'teste');

INSERT INTO user (id,nome, senha) VALUES (1,'david', 'teste');
