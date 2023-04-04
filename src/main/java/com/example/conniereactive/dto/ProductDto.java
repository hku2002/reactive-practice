package com.example.conniereactive.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductDto {

    private int productId;
    private String productName;
    private int price;
    private String status;

    @Builder
    public ProductDto(int productId, String productName, int price, String status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

}
