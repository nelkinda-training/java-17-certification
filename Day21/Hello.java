import java.util.Locale;

public class Hello {
    static {
        Locale.setDefault(Locale.GERMANY);
    }
    public static void main(final String... args) {
        System.out.println(getHelloMessage());
    }
    public static String getHelloMessage() {
        if (Locale.getDefault().getLanguage().equals("de"))
            return "Hallo, Welt!";
        return "Hello, world!";
    }
}
