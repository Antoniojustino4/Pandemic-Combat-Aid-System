DROP TABLE IF EXISTS hospital;

CREATE TABLE hospital (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  endereco VARCHAR(250) NOT NULL,
  cnpj VARCHAR(250) DEFAULT NULL
);

INSERT INTO hospital (nome, endereco, cnpj) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist');