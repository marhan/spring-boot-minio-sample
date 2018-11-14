package de.markushanses.sample.minio.adapter.s3.inbound;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BucketRepository {

    private AmazonS3 amazonS3;
    private final MinioClient minioClient;

    @Autowired
    public BucketRepository(AmazonS3 amazonS3, MinioClient minioClient) {
        this.amazonS3 = amazonS3;
        this.minioClient = minioClient;
    }

    public boolean isEmpty() {
        ObjectListing objectListing = amazonS3.listObjects("community-bank-account");
        return objectListing.getObjectSummaries().isEmpty();


/*        try {
            Iterable<Result<Item>> myObjects = minioClient.listObjects("community-bank-account");
            return !myObjects.iterator().hasNext();
        } catch (XmlPullParserException e) {
            log.error("Could not get bucket objects", e);
            throw new RuntimeException(e);
        }*/
    }

}
