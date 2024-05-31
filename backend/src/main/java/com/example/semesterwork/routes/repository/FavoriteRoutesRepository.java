package com.example.semesterwork.routes.repository;

import com.example.semesterwork.routes.model.FavoriteRouteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRoutesRepository extends JpaRepository<FavoriteRouteModel, Long> {
}
