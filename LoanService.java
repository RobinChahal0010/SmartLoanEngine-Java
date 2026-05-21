public class LoanService {

    public static void evaluateLoan(Customer c, int score) {

        if(c.monthlyIncome <= 0 || c.requestedLoan <= 0) {
            System.out.println("Invalid Input");
            return;
        }

        int tenure = 0;

        
        if(c.loanType == LoanType.HOME) {

            if(score >= 750) {
                tenure = 15;
            }
            else if(score >= 700) {
                tenure = 10;
            }
            else {

                System.out.println("\n================================");
                System.out.println("         LOAN REJECTED");
                System.out.println("================================");

                System.out.println("Loan Type: HOME");
                System.out.println("Risk Category: " +
                    RiskAnalyzer.getRisk(score));

                System.out.println("\nReason: Low Credit Score");
                System.out.println("Minimum Required Score: 700");
                System.out.println("Your Score: " + score);

                return;
            }
        }

        
        else if(c.loanType == LoanType.CAR) {

            if(score >= 700) {
                tenure = 7;
            }
            else if(score >= 600) {
                tenure = 5;
            }
            else {

                System.out.println("\n================================");
                System.out.println("         LOAN REJECTED");
                System.out.println("================================");

                System.out.println("Loan Type: CAR");
                System.out.println("Risk Category: " +
                    RiskAnalyzer.getRisk(score));

                System.out.println("\nReason: Low Credit Score");
                System.out.println("Minimum Required Score: 600");
                System.out.println("Your Score: " + score);

                return;
            }
        }

        
        else if(c.loanType == LoanType.EDUCATION) {

            if(score >= 550) {
                tenure = 8;
            }
            else {

                System.out.println("\n================================");
                System.out.println("         LOAN REJECTED");
                System.out.println("================================");

                System.out.println("Loan Type: EDUCATION");
                System.out.println("Risk Category: " +
                    RiskAnalyzer.getRisk(score));

                System.out.println("\nReason: Low Credit Score");
                System.out.println("Minimum Required Score: 550");
                System.out.println("Your Score: " + score);

                return;
            }
        }

        
        double interest =
            InterestRateCalculator.getRate(score, c.loanType);

        double emi =
            EMICalculator.calculateEMI(
                c.requestedLoan,
                interest,
                tenure
            );

        double totalEMI = emi + c.existingEMI;

        
        if(totalEMI > 0.4 * c.monthlyIncome) {

            System.out.println("\n================================");
            System.out.println("         LOAN REJECTED");
            System.out.println("================================");

            System.out.println("Loan Type: " + c.loanType);
            System.out.println("Risk Category: " +
                RiskAnalyzer.getRisk(score));

            System.out.println("\nReason: High EMI Burden");
            System.out.println(
                "Total EMI exceeds 40% income limit"
            );

            return;
        }

        
        c.loanHistory.add(
            new LoanRecord(
                c.loanType.toString(),
                c.requestedLoan,
                false
            )
        );

        
        System.out.println("\n================================");
        System.out.println("      LOAN APPROVAL RESULT");
        System.out.println("================================");

        System.out.println("Loan Type: " + c.loanType);

        System.out.println("CIBIL Score: " + score);

        System.out.println("Risk Category: " +
            RiskAnalyzer.getRisk(score));

        System.out.println("\nLOAN APPROVED [SUCCESS]");

        System.out.println("Interest Rate: " +
            interest + "%");

        System.out.println("Tenure: " +
            tenure + " years");

        System.out.println("Monthly EMI: Rs " +
            String.format("%.2f", emi));
    }
}
