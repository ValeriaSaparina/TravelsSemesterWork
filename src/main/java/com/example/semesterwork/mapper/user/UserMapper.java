package com.example.semesterwork.mapper.user;

import com.example.semesterwork.dto.UserDto;
import com.example.semesterwork.entity.UserEntity;

public class UserMapper {
    public static UserEntity mapDtoToEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
//                .email(userDto.getEmail())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
//                .password(userDto.)
                .build();
    }
}
