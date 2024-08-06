package com.example.citiesapp.cities_feature.domain.repository

import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    fun getCities(): Flow<Resource<List<City>>>

}