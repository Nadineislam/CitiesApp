package com.example.citiesapp.cities_feature.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.domain.use_case.CityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val cityUseCase: CityUseCase
) : ViewModel() {

    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val cities: StateFlow<List<City>> get() = _cities

    init {
        fetchCities()
    }

    private fun fetchCities() {
        viewModelScope.launch {
            _cities.emit(cityUseCase())
        }
    }
}