
public class ProcessingReport {

    private final int totalTasks;
    private final int successfulTasks;
    private final int failedTasks;
    private final long executionTimeNanos;

    public ProcessingReport(
            int totalTasks,
            int successfulTasks,
            int failedTasks,
            long executionTimeNanos) {

        this.totalTasks = totalTasks;
        this.successfulTasks = successfulTasks;
        this.failedTasks = failedTasks;
        this.executionTimeNanos = executionTimeNanos;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public int getSuccessfulTasks() {
        return successfulTasks;
    }

    public int getFailedTasks() {
        return failedTasks;
    }

    public long getExecutionTimeNanos() {
        return executionTimeNanos;
    }

    public double getExecutionTimeMillis() {
        return executionTimeNanos / 1_000_000.0;
    }

    public double getThroughput() {
        if (executionTimeNanos == 0) {
            return 0;
        }

        return totalTasks / (executionTimeNanos / 1_000_000_000.0);
    }

    public void printReport() {
        System.out.println("\n========== PROCESSING REPORT ==========");
        System.out.println("Total Tasks      : " + totalTasks);
        System.out.println("Successful Tasks : " + successfulTasks);
        System.out.println("Failed Tasks    : " + failedTasks);
        System.out.printf("Execution Time  : %.3f ms%n", getExecutionTimeMillis());
        System.out.printf("Throughput      : %.2f tasks/sec%n", getThroughput());
        System.out.println("====================================");
    }
}
