package io.study.sideproject.domain.goods.repository;

import io.study.sideproject.domain.goods.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
}
