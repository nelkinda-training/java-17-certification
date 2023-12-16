public enum Logger {
    INSTANCE;

    private int level = 200;

    public void info(final String message) {
        if (level >= 100) System.err.println(message);
    }
    public void warning(final String message) {
        if (level >= 200) System.err.println(message);
    }
    public void error(final String message) {
        if (level >= 300) System.err.println(message);
    }
    public void setLevel(final int level) {
        this.level = level;
    }
}

class LogUser {
    private static final Logger logger = Logger.INSTANCE;
}
