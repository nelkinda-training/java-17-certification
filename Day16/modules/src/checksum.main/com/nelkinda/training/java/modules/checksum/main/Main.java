package com.nelkinda.training.java.modules.checksum.main;

import com.nelkinda.training.java.modules.checksum.Checksum;

public class Main {
    public static void main(final String... args) throws Throwable {
        final Checksum checksum = Checksum.newInstance(args[0]);
    }
}
