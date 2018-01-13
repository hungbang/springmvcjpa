package com.anh.exception;

public class ConstraintViolationException extends Exception {
    public ConstraintViolationException(String s) {
        super(s);
    }

    public ConstraintViolationException() {
        super();
    }

    public ConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConstraintViolationException(Throwable cause) {
        super(cause);
    }

    protected ConstraintViolationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
