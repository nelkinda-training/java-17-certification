package com.nelkinda.training.java.modules.checksum;

import java.util.ServiceLoader;

public interface Checksum {
    void update(int b);
    byte[] digest();

    static Checksum newInstance(final String algorithm) throws ChecksumAlgorithmNotFound {
        final ServiceLoader<ChecksumService> loader = ServiceLoader.load(ChecksumService.class);
        for (final ChecksumService service : loader) {
            if (service.supports(algorithm)) {
                return service.newInstance();
            }
        }
        throw new ChecksumAlgorithmNotFound(algorithm);
    }
}
