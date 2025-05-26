package com.acm.ecommerce.util;

import com.acm.ecommerce.dto.CartDto;
import com.acm.ecommerce.models.CartModel;

import java.util.List;

public class CartMapper {
    public static CartDto modelToDto(CartModel cart) {
        return CartDto.builder()
                .id(cart.getId())
                .userId(cart.getUserId())
                .products(ProductMapper.modelListToDtoList(cart.getProducts()))
                .date(cart.getDate())
                .build();
    }

    public static CartModel dtoToModel(CartDto cart) {
        return CartModel.builder()
                .id(cart.getId())
                .userId(cart.getUserId())
                .products(ProductMapper.dtoListToModelList(cart.getProducts()))
                .date(cart.getDate())
                .build();
    }

    public static List<CartDto> modelListToDtoList(List<CartModel> carts) {
        return carts.stream().map(CartMapper::modelToDto).toList();
    }

    public static List<CartModel> dtoListToModelList(List<CartDto> carts) {
        return carts.stream().map(CartMapper::dtoToModel).toList();
    }
}
