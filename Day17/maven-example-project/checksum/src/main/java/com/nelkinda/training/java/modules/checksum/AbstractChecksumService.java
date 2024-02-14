package com.nelkinda.training.java.modules.checksum;

public abstract class AbstractChecksumService implements ChecksumService {
    private final String algorithm;

    protected AbstractChecksumService(final String algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public boolean supports(final String algorithm) {
        return this.algorithm.equals(algorithm);
    }
}
