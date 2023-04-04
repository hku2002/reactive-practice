package com.example.conniereactive.repository;

import com.example.conniereactive.domain.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}
