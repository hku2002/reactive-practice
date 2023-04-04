package com.example.conniereactive.service;

import com.example.conniereactive.domain.Product;
import com.example.conniereactive.dto.ProductDto;
import com.example.conniereactive.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final ProductRepository productRepository;

    public Flux<Product> getProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public Mono<Product> addProduct(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> changeStatus(Long productId) {
        return null;
    }

}
