package com.example.semesterwork.places.mapper;

import com.example.semesterwork.places.dto.PlaceDto;
import com.example.semesterwork.places.model.PlaceModel;

public class PlaceMapper {

    public PlaceDto toDto(PlaceModel entity) {
        return PlaceDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .address(entity.getAddress())
                .description(entity.getDescription())
                .build();
    }

    public PlaceModel toEntity(PlaceDto dto) {
        return PlaceModel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .type(dto.getType())
                .address(dto.getAddress())
                .description(dto.getDescription())
                .build();
    }

}
