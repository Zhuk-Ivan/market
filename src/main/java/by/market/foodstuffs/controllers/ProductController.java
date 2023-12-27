package by.market.foodstuffs.controllers;

import by.market.foodstuffs.models.dtos.ProductDto;
import by.market.foodstuffs.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> getProducts(@RequestBody Optional<ProductDto> filter) {
        return new ResponseEntity<>(productService.getProducts(filter.orElse(new ProductDto())), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProduct(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    @PreAuthorize("hasAnyRole('PRO_USER', 'ADMIN')")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto body) {
        return new ResponseEntity<>(productService.saveProduct(body), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @PreAuthorize("hasAnyRole('PRO_USER', 'ADMIN')")
    public ResponseEntity<?> updateProduct(@PathVariable(name = "id") Long id,
                                           @RequestBody ProductDto body) {
        return new ResponseEntity<>(productService.updateProduct(id, body), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasAnyRole('PRO_USER', 'ADMIN')")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
