import java.io.*;

public class ReadObject {
    public static void main(final String... args) throws Throwable {
        try (final ObjectInputStream in = new ObjectInputStream(System.in)) {
            System.out.println(in.readObject());
        }
    }
}
