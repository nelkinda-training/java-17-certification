class Test {
    static int i = 0, j = 0;
    static synchronized void update() { i++; j++; }
    static synchronized void print() {
        System.out.println("i=" + i + " j=" + j);
    }

    public static void main(final String... args) {
        new Thread(() -> { while (true) { update(); } }).start();
        new Thread(() -> { while (true) { print(); } }).start();
    }
}
