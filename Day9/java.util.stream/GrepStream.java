import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class GrepStream {
    public static void main(final String... args) throws IOException {
        final Predicate<String> findPattern = Pattern.compile(args[0]).asPredicate();
        // final List<String> allLines = new ArrayList<>(); Manually synchronized list
        //final Object lock = new Object(); // Lock for manual synchronization
        final List<String> allLines = Collections.synchronizedList(new ArrayList<>()); // Automatic synchronization
        try (final Stream<String> stream = new BufferedReader(new InputStreamReader(System.in)).lines()) {
            stream
                .parallel()
                .peek(line -> System.out.println(Thread.currentThread()))
                // .peek(line -> { synchronized(lock) { allLines.add(line); } }) // Manual synchronization
                .peek(line -> allLines.add(line)) // Automatic synchronization
                .filter(findPattern)
                .forEach(System.out::println);
        }
        //System.out.println(allLines);
        System.out.format("Number of lines: %d%n", allLines.size());
    }
}
