package by.market.foodstuffs.mappers;

import by.market.foodstuffs.models.dtos.CategoryDto;
import by.market.foodstuffs.models.entity.Category;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {ProductMapper.class})
public interface CategoryMapper {

    @Named("categoryToCategoryDto")
    CategoryDto categoryToCategoryDto(Category category);

    @Named("categoryDtoToCategory")
    @InheritInverseConfiguration(name = "categoryToCategoryDto")
    Category categoryDtoToCategory(CategoryDto categoryDto);

    @IterableMapping(qualifiedByName = "categoryToCategoryDto")
    List<CategoryDto> categoryListToCategoryDtoList(List<Category> categories);

}
