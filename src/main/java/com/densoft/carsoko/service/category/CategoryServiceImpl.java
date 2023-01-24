package com.densoft.carsoko.service.category;

import com.densoft.carsoko.model.Category;
import com.densoft.carsoko.repo.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(String categoryName) {
        return categoryRepository.save(new Category(categoryName));
    }
}
