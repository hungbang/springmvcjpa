package com.example.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by KAI on 1/9/18.
 */
public class ResponseErrorMessage {
    private HttpStatus code;
    private String message;

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
