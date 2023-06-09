package io.study.sideproject.domain.goods.dto;

import io.study.sideproject.domain.goods.model.GoodsStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OptionListRequest {

    private List<String> options;
    private Long optionPrice;
    private Long stock;
    private GoodsStatus optionStatus;

}
