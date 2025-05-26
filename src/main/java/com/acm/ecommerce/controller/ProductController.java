package com.acm.ecommerce.controller;

import com.acm.ecommerce.models.ProductModel;
import com.acm.ecommerce.services.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @GetMapping("/products")
    public String index(Model model, HttpSession session) {
        List<ProductModel> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("userId", session.getAttribute("userId"));
        return "productsList";
    }
}
