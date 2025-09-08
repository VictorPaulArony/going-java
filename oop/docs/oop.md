Here's a **cheat sheet for Object-Oriented Programming (OOP) in Java**—a quick reference covering the core principles, syntax, and examples.

---

## ☕ Java OOP Cheat Sheet

### 🔑 4 Core Principles of OOP

| Principle         | Description                                                                  | Java Keyword/Concepts                |
| ----------------- | ---------------------------------------------------------------------------- | ------------------------------------ |
| **Encapsulation** | Binding data (fields) and methods into one unit (class); restricting access. | `private`, `public`, getters/setters |
| **Abstraction**   | Hiding complex implementation and showing only essential features.           | `abstract`, interfaces               |
| **Inheritance**   | One class inherits fields and methods from another.                          | `extends`                            |
| **Polymorphism**  | Ability of an object to take many forms (overriding/overloading).            | `@Override`, method overloading      |

---

### 📦 Class & Object Basics

```java
class Animal {
    String name;

    void speak() {
        System.out.println(name + " makes a sound");
    }
}

// Create object
Animal dog = new Animal();
dog.name = "Dog";
dog.speak(); // Output: Dog makes a sound
```

---

### 🔐 Encapsulation

```java
class Person {
    private String name; // private field

    public void setName(String name) { // setter
        this.name = name;
    }

    public String getName() { // getter
        return name;
    }
}
```

---

### 🧬 Inheritance

```java
class Animal {
    void sound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}
```

---

### 🔁 Polymorphism

#### Method Overriding (Runtime)

```java
class Animal {
    void sound() {
        System.out.println("Some sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}
```

#### Method Overloading (Compile-time)

```java
class MathUtil {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

---

### 🧱 Abstraction

#### Abstract Class

```java
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}
```

#### Interface

```java
interface Drawable {
    void draw();
}

class Square implements Drawable {
    public void draw() {
        System.out.println("Drawing Square");
    }
}
```

---

### 🧰 Access Modifiers

| Modifier    | Class | Package | Subclass | World |
| ----------- | ----- | ------- | -------- | ----- |
| `private`   | ✅     | ❌       | ❌        | ❌     |
| *default*   | ✅     | ✅       | ❌        | ❌     |
| `protected` | ✅     | ✅       | ✅        | ❌     |
| `public`    | ✅     | ✅       | ✅        | ✅     |

---

### 🧠 `this` Keyword

* Refers to current object instance.

```java
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}
```

---

### 🛠 Constructors

```java
class Car {
    String model;

    // Constructor
    Car(String model) {
        this.model = model;
    }
}
```

---

### 📌 Final Notes

* `final` class/method/variable: cannot be overridden/extended/modified.
* `static`: belongs to the class, not instance.
* Java supports **single inheritance only**, but interfaces allow multiple inheritance-like behavior.

---


Great! Here's **Part 2** of the Java OOP Cheat Sheet — diving deeper into important concepts like constructors, static members, final keyword, `super`, nested classes, and more real-world structure.

---

## ☕ Java OOP Cheat Sheet — Part 2

---

### 🔄 Types of Constructors

```java
class Book {
    String title;

    // No-arg constructor
    Book() {
        title = "Unknown";
    }

    // Parameterized constructor
    Book(String t) {
        title = t;
    }
}
```

---

### 🧍‍♂️ Static Members

* Belong to the **class**, not instances.

```java
class Counter {
    static int count = 0; // shared among all instances

    Counter() {
        count++;
    }
}
```

* Static methods can’t access **non-static** members directly.

```java
class Utility {
    static void printMessage() {
        System.out.println("Static method");
    }
}
```

---

### 🔒 `final` Keyword

* **Variable**: can’t be changed
* **Method**: can’t be overridden
* **Class**: can’t be extended

```java
final class ConstantClass {
    final int VALUE = 100;
    
    final void display() {
        System.out.println("Fixed");
    }
}
```

---

### 🧭 `super` Keyword

* Refers to the **parent class**.

```java
class Animal {
    void sound() {
        System.out.println("Animal.java sound");
    }
}

class Dog extends Animal {
    void sound() {
        super.sound(); // calls parent method
        System.out.println("Dog barks");
    }
}
```

---

### 🧱 Nested Classes

#### Static Nested Class

```java
class Outer {
    static class Inner {
        void display() {
            System.out.println("Static inner class");
        }
    }
}
```

#### Non-static Inner Class

```java
class Outer {
    class Inner {
        void display() {
            System.out.println("Non-static inner class");
        }
    }
}
```

---

### 🧵 Object Class Methods (Inherited by all classes)

| Method       | Description                    |
| ------------ | ------------------------------ |
| `toString()` | Converts object to string      |
| `equals()`   | Compares two objects           |
| `hashCode()` | Returns object's hash code     |
| `clone()`    | Creates a copy of the object   |
| `getClass()` | Returns the runtime class info |

```java
@Override
public String toString() {
    return "Custom object string";
}
```

---

### 🧩 Interface vs Abstract Class

| Feature     | Interface                                         | Abstract Class               |
| ----------- | ------------------------------------------------- | ---------------------------- |
| Methods     | Only abstract (Java 8+ allows `default`/`static`) | Can have abstract + concrete |
| Variables   | `public static final` only                        | Any type                     |
| Inheritance | Multiple                                          | Single                       |
| Constructor | Not allowed                                       | Allowed                      |

---

### 🎯 Real-World OOP Example

```java
interface Vehicle {
    void drive();
}

abstract class Car implements Vehicle {
    String model;

    Car(String model) {
        this.model = model;
    }

    abstract void fuelType();

    public void drive() {
        System.out.println(model + " is driving");
    }
}

class Tesla extends Car {
    Tesla() {
        super("Tesla Model S");
    }

    void fuelType() {
        System.out.println("Electric");
    }
}
```

---

### ✅ Common Design Patterns Using OOP

| Pattern   | Use Case                               |
| --------- | -------------------------------------- |
| Singleton | Ensure a class has only one instance   |
| Factory   | Create objects without exposing logic  |
| Builder   | Construct complex objects step-by-step |
| Observer  | Notify objects of state changes        |
| Strategy  | Switch algorithms at runtime           |

---

Here’s a **real-world Java OOP example** that brings together **encapsulation, inheritance, abstraction, polymorphism, interfaces, constructors, `super`, static fields**, and more—all in one mini project.

---

## 🚗 **Vehicle Management System (OOP Java Mini Project)**

### 🔧 Requirements:

* Different types of vehicles: `Car`, `Bike`, `Truck`
* Shared behaviors: `drive()`, `fuelType()`
* Unique behavior per vehicle type
* Use interface `Vehicle`, abstract class `Transport`, concrete classes
* Track total number of vehicles (using `static`)
* Use encapsulation for internal details
* Demonstrate polymorphism

---

### 📦 1. Interface: `Vehicle.java`

```java
public interface Vehicle {
    void drive();
    void fuelType();
}
```

---

### 🏗️ 2. Abstract Class: `Transport.java`

```java
public abstract class Transport implements Vehicle {
    private String brand;
    protected int year;
    static int vehicleCount = 0;

    // Constructor
    public Transport(String brand, int year) {
        this.brand = brand;
        this.year = year;
        vehicleCount++;
    }

    public String getBrand() {
        return brand;
    }

    public abstract void fuelType(); // force subclasses to define
}
```

---

### 🚘 3. Class: `Car.java`

```java
public class Car extends Transport {
    private int numberOfDoors;

    public Car(String brand, int year, int doors) {
        super(brand, year);
        this.numberOfDoors = doors;
    }

    @Override
    public void drive() {
        System.out.println(getBrand() + " car is driving.");
    }

    @Override
    public void fuelType() {
        System.out.println(getBrand() + " uses Petrol.");
    }

    public int getDoors() {
        return numberOfDoors;
    }
}
```

---

### 🏍️ 4. Class: `Bike.java`

```java
public class Bike extends Transport {
    private boolean hasCarrier;

    public Bike(String brand, int year, boolean carrier) {
        super(brand, year);
        this.hasCarrier = carrier;
    }

    @Override
    public void drive() {
        System.out.println(getBrand() + " bike is riding.");
    }

    @Override
    public void fuelType() {
        System.out.println(getBrand() + " uses Petrol.");
    }

    public boolean hasCarrier() {
        return hasCarrier;
    }
}
```

---

### 🚛 5. Class: `Truck.java`

```java
public class Truck extends Transport {
    private double loadCapacity;

    public Truck(String brand, int year, double capacity) {
        super(brand, year);
        this.loadCapacity = capacity;
    }

    @Override
    public void drive() {
        System.out.println(getBrand() + " truck is moving heavy goods.");
    }

    @Override
    public void fuelType() {
        System.out.println(getBrand() + " uses Diesel.");
    }

    public double getCapacity() {
        return loadCapacity;
    }
}
```

---

### 🧪 6. Test Class: `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 2022, 4);
        Bike bike = new Bike("Yamaha", 2021, true);
        Truck truck = new Truck("Volvo", 2020, 10000);

        Transport[] vehicles = {car, bike, truck};

        for (Transport v : vehicles) {
            v.drive();        // Polymorphism
            v.fuelType();     // Polymorphism
            System.out.println("Year: " + v.year);
            System.out.println("Brand: " + v.getBrand());
            System.out.println("----------------------");
        }

        System.out.println("Total vehicles created: " + Transport.vehicleCount);
    }
}
```

---

### 🧠 OOP Concepts Demonstrated:

| OOP Concept       | How it's used                                              |
| ----------------- | ---------------------------------------------------------- |
| **Encapsulation** | Private fields + getters in `Transport`, `Car`             |
| **Abstraction**   | `Vehicle` interface and `Transport` abstract class         |
| **Inheritance**   | `Car`, `Bike`, `Truck` inherit from `Transport`            |
| **Polymorphism**  | `drive()` and `fuelType()` overridden & dynamically called |
| **Static**        | `vehicleCount` tracks shared data                          |
| **Constructors**  | Used to initialize objects with custom values              |
| **Super**         | Used to call parent constructor in subclasses              |

---

### 📝 Output Example:

```
Toyota car is driving.
Toyota uses Petrol.
Year: 2022
Brand: Toyota
----------------------
Yamaha bike is riding.
Yamaha uses Petrol.
Year: 2021
Brand: Yamaha
----------------------
Volvo truck is moving heavy goods.
Volvo uses Diesel.
Year: 2020
Brand: Volvo
----------------------
Total vehicles created: 3
```

---

Would you like:

* ✅ A version with file structure (`.java` file per class)?
* 📄 Export to PDF or Markdown?
* 🌐 Add database interaction (JDBC)?
* 🧪 JUnit test cases for this setup?

Let me know how you’d like to extend or use this.

Perfect — here are **3 more real-world Java OOP examples**, each focusing on different combinations of OOP principles and practical applications. Each example is a separate mini-module.

---

## 🛒 **Example 1: E-Commerce Product System**

### 🧩 Key Concepts: Encapsulation, Abstraction, Inheritance, Polymorphism

### ✅ Requirements:

* Multiple product types: `Book`, `Electronics`
* Common product behaviors
* Pricing logic per type

---

### Base Class: `Product.java`

```java
public abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract double calculateDiscount();
}
```

### Subclass: `Book.java`

```java
public class Book extends Product {
    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }
}
```

### Subclass: `Electronics.java`

```java
public class Electronics extends Product {
    private int warrantyInMonths;

    public Electronics(String name, double price, int warranty) {
        super(name, price);
        this.warrantyInMonths = warranty;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}
```public class Electronics extends Product {

public class Electronics extends Product {

### Testpublic class Electronics extends Product {
public class Electronics extends Product {
: `Store.java`
public class Electronics extends Product {

```javapublic class Electronics extends Product {

public cpublic class Electronics extends Product {
lass Store {
    publpublic class Electronics extends Product {
ic static void main(String[] args) {
        public class Electronics extends Product {
Product p1 = new Book("Java Book", 50.0, "James Gosling");
        public class Electronics extends Product {
Product p2 = new Electronics("Smartphone", 400.0, 24);
public class Electronics extends Product {

        public class Electronics extends Product {
Product[] products = {p1, p2};
public class Electronics extends Product {

        public class Electronics extends Product {
public class Electronics extends Product {
for (Product p : products) {
        public class Electronics extends Product {
    System.out.println(p.getName() + " - Discount: $" + p.calculateDiscount());
                }
        }
}
    }        }

}        }

```        }

        }

---        }

        }

## 🧑‍🎓 **        }
Example 2: School Management System**
        }

### 🧩 K        }
ey Concepts: Interface, Inheritance, Polymorphism, Method Overriding
        }

---        }

        }

### Inte        }
rface: `Person.java`
        }

```java        }

public i        }
nterface Person {
    void        }
 showDetails();
}        }

```        }

        }

### Clas        }
s: `Student.java`
        }

```java        }

public c        }
lass Student implements Person {
    priv        }
ate String name;
    priv        }
ate int grade;
        }

    publ        }
ic Student(String name, int grade) {
                }
this.name = name;
                }
this.grade = grade;
    }        }

        }

    @Ove        }
rride
    publ        }
ic void showDetails() {
                }
System.out.println("Student: " + name + ", Grade: " + grade);
    }        }

}        }

```        }

        }

### Clas        }
s: `Teacher.java`
        }

```java        }

public c        }
lass Teacher implements Person {
    priv        }
ate String name;
    priv        }
ate String subject;
        }

    publ        }
ic Teacher(String name, String subject) {
                }
this.name = name;
                }
this.subject = subject;
    }        }

        }

    @Ove        }
rride
    publ        }
ic void showDetails() {
                }
        }
System.out.println("Teacher: " + name + ", Subject: " + subject);
    }        }

}        }

```        }

        }

### Test        }
: `School.java`
        }

```java        }

public c        }
lass School {
    publ        }
ic static void main(String[] args) {
                }
Person s1 = new Student("Alice", 10);
        Person t1 = new Teacher("Mr. Smith", "Math");

        Person[] people = {s1, t1};

        for (Person p : people) {
            p.showDetails(); // Polymorphism in action
        }
    }
}
```

---

## 🏦 **Example 3: Banking System**

### 🧩 Key Concepts: Inheritance, Static, Final, Encapsulation

---

### Class: `Account.java`

```java
public class Account {
    private static int counter = 1000;
    private final int accountNumber;
    private String holderName;
    private double balance;

    public Account(String holderName, double initialBalance) {
        this.holderName = holderName;
        this.balance = initialBalance;
        this.accountNumber = ++counter;
    }

    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }
}
```

### Subclass: `SavingsAccount.java`

```java
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String holder, double balance, double rate) {
        super(holder, balance);
        this.interestRate = rate;
    }

    public void applyInterest() {
        deposit(getBalance() * interestRate / 100);
    }
}
```

### Test: `BankApp.java`

```java
public class BankApp {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("John Doe", 1000, 5.0);
        sa.deposit(500);
        sa.applyInterest();
        System.out.println("Account: " + sa.getAccountNumber() + ", Balance: $" + sa.getBalance());
    }
}
```

---

## ✅ Summary of What You’ve Practiced

| OOP Feature       | Used In                                 |
| ----------------- | --------------------------------------- |
| **Encapsulation** | All examples                            |
| **Abstraction**   | `Product`, `Person`, `Account`          |
| **Inheritance**   | `Book`, `Electronics`, `SavingsAccount` |
| **Polymorphism**  | `showDetails()`, `calculateDiscount()`  |
| **Interface**     | `Person`                                |
| **Static**        | Account numbering                       |
| **Final**         | `final accountNumber`                   |

---

Would you like:

* 📦 All code zipped and ready to run?
* 🧪 Unit test examples for these?
* 💾 Add file/database I/O?
* 🕸 Convert one into a basic REST API using Spring Boot?

Let me know how you'd like to expand these!
