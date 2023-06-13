package io.study.sideproject.domain.goods.model;

import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.common.BaseEntity;
import io.study.sideproject.domain.goods.model.option.OptionSetting;
import io.study.sideproject.domain.goods.model.category.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "goods")
@Entity
public class  Goods extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GoodsStatus goodsStatus;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "goods")
    private List<Files> files;

    @OneToOne(mappedBy = "goods")
    private OptionSetting optionSetting;

    @Builder
    public Goods(Long id, String name, String description, Long price,
                 Long stock, Account seller, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.goodsStatus = GoodsStatus.getStatus(stock);
        this.seller = seller;
        this.category = category;
    }


}
