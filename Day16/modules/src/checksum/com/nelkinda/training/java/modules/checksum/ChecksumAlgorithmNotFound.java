package com.nelkinda.training.java.modules.checksum;

public class ChecksumAlgorithmNotFound extends Exception {
    public ChecksumAlgorithmNotFound(final String name) {
        super("No checksum algorithm named " + name + " found.");
    }
}
