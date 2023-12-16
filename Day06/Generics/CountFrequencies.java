import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class CountFrequencies {
    public static void main(final String... args) {
        final Map<String, Integer> tokenCount = new HashMap<>();
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String token = scanner.next();
            if (!tokenCount.containsKey(token))
                tokenCount.put(token, 0);
            tokenCount.put(token, tokenCount.get(token) + 1);
        }

        for (final var token : tokenCount.entrySet()) {
            System.out.println("Token: " + token.getKey() + ", count: " + token.getValue());
        }
    }
}
