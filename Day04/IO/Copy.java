import java.io.*;

public class Copy {
    public static void main(final String... args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java Copy sourceFile destinationFile");
            System.exit(1);
        }
        final String sourceFileName = args[0];
        final String destinationFileName = args[1];
        final InputStream in = new FileInputStream(sourceFileName);
        final OutputStream out = new FileOutputStream(destinationFileName);
        in.transferTo(out);

        // byte[] buf = new byte[4096];
        // for (int bytesRead; (bytesRead = in.read(buf)) != -1; )
        //     out.write(buf, 0, bytesRead);

        // for (int b; (b = in.read()) != -1;)
        //     out.write(b);

        out.close();
        in.close();
    }
}
