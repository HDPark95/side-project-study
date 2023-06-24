package io.study.sideproject.domain.goods.dto;

import io.study.sideproject.domain.goods.model.option.OptionItem;
import io.study.sideproject.domain.goods.model.option.OptionList;
import io.study.sideproject.domain.goods.model.option.OptionSetting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionResponse {

    private Map<String, List<String>> options = new HashMap<>();
    private Integer size;
    private String sort;
    private List<OptionListResponse> optionList = new ArrayList<>();

    @Builder
    public OptionResponse(OptionSetting optionSetting, List<OptionList> optionLists) {
        this.size = optionSetting.getSize();
        this.sort = optionSetting.getSort().getViewName();
        setOptions(optionSetting);
        setOptionList(optionLists);
    }

    private void setOptions(OptionSetting optionSetting) {
        optionSetting.getOptions().stream()
                .map(option ->
                        this.options.put(option.getName(),
                                option.getOptionItems().stream()
                                        .map(OptionItem::getValue)
                                        .collect(Collectors.toList())))
                .close();
    }

    private void setOptionList(List<OptionList> optionLists) {
        optionLists.stream()
                .map(value -> this.optionList.add(OptionListResponse.builder()
                        .optionList(value)
                        .build()))
                .close();
    }
}
