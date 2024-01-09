package com.nelkinda.training.java.modules.checksum.xor;

import com.nelkinda.training.java.modules.checksum.Checksum;

public class XorChecksum implements Checksum {
    private byte checksum;
    @Override
    public void update(int b) {
        checksum ^= (byte) b;
    }

    @Override
    public byte[] digest() {
        return new byte[] { checksum };
    }
}
