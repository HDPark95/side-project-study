package io.study.sideproject.domain.goods.service;

import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.goods.dto.GoodsCreateRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsService {

    void create(GoodsCreateRequest request, Account account,
                MultipartFile representativeImage, List<MultipartFile> images);
}
