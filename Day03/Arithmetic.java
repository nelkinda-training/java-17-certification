class Arithmetic {
    public static void main(final String... args) {
        double ad = 0;
        double bd = 1;
        double cd = bd / ad;
        System.out.println(cd);
        System.out.println(cd * 0.0);
        int a = 0;
        int b = 1;
        int c = b / a; // ArithmeticException: / by zero
        System.out.println(c);
    }
}
