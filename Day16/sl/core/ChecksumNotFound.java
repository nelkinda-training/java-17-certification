class ChecksumNotFound extends Exception {
    ChecksumNotFound(final String name) {
        super("Checksum for algorithm " + name + " not found");
    }
}
