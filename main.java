import java.util.*;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("        SMART LOAN ENGINE");
        System.out.println("================================");

        // AVERAGE BALANCE
        System.out.print(
            "Enter Average Bank Balance: "
        );

        double avgBalance = sc.nextDouble();

        // ACCOUNT AGE
        System.out.print(
            "Enter Account Age (years): "
        );

        int yearsActive = sc.nextInt();

        // BASIC ACCOUNT AGE VALIDATION
        if(yearsActive <= 0) {

            System.out.println("\nInvalid Account Age");

            sc.close();
            return;
        }

        // DYNAMIC TRANSACTION ARRAY
        double[] transactions =
            new double[yearsActive];

        System.out.println(
            "\nEnter yearly transactions " +
            "for " + yearsActive + " years:"
        );

        for(int i = 0; i < yearsActive; i++) {

            System.out.print(
                "Year " + (i + 1) + ": "
            );

            transactions[i] =
                sc.nextDouble();

            // NEGATIVE TRANSACTION CHECK
            if(transactions[i] < 0) {

                System.out.println(
                    "\nTransaction amount " +
                    "cannot be negative."
                );

                sc.close();
                return;
            }
        }

        // FAILED TRANSACTIONS
        System.out.print(
            "\nEnter number of failed transactions: "
        );

        int failedTransactions =
            sc.nextInt();

        // MONTHLY INCOME
        System.out.print(
            "Enter Monthly Income: "
        );

        double monthlyIncome =
            sc.nextDouble();

        // EXISTING EMI
        System.out.print(
            "Enter Existing EMI: "
        );

        double existingEMI =
            sc.nextDouble();

        // REQUESTED LOAN
        System.out.print(
            "Enter Requested Loan Amount: "
        );

        double requestedLoan =
            sc.nextDouble();

        // LOAN TYPE
        System.out.println("\nSelect Loan Type:");
        System.out.println("1. CAR");
        System.out.println("2. HOME");
        System.out.println("3. EDUCATION");

        int choice = sc.nextInt();

        LoanType type;

        switch(choice) {

            case 1:
                type = LoanType.CAR;
                break;

            case 2:
                type = LoanType.HOME;
                break;

            case 3:
                type = LoanType.EDUCATION;
                break;

            default:

                System.out.println(
                    "\nInvalid Loan Type"
                );

                sc.close();
                return;
        }

        // GLOBAL INPUT VALIDATION
        if(avgBalance < 0 ||
           monthlyIncome <= 0 ||
           requestedLoan <= 0 ||
           existingEMI < 0 ||
           failedTransactions < 0) {

            System.out.println(
                "\nInvalid Input Values"
            );

            sc.close();
            return;
        }

        // EMI VS INCOME VALIDATION
        if(existingEMI > monthlyIncome) {

            System.out.println(
                "\nExisting EMI cannot " +
                "exceed monthly income."
            );

            sc.close();
            return;
        }

        // CREATE CUSTOMER OBJECT
        Customer c = new Customer(
            avgBalance,
            transactions,
            yearsActive,
            failedTransactions,
            monthlyIncome,
            existingEMI,
            requestedLoan,
            type
        );

        // CREDIT SCORE CALCULATION
        int score =
            CreditScoreCalculator
                .calculateScore(c);
                String rating =
    CreditScoreCalculator
        .getCreditRating(score);

System.out.println("\n================================");
System.out.println("        CREDIT REPORT");
System.out.println("================================");
System.out.println("Credit Score  : " + score);
System.out.println("Credit Rating : " + rating);
System.out.println("================================");
double averageTransaction =
        FraudDetectionService.calculateAverage(transactions);

double maximumTransaction =
        FraudDetectionService.findMaximum(transactions);

System.out.println("\n================================");
System.out.println("       TRANSACTION ANALYSIS");
System.out.println("================================");

System.out.println("Average Transaction : ₹" + averageTransaction);
System.out.println("Largest Transaction : ₹" + maximumTransaction);
        // LOAN EVALUATION
        LoanService.evaluateLoan(
            c,
            score
        );

        sc.close();
    }
}