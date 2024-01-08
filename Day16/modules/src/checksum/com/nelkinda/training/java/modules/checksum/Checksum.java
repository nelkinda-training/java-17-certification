package com.nelkinda.training.java.modules.checksum;

import java.util.Iterator;
import java.util.ServiceLoader;

public interface Checksum {
    void update(final int b);
    byte[] digest();

    public static Checksum newInstance(final String name) throws ChecksumAlgorithmNotFound {
        final ServiceLoader<ChecksumService> sl = ServiceLoader.load(ChecksumService.class);
        for (final Iterator<ChecksumService> it = sl.iterator(); it.hasNext(); ) {
            final ChecksumService checksumService = it.next();
            if (checksumService.supports(name))
                return checksumService.create(name);
        }
        throw new ChecksumAlgorithmNotFound(name);
    }
}
