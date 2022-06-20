package com.accountapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ValidationManager {

    private final PasswordEncoder passwordEncoder;

    public boolean validateByPassword(String rawPassword, String encodedPassword){
        if(passwordEncoder.matches(rawPassword,encodedPassword)) return true;
        return false;
    }

    // [회원가입] 유효성 검사
    public Map<String, String> displayErrorMessage(Errors errors) {

        Map<String, String> errorMessage = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String fieldName = String.format("%s", error.getField());
            errorMessage.put(fieldName, error.getDefaultMessage());
        }

        return errorMessage;

    }
}
