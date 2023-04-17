# MANAGER-SYSTEMS

# TESTE-MANAGER-SYSTEMS
Api desenvolvida como teste técnico, com ás tecnologias Java, Spring e H2 Database.

# Visão Geral

Projeto de uma API, no padrão MVC com o objetivo de avaliação técnica pela empresa Manager Systemns, faz uso de Spring Boot 2.7.10, JDK 17 e  Maven .


Para ilustrar o projeto inclui:

 Um Controlador de acesso e autenticação, onde o usuário informa dados de Login e Senha no endpoint, e recebe um token de acesso com validade de 5 min,
 e outro endpoit de revalidação desse token, quê revalida o token e retorna true em caso de sucesso, são utilizadas camadas de serviço e repositório,
 além de DTOs para a representação das respostas.
 
 Um Controlador que busca os dados de países cadastrados, com endpoints de listagem, listagem com busca dinâmica pelo nome, delete por Id e salva/altera
 de acordo com a informação passada, todos endpoints recebem o token de autenticação e possuem regras de acesso específicas, sendo permitido o acesso aos
 endpoints de salvar e deletar, apenas a administradores.



## Tecnologias :

- Java
- Spring 
- H2 Database


## Demais Funcionalidades

A aplicação usa o Flyway para migração de banco de dados, ModelMapper para a corversão de Dtos e oferece respostas de erro customizadas
e tratamento dessas respostas, através de um ExceptionHandler, com objetivo de auxiliar o usuário, além de validações de entrada com Spring Doc.
