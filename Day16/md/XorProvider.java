import java.security.MessageDigestSpi;
import java.security.Provider;

public class XorProvider extends Provider {
    public XorProvider() {
        super("XorMessageDigestProvider", "0.0.1", "Xor MessageDigest Provider");
        put("MessageDigest.Xor", XorMessageDigestImpl.class.getName());
    }

    public static class XorMessageDigestImpl extends MessageDigestSpi {
        private byte checksum;
        protected void engineReset() {
            checksum = 0;
        }
        protected byte[] engineDigest() {
            return new byte[] { checksum };
        }
        protected void engineUpdate(final byte input) {
            checksum ^= input;
        }
        protected void engineUpdate(final byte[] input, final int offset, final int length) {
            for (int i = offset; i < offset+length; i++)
                checksum ^= input[i];
        }
    }
}
