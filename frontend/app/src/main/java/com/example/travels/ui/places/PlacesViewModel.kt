package com.example.travels.ui.places

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.travels.domain.places.usecase.AddNewFavPlaceUseCase
import com.example.travels.domain.places.usecase.DeleteFromFavPlacesUseCase
import com.example.travels.domain.places.usecase.SearchPlacesUseCase
import com.example.travels.ui.places.mapper.PlacesUiModelMapper
import com.example.travels.ui.places.model.PlaceUiModel
import com.example.travels.utils.NetworkErrors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlacesViewModel @Inject constructor(
    private val searchPlacesUseCase: SearchPlacesUseCase,
    private val addNewFavPlaceUseCase: AddNewFavPlaceUseCase,
    private val deleteFromFavPlacesUseCase: DeleteFromFavPlacesUseCase,
    private val mapper: PlacesUiModelMapper,
) : ViewModel() {

    private val _error = MutableStateFlow<NetworkErrors?>(null)
    val error: StateFlow<NetworkErrors?> get() = _error

    private val queries = MutableSharedFlow<String>()

    val result = queries.flatMapLatest { query ->
        searchPlacesUseCase(query)
            .map { pagingData ->
                pagingData.map { place ->
                    mapper.mapItemDomainToItemUiModel(place)
                }
            }
    }.cachedIn(viewModelScope)

    fun searchPlaces(query: String) {
        viewModelScope.launch {
            queries.emit(query)
        }
    }

    fun onFavIcClicked(item: PlaceUiModel) {
        viewModelScope.launch {
            if (item.isFav) {
                deleteFromFavPlacesUseCase.invoke(item.id)
            } else {
                addNewFavPlaceUseCase.invoke(item)
            }
            item.isFav = !item.isFav
        }
    }

}
