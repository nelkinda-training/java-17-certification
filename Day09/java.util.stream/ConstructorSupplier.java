import java.util.stream.*;

public class ConstructorSupplier {
    public static void main(final String... args) {
        try (Stream<Object> stream = Stream.generate(Object::new)) {
            stream
                .limit(10)
                .mapToInt(Object::hashCode)
                .forEach(System.out::println);
        }
    }
}
