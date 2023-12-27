package by.market.foodstuffs.services.impl;

import by.market.foodstuffs.exception.ResourceNotFoundException;
import by.market.foodstuffs.mappers.ProductMapper;
import by.market.foodstuffs.models.dtos.ProductDto;
import by.market.foodstuffs.repositories.CategoryRepository;
import by.market.foodstuffs.repositories.ProductRepository;
import by.market.foodstuffs.services.ProductService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getProducts(ProductDto filter) {
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return productMapper.productListToProductDtoList(
                productRepository.findAll(Example.of(
                        productMapper.productDtoToProduct(filter), caseInsensitiveExampleMatcher)));
    }

    public ProductDto getProductById(Long id) {
        return productMapper.productToProductDto(
                productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт", "id", id)));
    }

    public ProductDto saveProduct(ProductDto productDto) {
        categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Категория", "id", productDto.getCategoryId()));

        return productMapper.productToProductDto(
                productRepository.save(
                        productMapper.productDtoToProduct(productDto)));
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт", "id", id));
        categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Категории", "id", productDto.getCategoryId()));

        productDto.setProductId(id);

        return productMapper.productToProductDto(
                productRepository.save(
                        productMapper.productDtoToProduct(productDto)));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
