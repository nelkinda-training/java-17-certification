import java.io.*;
import java.util.*;

public class ProcessLines {
    public static void main(final String... args) throws IOException {
        List<String> lines = readAllLinesFromStdin();
        Collections.sort(lines);
        for (String line : lines)
            System.out.println(line);
    }

    public static List<String> readAllLinesFromStdin() throws IOException {
        final List<String> lines = new ArrayList<>();
        try (var in = new BufferedReader(new InputStreamReader(System.in))) {
            for (String line; (line = in.readLine()) != null;)
                lines.add(line);
        }
        return lines;
    }
}
