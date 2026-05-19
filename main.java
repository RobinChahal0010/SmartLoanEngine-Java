import java.util.*;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("      SMART LOAN ENGINE");
        System.out.println("================================");

        System.out.print("Enter Average Bank Balance: ");
        double avgBalance = sc.nextDouble();

        double[] transactions = new double[5];

        System.out.println("Enter yearly transactions for 5 years:");

        for(int i = 0; i < 5; i++) {
            System.out.print("Year " + (i + 1) + ": ");
            transactions[i] = sc.nextDouble();
        }

        System.out.print("Enter Account Age (years): ");
        int yearsActive = sc.nextInt();

        System.out.print("Enter number of failed transactions: ");
        int failedTransactions = sc.nextInt();

        System.out.print("Enter Monthly Income: ");
        double monthlyIncome = sc.nextDouble();

        System.out.print("Enter Existing EMI: ");
        double existingEMI = sc.nextDouble();

        System.out.print("Enter Requested Loan Amount: ");
        double requestedLoan = sc.nextDouble();

        
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
                System.out.println("Invalid Loan Type");
                sc.close();
                return;
        }

        
        if(avgBalance < 0 ||
           monthlyIncome <= 0 ||
           requestedLoan <= 0) {

            System.out.println("Invalid Input");
            sc.close();
            return;
        }

        // Create Customer Object
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

        // Calculate Credit Score
        int score =
            CreditScoreCalculator.calculateScore(c);

        // Evaluate Loan
        LoanService.evaluateLoan(c, score);

        sc.close();
    }
}
