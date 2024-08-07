package com.example.citiesapp.cities_feature.domain.use_case

import com.example.citiesapp.cities_feature.data.models.City
import kotlinx.coroutines.flow.Flow

interface ICityUseCase {
    operator fun invoke(): Flow<List<City>>
}