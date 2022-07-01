package com.accountapi.exception;

import lombok.Getter;

@Getter
public abstract class AccountApiException extends RuntimeException {
    
    private final String message;

    protected AccountApiException(String message) {
        this.message = message;
    }
}
