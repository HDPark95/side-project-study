package io.study.sideproject.domain.goods.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsStatus {
    SELLING("판매중"),
    SOLD_OUT("품절");

    private final String viewName;

    public static GoodsStatus getStatus(Long stock) {
        if (stock.compareTo(0L) > 0) {
            return SELLING;
        }
        return SOLD_OUT;
    }
}
