public class Hello {
    public static void main(final String... args) {
        System.out.println(getHelloMessage());
    }
    public static String getHelloMessage() {
        if (System.getenv("LANG").equals("de")) return "Hallo, Welt!";
        return "Hello, world!";
    }
}
