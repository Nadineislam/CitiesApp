package com.example.citiesapp.cities_feature.domain.use_case

import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CityUseCase @Inject constructor(
    private val repository: CityRepository
) : ICityUseCase {
    override operator fun invoke(): Flow<List<City>> =
        repository.getCities().map { resource ->
            resource.data?.sortedBy { it.name } ?: emptyList()
        }


}