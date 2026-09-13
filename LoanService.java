public class LoanService {

    private static final double EMI_LIMIT = 0.40;
    

    public static void evaluateLoan(Customer c, int score) {

        // BASIC VALIDATIONS
        if(c.monthlyIncome <= 0 ||
           c.requestedLoan <= 0 ||
           c.avgBalance < 0) {

            System.out.println("\n================================");
            System.out.println("         INVALID INPUT");
            System.out.println("================================");

            System.out.println(
                "Income, balance and loan amount " +
                "must be valid positive values."
            );

            return;
        }

        // BUSINESS VALIDATION
        if(c.yearsActive < c.yearlyTransactions.length) {

            System.out.println("\n================================");
            System.out.println("         INVALID DATA");
            System.out.println("================================");

            System.out.println(
                "Account age cannot be less than " +
                "transaction history years."
            );

            return;
        }

        // FAILED TRANSACTION VALIDATION
        if(c.failedTransactions < 0) {

            System.out.println("\n================================");
            System.out.println("         INVALID INPUT");
            System.out.println("================================");

            System.out.println(
                "Failed transactions cannot be negative."
            );

            return;
        }

        // EMI VALIDATION
        if(c.existingEMI > c.monthlyIncome) {

            System.out.println("\n================================");
            System.out.println("         INVALID INPUT");
            System.out.println("================================");

            System.out.println(
                "Existing EMI cannot exceed monthly income."
            );

            return;
        }

        // TRANSACTION VALIDATION
        for(double amount : c.yearlyTransactions) {

            if(amount < 0) {

                System.out.println("\n================================");
                System.out.println("         INVALID INPUT");
                System.out.println("================================");

                System.out.println(
                    "Transaction amounts cannot be negative."
                );

                return;
            }
        }

        int tenure = 0;

        // HOME LOAN RULES
        if(c.loanType == LoanType.HOME) {

            if(score >= 750) {
                tenure = 15;
            }
            else if(score >= 700) {
                tenure = 10;
            }
            else {

                rejectLoan(
                    "HOME",
                    score,
                    "Low Credit Score",
                    "Minimum Required Score: 700"
                );

                return;
            }
        }

        // CAR LOAN RULES
        else if(c.loanType == LoanType.CAR) {

            if(score >= 700) {
                tenure = 7;
            }
            else if(score >= 600) {
                tenure = 5;
            }
            else {

                rejectLoan(
                    "CAR",
                    score,
                    "Low Credit Score",
                    "Minimum Required Score: 600"
                );

                return;
            }
        }

        // EDUCATION LOAN RULES
        else if(c.loanType == LoanType.EDUCATION) {

            if(score >= 550) {
                tenure = 8;
            }
            else {

                rejectLoan(
                    "EDUCATION",
                    score,
                    "Low Credit Score",
                    "Minimum Required Score: 550"
                );

                return;
            }
        }

        // DYNAMIC INTEREST RATE
        double interest =
            InterestRateCalculator.getRate(
                score,
                c.loanType
            );

        // EMI CALCULATION
        double emi =
            EMICalculator.calculateEMI(
                c.requestedLoan,
                interest,
                tenure
            );

        double totalEMI = emi + c.existingEMI;

        // EMI BURDEN CHECK
        if(totalEMI >
           EMI_LIMIT * c.monthlyIncome) {

            rejectLoan(
                c.loanType.toString(),
                score,
                "High EMI Burden",
                "Total EMI exceeds 40% income limit"
            );

            return;
        }

        // ELIGIBILITY PERCENTAGE
        double eligibility =
            Math.min(
                100,
                (c.monthlyIncome /
                (totalEMI + 1)) * 100
            );

        // ADD APPROVED LOAN TO HISTORY
        c.loanHistory.add(
            new LoanRecord(
                c.loanType.toString(),
                c.requestedLoan,
                false
            )
        );

        // APPROVAL OUTPUT
        System.out.println("\n================================");
        System.out.println("      LOAN APPROVAL RESULT");
        System.out.println("================================");

        System.out.println(
            "Loan Type: " + c.loanType
        );

        System.out.println(
            "CIBIL Score: " + score
        );

        System.out.println(
            "Risk Category: " +
            RiskAnalyzer.getRisk(score)
        );

        System.out.println(
            "\nLOAN APPROVED [SUCCESS]"
        );

        System.out.println(
            "Interest Rate: " +
            interest + "%"
        );

        System.out.println(
            "Tenure: " +
            tenure + " years"
        );

        System.out.println(
            "Monthly EMI: Rs " +
            String.format("%.2f", emi)
        );

        System.out.println(
            "Total Monthly EMI: Rs " +
            String.format("%.2f", totalEMI)
        );

        System.out.println(
            "Eligibility Strength: " +
            String.format("%.2f", eligibility) +
            "%"
        );
    }

    // COMMON REJECTION METHOD
    private static void rejectLoan(
        String loanType,
        int score,
        String reason,
        String details
    ) {

        System.out.println("\n================================");
        System.out.println("         LOAN REJECTED");
        System.out.println("================================");

        System.out.println(
            "Loan Type: " + loanType
        );

        System.out.println(
            "Risk Category: " +
            RiskAnalyzer.getRisk(score)
        );

        System.out.println(
            "\nReason: " + reason
        );

        System.out.println(details);

        System.out.println(
            "Your Score: " + score
        );
    }
}