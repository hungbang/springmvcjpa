package com.example.exception;

public class TokenInvalidException extends Exception {

    public TokenInvalidException(String token_invalid) {

    }

    public TokenInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenInvalidException(Throwable cause) {
        super(cause);
    }

    public TokenInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
