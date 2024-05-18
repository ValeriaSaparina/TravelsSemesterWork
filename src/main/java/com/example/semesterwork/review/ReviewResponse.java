package com.example.semesterwork.review;

import com.example.semesterwork.user.dto.UserDto;
import com.example.semesterwork.user.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewResponse {
    private Float rating;
    private String text;
    private UserDto user;
}
