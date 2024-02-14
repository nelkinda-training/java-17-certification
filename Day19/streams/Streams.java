import java.util.List;

public class Streams {
    public static void main(final String... args) {
        final List<Integer> numbers = List.of(); //List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var x = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(x);
    }
}
