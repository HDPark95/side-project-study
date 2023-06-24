package io.study.sideproject.domain.goods.service.cloud;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class AwsCloudFileService implements CloudFileService{

    private final AmazonS3 amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Override
    public String upload(MultipartFile uploadFile, String fileName) {
        return putS3(uploadFile, fileName);
    }

    private String putS3(MultipartFile uploadFile, String fileName) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(uploadFile.getContentType());
        metadata.setContentLength(uploadFile.getSize());

        try {
            amazonS3Client.putObject(
                    new PutObjectRequest(bucket, fileName, uploadFile.getInputStream(), metadata)
                            .withCannedAcl(CannedAccessControlList.PublicRead)
            );
        } catch (IOException e) {
            throw new RuntimeException("io");
        }

        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

}
