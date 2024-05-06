package com.example.semesterwork.routes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {
    // Routes dto
    private Long id;
    private String type;
    private String name;
    private String description;
    private String address;
}
