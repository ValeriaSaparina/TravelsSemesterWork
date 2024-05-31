package com.example.travels.ui.places.mapper

import com.example.travels.domain.places.model.PlaceDomainModel
import com.example.travels.ui.places.model.PlaceUiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesUiModelMapper @Inject constructor() {
    fun mapItemDomainToItemUiModel(item: PlaceDomainModel?): PlaceUiModel {
        return item?.let {
            return PlaceUiModel(
                id = it.id,
                type = it.type,
                name = it.name,
                description = it.description,
                address = it.address,
                rating = it.rating,
                isFav = it.isFav
            )
        } ?: PlaceUiModel(
            id = -1,
            type = "",
            name = "",
            description = "",
            address = "",
            rating = 0.0f,
            isFav = false,
        )
    }


    fun toDomainModel(item: PlaceUiModel): PlaceDomainModel {
        return with(item) {
            PlaceDomainModel(
                id = id.toLong(),
                type = type,
                name = name,
                description = description,
                address = address,
                rating = rating,
                isFav = isFav
            )
        }
    }

    fun toUiModel(item: PlaceDomainModel): PlaceUiModel {
        return with(item) {
            PlaceUiModel(
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

    fun toUiModel(items: List<PlaceDomainModel>): List<PlaceUiModel> {
        val result = mutableListOf<PlaceUiModel>()
        items.forEach {
            result.add(toUiModel(it))
        }
        return result
    }

}