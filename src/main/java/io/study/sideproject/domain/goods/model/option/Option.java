package io.study.sideproject.domain.goods.model.option;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "options")
@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_setting_id", nullable = false)
    private OptionSetting optionSetting;

    @OneToMany(mappedBy = "option")
    private List<OptionItem> optionItems;

    @Builder
    public Option(Long id, String name, OptionSetting optionSetting) {
        this.id = id;
        this.name = name;
        this.optionSetting = optionSetting;
    }
}
