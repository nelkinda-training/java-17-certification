class LambdaVsAnon {
    public static void main(final String... args) {
        new LambdaVsAnon();
    }
    public LambdaVsAnon() {
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println(this.getClass().getName());
            }
        };
        Runnable r2 = () -> System.out.println(this.getClass().getName());
        r1.run();
        r2.run();
    }
}
