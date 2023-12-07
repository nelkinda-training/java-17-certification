import java.io.*;
import java.util.regex.Pattern;

public class GrepClassic {
    public static void main(final String... args) throws IOException {
        final Pattern pattern = Pattern.compile(args[0]);
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            for (String line; (line = in.readLine()) != null;) {
                if (pattern.matcher(line).find()) {
                    System.out.println(line);
                }
            }
        }
    }
}
