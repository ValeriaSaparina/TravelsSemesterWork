package com.example.semesterwork.routes.repository;

import com.example.semesterwork.places.model.PlaceModel;
import com.example.semesterwork.routes.model.RouteModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<RouteModel, Long> {

    @Query(value = """
            select * from routes
            where lower(name) LIKE lower(concat('%', :query, '%'))
            """, nativeQuery = true)
    Optional<List<RouteModel>> findByQuery(String query, Pageable pageable);
}
