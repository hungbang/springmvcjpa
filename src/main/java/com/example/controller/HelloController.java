package com.example.controller;

import com.example.exception.ResponseErrorMessage;
import com.example.exception.UserNotFoundException;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {


    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/users/{id}")
    public ModelAndView getUserById(@PathVariable("id") Integer id) throws UserNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.getUserById(id));
        modelAndView.setViewName("user");
        return modelAndView;
    }


    @RequestMapping("/access_denied")
    public ModelAndView unauthorized() {
        ResponseErrorMessage message = new ResponseErrorMessage();
        message.setCode(HttpStatus.UNAUTHORIZED);
        message.setMessage("Unauthorized");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("401");
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
