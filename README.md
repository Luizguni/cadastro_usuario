#  Projeto: Cadastro de Usuário com Spring Boot

Este projeto é uma API RESTful desenvolvida em **Java 17** utilizando o **Spring Boot**, com o objetivo de gerenciar cadastros de usuários. A aplicação foi construída com foco em boas práticas de backend, organização em camadas e uso de banco de dados H2 para testes.

---

##  Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.2
- Spring Data JPA
- Lombok
- H2 Database (em memória)
- Maven

---

## 📂 Estrutura do Projeto

```
cadastro_usuario
├── controller           # Camada de controle (endpoints REST)
├── business             # Camada de serviço (lógica de negócio)
├── infrastructure
│   ├── entitys          # Entidades JPA (modelo de dados)
│   └── repository       # Repositórios de persistência
└── resources
    └── application.properties
```

---

## 📌 Endpoints da API

### ✅ Criar Usuário
- **POST** `/usuario`
- **Body**:
```json
{
  "nome": "Luiz Guni",
  "email": "luiz@email.com"
}
```

### 🔍 Buscar Usuário por E-mail
- **GET** `/usuario?email=luiz@email.com`

### ✏️ Atualizar Usuário por ID
- **PUT** `/usuario?id=1`
- **Body**:
```json
{
  "nome": "Luiz Atualizado",
  "email": "atualizado@email.com"
}
```

### ❌ Deletar Usuário por E-mail
- **DELETE** `/usuario?email=luiz@email.com`

---

## 🧪 Acesso ao H2 Console

Acesse o banco de dados em tempo de execução via navegador:

```
http://localhost:8080/h2-console
```

- **JDBC URL**: `jdbc:h2:mem:usuario`
- **User**: `GUNI`
- **Password**: (deixe em branco)

---

## 🧰 Como Executar Localmente

```bash
# Clone o repositório
git clone https://github.com/Luizguni/cadastro_usuario.git

# Acesse o diretório do projeto
cd cadastro_usuario

# Execute o projeto com Maven
./mvnw spring-boot:run
```

---

## 🧠 Destaques Técnicos

- ✅ Camadas bem definidas (Controller, Service, Repository)
- ✅ Boas práticas com Spring Boot e JPA
- ✅ Código limpo, conciso e com uso de `Optional` e `@Builder`
- ✅ Pronto para testes e extensões futuras

---

## 📈 Melhorias Futuras

- [ ] Validações com Bean Validation (`@Email`, `@NotBlank`)
- [ ] Testes unitários com JUnit e Mockito
- [ ] Tratamento global de exceções com `@ControllerAdvice`
- [ ] Integração com PostgreSQL
- [ ] Dockerização da aplicação

---

## 👨‍💻 Autor

**Luiz Guni**  
Desenvolvedor Backend Java & ABAP  
[🔗 GitHub](https://github.com/Luizguni)

---

## ⭐ Contribua com uma Estrela

Se este projeto te ajudou ou demonstrou boas práticas, deixe uma ⭐ no repositório para apoiar!
