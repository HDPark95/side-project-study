package io.study.sideproject.domain.goods.service.cloud;

import org.springframework.web.multipart.MultipartFile;

public interface CloudFileService {
    String upload(MultipartFile file, String filename);
}
