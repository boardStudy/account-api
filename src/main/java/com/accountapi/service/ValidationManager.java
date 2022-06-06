package com.accountapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ValidationManager {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean validateByPassword(String rawPassword, String encodedPassword){
        if(passwordEncoder.matches(rawPassword,encodedPassword)) return true;
        return false;
    }
}
