public class LoanService {
    public static void evaluateLoan(Customer c,int score){
        if(c.monthlyIncome<=0 || c.requestedLoan<=0){
            System.out.println("Invalid Input");
            return;
        }

        double interest;
        int tenure;
        if(score>=750){
            interest=7.5;
            tenure=7;
        }
        else if(score>=700){
            interest=8.5;
            tenure=5;
        }
        else if(score>=650){
            interest=10.5;
            tenure=3;
        }
        else{
            System.out.println("Loan Rejected (Low Score)"); return;
        }


        double emi=EMICalculator.calculateEMI(c.requestedLoan, interest, tenure);


        double totalEMI=emi+c.existingEMI;

        if(totalEMI>0.4*c.monthlyIncome){
            System.out.println("Rejected (High EMI Burden)"); return;
        }


        System.out.println("\n===== LOAN APPROVAL RESULT =====");
        System.out.println("CIBIL Score: "+score);
        System.out.println("Risk Category: "+RiskAnalyzer.getRisk(score));
        System.out.println("LOAN APPROVED");
        System.out.println("Interest Rate: "+interest+"%");
        System.out.println("Tenure: "+tenure+" years");
        System.out.println("Monthly EMI: Rs "+emi);
    }
    
}
