package com.example.conniereactive.domain;

import static lombok.AccessLevel.PROTECTED;

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

}
