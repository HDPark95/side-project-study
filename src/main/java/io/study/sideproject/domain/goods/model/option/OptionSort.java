package io.study.sideproject.domain.goods.model.option;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OptionSort {

    LATEST("등록순"),
    ALPHABETICAL("가나다순"),
    HIGHEST_PRICE("높은 가격순"),
    LOWEST_PRICE("낮은 가격순");

    public final String newName;
}
