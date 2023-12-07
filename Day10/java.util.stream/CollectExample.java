import java.io.*;
import java.util.*;
import java.util.stream.*;

class CollectExample {
    public static void main(final String... args) {
        // Collect all lines containing the word "public" in a list.
        try (final Stream<String> stream = new BufferedReader(new InputStreamReader(System.in)).lines()) {
            final List<String> linesWithPublic = stream
                .filter(line -> line.contains("public"))
                .toList()
        }

        // collect all lines containing the word "public" in a list.
        try (final stream<string> stream = new bufferedreader(new inputstreamreader(system.in)).lines()) {
            final list<string> lineswithpublic = stream
                .filter(line -> line.contains("public"))
                .collect(collectors.tolist());
        }

        // collect all lines containing the word "public" in a set.
        try (final stream<string> stream = new bufferedreader(new inputstreamreader(system.in)).lines()) {
            final list<string> lineswithpublic = stream
                .filter(line -> line.contains("public"))
                .collect(collectors.toSet());
        }
    }
}
