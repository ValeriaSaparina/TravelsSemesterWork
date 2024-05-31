package com.example.travels.data.user.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DemoResponse(
    @SerialName("demo") val demo: String
)