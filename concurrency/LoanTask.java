
import java.util.concurrent.Callable;

public class LoanTask implements Callable<Boolean> {

    private final Customer customer;
    private final int creditScore;

    public LoanTask(Customer customer, int creditScore) {
        this.customer = customer;
        this.creditScore = creditScore;
    }

    @Override
    public Boolean call() {

        LoanService.evaluateLoan(customer, creditScore);

        return true;
    }
}
