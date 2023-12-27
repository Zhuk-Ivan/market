package by.market.foodstuffs.services;

import by.market.foodstuffs.models.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProducts(ProductDto filter);

    ProductDto getProductById(Long id);

    ProductDto saveProduct(ProductDto product);

    ProductDto updateProduct(Long id, ProductDto product);

    void deleteProduct(Long id);
}
