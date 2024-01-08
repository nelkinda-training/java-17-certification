package com.nelkinda.training.java.modules.checksum.xor;

import com.nelkinda.training.java.modules.checksum.Checksum;

public class XorChecksum implements Checksum {
    private byte checksum;

    public void update(final int b) {
        checksum = (byte) (checksum ^ b);
    }

    public byte[] digest() {
        return new byte[] { checksum };
    }
}
