package io.study.sideproject.domain.goods.service;

import io.study.sideproject.domain.goods.model.Files;
import io.study.sideproject.domain.goods.model.Goods;
import io.study.sideproject.domain.goods.repository.FilesRepository;
import io.study.sideproject.domain.goods.service.cloud.CloudFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FilesServiceImpl implements FilesService {

    private final FilesRepository filesRepository;
    private final CloudFileService cloudFileService;

    @Transactional
    @Override
    public void create(MultipartFile representativeImage,
                       List<MultipartFile> images, Goods goods) {
        create(representativeImage, goods, true);
        images.forEach(image -> create(image, goods, false));
    }

    @Transactional
    @Override
    public void create(MultipartFile image, Goods goods, Boolean isRepresent) {
        Files files = Files.builder()
                .image(image)
                .representative(isRepresent)
                .goods(goods)
                .build();
        files.setFilePath(
                cloudFileService.upload(image, files.getStoreName())
        );
        filesRepository.save(files);
    }

    @Transactional
    @Override
    public void delete(List<Files> files) {
        cloudFileService.delete(files.stream()
                .map(Files::getStoreName)
                .collect(Collectors.toList()));
        filesRepository.deleteAll(files);
    }



}
