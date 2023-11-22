public class Race {
    private static int number = 0;
    public static void main(final String... args) throws Throwable {
        Thread t1 = new Thread(() -> { for (int i = 0; i < 100000; i++) number++; });
        Thread t2 = new Thread(() -> { for (int i = 0; i < 100000; i++) number++; });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(number); // Does not print 200000 (unless your CPU is timetravelling back from the distant future)
    }
}
