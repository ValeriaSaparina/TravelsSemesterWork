package com.example.travels.domain.places.usecase

import com.example.travels.data.review.ReviewRequest
import com.example.travels.data.review.mapper.ReviewDomainModelMapper
import com.example.travels.domain.places.repository.PlacesRepository
import com.example.travels.domain.review.model.ReviewDomainModel
import com.example.travels.utils.runSuspendCatching
import javax.inject.Inject

class SendPlaceReviewUseCase @Inject constructor(
    private val repository: PlacesRepository,
    private val mapper: ReviewDomainModelMapper,
) {
    suspend operator fun invoke(placeId: Long, rating: String, text: String): Result<ReviewDomainModel> {
        return runSuspendCatching {
            mapper.toDomainModel(repository.sendReview(
                ReviewRequest(
                    placeId = placeId,
                    rating = rating.toFloat(),
                    text = text,
                )
            ))
        }
    }
}
