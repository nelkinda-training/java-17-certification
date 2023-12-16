import java.util.Random;
import java.util.stream.*;

public class RandomNumbersStreams {
    public static void main(final String... args) {
        final Random rng = new Random();
        try (DoubleStream stream = DoubleStream.generate(rng::nextDouble)) {
            stream
                .parallel()
                .limit(1_000_000_000)
                .mapToLong(randomNumber -> Math.round(randomNumber * 1000))
                .filter(RandomNumbersStreams::isTriplet)
                .forEach(System.err::println);
        }
    }


    public static boolean isTriplet(final long number) {
        return number % 1000 / 100 == number % 100 / 10 && number % 100 / 10 == number % 10;
    }
}
