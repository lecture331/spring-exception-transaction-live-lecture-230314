package com.example.springexceptiontransactionlivelecture230314.exception;

public class UserUnmatchedPasswordException extends RuntimeException {
    public UserUnmatchedPasswordException(String message) {
        super(message);
    }
}
