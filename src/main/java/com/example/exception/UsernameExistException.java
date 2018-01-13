package com.example.exception;


public class UsernameExistException extends Exception {
    public UsernameExistException() {
        super();
    }

    public UsernameExistException(String message) {
        super(message);
    }

    public UsernameExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameExistException(Throwable cause) {
        super(cause);
    }

    protected UsernameExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
