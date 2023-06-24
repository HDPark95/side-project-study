package io.study.sideproject.domain.goods.router;

import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.goods.dto.GoodsCreateRequest;
import io.study.sideproject.domain.goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/goods")
public class GoodsController {

    private final GoodsService goodsService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> create(@RequestPart("request") GoodsCreateRequest request,
                                    @RequestPart("representImage") MultipartFile representImage,
                                    @Nullable @RequestPart List<MultipartFile> images,
                                    @AuthenticationPrincipal Authentication authentication
                                                ) {
        goodsService.create(request, (Account) authentication.getPrincipal(), representImage, images);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
