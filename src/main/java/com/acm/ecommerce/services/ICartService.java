package com.acm.ecommerce.services;

import com.acm.ecommerce.models.CartModel;

import java.util.List;

public interface ICartService {
    public List<CartModel> getAllCarts();
    public List<CartModel> getCartsByUserId(Long userId);
}
