package com.densoft.carsoko.service.category;

import com.densoft.carsoko.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category createCategory(String categoryName);
}
