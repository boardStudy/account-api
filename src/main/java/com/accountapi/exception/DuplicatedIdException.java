package com.accountapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedIdException extends AccountApiException {

    public DuplicatedIdException() {
        super("중복된 아이디입니다.");
    }
}
