import java.util.UUID;
import java.util.stream.Stream;

class PrintUUIDsStream {
    public static void main(final String... args) {
        try (final Stream<UUID> stream = Stream.generate(UUID::randomUUID)) {
            stream
                .limit(20)
                .forEach(System.out::println);
        }
    }
}
