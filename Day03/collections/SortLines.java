import java.io.*;

public class SortLines {
    public static void main(final String... args) {
        new BufferedReader(new InputStreamReader(System.in))
            .lines()
            .sorted()
            .forEach(System.out::println);
    }
}
