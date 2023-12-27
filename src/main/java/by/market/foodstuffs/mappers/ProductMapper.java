package by.market.foodstuffs.mappers;

import by.market.foodstuffs.models.dtos.ProductDto;
import by.market.foodstuffs.models.entity.Product;
import org.mapstruct.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ProductMapper {

    @Named("productToProductDto")
    @Mapping(target = "categoryId", source = "category.categoryId")
    @Mapping(target = "categoryName", source = "category.categoryName")
    @Mapping(target = "specialNotes", conditionExpression = "java(hasPermission())")
    ProductDto productToProductDto(Product product);

    @Named("productDtoToProduct")
    @InheritInverseConfiguration(name = "productToProductDto")
    Product productDtoToProduct(ProductDto productDto);

    @IterableMapping(qualifiedByName = "productToProductDto")
    List<ProductDto> productListToProductDtoList(List<Product> products);

    default boolean hasPermission() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userDetails.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN") || auth.getAuthority().equals("ROLE_PRO_USER"));
    }
}
