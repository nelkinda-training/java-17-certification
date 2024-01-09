package com.nelkinda.training.java.modules.checksum.and;

import com.nelkinda.training.java.modules.checksum.Checksum;
import com.nelkinda.training.java.modules.checksum.ChecksumAlgorithmNotFound;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AddChecksumTest {
    private final Checksum checksum = new AddChecksum();

    @Test
    void canObtainInstanceViaServiceLoader() throws ChecksumAlgorithmNotFound {
        assertInstanceOf(AddChecksum.class, Checksum.newInstance("ADD"));
    }

    @Test
    void empty_checksum_is_zero() {
        assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x00 }, checksum.digest());
    }

    @Test
    void checksum_of_one_byte_is_that_byte() {
        checksum.update(0x42);
        assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x42 }, checksum.digest());
    }

    @Test
    void checksum_of_two_bytes_are_these_two_bytes() {
        checksum.update(0x42);
        checksum.update(0xFF);
        assertArrayEquals(new byte[] { 0x00, 0x00, 0x01, 0x41 }, checksum.digest());
    }
}
