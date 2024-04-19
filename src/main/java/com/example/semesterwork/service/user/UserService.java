package com.example.semesterwork.service.user;

import com.example.semesterwork.dto.UserDto;
import com.example.semesterwork.entity.UserEntity;

public interface UserService {
    // crud
    void addUser(UserEntity userEntity);
    UserDto getUserById(Long id);

}
