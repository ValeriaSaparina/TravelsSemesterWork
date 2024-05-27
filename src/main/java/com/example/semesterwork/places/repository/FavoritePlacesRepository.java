package com.example.semesterwork.places.repository;

import com.example.semesterwork.places.model.FavoritePlaceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritePlacesRepository  extends JpaRepository<FavoritePlaceModel, Long> {
}
