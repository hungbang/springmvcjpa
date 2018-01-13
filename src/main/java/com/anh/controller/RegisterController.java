package com.anh.controller;


import com.anh.entity.UsersEntity;
import com.anh.exception.ConfirmException;
import com.anh.exception.UserNotFoundException;
import com.anh.model.RegisterParam;
import com.anh.model.TokenParam;
import com.anh.service.EmailService;
import com.anh.service.EncryptDecryptService;
import com.anh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Random;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private EmailService emailService;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    private Random rand = new Random();

    @PostMapping("/register")
//    @ResponseBody
    public ModelAndView handleRegister(@ModelAttribute("user") @Valid RegisterParam registerParam) throws ConstraintViolationException {
        String username = registerParam.getUserName();
        String password = registerParam.getPassWord();
        UsersEntity user = new UsersEntity(username, encoder.encode(password));
        userService.saveCustomer(user);

        int random = rand.nextInt(999 - 100 + 1) + 100;
        String key = random+""+user.getId();
        String token = "";
        try {
            EncryptDecryptService encryptDecryptService = new EncryptDecryptService();
            token = encryptDecryptService.encrypt(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        emailService.sendSimpleMessage("anhphan96dn@gmail.com", "confirm", "Your confirm code is: "+random);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "token",token);
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    @PostMapping("/confirm")
    public RedirectView confirm(@ModelAttribute("token") TokenParam tokenParam){
        String token = tokenParam.getToken();
        String userConfirmCode = tokenParam.getUserToken();
        try {
            EncryptDecryptService encryptDecryptService = new EncryptDecryptService();
            String decryptToken = encryptDecryptService.decrypt(token);
            String code = decryptToken.substring(0, 3);
            String id = decryptToken.substring(3, decryptToken.length());

            if (!code.equals(userConfirmCode)){
                throw new ConfirmException();
            }

            UsersEntity user = userService.findById(Integer.parseInt(id));
            if(user == null){
                throw new UserNotFoundException();
            }else{
                user.setEnable(true);
                userService.saveCustomer(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("/user-login");
    }
}
