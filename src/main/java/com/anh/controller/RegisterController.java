package com.anh.controller;


import com.anh.entity.UsersEntity;
import com.anh.model.RegisterParam;
import com.anh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;


    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
//    @ResponseBody
    public RedirectView handleRegister(@ModelAttribute("user") RegisterParam registerParam){
        String username = registerParam.getUserName();
        String password = registerParam.getPassWord();
        UsersEntity user = new UsersEntity(username, encoder.encode(password));

        userService.saveCustomer(user);
        return new RedirectView("/user-login");
    }
}
