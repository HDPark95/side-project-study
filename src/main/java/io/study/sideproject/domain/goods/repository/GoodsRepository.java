package io.study.sideproject.domain.goods.repository;

import io.study.sideproject.domain.goods.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long>, GoodsRepositoryCustom {
}
