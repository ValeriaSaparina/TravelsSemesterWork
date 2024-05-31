package com.example.travels.ui.places.model

import com.example.travels.ui.base.DisplayableItem

data class PlaceUiModel(
    val id: Long,
    val type: String,
    val name: String,
    val description: String,
    val address: String,
    val rating: Float,
    var isFav: Boolean
) : DisplayableItem