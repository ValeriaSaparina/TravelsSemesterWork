package com.example.semesterwork.routes.model;

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
public class RouteRequest {
    private Long id;
    private String name;
    private String description;
    private Set<PlaceModel> places;
}
