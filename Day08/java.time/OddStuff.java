import java.time.*;

public class OddStuff {
    public static void main(final String... args) {
        {
            ZonedDateTime t1 = ZonedDateTime.of(LocalDateTime.parse("2023-10-29T00:00:00"), ZoneId.of("Europe/Berlin"));
            ZonedDateTime t2 = ZonedDateTime.of(LocalDateTime.parse("2023-10-30T00:00:00"), ZoneId.of("Europe/Berlin"));
            System.out.format("Duration between %s and %s: %s%n", t1, t2, Duration.between(t1, t2));
        }
        {
            ZonedDateTime t1 = ZonedDateTime.of(LocalDateTime.parse("2023-03-26T00:00:00"), ZoneId.of("Europe/Berlin"));
            ZonedDateTime t2 = ZonedDateTime.of(LocalDateTime.parse("2023-03-27T00:00:00"), ZoneId.of("Europe/Berlin"));
            System.out.format("Duration between %s and %s: %s%n", t1, t2, Duration.between(t1, t2));
        }
        {
            Year year = Year.parse("2024");
            System.out.format("Number of days in Year %s: %s (isLeap: %s)%n", year, year.length(), year.isLeap());
        }
        {
            Month month = Month.FEBRUARY;
            System.out.format("February has %s days in a leap year%n", month.length(true));
            System.out.format("February has %s days in a non-leap year%n", month.length(false));
        }
        {
            YearMonth ym = YearMonth.parse("2024-02");
            System.out.format("%s has %s days%n", ym, ym.lengthOfMonth());
        }
        {
            Clock clock = Clock.systemUTC();
            Instant previous = Instant.now(clock);
            for (int i = 0; i < 1000000000; i++) {
                Instant current = Instant.now(clock);
                if (previous.isBefore(current)) {
                    System.err.println("Ooops"); // Will occasionally print on some machines!
                                                 // Why?
                                                 // Your computer time is running of a quartz.
                                                 // That quartz might oscillate within tolerance slightly faster than actual time.
                                                 // Once your computer synchronizes time with a reliable source (like NTP),
                                                 // it updates the time and time might be reset.
                }
                previous = current;
            }
        }
    }
}
