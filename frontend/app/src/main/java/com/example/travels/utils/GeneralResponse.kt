package com.example.travels.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GeneralResponse (
    @SerialName("code") val code: Int,
    @SerialName("message") val message: String
)

