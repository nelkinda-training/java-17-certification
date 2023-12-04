public enum Strings {
    ;

    public static String join(final String start, final String joiner, final String end, final String... strings) {
        final StringBuilder sb = new StringBuilder();
        sb.append(start);
        for (int i = 0; i < strings.length; i++) {
            if (i > 0) sb.append(joiner);
            sb.append(strings[i]);
        }
        sb.append(end);
        return sb.toString();
    }
}
