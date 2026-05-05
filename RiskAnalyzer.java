public class RiskAnalyzer {
    public static String getRisk(int score) {
        if(score>=750) return "Low Risk";
        else if(score>=650) return "Medium Risk";
        else return"High Risk";
        
    }
    
}
