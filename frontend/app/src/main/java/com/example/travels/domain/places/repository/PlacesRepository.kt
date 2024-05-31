package com.example.travels.domain.places.repository

import androidx.paging.PagingData
import com.example.travels.data.review.ReviewRequest
import com.example.travels.data.review.ReviewResponse
import com.example.travels.domain.places.model.PlaceDomainModel
import kotlinx.coroutines.flow.Flow

interface PlacesRepository {

    suspend fun getPlaceByTextQuery(query: String): PlaceDomainModel
    suspend fun getPlacesByPage(query: String, page: Long, pageSize: Int = 50): PlaceDomainModel
    fun searchPlaces(query: String): Flow<PagingData<PlaceDomainModel>>

    suspend fun getAllFavPlaces(): List<PlaceDomainModel>
    suspend fun getIdAllFavPlaces(): List<Long>
    suspend fun getFavPlaceById(id: Long): PlaceDomainModel
    suspend fun deleteAllFavPlaces()
    suspend fun deleteFromFavPlaces(id: Long)
    suspend fun addNewFavPlaces(vararg items: PlaceDomainModel)

    suspend fun getFavPlaces(n: Int): List<PlaceDomainModel>
    suspend fun getPlaceById(id: Long): PlaceDomainModel
    suspend fun sendReview(request: ReviewRequest) : ReviewResponse?
    suspend fun getAllReviews(placeId: Long): List<ReviewResponse>?
}
