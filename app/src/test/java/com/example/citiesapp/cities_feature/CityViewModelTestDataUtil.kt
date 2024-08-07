package com.example.citiesapp.cities_feature

import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.data.models.Coordinates
import com.example.citiesapp.cities_feature.domain.repository.CityRepository
import com.example.citiesapp.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

val expectedCities = listOf(
    City("Tokyo", "Japan", 3, Coordinates(35.6895, 139.6917)),
    City("London", "UK", 2, Coordinates(51.5074, -0.1278)),
    City("New York", "USA", 1, Coordinates(40.7128, -74.0060))
)

val fakeSuccessCityRepository = object : CityRepository {
    override fun getCities(): Flow<Resource<List<City>>> = flow {
        emit(Resource.Success(expectedCities))
    }
}





