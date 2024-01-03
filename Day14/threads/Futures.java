import java.util.concurrent.*;

public class Futures {
    public static long fibonacciRecursive(long n) {
        if (n == 0 || n == 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(final String... args) throws InterruptedException {
        final ExecutorService service = Executors.newWorkStealingPool();
        final CompletionService completionService = new ExecutorCompletionService(service);
        completionService.submit(() -> fibonacciRecursive(45));
        completionService.submit(() -> fibonacciRecursive(42));
        service.shutdown();

        try {
            System.out.println(completionService.take().get());
            System.out.println(completionService.take().get());
            completionService.take();
        } catch (final ExecutionException e) {
            e.getCause().printStackTrace();
        }
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
}
