import java.util.UUID;

class UserNotFound extends Exception {
    private final UUID id;

    public UserNotFound(final UUID id) {
        super("User with id " + id " + not found");
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
