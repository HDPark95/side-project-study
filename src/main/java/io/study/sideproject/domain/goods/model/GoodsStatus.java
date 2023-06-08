package io.study.sideproject.domain.goods.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsStatus {
    SELLING("판매중"),
    SOLD_OUT("품절");

    private final String viewName;

}
