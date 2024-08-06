package com.example.citiesapp.cities_feature.domain.use_case

import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.domain.repository.CityRepository
import com.example.citiesapp.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CityUseCase @Inject constructor(
    private val repository: CityRepository
) {
    operator fun invoke(): Flow<List<City>> =
        repository.getCities().map { resource ->
            when (resource) {
                is Resource.Success -> resource.data?.sortedBy { it.name } ?: emptyList()
                else -> emptyList()
            }
        }

}