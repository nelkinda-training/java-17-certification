public class FactorialTest {
    @ParameterizedTest
    public void factorial(
        // Index 0  1  2  3
        @Values({0, 1, 2, 3}) final int input,
        @Values({1, 1, 2, 6}) final int expected
    ) {
        if (factorial(input) != expected) {
            throw new AssertionError("Expected 1, got something else");
        }
    }

    public static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }
}
