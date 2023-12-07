public record Hello(String message) {
    public Hello {
        java.util.Objects.requireNonNull(message);
    }
}
