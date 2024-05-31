package com.example.travels.data.review

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewRequest(
    @SerialName("rating") val rating: Float,
    @SerialName("text") val text: String,
    @SerialName("placeId") val placeId: Long,
)