package com.accountapi.mapper;

import com.accountapi.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findUserById(String userId);
}
