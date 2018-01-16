package com.example.model;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RegisterTemp {

    @NotNull
    @Email(message = "Email invalid")
    private String username;
    @NotNull
    @Min(value = 8, message = "Password of minimum length 8 character")
    private String password;
    @NotNull
    @Min(value = 8, message = "Confirm Password of minimum length 8 character")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
