package com.acm.ecommerce.controller;

import com.acm.ecommerce.models.CartModel;
import com.acm.ecommerce.models.ProductModel;
import com.acm.ecommerce.services.impl.CartServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartServiceImpl cartService;

    @GetMapping("/carts")
    public String index(Model model, HttpSession session) {
        List<CartModel> carts = cartService.getCartsByUserId(Long.parseLong(session.getAttribute("userId").toString()));
        model.addAttribute("carts", carts);
        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("userId", session.getAttribute("userId"));
        return "cartsList";
    }
}
