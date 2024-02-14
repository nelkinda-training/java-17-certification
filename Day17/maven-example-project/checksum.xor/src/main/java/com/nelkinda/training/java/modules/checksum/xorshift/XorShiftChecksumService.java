package com.nelkinda.training.java.modules.checksum.xorshift;

import com.nelkinda.training.java.modules.checksum.AbstractChecksumService;
import com.nelkinda.training.java.modules.checksum.Checksum;

public class XorShiftChecksumService extends AbstractChecksumService {
    public XorShiftChecksumService() {
        super("XOR-SHIFT");
    }

    @Override
    public Checksum newInstance() {
        return new XorShiftChecksum();
    }
}
