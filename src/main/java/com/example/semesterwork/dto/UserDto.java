package com.example.semesterwork.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Dto{
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
}