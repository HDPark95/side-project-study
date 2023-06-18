package io.study.sideproject.domain.goods.dto;

import io.study.sideproject.domain.goods.model.option.OptionList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionListResponse {

    private List<String> options;
    private Long optionPrice;
    private Long stock;
    private String goodsStatus;

    @Builder
    public OptionListResponse(OptionList optionList) {
        setOptions(optionList);
        this.optionPrice = optionList.getOptionPrice();
        this.stock = optionList.getStock();
        this.goodsStatus = optionList.getGoodsStatus().getViewName();
    }

    private void setOptions(OptionList optionList) {
        this.options.add(optionList.getOption1().getValue());
        if (optionList.getOption2() != null) {
            this.options.add(optionList.getOption2().getValue());
        }
        if (optionList.getOption3() != null) {
            this.options.add(optionList.getOption3().getValue());
        }
    }
}
