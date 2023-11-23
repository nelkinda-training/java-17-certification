class ClassThatUsesConstants {
    public static void main(final String... args) {
        System.out.format("%04x%n", ClassWithConstants.COMPILE_TIME_RESOLVABLE);
        System.out.format("%04x%n", ClassWithConstants.RUNTIME_RESOLVABLE);
    }
}
