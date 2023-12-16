import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.*;
import java.util.*;

public class Sort {
    public static void main(final String... args) throws IOException {
        // Read all lines from STDIN and print them alphabetically sorted according to the current locale.
        final InputStream in = System.in;
        final InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
        final BufferedReader bufferedReader = new BufferedReader(reader);
        final List<String> lines = new ArrayList<>();
        for (String line; (line = bufferedReader.readLine()) != null;)
            lines.add(line);
        Collections.sort(lines, Collator.getInstance());
        for (String line : lines)
            System.out.println(line);
    }
}
