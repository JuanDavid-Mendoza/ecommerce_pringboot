package com.acm.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CartDto {
    private Long id;
    private Long userId;
    private List<ProductDto> products;
    private String date;
}
