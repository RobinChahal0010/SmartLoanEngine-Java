import java.util.*;
public class main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("===== CAR LOAN SYSTEM =====");

        System.out.print("Enter Average Bank Balance: ");
        double avgBalance=sc.nextDouble();

        double[] transactions=new double[5];
        System.out.println("Enter yearly transactions for 5 years:");
        for(int i=0;i<5;i++){
            System.out.print("Year "+(i+1)+": ");
            transactions[i]=sc.nextDouble();}

        System.out.print("Enter Account Age (years): ");
        int yearsActive=sc.nextInt();

        System.out.print("Enter number of failed transactions: ");
        int failedTransactions=sc.nextInt();

        System.out.print("Enter Monthly Income: ");
        double monthlyIncome=sc.nextDouble();

        System.out.print("Enter Existing EMI: ");
        double existingEMI=sc.nextDouble();
        System.out.print("Enter Requested Loan Amount: ");
        double requestedLoan=sc.nextDouble();

        if(avgBalance<0 || monthlyIncome<=0 || requestedLoan<=0){
            System.out.println("Invalid Input");
            return;
        }


        Customer c=new Customer(avgBalance, transactions, yearsActive, failedTransactions, monthlyIncome, existingEMI, requestedLoan);
        int score=CreditScoreCalculator.calculateScore(c);
        LoanService.evaluateLoan(c, score);
        sc.close();
    }
}