# Employee Soft Deletion System

This is a Spring Boot-based REST API that demonstrates **soft deletion** of employee records. Instead of permanently deleting records from the database, a `deleted` flag is used to mark them as inactive, ensuring data integrity and auditability.

---

## 🔧 Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- H2 / MySQL (configurable)
- Lombok
- Maven

---

## 📚 Features

- Add new employee records
- View all active employees
- Soft delete employees (`isDeleted = true`)
- Restore soft-deleted employees (optional)
- Filter based on soft-delete status
- Standardized REST responses

---

## 🔄 Soft Delete Implementation

- The `Employee` entity includes a boolean field `isDeleted`.
- Queries are filtered using `@Query` or by overriding default Spring Data methods to include `WHERE is_deleted = false`.

java
@Query("SELECT e FROM Employee e WHERE e.isDeleted = false")
List<Employee> findAllActiveEmployees();
▶️ Running the Application
Clone the repo:

bash
Copy
Edit
git clone https://github.com/Junior-bell/Employee_Soft_Deletion.git
Navigate to the project directory:

bash
Copy
Edit
cd Employee_Soft_Deletion
Run the app:

Using IDE: Run SoftDeleteApplication.java

Or from terminal:

bash
Copy
Edit
./mvnw spring-boot:run
🔗 API Endpoints
Method	Endpoint	Description
GET	/employees	Get all active employees
POST	/employees	Add a new employee
DELETE	/employees/{id}	Soft delete an employee
GET	/employees/deleted	Get all deleted employees
PUT	/employees/restore/{id}	Restore a deleted employee

🧠 Learning Outcome
This project demonstrates how to:

Implement soft deletion logic cleanly

Maintain auditability and data recovery

Write REST APIs using Spring Boot and JPA

📌 Author
Shivam Wagh
📍 Pune, Maharashtra
🔗 GitHub: Junior-bell
