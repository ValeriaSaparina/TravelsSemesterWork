package com.example.travels.data.routes.remote.model

import com.example.travels.data.places.remote.response.PlacesResponseModel
import kotlinx.serialization.Serializable

@Serializable
data class RouteRequestModel(
    val id: Long,
    val name: String,
    val description: String,
    val places: List<PlacesResponseModel>
)
