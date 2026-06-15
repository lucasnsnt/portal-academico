# Portal Acadêmico — Documentação do Projeto

## 1. Visão Geral

Sistema acadêmico desenvolvido em Java com Spring Boot como projeto final da disciplina de Web Back End. Simula o gerenciamento de um ambiente universitário: alunos, matérias, turmas e matrículas com cálculo automático de aprovações.

- **Java:** 21 (rodando com 24 via SDKMAN)
- **Spring Boot:** 4.0.6
- **Banco de dados:** PostgreSQL 16
- **Porta:** 8080
---

## 2. O que o Professor Pede

### Módulo de Alunos
- Cadastro de aluno com: nome, endereço, matrícula e data de ingresso
- Consulta por matrícula → retorna quais matérias o aluno está matriculado e sua média
### Módulo de Matérias
- Cadastro de matéria com: código e ementa (conteúdo)
- Consulta por código da matéria
### Módulo de Turmas
- Cadastro de turma com: código
- Consulta por código da turma → retorna alunos matriculados, suas 3 notas e se foi aprovado (média >= 6)
### Requisitos Gerais
- Dados persistidos em PostgreSQL ✅
- Java com Spring Boot ✅
- Sem autenticação (não é necessário)
- Apresentação em formato de code review
---

## 3. Arquitetura

```
HTTP Request → Controller → Service → Repository → Banco de Dados
HTTP Response ←————————————————————————————————————
```

### Camadas
| Camada | Responsabilidade |
|---|---|
| `entity/` | Modelos de dados (tabelas do banco via JPA) |
| `repository/` | Acesso ao banco (queries automáticas via JpaRepository) |
| `service/` | Lógica de negócio |
| `controller/` | Recebe requisições HTTP e retorna respostas |
| `config/` | Configurações gerais (CORS, tratamento de erros) |
 
---

## 4. Entidades (Banco de Dados)

### Student (Aluno)
| Campo | Tipo | Observação |
|---|---|---|
| registrationNumber | String | Chave primária (matrícula) |
| name | String | Obrigatório |
| address | String | Obrigatório |
| enrollmentDate | LocalDate | Data de ingresso |
| enrollments | List\<Enrollment\> | Relação 1:N |

### Course (Matéria)
| Campo | Tipo | Observação |
|---|---|---|
| code | String | Chave primária |
| name | String | Obrigatório |
| syllabus | String | Ementa, obrigatório |
| classrooms | List\<Classroom\> | Relação 1:N |

### Classroom (Turma)
| Campo | Tipo | Observação |
|---|---|---|
| code | String | Chave primária |
| semester | byte | 1 ou 2 |
| year | int | Ano letivo |
| course | Course | Relação N:1 |
| enrollments | List\<Enrollment\> | Relação 1:N |

### Enrollment (Matrícula)
| Campo | Tipo | Observação |
|---|---|---|
| id | Long | Auto-gerado |
| student | Student | Relação N:1 |
| classroom | Classroom | Relação N:1 |
| firstGrade | double | 0.0 a 10.0 |
| secondGrade | double | 0.0 a 10.0 |
| thirdGrade | double | 0.0 a 10.0 |

### Relacionamentos
```
Student (1) ——— (N) Enrollment (N) ——— (1) Classroom (N) ——— (1) Course
```
 
---

## 5. Endpoints Necessários

### Alunos — StudentController
| Método | Endpoint | Descrição |
|---|---|---|
| POST | /api/students | Cadastrar aluno |
| GET | /api/students/{registration} | Buscar aluno por matrícula |
| PUT | /api/students/{registration} | Atualizar aluno |
| DELETE | /api/students/{registration} | Deletar aluno |
| GET | /api/students/{registration}/average | Matérias matriculadas + médias |

### Matérias — CourseController
| Método | Endpoint | Descrição |
|---|---|---|
| POST | /api/courses | Cadastrar matéria |
| GET | /api/courses/{code} | Buscar matéria por código |
| PUT | /api/courses/{code} | Atualizar matéria |

### Turmas — ClassroomController
| Método | Endpoint | Descrição |
|---|---|---|
| POST | /api/classrooms | Cadastrar turma |
| GET | /api/classrooms/{code} | Buscar turma por código |
| GET | /api/classrooms/{code}/students | Alunos da turma + notas + aprovação |

### Matrículas — EnrollmentController
| Método | Endpoint | Descrição |
|---|---|---|
| POST | /api/enrollments | Matricular aluno em turma |
| PUT | /api/enrollments/{id} | Atualizar notas |
| GET | /api/enrollments/{id} | Buscar matrícula |
 
---

## 6. Regras de Negócio

| Regra | Status |
|---|---|
| Média = (nota1 + nota2 + nota3) / 3 | ✅ Implementado |
| Aprovado se média >= 6.0 | ✅ Implementado |
| Notas entre 0.0 e 10.0 | ✅ Validado na entidade |
| Semestre apenas 1 ou 2 | ✅ Validado na entidade |
| Campos obrigatórios | ✅ @NotBlank nas entidades |
 
---

## 7. Progresso Atual

| Camada | % | Observação |
|---|---|---|
| Entity | 100% | Todas as entidades criadas |
| Repository | 100% | 4 interfaces JpaRepository |
| Service | 15% | Estrutura base + cálculo de média/aprovação |
| Controller | 0% | Não iniciado — próximo passo |
| Config | 0% | CORS e exception handler pendentes |
| Banco | 100% | PostgreSQL conectado, tabelas geradas |
 
---

## 8. Próximos Passos (em ordem)

1. **Controllers** — criar os 4 controllers com os endpoints listados acima
2. **Services** — implementar os métodos CRUD conforme os controllers precisarem
3. **Config** — tratamento global de erros (`@ControllerAdvice`)
4. **Testes manuais** — validar todos os endpoints via Postman/Insomnia
---

## 9. Stack Tecnológico

- Java 21 / Spring Boot 4.0.6
- Spring Data JPA + Hibernate 7
- Spring Web (REST)
- PostgreSQL 16
- Lombok (`@RequiredArgsConstructor`, etc.)
- Bean Validation (`@NotBlank`, `@Min`, `@Max`)
- Maven
 
