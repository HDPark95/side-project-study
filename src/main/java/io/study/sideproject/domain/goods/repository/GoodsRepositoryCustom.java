package io.study.sideproject.domain.goods.repository;

import io.study.sideproject.domain.goods.model.Goods;

import java.util.List;

public interface GoodsRepositoryCustom {
    List<Goods> findAllByUsername(String username);
}
