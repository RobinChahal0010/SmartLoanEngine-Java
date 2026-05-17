import java.util.ArrayList;

public class Customer {
    double avgBalance;
    double[] yearlyTransactions;
    int yearsActive;
    int failedTransactions;
    double monthlyIncome;
    double existingEMI;
    double requestedLoan;
    ArrayList<LoanRecord> loanHistory;
    LoanType loanType;

    Customer(
    double avgBalance,
    double[] yearlyTransactions,
    int yearsActive,
    int failedTransactions,
    double monthlyIncome,
    double existingEMI,
    double requestedLoan,
    LoanType loanType
){
                this.avgBalance = avgBalance;
        this.yearlyTransactions = yearlyTransactions;
        this.yearsActive = yearsActive;
        this.failedTransactions = failedTransactions;
        this.monthlyIncome = monthlyIncome;
        this.existingEMI = existingEMI;
        this.requestedLoan = requestedLoan;
        this.loanType = loanType;
this.loanHistory = new ArrayList<>();

             }
    }
    

