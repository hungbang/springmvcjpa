package com.example.controller;

import com.example.entity.Users;
import com.example.model.RegisterTemp;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView getRegister() {
        return new ModelAndView("register", "user", new RegisterTemp());
    }

    @PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute("user") RegisterTemp registerTemp, BindingResult result) {
        if(result.hasErrors()) {
            return "register";
        }

        userService.saveUser(registerTemp);
        return "redirect:/login";
    }
}
