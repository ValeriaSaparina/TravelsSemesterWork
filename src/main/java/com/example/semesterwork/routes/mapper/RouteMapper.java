package com.example.semesterwork.routes.mapper;

import com.example.semesterwork.routes.dto.RouteDto;
import com.example.semesterwork.routes.model.RouteModel;
import com.example.semesterwork.routes.model.RouteRequest;

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

    public RouteModel toEntity(RouteRequest request) {
        return RouteModel.builder()
                .name(request.getName())
                .type(request.getType())
                .address(request.getAddress())
                .description(request.getDescription())
                .build();
    }
}
