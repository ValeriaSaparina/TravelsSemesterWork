package com.example.travels.domain.routes.model

import com.example.travels.domain.places.model.PlaceDomainModel

data class RouteDomainModel(
    val id: Long,
    val name: String,
    val description: String,
    val places: List<PlaceDomainModel>,
)
