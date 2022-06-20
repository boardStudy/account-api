package com.accountapi.service;

import com.accountapi.dto.User;
import com.accountapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountManager {

    private final UserMapper userMapper;
    private final PasswordManager passwordManager;


    // 유저정보
    @Transactional
    public User findUserById(String userId){
        return userMapper.findUserById(userId);
    }

    // 회원가입
    @Transactional
    public void createUser(User signUpInfo) {

        String encodedPassword = passwordManager.encodePassword(signUpInfo);
        signUpInfo.setPassword(encodedPassword);

        User newUser = new User(
                signUpInfo.getUserId(),
                signUpInfo.getPassword(),
                signUpInfo.getEmail(),
                signUpInfo.getName(),
                signUpInfo.getGender(),
                signUpInfo.getPhone());

        userMapper.createUser(newUser);
    }
}

