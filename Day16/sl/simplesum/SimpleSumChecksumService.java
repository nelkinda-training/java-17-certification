public class SimpleSumChecksumService implements ChecksumService {
    public String name() {
        return "SimpleSum";
    }

    public Checksum newChecksum() {
        return new SimpleSumChecksum();
    }
}
