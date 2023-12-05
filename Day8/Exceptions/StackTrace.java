public class StackTrace {
    public static void main(final String... args) throws Throwable {
        Throwable t = create();

        t.printStackTrace();

        update(t);

        t.printStackTrace();

        analyze(t);
    }

    public static Throwable create() {
        return new Throwable();
    }

    public static void update(Throwable t) {
        t.fillInStackTrace();
    }

    public static void analyze(Throwable t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        for (StackTraceElement e : stackTrace) {
            System.out.format("In class %s method %s (file %s line %s)%n", e.getClassName(), e.getMethodName(), e.getFileName(), e.getLineNumber());
        }
    }
}
