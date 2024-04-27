package com.example.semesterwork.user.mapper;

import com.example.semesterwork.user.dto.UserDto;
import com.example.semesterwork.user.model.MyUser;

public class UserMapper {

    public UserDto entityToDto(MyUser user) {
        return UserDto
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .isActive(user.getIsActive())
                .isBlocked(user.getIsBlocked())
                .build();
    }

}
