package com.example.travels.domain.routes.usercase

import com.example.travels.domain.routes.model.RouteDomainModel
import com.example.travels.domain.routes.repository.RoutesRepository
import com.example.travels.utils.runSuspendCatching
import javax.inject.Inject

class SearchRoutesUseCase @Inject constructor(
    private val repository: RoutesRepository,
) {
    suspend operator fun invoke(query: String): Result<List<RouteDomainModel>> {
        return runSuspendCatching {
            repository.searchRoutes(query)
        }
    }
}
