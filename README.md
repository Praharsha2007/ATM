# 💳 ATM Banking System

A Java-based ATM Banking System with JavaFX UI that allows customers to perform transactions and manage their bank accounts.

---

## 📌 Project Overview

The **ATM Banking System** is a Java-based application designed to simulate real-world ATM operations. It supports both **console-based execution** and a **modern JavaFX UI dashboard**, enabling customers to perform deposits, withdrawals, and view transaction history, while the system manages accounts and validates operations securely.

---

## 🏗️ System Architecture

### 📦 Core Classes

- **ATM** → Central controller managing customers and transactions
- **Account** → Stores balance, PIN, and transaction history
- **Customer** → Represents a bank customer linked to an account
- **Transaction** → Abstract base class for all transaction types
- **DepositTransaction** → Handles deposit logic
- **WithdrawTransaction** → Handles withdrawal with balance validation
- **FileManager** → Handles file I/O for saving and reading data
- **BankUI** → JavaFX UI layer for customer interaction
- **Main** → Entry point for console execution

---

## 💡 Features

- ✅ Customer login with PIN authentication
- ✅ Deposit & withdrawal transactions
- ✅ Real-time balance checking
- ✅ Transaction history tracking
- ✅ Admin dashboard (JavaFX UI)
- ✅ Data validation and error handling
- ✅ File-based data persistence (FileManager)

---

## 📊 Sample Workflow

1. System initializes with pre-loaded customer accounts
2. Customer enters PIN to authenticate
3. Customer selects transaction type (Deposit / Withdraw)
4. System validates and processes the transaction
5. Balance is updated and transaction is recorded
6. Customer views transaction history or checks balance

---

## 📈 Output Highlights

- Displays:
  - Customer account details
  - Transaction ID and type
  - Updated balance after each transaction
  - Full transaction history
- Validates PIN before granting access
- Shows error messages for invalid inputs or insufficient balance

---

## 🔭 Future Enhancements

- Database integration (MySQL)
- Authentication system with roles
- Web-based deployment
- Advanced analytics & charts
- Multi-language support

---

## 🖥️ Technologies Used

- Java (Core + OOP Concepts)
- JavaFX (UI Interface)
- CSS Styling for UI
- Collections Framework (ArrayList, etc.)
- File I/O (FileReader, FileWriter)

---

## ▶️ How to Run

### Console Version

1. Compile all `.java` files
2. Run:

```
javac *.java
java ATM.Main
```

### JavaFX UI Version

1. Ensure JavaFX is installed
2. Run:

```
javac --module-path /path/to/javafx/lib --add-modules javafx.controls ATM/BankUI.java
java --module-path /path/to/javafx/lib --add-modules javafx.controls ATM.BankUI
```

---

## 📋 Conclusion

This project demonstrates:

- Strong use of **Object-Oriented Programming**
- Real-world system design with inheritance and abstraction
- Clean separation of UI and business logic

Each component contributes to building a **complete, functional, and scalable ATM system**.

---

## 🙌 Acknowledgment

We thank our faculty and institution for guiding us through this project and helping us understand real-world software development practices.
