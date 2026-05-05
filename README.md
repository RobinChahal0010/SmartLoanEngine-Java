# Smart Loan Engine (Java)

A real-world inspired **Car Loan Approval System** built using core Java.
This project simulates how financial institutions evaluate loan applications based on **creditworthiness, repayment capacity, and risk analysis**.

---

## Key Features

* **Custom Credit Scoring System**
  Calculates a score (300–900) based on:

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
