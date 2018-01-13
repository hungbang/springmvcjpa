package com.nhat.controller;

import com.nhat.entity.UsersEntity;
import com.nhat.service.EmailService;
import com.nhat.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    UsersService usersService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("users",usersService.findAll());
        return "indexAccount";
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addUsers(Model model){
        model.addAttribute("user",new UsersEntity());
        return "addUser";
    }
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public String addUsers(@ModelAttribute("user") UsersEntity usersEntity){
        usersEntity.setActive(false);
        usersEntity.setLinkConfirm(("http://localhost:8080/account/"+usersEntity.getUsername()));
        usersService.save(usersEntity);
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(usersEntity.getEmail());
        simpleMailMessage.setSubject("Xac Nhan Tai Khoan");
        simpleMailMessage.setText(usersEntity.getLinkConfirm());
        emailService.sendEmail(simpleMailMessage);
        return "indexAccount";
    }
   /* @RequestMapping("/users/{id}")
    public ModelAndView getUserById(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", usersService.getUserById(id));
        modelAndView.setViewName("user");
        return modelAndView;
    }
    @RequestMapping(value = "users/",method = RequestMethod.POST)
    public ModelAndView confirmUser(@ModelAttribute("user")UsersEntity usersEntity){
        ModelAndView modelAndView=new ModelAndView();
        usersService.save(usersEntity);
        modelAndView.setViewName("indexAccount");
        return modelAndView;
    }*/
    @RequestMapping("/{email}")
    public ModelAndView confrimUser1(@PathVariable("email") String email) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", usersService.setAcctiveForUser(email));
        modelAndView.setViewName("confirm");
        return modelAndView;
    }


}
