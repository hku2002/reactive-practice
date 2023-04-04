package com.example.conniereactive.service;

import com.example.conniereactive.domain.Product;
import com.example.conniereactive.dto.ProductDto;
import com.example.conniereactive.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final ProductRepository productRepository;

    public Flux<ProductDto> getProducts() {
        return productRepository.findAll()
                .map(ProductDto::toDto);
    }

    public Mono<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public Mono<Product> addProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Mono<Product> changeStatus(Long id, ProductDto productDto) {
        return getProduct(id)
                .doOnNext(product -> product.changeStatus(productDto.getStatus()))
                .flatMap(productRepository::save);
    }

    @Transactional
    public Mono<Product> changeAll(Long id, ProductDto productDto) {
        return getProduct(id)
                .map(product -> {
                    productDto.setId(id);
                    return ProductDto.toEntity(productDto);
                })
                .flatMap(productRepository::save);
    }

}
