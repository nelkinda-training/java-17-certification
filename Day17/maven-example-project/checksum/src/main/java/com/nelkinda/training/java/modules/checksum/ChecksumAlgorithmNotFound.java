package com.nelkinda.training.java.modules.checksum;

public class ChecksumAlgorithmNotFound extends Throwable {
    private final String algorithm;

    public ChecksumAlgorithmNotFound(final String algorithm) {
        super("Checksum algorithm not found: " + algorithm);
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
