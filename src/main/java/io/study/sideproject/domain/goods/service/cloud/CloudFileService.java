package io.study.sideproject.domain.goods.service.cloud;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CloudFileService {
    String upload(MultipartFile file, String filename);

    void delete(List<String> fileNames);
}
