import java.io.*;

class CopyWithoutTryWithResources {
    public static void main(final String... args) throws IOException {
        final InputStream in = new FileInputStream(args[0]);
        IOException exceptionToThrow = null;
        try {
            final OutputStream out = new FileOutputStream(args[1]);
            try {
                in.transferTo(out);
            } catch (IOException e) {
                exceptionToThrow = e;
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    if (exceptionToThrow == null)
                        exceptionToThrow = e;
                    else
                        exceptionToThrow.addSuppressed(e);
                }
            }
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                if (exceptionToThrow == null)
                    exceptionToThrow = e;
                else
                    exceptionToThrow.addSuppressed(e);
            }
        }
        if (exceptionToThrow != null)
            throw exceptionToThrow;
    }
}

class CopyWithTryWithResources {
    public static void main(final String... args) throws IOException {
        try (
            final InputStream in = new FileInputStream(args[0]);
            final OutputStream out = new FileOutputStream(args[1])
        ) {
            in.transferTo(out);
        }
    }
}
