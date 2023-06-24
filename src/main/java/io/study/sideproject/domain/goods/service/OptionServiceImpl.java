package io.study.sideproject.domain.goods.service;

import io.study.sideproject.domain.goods.dto.OptionRequest;
import io.study.sideproject.domain.goods.model.Goods;
import io.study.sideproject.domain.goods.model.option.*;
import io.study.sideproject.domain.goods.repository.option.OptionItemRepository;
import io.study.sideproject.domain.goods.repository.option.OptionListRepository;
import io.study.sideproject.domain.goods.repository.option.OptionRepository;
import io.study.sideproject.domain.goods.repository.option.OptionSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService{

    private final OptionSettingRepository optionSettingRepository;
    private final OptionItemRepository optionItemRepository;
    private final OptionRepository optionRepository;
    private final OptionListRepository optionListRepository;

    @Transactional
    @Override
    public void create(OptionRequest request, Goods goods) {
        OptionSetting optionSetting = optionSettingRepository.save(
                OptionSetting.create(request, goods)
        );
        List<Option> options = new ArrayList<>();
        List<OptionItem> optionItems = new ArrayList<>();

        request.getOptions().forEach(
                (name, values) -> {
                    Option option = Option.builder()
                            .name(name)
                            .optionSetting(optionSetting)
                            .build();
                    options.add(option);
                    optionItems.addAll(values.stream()
                            .map(value -> OptionItem.builder()
                            .value(value)
                            .option(option)
                            .build())
                            .collect(Collectors.toList()));
                }
        );

        List<OptionList> optionLists = request.getOptionList().stream()
                .map(list -> OptionList.builder().request(list)
                        .optionItems(optionItems)
                        .build())
                .collect(Collectors.toList());

        optionRepository.saveAll(options);
        optionItemRepository.saveAll(optionItems);
        optionListRepository.saveAll(optionLists);
    }


}
