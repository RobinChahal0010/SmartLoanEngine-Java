public class CreditScoreCalculator {
    public static int calculateScore(Customer c) {
        int score=300;

        if(c.avgBalance>100000) score+=300;
        else if(c.avgBalance>50000) score+=200;
        else if(c.avgBalance>10000) score+=100;

        double total=0;
        for(double t: c.yearlyTransactions) total+=t;
        double avg=total/c.yearlyTransactions.length;

        if(avg>500000) score+=200;
        else if(avg>200000) score+=100;

        for(int i=1;i<c.yearlyTransactions.length;i++){
            if(c.yearlyTransactions[i]>c.yearlyTransactions[i-1]){
                score+=10;
            }
        }

        score+=Math.min(c.yearsActive*20,100);

        score -=c.failedTransactions*20;

        return Math.max(300,Math.min(score,900));
    }
    
}
