package com.example.conniereactive.domain;

import static lombok.AccessLevel.PROTECTED;

import com.example.conniereactive.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document
@NoArgsConstructor(access = PROTECTED)
public class Product {

    @Id
    private Long id;
    private String productName;
    private int price;
    private String status;

    @Builder
    public Product(Long id, String productName, int price, String status) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public void changeStatus(String status) {
        this.status = status;
    }

}
