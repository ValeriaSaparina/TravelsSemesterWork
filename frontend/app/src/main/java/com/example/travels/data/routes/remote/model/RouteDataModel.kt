package com.example.travels.data.routes.remote.model

import com.example.travels.data.places.remote.response.PlacesResponseModel

data class RouteDataModel(
    val id: Long,
    val name: String,
    val places: Set<PlacesResponseModel>,
)