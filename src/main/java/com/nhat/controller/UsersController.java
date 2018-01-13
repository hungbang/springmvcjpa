package com.nhat.controller;

import com.nhat.entity.UsersEntity;
import com.nhat.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;
    @RequestMapping("/login")
    public String home() {
        return "login";
    }
    @RequestMapping("/users/{id}")
    public ModelAndView getUserById(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", usersService.getUserById(id));
        modelAndView.setViewName("user");
        return modelAndView;
    }
    @RequestMapping("/error")
    public String error(){
        return "errorPage";
    }
}
