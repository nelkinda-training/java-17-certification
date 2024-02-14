package com.nelkinda.training.java.modules.checksum.xor;

import com.nelkinda.training.java.modules.checksum.AbstractChecksumService;
import com.nelkinda.training.java.modules.checksum.Checksum;
import com.nelkinda.training.java.modules.checksum.ChecksumService;

public class XorChecksumService extends AbstractChecksumService {
    public XorChecksumService() {
        super("XOR");
    }

    @Override
    public Checksum newInstance() {
        return new XorChecksum();
    }
}
