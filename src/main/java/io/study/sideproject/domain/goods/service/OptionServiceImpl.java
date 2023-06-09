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

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService{

    private final OptionSettingRepository optionSettingRepository;
    private final OptionItemRepository optionItemRepository;
    private final OptionRepository optionRepository;
    private final OptionListRepository optionListRepository;

    @Transactional
    @Override
    public void create(OptionRequest optionRequest, Goods goods) {
        OptionSetting optionSetting = optionSettingRepository.save(
                OptionSetting.create(optionRequest, goods)
        );

        optionRequest.getOptions().forEach(
                (name, value) -> createOption(name, value, optionSetting)
        );

        // TODO : OptionList 만들기
    }

    @Transactional
    public void createOption(String name, List<String> values, OptionSetting optionSetting) {
        Option option = Option.builder()
                .name(name)
                .optionSetting(optionSetting)
                .build();
        optionRepository.save(option);
        values.forEach((value) -> createOptionItem(value, option));
    }

    @Transactional
    public void createOptionItem(String value, Option option) {
        optionItemRepository.save(OptionItem.builder()
                        .value(value)
                        .option(option)
                        .build());
    }
}
