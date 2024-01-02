import java.io.*;

public class WriteObject {
    public static void main(final String... args) throws Throwable {
        final ObjectToSerialize object = new ObjectToSerialize("foo", "bar");
        try (final ObjectOutputStream out = new ObjectOutputStream(System.out)) {
            out.writeObject(object);
        }
    }
}
