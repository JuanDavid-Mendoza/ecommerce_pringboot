package com.acm.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
    private Long id;
    private Long productId;
    private String title;
    private String description;
    private Double price;
    private String image;
    private int quantity;
}
