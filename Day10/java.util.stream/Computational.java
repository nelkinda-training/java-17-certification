import java.time.*;
import java.util.stream.*;

public class Computational {
    public static void main(final String... args) {
        final Duration duration = durationOf(() -> 
            IntStream
                .range(0, 46)
                .map(i -> 45 - i)
                .parallel()
                .map(Computational::fibonacci)
                .forEach(System.out::println)
        );
        System.out.format("Calculation took: %s%n", duration);
    }

    public static int fibonacci(int n) {
        switch (n) {
        case 0: return 0;
        case 1: return 1;
        default: return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static Duration durationOf(final Runnable runnable) {
        final Clock clock = Clock.systemUTC();
        final Instant start = clock.instant();
        runnable.run();
        final Instant end = clock.instant();
        return Duration.between(start, end);
    }
}
