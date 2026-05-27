# Marks Management System

A Spring Boot web application for managing student details and marks using Spring MVC, Thymeleaf, Hibernate/JPA, and MySQL.

---

## Features

- Add Student Details
- View Student Information
- Add Student Marks
- Delete Student Records
- Archive Deleted Students
- Archive Deleted Marks
- Automatic Cascade Delete using JPA Relationships
- Form Validation and Error Messages
- Success/Error Flash Messages
- Thymeleaf Dynamic Table Rendering
- MySQL Database Integration

---

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Thymeleaf
- MySQL
- Maven
- Lombok

---

## Project Architecture

The project follows layered architecture:

```text
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
