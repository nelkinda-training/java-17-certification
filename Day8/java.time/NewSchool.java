import java.time.*;

public class NewSchool {
    public static void main(final String... args) {
        printTimeInfo(Clock.systemUTC());
        printTimeInfo(Clock.systemDefaultZone());
        printTimeInfo(Clock.system(ZoneId.of("Europe/Berlin")));
        printTimeInfo(Clock.fixed(Instant.parse("2023-01-01T00:00:00Z"), ZoneOffset.UTC));
        printTimeInfo(Clock.fixed(Instant.parse("2023-01-01T00:00:00Z"), ZoneId.of("Asia/Kathmandu")));
    }

    public static void printTimeInfo(Clock clock) {
        System.out.format("Clock: %s%n", clock);
        System.out.format("Instant: %s%n", Instant.now(clock));
        System.out.format("LocalDateTime: %s%n", LocalDateTime.now(clock));
        System.out.format("LocalDate: %s%n", LocalDate.now(clock));
        System.out.format("LocalTime: %s%n", LocalTime.now(clock));
        System.out.format("OffsetDateTime: %s%n", OffsetDateTime.now(clock));
        System.out.format("ZonedDateTime: %s%n", ZonedDateTime.now(clock));
        System.out.println();
    }
}
