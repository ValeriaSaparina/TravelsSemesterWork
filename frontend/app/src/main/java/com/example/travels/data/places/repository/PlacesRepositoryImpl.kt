package com.example.travels.data.places.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.travels.data.places.PlacesPagingSource
import com.example.travels.data.places.remote.PlacesApi
import com.example.travels.data.places.remote.mapper.PlacesResponseDomainModelMapper
import com.example.travels.data.review.ReviewRequest
import com.example.travels.data.review.ReviewResponse
import com.example.travels.domain.places.model.PlaceDomainModel
import com.example.travels.domain.places.repository.PlacesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlacesRepositoryImpl @Inject constructor(
    private val placesApi: PlacesApi,
    private val responseDomainModelMapper: PlacesResponseDomainModelMapper,
) : PlacesRepository {

    override suspend fun getPlaceByTextQuery(query: String): PlaceDomainModel {
        return responseDomainModelMapper.mapResponseToDomainModel(
            response = placesApi.getPlaceByTextQuery(
                query
            )
        )
    }

    override suspend fun getPlacesByPage(
        query: String,
        page: Long,
        pageSize: Int
    ): PlaceDomainModel {
        TODO("not used")
//        return responseDomainModelMapper.mapResponseToDomainModel(
//            placesApi.getPlacesByQueryPage(
//                query = query,
//                page = page.toInt()
//            )
//        )
    }

    override fun searchPlaces(query: String): Flow<PagingData<PlaceDomainModel>> = Pager(
        pagingSourceFactory = {
            PlacesPagingSource(
                placesApi = placesApi,
                repository = this,
                mapperDomainModel = responseDomainModelMapper,
                query = query
            )
        },
        config = PagingConfig(
            pageSize = 10,
            prefetchDistance = 4,
        )
    ).flow

    override suspend fun addNewFavPlaces(vararg items: PlaceDomainModel) {
//        TODO("not implemented")
//        val entities = mutableListOf<PlaceDomainModel>()
//        items.forEach {
//            entities.add(responseDomainModelMapper.toEntity(it))
//        }
//        placesApi.addNewPlaces(*entities.toTypedArray())
    }

    override suspend fun deleteFromFavPlaces(id: Long) {
        TODO("not implemented")
//        placesApi.deleteFavPlace(id)
    }

    override suspend fun getAllFavPlaces(): List<PlaceDomainModel> {
        TODO("not implemented")
//        return placesApi.getAllFavPlaces()?.map {
//            favPlaceDomainModelMapper.toDomainModel(it)
//        } ?: listOf()
    }

    override suspend fun getFavPlaces(n: Int): List<PlaceDomainModel> {
        TODO("not implemented")
//
//        return placesApi.getFavPlaces(n)?.map {
//            favPlaceDomainModelMapper.toDomainModel(it)
//        } ?: listOf()
    }

    override suspend fun getPlaceById(id: Long): PlaceDomainModel {
        return responseDomainModelMapper.mapResponseToDomainModel(placesApi.getPlaceById(id))
    }

    override suspend fun sendReview(request: ReviewRequest): ReviewResponse {
        return placesApi.sendReview(request)
    }

    override suspend fun getAllReviews(placeId: Long): List<ReviewResponse>? {
        return placesApi.getAllReviews(placeId)
    }


    override suspend fun getIdAllFavPlaces(): List<Long> {
        TODO("not implemented")
//        return placesApi.getIdAllFavPlaces()
    }

    override suspend fun getFavPlaceById(id: Long): PlaceDomainModel {
        TODO("not implemented")
//        return responseDomainModelMapper.toDomainModel(placesApi.getFavPlace(id))
    }

    override suspend fun deleteAllFavPlaces() {
        TODO("not implemented")
//        favoritePlacesDao.deleteAllFavPlaces()
    }
}
