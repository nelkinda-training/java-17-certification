import java.util.*;

class Question16 {
    public static void main(final String... args) {
        Locale.setDefault(new Locale("en"));
        var rb = ResourceBundle.getBundle("Cars",
                                          new Locale("de", "DE"));
        var r1 = rb.getString("engine");
        var r2 = rb.getString("horses");
        var r3 = rb.getString("country");
        System.out.println(r1+ " " + r2 + " " + r3);

        System.out.println(rb.getString("v1"));
        System.out.println(rb.getString("v2"));
        System.out.println(rb.getString("v3"));
        System.out.println(rb.getString("v4"));
    }
}
