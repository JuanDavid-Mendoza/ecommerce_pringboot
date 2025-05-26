package com.acm.ecommerce.util;

import com.acm.ecommerce.dto.ProductDto;
import com.acm.ecommerce.models.ProductModel;

import java.util.List;

public class ProductMapper {
    public static ProductDto modelToDto(ProductModel product) {
        return ProductDto.builder()
                .id(product.getId())
                .productId(product.getProductId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .quantity(product.getQuantity())
                .build();
    }

    public static ProductModel dtoToModel(ProductDto product) {
        return ProductModel.builder()
                .id(product.getId())
                .productId(product.getProductId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .quantity(product.getQuantity())
                .build();
    }

    public static List<ProductDto> modelListToDtoList(List<ProductModel> products) {
        return products.stream().map(ProductMapper::modelToDto).toList();
    }

    public static List<ProductModel> dtoListToModelList(List<ProductDto> products) {
        return products.stream().map(ProductMapper::dtoToModel).toList();
    }
}
