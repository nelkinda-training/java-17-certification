import java.io.*;
import java.text.*;
import java.util.*;

class Sort {
    public static void main(final String... args) throws IOException {
        var collator = Collator.getInstance(Locale.GERMANY);
        //collator.setStrength(Collator.IDENTICAL);
        try (var in = new BufferedReader(new InputStreamReader(System.in))) {
            in.lines().sorted(collator).forEach(System.out::println);
        }
    }
}
