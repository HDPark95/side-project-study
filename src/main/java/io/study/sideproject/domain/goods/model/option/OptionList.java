package io.study.sideproject.domain.goods.model.option;

import io.study.sideproject.domain.common.BaseEntity;
import io.study.sideproject.domain.goods.dto.OptionListRequest;
import io.study.sideproject.domain.goods.model.GoodsStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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
    public OptionList(OptionListRequest request, List<OptionItem> optionItems) {
        this.optionPrice = request.getOptionPrice();
        this.stock = request.getStock();
        this.goodsStatus = GoodsStatus.getStatus(request.getStock());

        setOptionItem(filterOptionItem(request.getOptions(), optionItems));
    }

    public void setOptionItem(List<OptionItem> optionItems) {
        this.option1 = optionItems.get(0);
        if (optionItems.size() >= 2) {
            this.option2 = optionItems.get(1);
        }
        if (optionItems.size() >= 3) {
            this.option3 = optionItems.get(2);
        }
    }

    private List<OptionItem> filterOptionItem(List<String> options, List<OptionItem> optionItems) {
        return optionItems.stream()
                .filter(item -> options.contains(item.getValue()))
                .collect(Collectors.toList());
    }
}
