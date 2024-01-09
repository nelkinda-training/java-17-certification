package com.nelkinda.training.java.modules.checksum.and;

import com.nelkinda.training.java.modules.checksum.Checksum;

public class AddChecksum implements Checksum {
    private int checksum;
    @Override
    public void update(int b) {
        checksum += b;
    }

    @Override
    public byte[] digest() {
        return new byte[] { (byte) (checksum >> 24), (byte) (checksum >> 16), (byte) (checksum >> 8), (byte) checksum };
    }
}
