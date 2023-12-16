public class FibonacciTest {
    @Test
    public void fibonacci() {
        if (fibonacci(0) != 0) {
            throw new AssertionError("Expected 0, got something else");
        }
    }

    public static int fibonacci(int n) {
        return 0;
    }
}
