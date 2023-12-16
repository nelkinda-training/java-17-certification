import java.io.*;

public class Cat {
    public static void main(final String... args) {
        try {
            System.in.transferTo(System.out);
        } catch (ArithmeticException e) { // Unchecked exception
            System.err.println("Division by zero");
        } catch (IOException e) { // Checked exception
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Unchecked exception: java.lang.RuntimeException, java.lang.Error
    // All other exceptions are checked exceptions
}
