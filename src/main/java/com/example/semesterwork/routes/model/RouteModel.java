package com.example.semesterwork.routes.model;

import com.example.semesterwork.places.model.PlaceModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "routes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<PlaceModel> places;
}
