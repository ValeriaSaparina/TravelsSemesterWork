package com.example.travels.data.routes.remote.mapper

import com.example.travels.data.places.remote.mapper.PlacesResponseDomainModelMapper
import com.example.travels.data.routes.remote.model.RouteRequestModel
import com.example.travels.data.routes.remote.model.RouteResponseModel
import com.example.travels.domain.routes.model.RouteDomainModel
import com.example.travels.ui.routes.model.RouteUIModel
import javax.inject.Inject

class RouteDomainMapper @Inject constructor(
    private val placesMapper: PlacesResponseDomainModelMapper,
) {
    fun toDomainModel(response: RouteResponseModel?): RouteDomainModel {
        return response?.let {
            with(it) {
                RouteDomainModel(
                    id = id,
                    name = name,
                    description = description,
                    places = placesMapper.mapResponseToDomainModel(places.toList())
                )
            }
        } ?: RouteDomainModel(
            id = -1,
            name = "",
            description = "",
            places = listOf()
        )
    }

    fun toDomainModel(response: List<RouteResponseModel>?): List<RouteDomainModel> {
        return response?.map { toDomainModel(it) } ?: listOf()
    }

    fun toRequest(route: RouteDomainModel): RouteRequestModel {
        return with(route) {
            RouteRequestModel(
                id = id,
                name = name,
                description = description,
                places = placesMapper.toResponse(places)
            )
        }
    }

    fun toDomainModel(route: RouteUIModel): RouteDomainModel {
        return with(route) {
            RouteDomainModel(
                id = id,
                name = name,
                description = description,
                places = placesMapper.toDomainModel(places)
            )
        }
    }

}
