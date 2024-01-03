public class ThreadSuspend {
    public static void heavyWork() {
        System.out.print("Hello, ");
        try { Thread.sleep(1000); } catch (final InterruptedException e) {}
        System.out.println("world!");
    }

    public static void main(final String... args) {
        parallel();
    }

    public static void parallel() {
        System.out.println("Parallel");
        final Thread t1 = new Thread(() -> heavyWork());
        final Thread t2 = new Thread(() -> heavyWork());
        final Thread t3 = new Thread(() -> heavyWork());
        t1.start();
        t2.start();
        t3.start();
        t1.suspend(); // hard suspend - deprecated for removal, and in Java 21 throws UnsupportedOperationException
        t2.suspend();
        t3.suspend();
        System.out.println("Suspended threads");
        try { Thread.sleep(1000); } catch (final InterruptedException e) {}
        System.out.println("Resuming threads");
        t1.resume();
        t2.resume();
        t3.resume();
    }
}
