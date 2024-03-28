import java.util.*;
import java.time.*;
import java.time.format.*;

public class PrintNow {
    public static void main(final String... args) {
        Locale.setDefault(Locale.GERMANY);
        for (final FormatStyle formatStyle : FormatStyle.values()) {
            try {
                System.out.println(formatStyle);
                //System.out.println(DateTimeFormatter.ofLocalizedDateTime(formatStyle).format(ZonedDateTime.now())); // All
                //System.out.println(DateTimeFormatter.ofLocalizedDateTime(formatStyle).format(LocalDateTime.now())); // SHORT, MEDIUM
                //System.out.println(DateTimeFormatter.ofLocalizedDateTime(formatStyle).format(Instant.now())); // None
                System.out.println(DateTimeFormatter.ofLocalizedDateTime(formatStyle).format(OffsetDateTime.now())); // SHORT, MEDIUM
                System.out.println();
            } catch (final Exception e) {
                System.err.format("Format style %s not possible.%n", formatStyle);
            }
        }
    }
}
