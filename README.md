# Smart Loan Engine (Java)

A real-world inspired **Car Loan Approval System** built using core Java.
This project simulates how financial institutions evaluate loan applications based on **creditworthiness, repayment capacity, and risk analysis**.

---

## Key Features

* **Custom Credit Scoring System**
  Calculates a score (300–900) based on:
<p align="center">
  <img src="https://media.giphy.com/media/l3vR85PnGsBwu1PFK/giphy.gif" width="100%" />
</p>

<h1 align="center">💳 Smart Loan Engine</h1>

<h3 align="center">
A Real-World Inspired Loan Approval System Built with Java ☕
</h3>

<p align="center">
  <img src="https://img.shields.io/badge/Java-Core%20Java-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/OOP-Design-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Finance-Logic-green?style=for-the-badge" />
  <img src="https://img.shields.io/github/stars/RobinChahal0010/SmartLoanEngine-Java?style=for-the-badge" />
</p>

---

# 🧠 About The Project

Smart Loan Engine is a **real-world inspired Car Loan Approval System** developed using **Core Java**.

The project simulates how financial institutions evaluate loan applications using:

- Credit Scoring
- EMI Calculation
- Debt-to-Income Analysis
- Risk Categorization
- Approval/Rejection Logic

It focuses on **backend decision-making systems** and demonstrates how financial software evaluates customer reliability.

---

# ⚙️ Core Features

## 📊 Credit Score Calculation

The system generates a custom score between **300–900** using:

- Average Bank Balance
- 5-Year Transaction History
- Account Age
- Failed Transactions

---

## 💸 EMI Calculation Engine

Uses the standard EMI formula to calculate:

- Monthly EMI
- Loan affordability
- Repayment burden

---

## 📈 Debt-To-Income (DTI) Validation

Ensures:

```txt
Total EMI ≤ 40% of Monthly Income
```

Prevents risky loan approvals.

---

## 🚨 Risk Analysis System

Customers are categorized as:

| Score Range | Risk |
|---|---|
| 750+ | Low Risk |
| 650–749 | Medium Risk |
| Below 650 | High Risk |

---

## ❌ Smart Rejection Logic

Loan gets rejected if:

- Credit score is too low
- EMI burden exceeds safe limit
- Invalid financial data is entered

---

# 🏗️ System Flow

```txt
User Input
    ↓
Credit Score Calculation
    ↓
EMI Calculation
    ↓
DTI Validation
    ↓
Risk Analysis
    ↓
Final Loan Decision
```

---

# 🧩 Project Structure

```txt
├── Customer.java
├── CreditScoreCalculator.java
├── EMICalculator.java
├── LoanService.java
├── RiskAnalyzer.java
├── Main.java
```

---

# 🖥️ Screenshots

## ✅ Approved Loan Case

<img width="850" src="./assets
/Screenshot 2026-05-16 220359.png"/>

---

## ❌ Rejected Loan Case

<img width="850" src="https://i.imgur.com/Q6v5N8F.png"/>

---

# 🚀 Sample Output

```txt
===== LOAN APPROVAL RESULT =====

CIBIL Score: 782
Risk Category: Low Risk

LOAN APPROVED ✅

Interest Rate: 8.5%
Tenure: 5 years
Monthly EMI: Rs 10258.27
```

---

# 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java | Core Development |
| OOP | Modular Design |
| Arrays | Transaction Analysis |
| Mathematical Modeling | EMI & Financial Logic |

---

# 🧠 Concepts Demonstrated

- Object-Oriented Programming
- Real-World Business Logic
- Financial System Design
- Input Validation
- Modular Architecture
- Decision Engines

---

# 🌍 Real-World Relevance

In production banking systems, this engine could evolve into:

- Stateless Backend Service
- REST API
- Microservice Architecture
- Database Integrated System
- Distributed Loan Processing Engine

---

# 📚 What I Learned

✔ Designing financial approval systems  
✔ Implementing real-world logic in Java  
✔ Writing modular backend code  
✔ Handling validations & edge cases  
✔ Translating business rules into software  

---

# 🔮 Future Improvements

- REST API Integration
- MySQL/PostgreSQL Support
- Spring Boot Version
- Web Dashboard
- Multi-user Processing
- AI-Based Risk Prediction

---

# 👨‍💻 Author

## Robinpreet Singh Chahal

☕ Backend Engineering Enthusiast  
🌴 Coffee & Code Under the Palm  
🚀 Passionate About Real-World Systems

---

<p align="center">
  <img src="https://media.giphy.com/media/ZVik7pBtu9dNS/giphy.gif" width="250"/>
</p>

<h3 align="center">⭐ If you liked this project, consider giving it a star ⭐</h3>
  * Average bank balance
  * Transaction history (5 years)
  * Account age
  * Failed transactions

* **EMI Calculation Engine**
  Implements standard EMI formula to compute monthly installments.

* **DTI (Debt-to-Income Ratio) Check**
  Ensures loan affordability:

  > Total EMI ≤ 40% of monthly income

* **Risk Categorization**

  * Low Risk
  * Medium Risk
  * High Risk

* **Smart Rejection Logic**

  * Low credit score
  * High EMI burden
  * Invalid inputs

---

## Tech Stack

* **Java (Core)**
* OOP (Encapsulation, Separation of Concerns)
* Arrays & Data Handling
* Mathematical Modeling

---

## System Design

```
Input → Credit Score → EMI Calculation → DTI Check → Risk Analysis → Decision
```

---

## Project Structure

```
├── Customer.java
├── CreditScoreCalculator.java
├── EMICalculator.java
├── LoanService.java
├── RiskAnalyzer.java
├── Main.java
```

---

## How It Works

1. User inputs financial data
2. System calculates internal credit score
3. Determines interest rate & tenure
4. Calculates EMI
5. Applies DTI constraint
6. Outputs loan approval decision

---

## Sample Output

```
===== LOAN APPROVAL RESULT =====
CIBIL Score: 740
Risk Category: Medium Risk
LOAN APPROVED
Interest Rate: 8.5%
Tenure: 5 years
Monthly EMI: Rs 10258.27
```

---

## Note

This is a **single-user simulation** focused on decision-making logic.
In real-world systems:

* It would be deployed as a **stateless service**
* Integrated with databases & APIs
* Scaled horizontally for multiple users

---

## What I Learned

* Designing real-world decision systems
* Applying financial formulas in code
* Writing clean, modular Java code
* Handling edge cases & validations

---

## Future Improvements

* REST API integration
* Database support
* Web UI / Dashboard
* Multi-user concurrency handling

---

## Author

**Robinpreet Singh Chahal**
Aspiring Software Engineer :)

---

⭐ If you found this project interesting, feel free to star it!
