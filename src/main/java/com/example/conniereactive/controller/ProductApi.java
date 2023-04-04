package com.example.conniereactive.controller;

import com.example.conniereactive.domain.Product;
import com.example.conniereactive.dto.ProductDto;
import com.example.conniereactive.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @GetMapping(path = "/products")
    public Flux<Product> findProducts() {
        return productService.getProducts();
    }

    @PostMapping(path = "/product")
    public Mono<Product> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping(path = "/products/{id}")
    public Mono<Product> changeProductStatus(@PathVariable Long id) {
        return productService.changeStatus(id);
    }

}
