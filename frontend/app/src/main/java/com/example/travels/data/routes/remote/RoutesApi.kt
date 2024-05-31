package com.example.travels.data.routes.remote

import com.example.travels.data.routes.remote.model.RouteRequestModel
import com.example.travels.data.routes.remote.model.RouteResponseModel
import com.example.travels.utils.GeneralResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RoutesApi {

    @GET("routes")
    suspend fun getRouteByTextQuery(
        @Query("query") query: String
    ): List<RouteResponseModel>?

    @POST("createRoute")
    suspend fun createRoute(
        @Body request: RouteRequestModel
    ): GeneralResponse?


}