import java.io.*;
import java.util.function.*;
import java.util.*;
import java.util.regex.*;

public class Grep {
    public static void main(final String... args) throws IOException {
        final Pattern pattern = Pattern.compile(args[0]);
        final Predicate<String> filter = pattern.asPredicate();
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            in.lines().filter(filter).forEach(System.out::println);
        }
    }
}
