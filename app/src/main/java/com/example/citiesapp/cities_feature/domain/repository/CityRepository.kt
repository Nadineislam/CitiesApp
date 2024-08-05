package com.example.citiesapp.cities_feature.domain.repository

import com.example.citiesapp.cities_feature.data.models.City

interface CityRepository {
    suspend fun getCities(): List<City>

}