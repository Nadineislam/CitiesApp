package com.example.citiesapp.cities_feature.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citiesapp.cities_feature.domain.use_case.CityUseCase
import com.example.citiesapp.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class CityViewModel @Inject constructor(
    cityUseCase: CityUseCase
) : ViewModel() {
    private val _searchQuery = MutableStateFlow("")

    private val _cities = cityUseCase().map { cities ->
        Resource.Success(cities)
    }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = Resource.Loading()
        )

    val filteredCities = combine(_searchQuery, _cities) { query, resource ->
        when (resource) {
            is Resource.Success -> {
                val filtered = resource.data?.filter { city ->
                    city.name.startsWith(query, ignoreCase = true)
                } ?: emptyList()
                Resource.Success(filtered)
            }

            is Resource.Error -> resource
            is Resource.Loading -> Resource.Loading()
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = Resource.Loading()
    )

    fun onSearchQueryChanged(query: String) = viewModelScope.launch {
        _searchQuery.emit(query)

    }
}