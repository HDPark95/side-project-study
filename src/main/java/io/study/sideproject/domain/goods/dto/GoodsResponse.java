package io.study.sideproject.domain.goods.dto;

import io.study.sideproject.domain.goods.model.Goods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsResponse {

    private String name;
    private String description;
    private String goodsStatus;
    private Long price;
    private Long stock;

    private OptionResponse option;
//    private Map<String, String> category = new HashMap<>();

    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder

    public GoodsResponse(Goods goods) {
        this.name = goods.getName();
        this.description = goods.getDescription();
        this.goodsStatus = goods.getGoodsStatus().getViewName();
        this.price = goods.getPrice();
        this.stock = goods.getStock();

        this.option = OptionResponse.builder()
                .optionSetting(goods.getOptionSetting())
                .optionLists(goods.getOptionLists())
                .build();

        this.createDate = goods.getCreatedDate();
        this.modifiedDate = goods.getModifiedDate();
    }
}
