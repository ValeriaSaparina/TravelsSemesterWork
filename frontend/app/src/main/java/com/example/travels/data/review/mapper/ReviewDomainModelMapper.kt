package com.example.travels.data.review.mapper

import com.example.travels.data.review.ReviewResponse
import com.example.travels.data.user.mapper.UserDomainMapper
import com.example.travels.domain.review.model.ReviewDomainModel
import javax.inject.Inject

class ReviewDomainModelMapper @Inject constructor(
    private val userDomainMapper: UserDomainMapper
) {

    fun toDomainModel(response: ReviewResponse?): ReviewDomainModel {
        return response?.run {
            ReviewDomainModel(
                rating = rating,
                text = text,
                user = userDomainMapper.toDomainModel(user)
            )
        } ?: ReviewDomainModel(
            rating = 0f,
            text = "",
            user = userDomainMapper.toDomainModel(null)
        )
    }

}
