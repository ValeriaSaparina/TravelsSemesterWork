package com.example.travels.data.places.remote

import com.example.travels.data.places.remote.response.PlacesResponseModel
import com.example.travels.data.review.ReviewRequest
import com.example.travels.data.review.ReviewResponse
import com.example.travels.utils.Constants
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PlacesApi {

    @GET("allPlaces")
    suspend fun getPlaceByTextQuery(
        @Query("query") query: String,
        @Query("pageSize") pageSize: Int = Constants.MAX_PAGE_SIZE,
    ): PlacesResponseModel?

    @GET("places")
    suspend fun getPlacesByQueryPage(
        @Query("query") query: String,
        @Query("pageSize") pageSize: Int = Constants.MAX_PAGE_SIZE,
        @Query("pageNumber") page: Int
    ): List<PlacesResponseModel>?

    @GET("placeDetails")
    suspend fun getPlaceById(
        @Query("id") id: Long
    ): PlacesResponseModel?


    @POST("sendReview")
    suspend fun sendReview(
        @Body request: ReviewRequest
    ): ReviewResponse

    @GET("getAllReviews")
    suspend fun getAllReviews(
        @Query("placeId") placeId: Long
    ): List<ReviewResponse>?



}