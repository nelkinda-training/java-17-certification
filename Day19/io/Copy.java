import java.io.*;

public class Copy {
    public static void main(final String... args) throws IOException {
        try (final InputStream in = new FileInputStream(args[0]);
             final OutputStream out = new FileOutputStream(args[1])
        ) {
            in.transferTo(out);
        }
    }
}
