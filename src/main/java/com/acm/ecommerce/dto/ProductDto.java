package com.acm.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Long id;
    private Long productId;
    private String title;
    private String description;
    private Double price;
    private String image;
    private int quantity;
}
