package com.example.citiesapp.cities_feature.di

import com.example.citiesapp.cities_feature.data.repository.CityRepositoryImpl
import com.example.citiesapp.cities_feature.domain.repository.CityRepository
import com.example.citiesapp.cities_feature.domain.use_case.CityUseCase
import com.example.citiesapp.cities_feature.domain.use_case.ICityUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CityModule {

    @Binds
    @Singleton
    abstract fun bindCityRepository(
        cityRepositoryImpl: CityRepositoryImpl
    ): CityRepository

    @Binds
    @Singleton
    abstract fun bindCityUseCase(
        cityUseCase: CityUseCase
    ): ICityUseCase
}