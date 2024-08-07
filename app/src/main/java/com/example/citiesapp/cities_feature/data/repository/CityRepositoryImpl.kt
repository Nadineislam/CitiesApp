package com.example.citiesapp.cities_feature.data.repository

import android.content.Context
import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.domain.repository.CityRepository
import com.example.citiesapp.core.utils.Resource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.InputStreamReader
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val context: Context
) : CityRepository {

    override fun getCities(): Flow<Resource<List<City>>> = flow {
        emit(Resource.Loading())
        try {
            val cities = withContext(Dispatchers.IO) {
                context.assets.open("cities.json").use { inputStream ->
                    val reader = InputStreamReader(inputStream)
                    val listType = object : TypeToken<List<City>>() {}.type
                    Gson().fromJson<List<City>>(reader, listType)
                }
            }
            emit(Resource.Success(cities))
        } catch (e: Exception) {
            emit(Resource.Error("Failed to load cities: ${e.message}"))
        }
    }
}