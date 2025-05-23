# 📚 Library API RESTful - Spring Boot & PostgreSQL

This is a backend REST API developed with **Spring Boot** and **PostgreSQL** that manages library users. The project was created for learning purposes and follows industry best practices for clean architecture, exception handling, and database interaction using JPA.

---

## 🚀 Features

- ✅ CRUD operations for users
- ✅ Search user by ID and email
- ✅ Soft delete (logical deletion using status flag)
- ✅ Global exception handling
- ✅ PostgreSQL integration with custom DB user
- ✅ RESTful architecture (GET, POST, PUT, DELETE)

---

## 🧰 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- IntelliJ / VS Code
- Postman (for testing)

---

## 📂 Project Structure

```bash
src/
├── controller        # REST controllers
├── model             # Entity classes
├── repository        # JPA repositories
├── service           # Business logic (optional layer)
├── exception         # Custom exceptions & handler
└── dto               # (To be added) DTOs for request/response

./mvnw spring-boot:run

📌 Author
Yhonn Mauricio Lara 📧 jmlm1719lara@gmail.com
Backend Developer - Java & Spring Boot

