package com.example.travels.data.places.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlacesResponseModel(
    @SerialName("id") val id: Long,
    @SerialName("type") val type: String,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("address") val address: String,
)
