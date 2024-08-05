package com.example.citiesapp.cities_feature.data.repository

import android.content.Context
import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.domain.repository.CityRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import javax.inject.Inject

class CityRepositoryImpl  @Inject constructor(
    private val context: Context
) : CityRepository {

    override suspend fun getCities(): List<City> {
        return context.assets.open("cities.json").use { inputStream ->
            val reader = InputStreamReader(inputStream)
            val listType = object : TypeToken<List<City>>() {}.type
            Gson().fromJson(reader, listType)
        }
    }
}