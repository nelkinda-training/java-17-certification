package com.nelkinda.training.java.modules.checksum.and;

import com.nelkinda.training.java.modules.checksum.AbstractChecksumService;
import com.nelkinda.training.java.modules.checksum.Checksum;
import com.nelkinda.training.java.modules.checksum.ChecksumService;

public class AddChecksumService extends AbstractChecksumService {
    public AddChecksumService() {
        super("ADD");
    }

    @Override
    public Checksum newInstance() {
        return new AddChecksum();
    }
}
