public class XorChecksumService implements ChecksumService {
    public String name() {
        return "XorSum";
    }

    public Checksum newChecksum() {
        return new XorChecksum();
    }
}
