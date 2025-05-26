package com.acm.ecommerce.services.impl;

import com.acm.ecommerce.dto.ProductDto;
import com.acm.ecommerce.models.ProductModel;
import com.acm.ecommerce.services.IProductService;
import com.acm.ecommerce.util.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final RestTemplate restTemplate;

    @Override
    public List<ProductModel> getAllProducts() {
        ProductDto[] products = restTemplate.getForObject("/products", ProductDto[].class);
        if (products == null || products.length == 0) { return List.of(); }
        Arrays.stream(products).forEach(product -> product.setProductId(product.getId()));
        return ProductMapper.dtoListToModelList(List.of(products));
    }
}
