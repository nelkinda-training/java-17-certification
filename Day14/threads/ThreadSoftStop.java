public class ThreadSoftStop implements Runnable {
    private volatile boolean keepRunning = true;
    public void run() {
        if (!keepRunning) return;
        System.out.print("Hello, ");
        if (!keepRunning) return;
        try { Thread.sleep(1000); } catch (final InterruptedException e) {}
        if (!keepRunning) return;
        System.out.println("world!");
    }

    public void stop() {
        keepRunning = false;
    }

    public static void main(final String... args) {
        parallel();
    }

    public static void parallel() {
        System.out.println("Parallel");
        final ThreadSoftStop o1 = new ThreadSoftStop();
        final ThreadSoftStop o2 = new ThreadSoftStop();
        final ThreadSoftStop o3 = new ThreadSoftStop();
        final Thread t1 = new Thread(o1);
        final Thread t2 = new Thread(o2);
        final Thread t3 = new Thread(o3);
        t1.start();
        t2.start();
        t3.start();
        o1.stop();
        o2.stop();
        o3.stop();
    }
}
