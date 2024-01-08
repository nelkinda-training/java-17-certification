package com.nelkinda.training.java.modules.checksum.xor;

import java.util.Set;

import com.nelkinda.training.java.modules.checksum.Checksum;
import com.nelkinda.training.java.modules.checksum.ChecksumService;

public class XorChecksumService implements ChecksumService {
    public Set<String> names() {
        return Set.of("XOR");
    }

    public boolean supports(final String name) {
        return names().contains(name);
    }

    public Checksum create(final String name) {
        if (!"XOR".equals(name)) throw new IllegalArgumentException(name);
        return new XorChecksum();
    }
}
