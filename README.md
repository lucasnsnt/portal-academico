# Portal Acadêmico

Sistema acadêmico desenvolvido em Java com Spring Boot como projeto final da disciplina de Web Back End.

## Objetivo

O sistema simula o ambiente de uma universidade, permitindo o gerenciamento de alunos, matérias, turmas e matrículas, além do acompanhamento de notas e aprovação dos estudantes.

## Tecnologias Utilizadas

* Java 21
* Spring Boot 4.0.6
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok
* Bean Validation

## Funcionalidades

### Alunos

* Cadastro de alunos
* Consulta de alunos por matrícula
* Visualização das matérias em que o aluno está matriculado
* Consulta da média do aluno

### Matérias

* Cadastro de matérias
* Consulta de matérias por código
* Gerenciamento de ementas

### Turmas

* Cadastro de turmas
* Consulta de turmas por código
* Listagem de alunos matriculados

### Matrículas

* Matrícula de alunos em turmas
* Registro de três notas por aluno
* Cálculo de média
* Verificação automática de aprovação

## Regras de Negócio

* Cada aluno deve possuir:

    * Nome
    * Endereço
    * Matrícula
    * Data de ingresso

* Cada matéria deve possuir:

    * Código
    * Ementa

* Cada turma deve possuir:

    * Código

* Um aluno será considerado aprovado quando sua média for maior ou igual a 6,0.

## Banco de Dados

O projeto utiliza PostgreSQL para persistência dos dados.

As tabelas serão geradas automaticamente pelo Hibernate/JPA durante a execução da aplicação.

## Repositório

Clone o projeto:

```bash
git clone https://github.com/lucasnsnt/portal-academico.git
```

## Como Executar

1. Clone o repositório
2. Configure o PostgreSQL
3. Configure o arquivo `application.properties`
4. Execute a aplicação

```bash
./mvnw spring-boot:run
```
## Autor

Projeto desenvolvido por Lucas Santos para a disciplina de Web Back End / Universidade Tiradentes.
