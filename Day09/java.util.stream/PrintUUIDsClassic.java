import java.util.UUID;


class PrintUUIDsClassic {
    public static void main(final String... args) {
        for (int i = 0; i < 20; i++)
            System.out.println(UUID.randomUUID());
    }
}
