# Crudify

Crudify is a RESTful API application built with Spring Boot for managing student records. It implements a standard layered architecture using Controllers, Services, and Repositories to perform Create, Read, Update, and Delete (CRUD) operations backed by a MySQL database.

## 🏗 Architecture Overview

The application follows a clean separation of concerns within the `com.vortex.crudify` package:

*   **Controller (`StudentController.java`):** Handles incoming HTTP requests and routes them to the appropriate service methods.
*   **Service (`StudentService.java`):** Encapsulates the core business logic, such as fetching, creating, or modifying student data.
*   **Repository (`StudentRepository.java`):** An interface that extends Spring Data JPA's `JpaRepository<Student, Long>`, providing built-in methods for database operations without requiring boilerplate SQL code.
*   **Entity (`Student.java`):** Represents the data model mapped to the MySQL database table.

## 🗃️ Data Model

The `Student` entity includes the following properties:

*   `id` (Long): The primary key, configured to be auto-generated (`@GeneratedValue`).
*   `name` (String)
*   `age` (int)
*   `email` (String)
*   `rollNo` (int)
*   `subject` (String)

## 📡 API Endpoints

The base URL for all student-related endpoints is mapped to `/api/students`. 

**Create a Student**
*   **URL:** `/api/students/create`
*   **Method:** `POST`
*   **Description:** Accepts a JSON payload representing a new student and saves it to the database using the `StudentService.createStudent` method.
*   **Success Response:** Returns the created Student object with an `HTTP 201 CREATED` status.

**Get a Student by ID**
*   **URL:** `/api/students/get/{id}`
*   **Method:** `GET`
*   **Description:** Retrieves a specific student record based on the provided path variable `id` using the `StudentService.getStudent(id)` method.

## 🚀 Setup and Installation

1.  **Clone the repository:**
    ```bash
    git clone <your-repository-url>
    ```
2.  **Configure Database:**
    *   Ensure MySQL is running on your local machine.
    *   Create a database (e.g., `student_crud_db`).
    *   Open `src/main/resources/application.properties` and configure it with your local MySQL credentials. Do not use your real password in public commits. Use the following template:

    ```properties
    spring.application.name=crudify

    # Database Connection
    spring.datasource.url=jdbc:mysql://localhost:3306/<your-database-name>
    spring.datasource.username=<your-username>
    spring.datasource.password=<your-password>

    # JPA/Hibernate Configuration
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    ```
3.  **Run the Application:**
    *   You can run the application directly from your IDE (like IntelliJ IDEA) by executing the `CrudifyApplication` main class.
    *   Alternatively, use Maven from the command line: `./mvnw spring-boot:run`
