import java.io.*;

public class Copy_Pre7 {
    public static void main(final String... args) throws IOException {
        final InputStream in = new FileInputStream(args[0]); // Main exception
        IOException exception = null;
        try {
            final OutputStream out = new FileOutputStream(args[1]); // Main exception
            try {
                in.transferTo(out); // Main exception
            } catch (IOException e) {
                exception = e;
                throw e;
            } finally {
                try {
                    out.close(); // Suppressed exception
                } catch (IOException e) {
                    if (exception == null) {
                        exception = e;
                        throw e;
                    } else {
                        exception.addSuppressed(e);
                    }
                }
            }
        } finally {
            try {
                in.close(); // Suppressed exception
            } catch (IOException e) {
                if (exception == null) {
                    exception = e;
                    throw e;
                } else {
                    exception.addSuppressed(e);
                }
            }
        }
    }
}
