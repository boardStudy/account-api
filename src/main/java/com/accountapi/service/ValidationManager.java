package com.accountapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationManager {

    private final PasswordEncoder passwordEncoder;

    public boolean validateByPassword(String rawPassword, String encodedPassword){
        if(passwordEncoder.matches(rawPassword,encodedPassword)) return true;
        return false;
    }
}
