package com.example.travels.ui.createRoute

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travels.domain.places.usecase.GetFavoritePlacesUseCase
import com.example.travels.domain.routes.usercase.CreateRouteUseCase
import com.example.travels.ui.places.mapper.PlacesUiModelMapper
import com.example.travels.ui.places.model.PlaceUiModel
import com.example.travels.ui.routes.model.RouteUIModel
import com.example.travels.utils.CreateRouteError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateRouteViewModel @Inject constructor(
    private val createRouteUseCase: CreateRouteUseCase,
    private val getFavoritePlacesUseCase: GetFavoritePlacesUseCase,
    private val placesMapper: PlacesUiModelMapper,
) : ViewModel() {
    private var _error = MutableStateFlow<CreateRouteError?>(null)
    val error: StateFlow<CreateRouteError?> get() = _error

    private val _places = mutableListOf<PlaceUiModel>(PlaceUiModel(
        id = 1,
        type = "type1",
        name = "name1",
        description = "desc1",
        address = "address1",
        rating = 0.0f,
        isFav = true,
    ))

    private val _success = MutableStateFlow<Boolean?>(null)
    val success: StateFlow<Boolean?> get() = _success

    private val _favPlaces = MutableStateFlow<List<PlaceUiModel>?>(null)
    val favPlaces: StateFlow<List<PlaceUiModel>?> get() = _favPlaces

    fun deleteFromList(item: PlaceUiModel) {
        _places.remove(item)
    }

    fun getFavPlaces() {

        viewModelScope.launch {
            getFavoritePlacesUseCase.invoke()
                .onSuccess {
                    _favPlaces.emit(placesMapper.toUiModel(it))
                }
                .onFailure {
                    Log.d("GET_FAVS", it.toString())
                }
        }
    }

    fun createRoute(name: String, description: String) {
        if (isValidData(name, description)) {
            val route = RouteUIModel(
                id = -1,
                name = name,
                description = description,
                places = _places
            )
            viewModelScope.launch {
                createRouteUseCase.invoke(route)
                    .onSuccess {
                        _success.emit(true)
                    }
                    .onFailure {
                        Log.d("GET_FAVS", it.toString())
                        _error.emit(CreateRouteError.UNEXPECTED)
                    }
            }
        }
    }

    private fun isValidData(
        name: String,
        description: String,
    ): Boolean {
        if (name.isEmpty()) {
            _error.value = CreateRouteError.EMPTY_VALUE
            return false
        }
        if (description.isEmpty()) {
            _error.value = CreateRouteError.EMPTY_VALUE
            return false
        }
        if (_places.isEmpty()) {
            _error.value = CreateRouteError.EMPTY_LIST
            return false
        }
        return true
    }

    fun onPlaceCliced(item: PlaceUiModel) {
        if (_places.contains(item)) {
            _places.add(item)
        } else {
            _places.remove(item)
        }
    }

}



