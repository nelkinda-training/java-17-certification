import java.util.Random;
import java.util.stream.*;

public class RandomNumbersStreams {
    public static void main(final String... args) {
        System.out.println(someTriplets());
    }

    public static List<Long> someTriplets() {

        final Random rng = new Random();
        try (final DoubleStream stream = DoubleStream.generate(rng::nextDouble)) {
            stream
                .limit(1000)
                .mapToLong(randomNumber -> Math.round(randomNumber * 1000))
                .filter(RandomNumbersStreams::isTriplet)
                .boxed().toList();
        }
    }


    public static boolean isTriplet(final long number) {
        return number % 1000 / 100 == number % 100 / 10 && number % 100 / 10 == number % 10;
    }
}
