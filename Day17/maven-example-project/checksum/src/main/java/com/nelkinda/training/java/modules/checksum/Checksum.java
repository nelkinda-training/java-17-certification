package com.nelkinda.training.java.modules.checksum;

import java.util.ServiceLoader;

/**
 * A checksum algorithm.
 */
public interface Checksum {
    /** Update the checksum with the specified byte.
     * @param b the byte to update the checksum with.
     */
    void update(int b);

    byte[] digest();

    static Checksum newInstance(final String algorithm) throws ChecksumAlgorithmNotFound {
        final ServiceLoader<ChecksumService> loader = ServiceLoader.load(ChecksumService.class);
        for (ChecksumService service : loader)
            if (service.supports(algorithm))
                return service.newInstance();
        throw new ChecksumAlgorithmNotFound(algorithm);
    }
}
