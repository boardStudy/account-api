package com.accountapi.exception;

public class InvalidPasswordException extends AccountApiException{
    protected InvalidPasswordException() {
        super("부적절한 패스워드입니다.");
    }
}
