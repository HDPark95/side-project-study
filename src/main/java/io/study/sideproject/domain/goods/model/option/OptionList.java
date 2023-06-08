package io.study.sideproject.domain.goods.model.option;

import io.study.sideproject.domain.common.BaseEntity;
import io.study.sideproject.domain.common.Status;
import io.study.sideproject.domain.goods.model.GoodsStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "option_list")
@Entity
public class OptionList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_list_id")
    private Long id;

    @Column(nullable = false)
    private Long optionPrice;

    @Column(nullable = false)
    private Long stock;

    @Enumerated(EnumType.STRING)
    private GoodsStatus goodsStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_item_id1")
    private OptionItem option1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_item_id2")
    private OptionItem option2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_item_id3")
    private OptionItem option3;

    @Builder
    public OptionList(Long id, Long optionPrice, Long stock, GoodsStatus goodsStatus,
                      OptionItem option1, OptionItem option2, OptionItem option3) {
        this.id = id;
        this.optionPrice = optionPrice;
        this.stock = stock;
        this.goodsStatus = goodsStatus;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }
}
