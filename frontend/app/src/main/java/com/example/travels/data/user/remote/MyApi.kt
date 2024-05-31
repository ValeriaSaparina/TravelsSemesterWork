package com.example.travels.data.user.remote

import com.example.travels.data.user.remote.request.RefreshRequest
import com.example.travels.data.user.remote.request.AuthRequest
import com.example.travels.data.user.remote.request.UserRequest
import com.example.travels.data.user.remote.response.DemoResponse
import com.example.travels.data.user.remote.response.TokenResponse
import com.example.travels.domain.user.UserModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @POST("auth/authentication")
    suspend fun auth(
        @Body request: AuthRequest
    ): TokenResponse?

    @GET("demo")
    suspend fun demo(): DemoResponse

    @POST("auth/refresh-token")
    suspend fun refreshToken(@Body request : RefreshRequest) : TokenResponse?

    @POST("auth/register")
    suspend fun register(@Body request: UserRequest): TokenResponse?
    @GET("auth/getCurrentUser")
    fun getCurrentUser(): UserModel
}