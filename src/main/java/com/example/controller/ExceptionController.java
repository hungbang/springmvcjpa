package com.example.controller;


import com.example.exception.ResponseErrorMessage;
import com.example.exception.UserNotFoundException;
import com.example.exception.UsernameExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundException(UserNotFoundException exception){
        ResponseErrorMessage message = new ResponseErrorMessage();
        message.setCode(HttpStatus.BAD_REQUEST);
        message.setMessage(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("400");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ModelAndView handleUsernameNotFoundException(UserNotFoundException exception){
        ResponseErrorMessage message = new ResponseErrorMessage();
        message.setCode(HttpStatus.UNAUTHORIZED);
        message.setMessage(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("401");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @ExceptionHandler(UsernameExistException.class)
    public ModelAndView handleUsernameExistException(UsernameExistException exception) {
        ResponseErrorMessage message = new ResponseErrorMessage();
        message.setCode(HttpStatus.CONFLICT);
        message.setMessage(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("409");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
