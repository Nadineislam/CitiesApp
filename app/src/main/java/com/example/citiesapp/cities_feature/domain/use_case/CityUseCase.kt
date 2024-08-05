package com.example.citiesapp.cities_feature.domain.use_case

import com.example.citiesapp.cities_feature.domain.repository.CityRepository
import javax.inject.Inject

class CityUseCase @Inject constructor(
    private val repository: CityRepository
) {
    suspend operator fun invoke() =
        repository.getCities().sortedBy { it.name }

}