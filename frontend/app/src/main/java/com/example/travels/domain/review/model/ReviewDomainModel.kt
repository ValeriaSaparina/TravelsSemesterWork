package com.example.travels.domain.review.model

import com.example.travels.domain.user.UserModel

data class ReviewDomainModel(
    val rating: Float,
    val text: String,
    val user: UserModel,
)
