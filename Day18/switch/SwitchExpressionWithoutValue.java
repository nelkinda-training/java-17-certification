import java.util.Random;

class SwitchExpressionWithoutValue {
    public static void main(final String... args) {
        int x = new Random().nextInt() % 10;
        switch (x) {
            case 5 -> System.out.println("foo");
            case 9 -> System.out.println("bar");
        }
    }
}
