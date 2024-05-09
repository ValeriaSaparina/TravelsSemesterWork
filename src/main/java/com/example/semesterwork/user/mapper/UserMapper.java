package com.example.semesterwork.user.mapper;

import com.example.semesterwork.user.dto.UserDto;
import com.example.semesterwork.user.model.UserModel;

public class UserMapper {

    public UserDto entityToDto(UserModel user) {
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
