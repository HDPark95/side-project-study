package io.study.sideproject.domain.goods.model.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryStep {
    CATEGORY1("대분류"),
    CATEGORY2("중분류"),
    CATEGORY3("소분류"),
    CATEGORY4("세분류");

    public final String viewName;
}
