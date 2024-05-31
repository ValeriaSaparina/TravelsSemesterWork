package com.example.travels.data.user.remote.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRequest (
    @SerialName("email") private val email: String? = null,
    @SerialName("password") private val password: String? = null,
    @SerialName("firstname") private val firstname: String? = null,
    @SerialName("lastname") private val lastname: String? = null,
)