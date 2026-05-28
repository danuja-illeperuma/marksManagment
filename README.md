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
```

---

## Database Relationships

### Student ↔ Marks Relationship

- One Student can have multiple Marks records
- Each Marks record belongs to one Student

Implemented using:

```java
@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
private List<MarksEntity> marks;
```

and

```java
@ManyToOne
@JoinColumn(name = "reg_no")
private StudentEntity student;
```

---

## Delete Workflow

Instead of permanently deleting records:

1. Student data is copied to `delete_student_data`
2. Marks data is copied to `delete_marks_data`
3. Original student is deleted
4. Related marks are automatically deleted using Cascade Delete

Implemented using:

- `@Transactional`
- `CascadeType.ALL`

---

## User Interface Features

- Dynamic Thymeleaf Tables
- Conditional Rendering using `th:if`
- Loop Rendering using `th:each`
- Success/Error Flash Messages
- Post-Redirect-Get (PRG) Pattern

---

## Setup Instructions

### 1. Clone Repository

```bash
git clone https://github.com/danuja-illeperuma/marksManagment.git
```

---

### 2. Configure MySQL Database

Create database:

```sql
CREATE DATABASE marksdb;
```

---

### 3. Configure application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/marksdb
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

---

### 4. Run Project

Using Maven:

```bash
mvn spring-boot:run
```

or run directly from IntelliJ IDEA.

---

## Learning Objectives

This project was developed to practice and understand:

- Spring MVC Request Flow
- Hibernate/JPA Relationships
- Entity Lifecycle
- Cascade Operations
- Transaction Management
- Thymeleaf Rendering
- PRG Pattern
- Layered Backend Architecture

---

## Future Improvements

- Student Update Module
- Marks Update Module
- Attendance Management
- GPA Calculation
- Login & Authentication
- REST API Integration
- Validation Annotations
- Exception Handling using `@ControllerAdvice`

---

## Author

### Danuja Illeperuma

GitHub:
https://github.com/danuja-illeperuma
