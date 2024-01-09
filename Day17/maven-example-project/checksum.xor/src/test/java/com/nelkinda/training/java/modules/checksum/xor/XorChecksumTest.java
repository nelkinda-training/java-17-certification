package com.nelkinda.training.java.modules.checksum.xor;

import com.nelkinda.training.java.modules.checksum.ChecksumAlgorithmNotFound;
import org.junit.jupiter.api.Test;
import com.nelkinda.training.java.modules.checksum.Checksum;

import static org.junit.jupiter.api.Assertions.*;

public class XorChecksumTest {
    private final Checksum xorChecksum = new XorChecksum();

    @Test
    void canObtainInstanceViaServiceLoader() throws ChecksumAlgorithmNotFound {
        assertInstanceOf(XorChecksum.class, Checksum.newInstance("XOR"));
    }

    @Test
    void empty_checksum_is_zero() {
        assertDigest(0x00);
    }

    @Test
    void checksum_of_one_byte_is_that_byte() {
        xorChecksum.update(0x42);
        assertDigest(0x42);
    }

    @Test
    void checksum_of_two_bytes_is_their_xor_value() {
        xorChecksum.update(0x42);
        xorChecksum.update(0x40);
        assertDigest(0x02);
    }

    void assertDigest(final int expectedDigest) {
        assertArrayEquals(new byte[] { (byte) expectedDigest }, xorChecksum.digest());
    }
}
