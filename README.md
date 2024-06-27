# Challenge ONE | Back End | Alura Forum 

# API ForumHub

Este de uma API RESTful desenvolvida com Spring Boot  para o challenge de Backend da Alura e do programa Oracle Next Education. A aplicação permite criar, visualizar, atualizar e excluir tópicos. Apenas usuários cadastrados e autenticados podem criar tópicos, e cada tópico é associado a um curso específico. Além disso, apenas o autor do tópico pode alterá-lo.

## Funcionalidades

- Cadastro de usuários
- Autenticação de usuários
- Criação de tópicos
- Visualização de tópicos
- Atualização de tópicos
- Exclusão de tópicos
- Associação de tópicos a cursos

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.1
- Spring Data JPA
- Spring Security
- PostgreSQL
- MySQL
- JWT (JSON Web Token)
- Lombok
- Maven

## Endpoints

### Autenticação

#### Registrar Usuário

- **URL:** `/api/auth/register`
- **Método:** `POST`
- **Request Body:**
  ```json
  {
    "username": "string",
    "password": "string"
  }
#### Response

```json
{
"id": "long",
"username": "string",
"roles": ["string"]
}
```
#### Login

- **URL:** `/api/auth/login´
- **Método:** POST
- **Request Body:**
- 
```json
{
  "username": "string",
  "password": "string"
}
```

### Tópicos
#### Criar Tópico
- **URL:** /api/topics
- **Método:** POST
- **Headers:**

```json
  {
  "Authorization": "Bearer {token}"
  }
  ```

##### Request body
```json
{
"title": "string",
"message": "string",
"course": "string"
}
```

##### Response
```json
{
"id": "long",
"title": "string",
"message": "string",
"course": "string",
"author": "string",
"created_at": "datetime"
}
```
### Visualizar Tópicos
- **URL:** /api/topics
- **Método:** GET

##### Response:

```json
{
"id": "long",
"title": "string",
"message": "string",
"course": "string",
"author": "string",
"created_at": "datetime"
}
```
### Atualizar Tópico
- **URL:**  /api/topics/{id}
- **Método:** PUT
- **Headers:**
```json
{
"Authorization": "Bearer {token}"
}
```

#### Request body
```json
{
"title": "string",
"message": "string"
}
```

#### Response
```json
{
"id": "long",
"title": "string",
"message": "string",
"course": "string",
"author": "string",
"created_at": "datetime"
}
```

### Excluir Tópico
- **URL:** /api/topics/{id}
- **Método:** DELETE
- **Headers:**
```json
{
"Authorization": "Bearer {token}"
}
```

#### Response
```json
{
"message": "Topic deleted successfully."
}
```

### Autenticação JWT
A autenticação na API ForumHub é feita utilizando JSON Web Tokens (JWT). Para acessar os endpoints protegidos, é necessário incluir um token JWT válido no cabeçalho das requisições.

#### Como Obter um Token
Registre-se na API utilizando o endpoint de registro de usuário.
Faça login utilizando o endpoint de login.
No corpo da resposta do login, você receberá um token JWT.
Inclua este token no cabeçalho das suas requisições aos endpoints protegidos.

#### Exemplo de Cabeçalho de Autenticação
``` json
{
"Authorization": "Bearer {token}"
}
```
## Configuração do Projeto
### Pré-requisitos
### Java 17
### Maven
### Banco de dados MySQL

### Challenge - Forumhub
