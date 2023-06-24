package io.study.sideproject.domain.goods.service;

import io.study.sideproject.domain.goods.model.category.Category;

public interface CategoryService {


    Category findByName(String name);
}
