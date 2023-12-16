import java.io.*;
import java.net.*;

public class Curl {
    public static void main(final String... args) throws IOException {
        //new URL(args[0]).openStream().transferTo(System.out);
        URI.create(args[0]).toURL().openStream().transferTo(System.out);
    }
}
