import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {
    static {
        //Locale.setDefault(Locale.GERMANY);
        Locale.setDefault(new Locale("de", "AT")); // -> {}_de_AT.properties, {}_de.properties, {}.properties
    }
    private static final ResourceBundle bundle = ResourceBundle.getBundle("data.messages");
    public static void main(final String... args) {
        System.out.println(getHelloMessage());
        System.out.println(bundle.keySet());
    }
    public static String getHelloMessage() {
        //if (Locale.getDefault().getLanguage().equals("de"))
        //    return "Hallo, Welt!";
        //return "Hello, world!";
        return bundle.getString("message");
    }
}
