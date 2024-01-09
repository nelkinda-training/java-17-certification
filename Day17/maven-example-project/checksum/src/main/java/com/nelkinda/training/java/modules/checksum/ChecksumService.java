package com.nelkinda.training.java.modules.checksum;

public interface ChecksumService {
    boolean supports(String algorithm);
    Checksum newInstance();
}
