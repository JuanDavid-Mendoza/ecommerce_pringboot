package com.acm.ecommerce.services.impl;

import com.acm.ecommerce.dto.CartDto;
import com.acm.ecommerce.models.CartModel;
import com.acm.ecommerce.models.ProductModel;
import com.acm.ecommerce.services.ICartService;
import com.acm.ecommerce.util.CartMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {
    private final RestTemplate restTemplate;

    @Override
    public List<CartModel> getAllCarts() {
        CartDto[] carts = restTemplate.getForObject("/carts", CartDto[].class);
        if (carts == null || carts.length == 0) { return List.of(); }
        return CartMapper.dtoListToModelList(List.of(carts));
    }

    @Override
    public List<CartModel> getCartsByUserId(Long userId) {
        List<CartModel> carts = this.getAllCarts();
        List<ProductModel> products = new ProductServiceImpl(restTemplate).getAllProducts();
        carts.forEach(cart -> cart.getProducts()
                .forEach(product -> {
                    ProductModel pM = products.stream().filter(p -> p.getProductId().equals(product.getProductId())).findFirst().orElse(null);
                    if (pM != null) {
                        product.setTitle(pM.getTitle());
                        product.setDescription(pM.getDescription());
                        product.setPrice(pM.getPrice());
                        product.setImage(pM.getImage());
                    }
                }));

        return carts
                .stream()
                .filter(cart -> cart.getUserId().equals(userId))
                .toList();
    }
}
