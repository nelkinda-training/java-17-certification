module checksum.xor {
    requires checksum;
    provides com.nelkinda.training.java.modules.checksum.ChecksumService with com.nelkinda.training.java.modules.checksum.xor.XorChecksumService;
}
