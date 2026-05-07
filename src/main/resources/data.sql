
-- =========================
-- CLIENTES
-- =========================
INSERT INTO cliente (nome, cpf) VALUES ('João Pereira', '12345678901');
INSERT INTO cliente (nome, cpf) VALUES ('Maria Souza', '98765432100');
INSERT INTO cliente (nome, cpf) VALUES ('Carlos Lima', '11122233344');
INSERT INTO cliente (nome, cpf) VALUES ('Ana Costa', '55566677788');
INSERT INTO cliente (nome, cpf) VALUES ('Pedro Santos', '99988877766');

-- =========================
-- ENDEREÇOS
-- cliente_id assumido na ordem de inserção (1 a 5)
-- =========================
INSERT INTO endereco (bairro, cep, cidade, complemento, logradouro, numero, uf, cliente_id)
VALUES ('Centro', '01001000', 'São Paulo', 'Apto 12', 'Rua A', '123', 'SP', 1);

INSERT INTO endereco (bairro, cep, cidade, complemento, logradouro, numero, uf, cliente_id)
VALUES ('Savassi', '30140071', 'Belo Horizonte', '', 'Rua B', '456', 'MG', 2);

INSERT INTO endereco (bairro, cep, cidade, complemento, logradouro, numero, uf, cliente_id)
VALUES ('Boa Vista', '50070000', 'Recife', 'Casa', 'Av. Central', '789', 'PE', 3);

INSERT INTO endereco (bairro, cep, cidade, complemento, logradouro, numero, uf, cliente_id)
VALUES ('Barra', '40140010', 'Salvador', '', 'Rua das Flores', '321', 'BA', 4);

INSERT INTO endereco (bairro, cep, cidade, complemento, logradouro, numero, uf, cliente_id)
VALUES ('Centro', '80010000', 'Curitiba', 'Bloco C', 'Rua XV', '654', 'PR', 5);

-- =========================
-- TELEFONES
-- =========================
INSERT INTO telefone (numero, tipo, cliente_id)
VALUES ('11999999999', 'celular', 1);

INSERT INTO telefone (numero, tipo, cliente_id)
VALUES ('11988888888', 'comercial', 2);

INSERT INTO telefone (numero, tipo, cliente_id)
VALUES ('21977777777', 'celular', 3);

INSERT INTO telefone (numero, tipo, cliente_id)
VALUES ('31966666666', 'residencial', 4);

INSERT INTO telefone (numero, tipo, cliente_id)
VALUES ('41955555555', 'celular', 5);

-- =========================
-- EMAILS
-- =========================
INSERT INTO email (endereco, cliente_id)
VALUES ('joao@email.com', 1);

INSERT INTO email (endereco, cliente_id)
VALUES ('maria@email.com', 2);

INSERT INTO email (endereco, cliente_id)
VALUES ('carlos@email.com', 3);

INSERT INTO email (endereco, cliente_id)
VALUES ('ana@email.com', 4);

INSERT INTO email (endereco, cliente_id)
VALUES ('pedro@email.com', 5);