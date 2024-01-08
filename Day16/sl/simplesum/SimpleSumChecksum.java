public class SimpleSumChecksum implements Checksum {
    private byte checksum;
    public void update(final int b) {
        checksum += (byte) b;
    }

    public byte[] digest() {
        return new byte[] { checksum };
    }
}
