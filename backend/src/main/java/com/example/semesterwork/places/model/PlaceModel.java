package com.example.semesterwork.places.model;

import com.example.semesterwork.routes.model.RouteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity(name = "places")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String name;
    private String description;
    private String address;
    @OneToMany(mappedBy = "place")
    private List<ReviewPlaceModel> reviews;
    @ManyToMany()
    private Set<RouteModel> routes;
}
