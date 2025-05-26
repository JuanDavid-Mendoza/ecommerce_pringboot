package com.acm.ecommerce.services;

import com.acm.ecommerce.models.ProductModel;

import java.util.List;

public interface IProductService {
    public List<ProductModel> getAllProducts();
}
