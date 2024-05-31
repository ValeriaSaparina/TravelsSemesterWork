package com.example.travels.ui.routes.mapper

import com.example.travels.domain.routes.model.RouteDomainModel
import com.example.travels.ui.places.mapper.PlacesUiModelMapper
import com.example.travels.ui.routes.model.RouteUIModel
import javax.inject.Inject

class RoutesUiModelMapper @Inject constructor(
    private val placesMapper: PlacesUiModelMapper,
) {
    fun mapToUiModel(route: RouteDomainModel): RouteUIModel {
        return with(route) {
            RouteUIModel(
                id = id,
                name = name,
                description = description,
                places = placesMapper.toUiModel(places)
            )
        }
    }

//    fun toDomainModel(route: RouteUIModel): RouteDomainModel {
//        return with(route) {
//            RouteDomainModel(
//                id = id,
//                name = name,
//                authorId = authorId,
//                type = type,
//                isFav = isFav
//            )
//        }
//    }

    fun mapTUiModel(routes: List<RouteDomainModel>): List<RouteUIModel> {
        return routes.map { mapToUiModel(it) }
    }

}
