package com.nelkinda.training.java.modules.checksum.xorshift;

import com.nelkinda.training.java.modules.checksum.Checksum;

public class XorShiftChecksum implements Checksum {
    private int checksum;
    @Override
    public void update(int b) {
        checksum <<= 1;
        checksum ^= (byte) b;
    }

    @Override
    public byte[] digest() {
        return new byte[] { (byte) (checksum >> 24), (byte) (checksum >> 16), (byte) (checksum >> 8), (byte) checksum };
    }
}
