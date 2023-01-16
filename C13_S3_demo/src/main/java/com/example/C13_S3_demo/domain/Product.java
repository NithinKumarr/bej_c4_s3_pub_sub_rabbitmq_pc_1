package com.example.C13_S3_demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private boolean interested;
}
