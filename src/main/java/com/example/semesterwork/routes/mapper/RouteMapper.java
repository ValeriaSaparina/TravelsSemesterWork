package com.example.semesterwork.routes.mapper;

import com.example.semesterwork.places.mapper.PlaceMapper;
import com.example.semesterwork.routes.dto.RouteDto;
import com.example.semesterwork.routes.model.RouteModel;
import com.example.semesterwork.routes.model.RouteRequest;
import lombok.AllArgsConstructor;

import java.util.stream.Collectors;

@AllArgsConstructor
public class RouteMapper {

    private final PlaceMapper placeMapper;

    public RouteDto toDto(RouteModel entity) {
        return RouteDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .places(entity.getPlaces().stream().map(placeMapper::toDto).collect(Collectors.toSet()))
                .build();
    }

    public RouteModel toEntity(RouteRequest request) {
        return RouteModel.builder()
                .name(request.getName())
                .name(request.getName())
                .places(request.getPlaces())
                .build();
    }
}
