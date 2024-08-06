package com.example.citiesapp.cities_feature.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.domain.use_case.CityUseCase
import com.example.citiesapp.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    cityUseCase: CityUseCase
) : ViewModel() {

    private val _cities = cityUseCase().map { cities ->
        Resource.Success(cities) as Resource<List<City>>
    }
        .catch { e ->
            emit(Resource.Error("Failed to load cities: ${e.message}"))
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = Resource.Loading()
        )

    val cities get() = _cities


}