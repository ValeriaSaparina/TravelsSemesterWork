package com.example.semesterwork.places.repository;

import com.example.semesterwork.places.model.PlaceModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<PlaceModel, Long> {

    @Query(value = """
            select * from place_model
            where lower(name) LIKE lower(concat('%', :query, '%'))
            """, nativeQuery = true)
    Optional<List<PlaceModel>> findByQuery(String query, Pageable pageable);
}
