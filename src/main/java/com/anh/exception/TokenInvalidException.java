package com.anh.exception;

/**
 * Created by KAI on 1/13/18.
 */
public class TokenInvalidException extends Exception {
    public TokenInvalidException(String s) {
        super(s);
    }

    public TokenInvalidException() {
        super();
    }

    public TokenInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenInvalidException(Throwable cause) {
        super(cause);
    }

    protected TokenInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
