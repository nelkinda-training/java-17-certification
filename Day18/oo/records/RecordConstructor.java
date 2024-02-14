record RecordConstructor(Boolean field) {
    public RecordConstructor {
        if (field == null)
            throw new IllegalArgumentException();
    }
    public RecordConstructor(String field) {
        this(Boolean.valueOf(field));
    }
    void transform() {}

    public static void main(final String... args) {
        new RecordConstructor(true) {
        };
    }
}
