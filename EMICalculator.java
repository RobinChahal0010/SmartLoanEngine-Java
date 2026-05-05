public class EMICalculator {
    public static double calculateEMI(double principal,double annualRate,int years){
        double monthlyRate=annualRate/(12*100);
        int month =years*12;
        return (principal*monthlyRate*Math.pow(1+monthlyRate,month))/
        (Math.pow(1+monthlyRate,month)-1);
    }
    
}
