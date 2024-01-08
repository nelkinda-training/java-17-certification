package com.nelkinda.training.java.modules.checksum;

import java.util.Set;

public interface ChecksumService {
    Set<String> names();
    boolean supports(String name);
    Checksum create(String name);
}
