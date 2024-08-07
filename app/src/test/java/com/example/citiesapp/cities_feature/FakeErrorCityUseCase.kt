package com.example.citiesapp.cities_feature

import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.domain.use_case.ICityUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeErrorCityUseCase : ICityUseCase {
    override fun invoke(): Flow<List<City>> = flow {
        throw Exception("Simulated error retrieving cities")
    }
}