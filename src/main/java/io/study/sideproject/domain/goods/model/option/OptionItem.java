package io.study.sideproject.domain.goods.model.option;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "option_item")
@Entity
public class OptionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_item_id")
    private Long id;

    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "options_id")
    private OptionItem optionItem;

    @Builder
    public OptionItem(Long id, String value, OptionItem optionItem) {
        this.id = id;
        this.value = value;
        this.optionItem = optionItem;
    }
}
