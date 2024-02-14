public class CheckedVsUnchecked {
    public static final boolean cond = true;
    public static void main(final String... args) {
        if (cond) throw new RuntimeException(); // unchecked
        if (cond) throw new Error(); // unchecked
        if (cond) throw new Exception(); // checked
        if (cond) throw new Throwable(); // checked
    }
}
