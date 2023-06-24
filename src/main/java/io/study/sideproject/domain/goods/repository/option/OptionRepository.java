package io.study.sideproject.domain.goods.repository.option;

import io.study.sideproject.domain.goods.model.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
