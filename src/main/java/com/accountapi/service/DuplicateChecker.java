package com.accountapi.service;

import com.accountapi.exception.DuplicatedIdException;
import com.accountapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DuplicateChecker {

    private final UserMapper userMapper;

    @Transactional
    public void checkDuplicateId(String userId) {

        int count = userMapper.checkDuplicateId(userId);

        if(count > 0)
            throw new DuplicatedIdException();
    }

}
