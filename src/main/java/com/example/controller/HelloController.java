package com.example.controller;

import com.example.exception.UserNotFoundException;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
