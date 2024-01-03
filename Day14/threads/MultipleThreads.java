import java.util.stream.IntStream;

public class MultipleThreads {
    public static void heavyWork() {
        System.out.print(Thread.currentThread() + ": Hello, ");
        try { Thread.sleep(1000); } catch (final InterruptedException e) {}
        System.out.println("world!");
        //Thread.dumpStack();
    }

    public static void main(final String... args) {
        System.out.println("Threads: " + Thread.activeCount());
        sequential();
        System.out.println("Threads: " + Thread.activeCount());
        parallel();
        System.out.println("Threads: " + Thread.activeCount());
        streamSequential();
        System.out.println("Threads: " + Thread.activeCount());
        streamParallel();
        System.out.println("Threads: " + Thread.activeCount());
    }

    public static void sequential() {
        System.out.println("Sequential");
        for (int i = 0; i < 3; i++) {
            heavyWork();
        }
    }

    public static void parallel() {
        System.out.println("Parallel");
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            (threads[i] = new Thread(() -> heavyWork())).start();
        }
        System.out.println("Threads: " + Thread.activeCount());
        for (int i = 0; i < 3; i++) {
            try { threads[i].join(); } catch (final InterruptedException e) {}
        }
    }

    public static void streamSequential() {
        System.out.println("Stream Sequential");
        IntStream.range(0, 3).forEach(i -> heavyWork());
    }

    public static void streamParallel() {
        System.out.println("Stream Parallel");
        IntStream.range(0, 3).parallel().forEach(i -> heavyWork());
    }
}
