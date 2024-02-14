class Example {
    public static void main(final String... args) {
outer:
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (x == 0 && y == 0) {
                    break outer;
                }
            }
        }
    }
}
