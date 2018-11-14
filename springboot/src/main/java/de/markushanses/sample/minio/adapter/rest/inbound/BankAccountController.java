package de.markushanses.sample.minio.adapter.rest.inbound;


import de.markushanses.sample.minio.adapter.s3.inbound.BucketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {

    private BucketRepository bucketRepository;

    @Autowired
    public BankAccountController(BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }

    @GetMapping("/bucketStatus")
    public ResponseEntity<BucketStatus> testBucket() {

        BucketStatus bucketStatus = new BucketStatus();
        bucketStatus.setStatus(bucketRepository.isEmpty() ? "EMPTY" : "NOT_EMPTY");
        return new ResponseEntity<>(bucketStatus, HttpStatus.OK);
    }
}
