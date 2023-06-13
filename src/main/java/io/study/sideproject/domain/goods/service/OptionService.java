package io.study.sideproject.domain.goods.service;

import io.study.sideproject.domain.goods.dto.OptionRequest;
import io.study.sideproject.domain.goods.model.Goods;

public interface OptionService {
    void create(OptionRequest optionRequest, Goods goods);
}
