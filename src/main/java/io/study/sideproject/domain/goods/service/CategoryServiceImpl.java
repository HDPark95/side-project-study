package io.study.sideproject.domain.goods.service;

import io.study.sideproject.domain.goods.model.category.Category;
import io.study.sideproject.domain.goods.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

}
