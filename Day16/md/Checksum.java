import java.security.*;
import java.io.*;
import java.util.*;

public class Checksum {
    public static void main(final String... args) throws Throwable {
        Security.addProvider(new XorProvider());
        final MessageDigest md = MessageDigest.getInstance(args[0]);
        System.out.println(md.getClass().getName());
        final DigestInputStream in = new DigestInputStream(System.in, md);
        in.transferTo(OutputStream.nullOutputStream());
        final byte[] checksum = md.digest();
        final Formatter f = new Formatter();
        for (final byte b : checksum)
            f.format("%02x", b);
        System.out.println(f.toString());
    }
}
