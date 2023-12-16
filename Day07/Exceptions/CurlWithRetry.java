import java.io.*;
import java.net.*;

public class CurlWithRetry {
    private static final int NUMBER_OF_TRIES = 3;

    public static void main(final String... args) throws IOException, InterruptedException {
        final URL url = URI.create(args[0]).toURL();
        boolean successful = false;
        for (int i = 0; !successful && i < NUMBER_OF_TRIES; i++) {
            try {
                url.openStream().transferTo(System.out);
                successful = true;
            } catch (IOException e) {
                System.err.println("File download failed due to reason: " + e.getMessage());
                System.err.println("Retrying in 5 minutes.");
                Thread.sleep(5 * 60 * 1000);
            }
        }
    }
}
