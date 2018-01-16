package com.example.controller;

import com.example.entity.Users;
import com.example.exception.ConfirmationException;
import com.example.exception.TokenInvalidException;
import com.example.exception.UserNotFoundException;
import com.example.exception.UsernameExistException;
import com.example.model.RegisterTemp;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView getRegister() {
        return new ModelAndView("register", "user", new RegisterTemp());
    }

    @PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute("user") RegisterTemp registerTemp, BindingResult result) throws UsernameExistException, ConfirmationException {
        if(result.hasErrors()) {
            return "register";
        }
        Users user = new Users(registerTemp.getUsername(), registerTemp.getPassword());
        userService.register(user);
        return "confirm";
    }

    @GetMapping("/confirm")
    public String emailConfirm(@RequestParam String token) throws UserNotFoundException, TokenInvalidException, UsernameExistException, ConfirmationException {
        userService.confirmRegistration(token);
        return "redirect:/login";
    }
}
