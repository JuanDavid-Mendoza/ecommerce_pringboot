package com.acm.ecommerce.controller;

import com.acm.ecommerce.models.UserModel;
import com.acm.ecommerce.services.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping("/login")
    public String index(Model model) {
        model.addAttribute("user", new UserModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute UserModel user, BindingResult result, Model model, HttpSession session) {
        // Errores de validadción en campos del formulario
        if(result.hasErrors()) {
            return "login";
        }

        // Validar usuario existente
        UserModel prevUser = userService.getUserByUsername(user.getUsername());

        if (prevUser == null) {
            model.addAttribute("error", "Usuario no encontrado");
            model.addAttribute("user", new UserModel());
            return "login";
        }

        if (!prevUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("error", "Acceso denegado");
            model.addAttribute("user", new UserModel());
            return "login";
        }

        // Actualizar usuario
        model.addAttribute("user", prevUser);
        session.setAttribute("username", prevUser.getUsername());
        session.setAttribute("userId", prevUser.getId());

        return "redirect:/products";
    }
}
