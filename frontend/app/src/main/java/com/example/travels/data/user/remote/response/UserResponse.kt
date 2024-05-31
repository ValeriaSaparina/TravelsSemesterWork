package com.example.travels.data.user.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("id") val id: Long,
    @SerialName("email") val email: String,
    @SerialName("firstname") val firstname: String,
    @SerialName("lastname") val lastname: String
)