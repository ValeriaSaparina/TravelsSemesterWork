package com.example.travels.domain.routes.usercase

import com.example.travels.data.routes.remote.mapper.RouteDomainMapper
import com.example.travels.domain.routes.repository.RoutesRepository
import com.example.travels.ui.routes.model.RouteUIModel
import com.example.travels.utils.runSuspendCatching
import javax.inject.Inject

class CreateRouteUseCase @Inject constructor(
    private val repository: RoutesRepository,
    private val mapper: RouteDomainMapper
) {
    suspend operator fun invoke(route: RouteUIModel): Result<Unit> {
        return runSuspendCatching {
            repository.createRoute(mapper.toDomainModel(route))
        }
    }
}
