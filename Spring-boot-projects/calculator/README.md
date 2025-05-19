
# 🧮 Spring Boot Calculator API

A simple RESTful calculator built with Spring Boot. It performs basic arithmetic operations including addition, subtraction, multiplication, division, and modulus.

---

## 🚀 Features

- RESTful API endpoints
- Supports:
  - Addition
  - Subtraction
  - Multiplication
  - Division
  - Modulus
- Handles input via query parameters

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Maven

---

## 📦 Project Structure

```
calculator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── app/
│   │   │           └── calculator/
│   │   │               ├── CalculatorApplication.java
│   │   │               ├── controller/
│   │   │               │   └── CalculatorController.java
│   │   │               ├── service/
│   │   │               │   └── CalculatorService.java
│   │   │               └── exception/
│   │   │                   └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── app/
│                   └── calculator/
│                       └── CalculatorApplicationTests.java
└── pom.xml

````

---

## ▶️ How to Run

1**Build and run the app**:

```bash
mvn clean install
mvn spring-boot:run
 ```

2**Access the API** at:
```
http://localhost:8080/calc
```

---

## 🧪 Test the API (via `curl`)

> ⚠️ Make sure to wrap the URL in double quotes to handle `&` correctly in shells.

### ➕ Add

```bash
curl "http://localhost:8080/calc/add?a=10&b=5"
# Response: 15.0
```

### ➖ Subtract

```bash
curl "http://localhost:8080/calc/subtract?a=10&b=5"
# Response: 5.0
```

### ✖️ Multiply

```bash
curl "http://localhost:8080/calc/multiply?a=10&b=5"
# Response: 50.0
```

### ➗ Divide

```bash
curl "http://localhost:8080/calc/divide?a=10&b=5"
# Response: 2.0
```

### 🧮 Modulus

```bash
curl "http://localhost:8080/calc/modulus?a=10&b=3"
# Response: 1.0
```

---

## ❗ Error Handling

* Division by zero will return an HTTP 400 error with a helpful message.

---

## 📬 Feedback

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📄 License

This project is open-source and free to use.

