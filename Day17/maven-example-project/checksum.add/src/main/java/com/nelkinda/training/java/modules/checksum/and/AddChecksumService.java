package com.nelkinda.training.java.modules.checksum.and;

import com.nelkinda.training.java.modules.checksum.Checksum;
import com.nelkinda.training.java.modules.checksum.ChecksumService;

public class AddChecksumService implements ChecksumService {
    @Override
    public boolean supports(final String algorithm) {
        return "ADD".equals(algorithm);
    }

    @Override
    public Checksum newInstance() {
        return new AddChecksum();
    }
}
