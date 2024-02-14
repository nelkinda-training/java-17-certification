import com.nelkinda.training.java.modules.checksum.ChecksumService;
import com.nelkinda.training.java.modules.checksum.xor.XorChecksumService;
import com.nelkinda.training.java.modules.checksum.xorshift.XorShiftChecksumService;

module checksum.xor {
    requires checksum;
    provides ChecksumService with XorChecksumService, XorShiftChecksumService;
}