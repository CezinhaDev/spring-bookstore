# Bookstore App

Um aplicativo de gerenciamento de livraria desenvolvido em **Java Spring**, utilizando **Spring Web**, **Spring Data JPA**, **Hibernate** e **Maven**. O sistema permite gerenciar livros, autores, editoras e avaliações de forma estruturada, seguindo boas práticas de persistência de dados.

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA / Hibernate
- Maven
- H2 Database / MySQL (opcional)
- Lombok (para reduzir boilerplate)

---

## Estrutura do Projeto

O projeto segue a arquitetura padrão do Spring Boot:

src/main/java
├── com.example.bookstore
│ ├── controller
│ ├── model
│ ├── repository
│ └── service

yaml
Copiar código

---

## Modelagem de Dados

### Entidades Principais

#### Book
- UUID id  
- String title  
- Publisher publisher (relação muitos-para-um)  
- Set<Author> authors (relação muitos-para-muitos)  
- Review review (relação um-para-um)  

#### Author
- UUID id  
- String name  
- Set<Book> books (relação muitos-para-muitos)  

#### Publisher
- UUID id  
- String name  
- Set<Book> books (relação um-para-muitos)  

#### Review
- UUID id  
- String comment  
- Book book (relação um-para-um)  

---

## Funcionalidades

- Criar, atualizar, listar e deletar livros
- Criar, atualizar, listar e deletar autores
- Criar, atualizar, listar e deletar editoras
- Criar, atualizar, listar e deletar reviews
- Consultar livros por autor, editora ou título

---

## Configuração do Projeto

1. Clone o repositório:
```bash
git clone <seu-repositório>
Navegue até a pasta do projeto:


cd bookstore-app
Configure o application.properties ou application.yml para o banco de dados:

properties

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
Rode a aplicação:

mvn spring-boot:run
Acesse a API via:

http://localhost:8080
Estrutura de Endpoints
Método	Endpoint	Descrição
GET	/books	Listar todos os livros
POST	/books	Criar um novo livro
GET	/books/{id}	Obter livro por ID
PUT	/books/{id}	Atualizar livro por ID
DELETE	/books/{id}	Deletar livro por ID

Endpoints similares existem para authors, publishers e reviews.

Exemplos de Request/Response (JSON)

json
Copiar código
{
  "title": "Java Spring Essentials",
  "publisherId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "authorIds": [
    "1f2e3d4c-5b6a-7c8d-9e0f-1a2b3c4d5e6f"
  ]
}
Resposta
json
Copiar código
{
  "id": "7b8c9d0e-1f2a-3b4c-5d6e-7f8a9b0c1d2e",
  "title": "Java Spring Essentials",
  "publisher": {
    "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
    "name": "Tech Books"
  },
  "authors": [
    {
      "id": "1f2e3d4c-5b6a-7c8d-9e0f-1a2b3c4d5e6f",
      "name": "John Doe"
    }
  ]
}
Testes com Postman
Importe os endpoints no Postman.

Configure o método HTTP (GET, POST, PUT, DELETE).

Para POST e PUT, use o corpo (body) em JSON.

Envie requisições para http://localhost:8080.

Contribuição
Faça um fork do projeto.

Crie sua branch:


git checkout -b feature/nova-funcionalidade
Faça commit das suas alterações:


git commit -m "feat: descrição da mudança"
Envie para o branch remoto:


git push origin feature/nova-funcionalidade
Abra um Pull Request.

Licença
Este projeto está sob a licença MIT.

