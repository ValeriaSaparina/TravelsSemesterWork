package com.example.semesterwork.places.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "favorite_places")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoritePlaceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "place_id")
    private PlaceModel place;
    private Long userId;
}