package io.study.sideproject.domain.goods.service;

import io.study.sideproject.domain.goods.model.Files;
import io.study.sideproject.domain.goods.model.Goods;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FilesService {

    void create(MultipartFile representativeImage, List<MultipartFile> images, Goods goods);

    @Transactional
    void create(MultipartFile image, Goods goods, Boolean isRepresent);

    @Transactional
    void delete(List<Files> files);
}
