package com.example.travels.data.review

import com.example.travels.data.user.remote.response.UserResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponse(
    @SerialName("rating") val rating: Float,
    @SerialName("text") val text: String,
    @SerialName("user") val user: UserResponse,
)
