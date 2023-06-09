package io.study.sideproject.domain.goods.repository.option;

import io.study.sideproject.domain.goods.model.option.OptionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionItemRepository extends JpaRepository<OptionItem, Long> {
}
