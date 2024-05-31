package com.example.travels.ui.routes.model

import com.example.travels.data.places.remote.response.PlacesResponseModel
import com.example.travels.ui.places.model.PlaceUiModel

data class RouteUIModel(
    val id: Long,
    val name: String,
    val description: String,
    val places: List<PlaceUiModel>
)
