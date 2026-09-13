public class FraudDetectionService {

    public static double calculateAverage(double[] transactions) {

        double total = 0;

        for (double transaction : transactions) {
            total += transaction;
        }

        return total / transactions.length;
    }

    public static double findMaximum(double[] transactions) {

        double maximum = transactions[0];

        for (double transaction : transactions) {
            if (transaction > maximum) {
                maximum = transaction;
            }
        }

        return maximum;
    }
}