public class LoanRecord {
    String loanType;
    double amount;
    boolean repaid;

    public LoanRecord(String loanType, double amount, boolean repaid) {
        this.loanType = loanType;
        this.amount = amount;
        this.repaid = repaid;
    }
}