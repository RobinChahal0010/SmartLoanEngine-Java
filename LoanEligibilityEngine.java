public class LoanEligibilityEngine {


private static final double MAX_DTI = 0.40;
private static final int LOAN_TENURE_MONTHS = 60;

public static double calculateEligibleLoan(
        double monthlyIncome,
        double existingEMI,
        double annualInterestRate) {

    if (monthlyIncome <= 0 || existingEMI < 0 ||
            annualInterestRate < 0 ||
            existingEMI >= monthlyIncome) {
        return 0;
    }

    // Maximum total EMI allowed: 40% of income
    double maxTotalEMI = monthlyIncome * MAX_DTI;

    // EMI available for the new loan
    double availableEMI = maxTotalEMI - existingEMI;

    if (availableEMI <= 0) {
        return 0;
    }

    // Convert annual interest rate to monthly rate
    double monthlyRate = annualInterestRate / 12 / 100;

    // Calculate eligible loan amount
    if (monthlyRate == 0) {
        return availableEMI * LOAN_TENURE_MONTHS;
    }

    double factor = Math.pow(
            1 + monthlyRate,
            LOAN_TENURE_MONTHS
    );

    return availableEMI * (factor - 1)
            / (monthlyRate * factor);
}

public static double calculateDTI(
        double monthlyIncome,
        double existingEMI,
        double newEMI) {

    if (monthlyIncome <= 0) {
        return 100;
    }

    return ((existingEMI + newEMI) / monthlyIncome) * 100;
}


}
