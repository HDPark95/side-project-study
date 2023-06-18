package io.study.sideproject.domain.goods.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.study.sideproject.domain.goods.model.Goods;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.study.sideproject.domain.account.model.QAccount.account;
import static io.study.sideproject.domain.goods.model.QGoods.goods;

@RequiredArgsConstructor
@Repository
public class GoodsRepositoryCustomImpl implements GoodsRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Goods> findAllByUsername(String username) {

        return queryFactory.selectFrom(goods)
                .join(goods.seller, account)
                .where(account.username.eq(username))
                .fetch();
    }
}
