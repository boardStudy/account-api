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

    // 유저정보
    @Transactional
    public User findUserById(String userId){
        return userMapper.findUserById(userId);
    }
}

