package com.example.semesterwork.places.model;

import com.example.semesterwork.user.model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "reviews")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPlaceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Float rating;
    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceModel place;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}