<h1 align="center">💳 Smart Loan Engine</h1>

<p align="center">
  A real-world inspired loan approval & risk analysis system built with Core Java ☕
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-Core%20Java-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/OOP-Design-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Finance-Logic-green?style=for-the-badge" />
</p>

---

## 🧠 Overview

**Smart Loan Engine** simulates how a financial institution evaluates loan applications using creditworthiness, repayment capacity, and risk analysis.

The system calculates a custom credit score, evaluates EMI affordability, analyzes DTI, and produces an approval/rejection decision.

## ⚙️ Features

* 📊 **Custom Credit Scoring**

  * Average bank balance
  * 5-year transaction history
  * Account age
  * Failed transactions

* 💸 **EMI Calculation**

  * Standard EMI formula
  * Repayment affordability analysis

* 📈 **DTI Validation**

  * Ensures total EMI stays within **40% of monthly income**

* 🚨 **Risk Analysis**

  * **750+** → Low Risk
  * **650–749** → Medium Risk
  * **<650** → High Risk

* ❌ **Smart Approval Logic**

  * Credit score
  * EMI burden
  * Financial input validation

## 🏗️ Architecture

```text
User Input
    ↓
Credit Score Engine
    ↓
EMI Calculator
    ↓
DTI Validation
    ↓
Risk Analyzer
    ↓
Loan Decision
```

## 📁 Project Structure

```text
src/
├── Customer.java
├── CreditScoreCalculator.java
├── EMICalculator.java
├── LoanService.java
├── RiskAnalyzer.java
├── LoanType.java
└── Main.java
```

## 🖥️ Sample Output

```text
================================
        CREDIT REPORT
================================
Credit Score  : 782
Credit Rating : EXCELLENT
--------------------------------
Loan Type     : HOME
Decision      : APPROVED
Interest Rate : 8.25%
Monthly EMI   : ₹20,050
================================
```

## 🛠️ Tech Stack

**Java • OOP • Arrays • Mathematical Modeling**

## 📸 Screenshots

### ✅ Approved

<p align="center">
  <img src="assets/Screenshot 2026-05-18 155802.png" width="500"/>
</p>

### ❌ Rejected

<p align="center">
  <img src="assets/Screenshot 2026-05-18 155630.png" width="500"/>
</p>

## 🚀 Future Scope

* Spring Boot REST API
* MySQL/PostgreSQL integration
* Web dashboard
* Multi-user loan processing
* AI-based risk prediction

## 👨‍💻 Author

**Robinpreet Singh Chahal**

> Coffee & Code Under the Palm 🌴☕

---

⭐ If you found the project interesting, consider giving it a star!
