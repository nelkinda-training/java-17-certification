package com.nelkinda.training.java.modules.checksum.xor;

import com.nelkinda.training.java.modules.checksum.Checksum;
import com.nelkinda.training.java.modules.checksum.ChecksumService;

public class XorChecksumService implements ChecksumService {
    @Override
    public boolean supports(final String algorithm) {
        return "XOR".equals(algorithm);
    }

    @Override
    public Checksum newInstance() {
        return new XorChecksum();
    }
}
