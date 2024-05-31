package com.example.travels.ui.review.model

import com.example.travels.domain.user.UserModel
import com.example.travels.ui.base.DisplayableItem

data class ReviewUiModel(
    val author: UserModel,
    val rating: String,
    val text: String
) : DisplayableItem
