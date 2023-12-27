package by.market.foodstuffs.services.impl;

import by.market.foodstuffs.exception.ResourceNotFoundException;
import by.market.foodstuffs.mappers.CategoryMapper;
import by.market.foodstuffs.models.dtos.CategoryDto;
import by.market.foodstuffs.repositories.CategoryRepository;
import by.market.foodstuffs.services.CategoryService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDto> getCategories(CategoryDto filter) {
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return categoryMapper.categoryListToCategoryDtoList(
                categoryRepository.findAll(Example.of(categoryMapper.categoryDtoToCategory(filter), caseInsensitiveExampleMatcher)));
    }

    public CategoryDto getCategoryById(Long id) {
        return categoryMapper.categoryToCategoryDto(
                categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Категории", "id", id)));
    }

    public CategoryDto saveCategory(CategoryDto category) {
        return categoryMapper.categoryToCategoryDto(
                categoryRepository.save(
                        categoryMapper.categoryDtoToCategory(category)));
    }

    public CategoryDto updateCategory(Long id, CategoryDto category) {
        categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Категории", "id", id));
        category.setCategoryId(id);
        return categoryMapper.categoryToCategoryDto(
                categoryRepository.save(
                        categoryMapper.categoryDtoToCategory(category)));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
