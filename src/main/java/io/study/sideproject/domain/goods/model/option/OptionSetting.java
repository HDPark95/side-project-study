package io.study.sideproject.domain.goods.model.option;

import io.study.sideproject.domain.common.BaseEntity;
import io.study.sideproject.domain.goods.dto.OptionRequest;
import io.study.sideproject.domain.goods.model.Goods;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "options_setting")
@Entity
public class OptionSetting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_setting_id")
    private Long id;

    @Column(nullable = false)
    private Integer size;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OptionSort sort;

    @OneToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @OneToMany(mappedBy = "optionSetting")
    private List<Option> options;

    @Builder
    public OptionSetting(Long id, Integer size, OptionSort sort, Goods goods) {
        this.id = id;
        this.size = size;
        this.sort = sort;
        this.goods = goods;
    }

    public static OptionSetting create(OptionRequest request, Goods goods) {
        return OptionSetting.builder()
                .size(request.getSize())
                .sort(OptionSort.valueOf(request.getSort()))
                .goods(goods)
                .build();
    }
}
