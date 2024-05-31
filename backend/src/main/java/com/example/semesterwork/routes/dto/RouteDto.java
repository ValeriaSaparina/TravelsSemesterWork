package com.example.semesterwork.routes.dto;

import com.example.semesterwork.places.dto.PlaceDto;
import com.example.semesterwork.places.model.PlaceModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {
    private Long id;
    private String name;
    private String description;
    private Set<PlaceDto> places;
}
