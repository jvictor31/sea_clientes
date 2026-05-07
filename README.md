# API de Clientes - SEA Tecnologia

Backend desenvolvido em Java Spring Boot para gerenciamento de clientes.

---

# Tecnologias

- Java 8
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database
- Maven
- ViaCEP API

---

# Funcionalidades

- Cadastro de clientes
- Listagem de clientes
- Busca de cliente por ID
- Remoção de clientes
- Múltiplos emails
- Múltiplos telefones
- Integração ViaCEP
- Autenticação Basic Auth
- Controle de permissões
- Validações
- API REST

---

# Regras

## Cliente
- Nome aceita letras, números e espaços
- CPF com máscara apenas visual

## Emails
- Um ou mais emails
- Pelo menos um obrigatório

## Telefones
- Múltiplos telefones
- Tipos:
  - celular
  - residencial
  - comercial
- Máscara apenas visual
- Persistência sem máscara

## Endereço
- Busca automática via CEP
- Usuário pode editar os dados retornados
- Campos obrigatórios:
  - CEP
  - Logradouro
  - Bairro
  - Cidade
  - UF

---

# Segurança

## ADMIN

Pode:
- listar
- cadastrar
- deletar

usuario: admin  
senha: 123qwe!@#

---

## USER

Pode:
- apenas listar

usuario: usuario  
senha: 123qwe123

---

# Dados para Teste

Foi disponibilizado um arquivo `data.sql` com carga inicial de dados para facilitar a avaliação técnica do projeto.

Ao iniciar a aplicação, o banco H2 é populado automaticamente com clientes, emails, telefones e endereços de exemplo.

Isso permite validar rapidamente:
- listagem de clientes
- autenticação
- relacionamentos
- integração frontend/backend
- regras de negócio

---

-----------------------

# Como executar

## Requisitos

- Java 8
- Maven

---

## Instalar dependências

```bash
mvn clean install

Executar projeto
mvn spring-boot:run

API
http://localhost:8080

Banco H2
Console
http://localhost:8080/h2-console

JDBC URL
jdbc:h2:file:./data/clientesdb
Usuário
sa
Senha
(vazio)

Endpoints
Listar clientes
GET /clientes

Criar cliente
POST /clientes

Buscar cliente
GET /clientes/{id}

Deletar cliente
DELETE /clientes/{id}

Integração CEP
Utilizado:
ViaCEP

Autor:
João Victor Portella
