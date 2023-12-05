import java.io.*;

public class HandleMultiple {
    public static void main(final String... args) {
        try {
            throwSome();
        } catch (ClassCastException e) {
            System.err.println("ClassCastException happened");
        } catch (RuntimeException | IOException e) {
            System.err.println("RuntimeException or IOException happened");
        }
    }

    public static void throwSome() throws IOException {
        if (Math.random() > 0.8)
            throw new RuntimeException();
        if (Math.random() > 0.8)
            throw new IOException();
        if (Math.random() > 0.8)
            throw new ClassCastException();
    }
}
