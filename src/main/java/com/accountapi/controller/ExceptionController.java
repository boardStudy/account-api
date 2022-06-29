package com.accountapi.controller;

import com.accountapi.dto.ErrorDto;
import com.accountapi.exception.AccountApiException;
import com.accountapi.exception.DuplicatedIdException;
import com.accountapi.exception.InvalidPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@RestController
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> processValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("](은)는 ");
            builder.append(fieldError.getDefaultMessage());
            builder.append(" 입력된 값: [");
            builder.append(fieldError.getRejectedValue());
            builder.append("]");
        }
        return ResponseEntity.badRequest().body(builder.toString());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AccountApiException.class)
    public ErrorDto invalidIdError(AccountApiException ex) {
        return new ErrorDto(ex.getMessage());
    }
}
