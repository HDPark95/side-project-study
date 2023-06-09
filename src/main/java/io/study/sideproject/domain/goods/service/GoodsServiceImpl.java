package io.study.sideproject.domain.goods.service;

import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.goods.dto.GoodsCreateRequest;
import io.study.sideproject.domain.goods.model.Goods;
import io.study.sideproject.domain.goods.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService{

    private final GoodsRepository goodsRepository;
    private final CategoryService categoryService;
    private final OptionService optionService;
    private final FilesService fileService;

    @Transactional
    @Override
    public void create(GoodsCreateRequest request, Account account,
                       MultipartFile representativeImage,List<MultipartFile> images) {

        Goods goods = Goods.builder()
                .name(request.getName()).description(request.getDescription())
                .price(request.getPrice()).stock(request.getStock())
                .seller(account)
                .category(categoryService.findByName(request.getCategory()))
                .build();
        goodsRepository.save(goods);
        optionService.create(request.getOption(), goods);
        fileService.create(representativeImage, images, goods);
    }
}
