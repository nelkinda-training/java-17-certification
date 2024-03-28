class Nonsense {
    public static void main(final String... args) {
        int durationInSeconds = 10;
        int numberOfColors = 2;
        int nonSense = durationInSeconds + numberOfColors;
    }
    public static void main(final String... args) {
        Duration duration = Duration.ofSeconds(10);
        int numberOfColors = 2;

    }
}

class Duration {
    private static final int SECONDS_PER_MINUTE = 60;

    private final double valueInSeconds;
    private Duration(final double valueInSeconds) {
        this.valueInSeconds = valueInSeconds;
    }
    public static Duration ofSeconds(final double durationInSeconds) {
        return new Duration(durationInSeconds);
    }
    public static Duration ofMinutes(final double durationInMinutes) {
        return new Duration(durationInMinutes * SECONDS_PER_MINUTE);
    }
}
