
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class LoanProcessingEngine implements AutoCloseable {

    private final ExecutorService executor;
    private final int workerCount;

    public LoanProcessingEngine(int workerCount) {

        if (workerCount <= 0) {
            throw new IllegalArgumentException(
                "Worker count must be greater than zero"
            );
        }

        this.workerCount = workerCount;
        this.executor = Executors.newFixedThreadPool(workerCount);
    }

    public ProcessingReport processLoans(List<LoanTask> tasks)
            throws InterruptedException {

        long startTime = System.nanoTime();

        List<Future<Boolean>> futures = new ArrayList<>();

        for (LoanTask task : tasks) {
            futures.add(executor.submit(task));
        }

        int successful = 0;
        int failed = 0;

        for (Future<Boolean> future : futures) {

            try {
                if (future.get()) {
                    successful++;
                } else {
                    failed++;
                }

            } catch (ExecutionException e) {
                failed++;
                System.err.println(
                    "Loan task failed: " + e.getCause()
                );
            }
        }

        long endTime = System.nanoTime();

        return new ProcessingReport(
            tasks.size(),
            successful,
            failed,
            endTime - startTime
        );
    }

    public int getWorkerCount() {
        return workerCount;
    }

    @Override
    public void close() {

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
