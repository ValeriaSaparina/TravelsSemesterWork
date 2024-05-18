package com.example.semesterwork.places.repository;

import com.example.semesterwork.places.model.ReviewPlaceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewPlaceRepository extends JpaRepository<ReviewPlaceModel, Long> {
    List<ReviewPlaceModel> findReviewPlaceModelByPlaceId(Long placeId);
}
