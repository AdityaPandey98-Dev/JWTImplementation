# JWT Authentication & Role-Based Authorization System

A production-style authentication system built using **Spring Boot**, **Spring Security**, **JWT (JSON Web Token)**, **Spring Data JPA**, **Hibernate**, and **MySQL**.

This project demonstrates secure authentication, authorization, password encryption, and REST API development following a layered architecture.

---

## Features

- User Registration
- User Login
- JWT Token Generation
- JWT Token Validation
- Role-Based Authorization (USER, ADMIN)
- BCrypt Password Encryption
- Spring Security Integration
- RESTful APIs
- Global Exception Handling
- MySQL Database Integration
- Layered Architecture

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT (JJWT)
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman

---

## Project Structure

```
src
├── config
├── controller
├── dto
├── entity
├── repository
├── security
├── service
├── util
└── exception
```

---

## Authentication Flow

```
Client

↓

POST /auth/login

↓

AuthenticationManager

↓

CustomUserDetailsService

↓

UserRepository

↓

MySQL Database

↓

JWT Generated

↓

Client Receives JWT

↓

Authorization: Bearer Token

↓

JwtAuthenticationFilter

↓

SecurityContextHolder

↓

Protected APIs
```

---

## REST APIs

### Authentication APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /auth/register | Register a new user |
| POST | /auth/login | Authenticate user and generate JWT |

### Protected APIs

| Method | Endpoint | Access |
|---------|----------|--------|
| GET | /user/profile | USER / ADMIN |
| GET | /user/dashboard | USER / ADMIN |
| GET | /admin/dashboard | ADMIN |

---

## Security Features

- Stateless Authentication
- JWT-Based Authorization
- BCrypt Password Hashing
- Spring Security Filter Chain
- Custom UserDetailsService
- Custom JWT Authentication Filter
- Role-Based Access Control

---

## Technologies & Concepts

- Spring Boot
- Spring Security
- JWT Authentication
- JPA & Hibernate
- MySQL
- REST API
- Layered Architecture
- Dependency Injection
- DTO Pattern
- Repository Pattern
- Global Exception Handling

---

## Future Enhancements

- Refresh Token
- Email Verification
- Forgot Password
- Docker Support
- Swagger/OpenAPI
- Redis Token Blacklisting
- OAuth2 Login
- Unit & Integration Testing

---

## Author

Aditya Kumar Pandey

Java Full Stack Developer
