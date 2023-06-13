package io.study.sideproject.domain.goods.repository;

import io.study.sideproject.domain.goods.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
