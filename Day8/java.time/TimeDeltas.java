import java.time.*;

public class TimeDeltas {
    public static void main(final String... args) {
        Instant i1 = Instant.parse("2023-01-01T00:00:00Z");
        Instant i2 = Instant.parse("2024-01-02T12:13:14Z");
        Duration d = Duration.between(i1, i2);
        System.out.format("Duration between %s and %s is %s%n", i1, i2, d);

        LocalDate d1 = LocalDate.ofInstant(i1, ZoneId.of("Asia/Kolkata"));
        LocalDate d2 = LocalDate.ofInstant(i2, ZoneId.of("Asia/Kolkata"));
        Period p = Period.between(d1, d2);
        System.out.format("Period between %s and %s is %s%n", d1, d2, p);
    }
}
