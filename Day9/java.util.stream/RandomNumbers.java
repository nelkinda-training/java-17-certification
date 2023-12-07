import java.util.Random;


public class RandomNumbers {
    public static void main(final String... args) {
        final Random rng = new Random();
        int i = 0; while (true) {
            final double randomNumber = rng.nextDouble();
            if (!(i++ < 1000)) break;
            final long number = Math.round(randomNumber * 1000);
            if (isTriplet(number)) {
                System.err.println(number);
            }
        }
    }
    public static boolean isTriplet(final long number) {
        return number % 1000 / 100 == number % 100 / 10 && number % 100 / 10 == number % 10;
    }
}
