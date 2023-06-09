package io.study.sideproject.domain.goods.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GoodsTest {

    @Test
    public void GoodsStatusCheckTest() {
        //given
        Long sellingStock = 10L;
        Long soldOutStock = 0L;

        //when
        Goods goods1 = Goods.builder()
                .stock(sellingStock)
                .build();
        Goods goods2 = Goods.builder()
                .stock(soldOutStock)
                .build();

        //then
        assertThat(goods1.getStock()).isEqualTo(sellingStock);
        assertThat(goods1.getGoodsStatus()).isEqualTo(GoodsStatus.SELLING);
        assertThat(goods2.getStock()).isEqualTo(soldOutStock);
        assertThat(goods2.getGoodsStatus()).isEqualTo(GoodsStatus.SOLD_OUT);
    }

}