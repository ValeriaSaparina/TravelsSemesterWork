package com.example.semesterwork.places.dto;

import com.example.semesterwork.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPlaceDto {
    private Long id;
    private String text;
    private Float rating;
    private Long place;
    private UserDto user;

}