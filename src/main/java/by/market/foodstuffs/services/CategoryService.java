package by.market.foodstuffs.services;

import by.market.foodstuffs.models.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getCategories(CategoryDto filter);

    CategoryDto getCategoryById(Long id);

    CategoryDto saveCategory(CategoryDto category);

    CategoryDto updateCategory(Long id, CategoryDto category);

    void deleteCategory(Long id);
}
