package com.anh.exception;

public class ConfirmException extends Exception {
    public ConfirmException(String s) {
        super(s);
    }

    public ConfirmException() {
        super();
    }

    public ConfirmException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfirmException(Throwable cause) {
        super(cause);
    }

    protected ConfirmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
