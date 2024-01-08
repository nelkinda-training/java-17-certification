import java.io.IOException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.ServiceLoader;

public interface Checksum {
    void update(int b);
    byte[] digest();

    public static void main(final String... args) throws ChecksumNotFound, IOException {
        final Checksum checksum = Checksum.getInstance(args[0]);
        for (int b; (b = System.in.read()) != -1;)
            checksum.update(b);
        final Formatter f = new Formatter();
        for (final byte b : checksum.digest())
            f.format("%02x", b);
        System.out.println(f.toString());
    }

    public static Checksum getInstance(final String name) throws ChecksumNotFound {
        final ServiceLoader<ChecksumService> serviceLoader = ServiceLoader.load(ChecksumService.class);
        for (final Iterator<ChecksumService> it = serviceLoader.iterator(); it.hasNext(); ) {
            final ChecksumService checksumService = it.next();
            if (checksumService.name().equals(name)) {
                return checksumService.newChecksum();
            }
        }
        throw new ChecksumNotFound(name);
    }
}
