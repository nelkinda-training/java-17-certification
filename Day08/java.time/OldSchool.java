import java.util.Date;

public class OldSchool {
    public static void main(final String... args) {
        System.out.println(new Date()); // Right now as in when new Date() is executed
        System.out.println(new Date(2023, 1, 1)); // This is Feb 1st of 3923
        System.out.println(new Date(123, 0, 1)); // This is Jan 1st of 2023
    }
}
