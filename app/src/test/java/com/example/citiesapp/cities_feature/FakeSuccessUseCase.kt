package com.example.citiesapp.cities_feature

import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.domain.repository.CityRepository
import com.example.citiesapp.cities_feature.domain.use_case.ICityUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeSuccessUseCase @Inject constructor(
    private val repository: CityRepository
) : ICityUseCase {

    override fun invoke(): Flow<List<City>> = flow {
        val cities = repository.getCities().first().data ?: emptyList()
        emit(cities.sortedBy { it.name })
    }
}