package com.example.travels.domain.places.model

data class PlaceDomainModel(
    val id: Long,
    val type: String,
    val name: String,
    val description: String,
    val address: String,
    val rating: Float,
    val isFav: Boolean
)