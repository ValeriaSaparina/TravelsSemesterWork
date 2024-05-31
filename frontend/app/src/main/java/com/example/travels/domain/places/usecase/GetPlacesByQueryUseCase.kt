package com.example.travels.domain.places.usecase

import com.example.travels.domain.places.model.PlaceDomainModel
import com.example.travels.domain.places.repository.PlacesRepository
import com.example.travels.utils.runSuspendCatching
import javax.inject.Inject

class GetPlacesByQueryUseCase @Inject constructor(
    private val repository: PlacesRepository,
) {
    suspend operator fun invoke(query: String): Result<PlaceDomainModel> {
        return runSuspendCatching {
            repository.getPlaceByTextQuery(query)
        }
    }
}