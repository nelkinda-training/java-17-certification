public class WeirdProgram {
    private static Color red = new Color(255, 0, 0);
    private static Color red;
    static {
        red = new Color(255, 0, 0);
    }

    static {
        System.out.println("Hello, world!");
        if (licenseFileNotFound) {
            System.exit(0);
        }
    }
    public static void main(final String... args) {
        System.out.println("main()");
    }
}
