import java.io.*;
import java.util.function.*;
import java.util.*;
import java.util.regex.*;

public class FindBackslashes {
    public static void main(final String... args) throws IOException {
        // ttt
        final Pattern pattern = Pattern.compile("\\\\"); // "\\\\" in source becomes "\\" in memory
        final Predicate<String> filter = pattern.asPredicate();
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            in.lines().filter(filter).forEach(System.out::println);
        }
    }
}

