package io.study.sideproject.domain.goods.repository.option;

import io.study.sideproject.domain.goods.model.option.OptionSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionSettingRepository extends JpaRepository<OptionSetting, Long> {

}
