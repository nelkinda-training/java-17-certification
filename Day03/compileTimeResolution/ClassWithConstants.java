class ClassWithConstants {
    static final short COMPILE_TIME_RESOLVABLE = (short) 0xFFFE;
    static final short RUNTIME_RESOLVABLE = getRuntimeResolvable();

    private static short getRuntimeResolvable() {
        return (short) 0xFFFE;
    }
}
