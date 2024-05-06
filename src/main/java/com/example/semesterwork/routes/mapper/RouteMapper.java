package com.example.semesterwork.routes.mapper;

import com.example.semesterwork.places.model.PlaceModel;
import com.example.semesterwork.routes.dto.RouteDto;
import com.example.semesterwork.routes.model.RouteModel;

public class RouteMapper {

    public RouteDto toDto(RouteModel entity) {
        return RouteDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .address(entity.getAddress())
                .description(entity.getDescription())
                .build();
    }
}
