import com.nelkinda.training.java.modules.checksum.ChecksumService;
import com.nelkinda.training.java.modules.checksum.and.AddChecksumService;

module checksum.add {
    requires checksum;
    provides ChecksumService with AddChecksumService;
}