package io.study.sideproject.domain.goods.dto;

import io.study.sideproject.domain.goods.model.GoodsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionListRequest {

    private List<String> options;
    private Long optionPrice;
    private Long stock;

}
