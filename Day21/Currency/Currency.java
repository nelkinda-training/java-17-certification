import java.text.*;
import java.util.*;

public class Currency {
    public static void main(final String... args) {
        double amount = 3_140_000.0;
        System.out.println(NumberFormat.getCurrencyInstance(Locale.getDefault()).format(amount));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(amount));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(amount));
    }
}
