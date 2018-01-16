package com.example.exception;

public class ConfirmationException extends Exception {
    public ConfirmationException(String s) {
    }

    public ConfirmationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfirmationException(Throwable cause) {
        super(cause);
    }

    public ConfirmationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ConfirmationException() {
    }
}
