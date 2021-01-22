# projeto-SOCTest
Projeto para criação de um CRUD com o tema EXAMES para avaliação técnica JAVA.

## Técnologias Utilizadas
O projeto foi criado com Spring Boot na linguagem de programação Java com BD MySQL, utilizando Spring Data JPA e o gerenciador de dependência Maven.

## Arquitetura 
O projeto está divido nas seguintes camadas:

*main:*
1. Model - @Entity
2. Repository
3. Service
4. Service Impl
5. Controller
6. Dto

## Como executar
1. Clonar o projeto
2. Ter instalado o BD MySQL 
3. Configurar no aplication.properties a conexão do BD
4. Executar no terminal o comando: ``mvn spring-boot:run``
5. Chamar os endpoint.
