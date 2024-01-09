package com.nelkinda.training.java.modules.checksum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChecksumTest {
    @Test
    void throwsExceptionWhenNoAlgorithmFound() {
        final ChecksumAlgorithmNotFound exception = assertThrows(ChecksumAlgorithmNotFound.class,
                () -> Checksum.newInstance("FOO"));
        assertEquals("FOO", exception.getAlgorithm());
    }
}
