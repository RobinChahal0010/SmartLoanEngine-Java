public class Customer {
    double avgBalance;
    double[] yearlyTransactions;
    int yearsActive;
    int failedTransactions;
    double monthlyIncome;
    double existingEMI;
    double requestedLoan;

    Customer(
        double avgBalance, double[] yearlyTransactions, int yearsActive,
             int failedTransactions, double monthlyIncome,
             double existingEMI, double requestedLoan){
                this.avgBalance = avgBalance;
        this.yearlyTransactions = yearlyTransactions;
        this.yearsActive = yearsActive;
        this.failedTransactions = failedTransactions;
        this.monthlyIncome = monthlyIncome;
        this.existingEMI = existingEMI;
        this.requestedLoan = requestedLoan;

             }
    }
    

