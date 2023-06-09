package io.study.sideproject.domain.goods.service;

import io.study.sideproject.domain.goods.model.Goods;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FilesService {

    void create(MultipartFile representativeImage, List<MultipartFile> images, Goods goods);
}
