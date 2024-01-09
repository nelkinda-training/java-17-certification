import com.nelkinda.training.java.modules.checksum.ChecksumService;
import com.nelkinda.training.java.modules.checksum.xor.XorChecksumService;

module checksum.xor {
    requires checksum;
    provides ChecksumService with XorChecksumService;
}