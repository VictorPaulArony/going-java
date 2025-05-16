
## 🧾 User Registration API (Spring Boot)

A simple RESTful API built with Spring Boot to manage user registration and retrieval in memory. The app provides endpoints to **register users**, **fetch all users**, **fetch a user by ID**, and **delete a user**.

---

### 📁 Project Structure

```
src/
 └── main/
     └── java/
         └── com.user.Registration/
             ├── controller/
             │   └── UserController.java
             ├── service/
             │   └── UserService.java
             └── model/
                 └── User.java
```

---

### 🔧 Technologies Used

* Java 17+
* Spring Boot
* Maven
* REST API (Spring Web)

---

### 🚀 Getting Started

#### Prerequisites

* JDK 17+
* Maven 3.6+
* IDE (IntelliJ, VSCode, Eclipse)

#### Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

By default, the app will run at: `http://localhost:8080`

---

### 📌 API Endpoints

#### ✅ Register a User

**POST** `/api/users/register`

**Request Body:**

```json
{
  "username": "viarony",
  "email": "viarony@example.com"
}
```

**Response:**

```json
{
  "id": 1,
  "username": "viarony",
  "email": "viarony@example.com"
}
```

#### 🔍 Get All Users

**GET** `/api/users`

**Response:**

```json
[
  {
    "id": 1,
    "username": "viarony",
    "email": "viarony@example.com"
  },
  ...
]
```

#### 🔍 Get User by ID

**GET** `/api/users/{id}`

**Example:**

```bash
curl http://localhost:8080/api/users/1
```

**Response (if found):**

```json
{
  "id": 1,
  "username": "viarony",
  "email": "viarony@example.com"
}
```

**404 Response (if not found):**

```http
404 Not Found
```

#### ❌ Delete User

**DELETE** `/api/users/{id}`

**Example:**

```bash
curl -X DELETE http://localhost:8080/api/users/1
```

**Response:**

* `200 OK` – User deleted successfully
* `404 Not Found` – If user doesn't exist

---

### 🧪 Testing the API with `curl`

```bash
# Register a user
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{"username":"smally","email":"smally@example.com"}'

# Get all users
curl http://localhost:8080/api/users

# Get user by ID
curl http://localhost:8080/api/users/1

# Delete a user
curl -X DELETE http://localhost:8080/api/users/1
```

---

### ❗ Notes

* This application uses an **in-memory list**, so all data will be reset when the application restarts.
* This is a basic example for learning or prototyping and **does not persist data**.

---
