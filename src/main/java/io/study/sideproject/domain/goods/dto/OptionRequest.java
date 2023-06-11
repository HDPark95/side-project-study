package io.study.sideproject.domain.goods.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionRequest {

    private Map<String, List<String>> options; //옵션 리스트
    private Integer size;
    private String sort;
    private List<OptionListRequest> optionList; //옵션 조합 리스트
}
