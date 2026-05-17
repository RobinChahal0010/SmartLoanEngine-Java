public class InterestRateCalculator {

    public static double getRate(int score, LoanType type) {

        if(type == LoanType.HOME) {
            if(score >= 800) return 7.2;
            else if(score >= 700) return 8.5;
            else return 10.5;
        }

        if(type == LoanType.CAR) {
            if(score >= 800) return 8;
            else if(score >= 700) return 9.5;
            else return 12;
        }

        return 11;
    }
}