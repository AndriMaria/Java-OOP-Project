# 🤝 Donation Management System

A Java-based Donation Management System built as part of my Object-Oriented Programming course during my first year of university. This is my first Java project.

---

## 📚 About the Project

This system manages the flow of donations between donors, beneficiaries, and organizations. It allows donators to offer materials or services, and beneficiaries to request them based on their needs and eligibility levels.

---

## 🛠️ Technologies

- ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white) **Java**
- Object-Oriented Programming (OOP)

---

## 🏗️ Class Structure

| Class | Description |
|---|---|
| `Entity` | Abstract base class representing a donation item |
| `Material` | Extends Entity — represents physical donation items with quantity levels |
| `Service` | Extends Entity — represents volunteer services |
| `User` | Abstract base class for all users |
| `Admin` | Extends User — manages the organization |
| `Donator` | Extends User — can offer donations |
| `Beneficiary` | Extends User — can request donations |
| `Organization` | Manages donors, beneficiaries, and available donations |
| `RequestDonation` | Represents a donation request for a specific entity and quantity |
| `RequestDonationList` | A collection of RequestDonation objects |
| `Offers` | Extends RequestDonationList — tracks what a Donator wants to contribute |
| `Requests` | Extends RequestDonationList — tracks what a Beneficiary needs |
| `Menu` | Handles the user interface menu |

---

## ✨ Features

- **Donator Actions**
  - Add items/services to their offers list
  - Modify or remove offers
  - Commit offers to the organization

- **Beneficiary Actions**
  - Request available donations
  - Eligibility check based on household size (level 1, 2, or 3)
  - Track received donations

- **Organization Actions**
  - Manage donators and beneficiaries
  - Track current available donations
  - List all registered users

- **Admin**
  - Manages the organization

---

## ⚙️ How to Run

1. Make sure you have **Java JDK** installed
2. Clone the repository:
```bash
git clone https://github.com/your-username/Donation-Management-System.git
```
3. Navigate to the project folder:
```bash
cd Donation-Management-System
```
4. Compile all Java files:
```bash
javac *.java
```
5. Run the main class:
```bash
java main
```

---

## 📖 The Process

I started by designing the class hierarchy, with `Entity` and `User` as abstract base classes. Then I built the concrete classes (`Material`, `Service`, `Donator`, `Beneficiary`) following OOP principles like inheritance and polymorphism.

The most challenging part was implementing the eligibility logic in `Requests.java` — checking whether a beneficiary is allowed to receive a certain quantity based on their household size and what they have already received.

---

## 🎓 What I Learned

- **Inheritance & Polymorphism** — Building class hierarchies with abstract classes
- **ArrayList Management** — Storing and manipulating collections of objects
- **OOP Design** — Thinking about how real-world systems can be modeled with classes
- **Java Basics** — Constructors, getters/setters, method overriding

---

## 🚀 How It Can Be Improved

- Add a graphical user interface (GUI)
- Implement proper exception handling (replace `System.out.println` error messages)
- Add a database to persist data between sessions
- Add login/authentication system
- Add unit tests

---

## 📄 License

This project is licensed under the MIT License.

---

🎓 *First-year university project | Object-Oriented Programming course | First Java project*
