package com.example.travels.data.places.remote.mapper

import com.example.travels.data.places.remote.response.PlacesResponseModel
import com.example.travels.domain.places.model.PlaceDomainModel
import com.example.travels.ui.places.model.PlaceUiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesResponseDomainModelMapper @Inject constructor() {

    fun mapResponseToDomainModel(response: PlacesResponseModel?): PlaceDomainModel {
        return response?.let {
            with(it) {
                PlaceDomainModel(
                    id = id,
                    type = type,
                    name = name,
                    description = description,
                    address = address,
                    rating = 0.0f,
                    isFav = false
                )
            }
        } ?: PlaceDomainModel(
            id = -1,
            type = "",
            name = "",
            description = "",
            address = "",
            rating = 0.0f,
            isFav = false
        )
    }

    fun mapResponseToDomainModel(places: List<PlacesResponseModel>?): List<PlaceDomainModel> {
        return places?.map { mapResponseToDomainModel(it) } ?: listOf()
    }

    fun toResponse(places: List<PlaceDomainModel>): List<PlacesResponseModel> {
        return places.map { toResponse(it) }
    }

    fun toResponse(route: PlaceDomainModel): PlacesResponseModel {
        return with (route) {
            PlacesResponseModel(
                id = id,
                type = type,
                name = name,
                description = description,
                address = address
            )
        }
    }

    fun toDomainModel(places: List<PlaceUiModel>): List<PlaceDomainModel> {
        return places.map { toDomainModel(it) }
    }

    fun toDomainModel(place: PlaceUiModel): PlaceDomainModel {
        return with (place) {
            PlaceDomainModel(
                id = id,
                type = type,
                name = name,
                description = description,
                address = address,
                rating = rating,
                isFav = isFav
            )
        }
    }
}