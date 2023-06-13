package io.study.sideproject.domain.goods.dto;

import io.study.sideproject.domain.goods.model.GoodsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCreateRequest {

    //기본정보
    private String name;
    private String description;
    private Long price;
    private Long stock;
    private GoodsStatus goodsStatus;
    private String category;

    //옵션정보
    private OptionRequest option;

}
