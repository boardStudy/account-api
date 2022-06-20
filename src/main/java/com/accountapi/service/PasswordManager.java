package com.accountapi.service;

import com.accountapi.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordManager {

    private final PasswordEncoder passwordEncoder;

    public String encodePassword(User signUpInfo) {

        String rawPassword = signUpInfo.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        return encodedPassword;
    }
}
