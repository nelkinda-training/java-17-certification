package com.nelkinda.training.java.modonmodpath;

import com.nelkinda.training.java.modules.checksum.Checksum;
import com.nelkinda.training.java.modules.checksum.ChecksumAlgorithmNotFound;

public class Main {
    public static void main(final String... args) throws ChecksumAlgorithmNotFound {
        System.out.println("Hello World!");
        final Checksum checksum = Checksum.newInstance("XOR-SHIFT");
        checksum.update(1);
        checksum.update(2);
        checksum.update(3);
        final byte[] digest = checksum.digest();
        for (final byte d : digest)
            System.out.println("Checksum: " + d);
    }
}
