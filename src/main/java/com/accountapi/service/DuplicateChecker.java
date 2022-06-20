package com.accountapi.service;

import com.accountapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DuplicateChecker {

    private final UserMapper userMapper;

    @Transactional
    public int checkDuplicateId(String userId) {
        int count = userMapper.checkDuplicateId(userId);
        return count;
    }

    @Transactional
    public int checkDuplicatePhone(String phone) {
        int count = userMapper.checkDuplicatePhone(phone);
        return count;
    }
}
