package com.example.semesterwork.routes.model;

import com.example.semesterwork.places.model.PlaceModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "favorite_routes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteRouteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "route_id")
    private RouteModel route;
    private Long userId;
}