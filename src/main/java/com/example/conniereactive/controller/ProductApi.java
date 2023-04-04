package com.example.conniereactive.controller;

import com.example.conniereactive.domain.Product;
import com.example.conniereactive.dto.ProductDto;
import com.example.conniereactive.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @GetMapping(path = "/products")
    public Flux<ProductDto> findProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "/products/{id}")
    public Mono<Product> findProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping(path = "/product")
    public Mono<Product> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PatchMapping(path = "/products/{id}")
    public Mono<Product> changeStatus(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.changeStatus(id, productDto);
    }

    @PutMapping(path = "/products/{id}")
    public Mono<Product> changeAll(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.changeAll(id, productDto);
    }

}
