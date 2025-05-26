package com.acm.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartModel {
    private Long id;
    private Long userId;
    private List<ProductModel> products;
    private String date;
}
