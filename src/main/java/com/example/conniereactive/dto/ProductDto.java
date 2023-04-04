package com.example.conniereactive.dto;

import com.example.conniereactive.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
public class ProductDto {

    @Setter
    private Long id;
    private String productName;
    private int price;
    private String status;

    @Builder
    public ProductDto(Long id, String productName, int price, String status) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }

    public static Product toEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .productName(productDto.getProductName())
                .price(productDto.getPrice())
                .status(productDto.getStatus())
                .build();
    }

}
