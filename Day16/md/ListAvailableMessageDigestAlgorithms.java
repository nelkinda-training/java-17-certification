import java.security.*;
import java.util.stream.Stream;

class ListAvailableMessageDigestAlgorithms {
    public static void main(final String... args) {
        Security.addProvider(new XorProvider());
        Stream
            .of(Security.getProviders())
            .flatMap(provider -> provider.getServices().stream())
            .filter(service -> service.getType().equalsIgnoreCase("MessageDigest"))
            .map(service -> service.getAlgorithm())
            .forEach(System.out::println);
    }
}
