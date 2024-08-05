package com.example.citiesapp.cities_feature.data.models

import com.google.gson.annotations.SerializedName

data class City(
    val country: String,
    val name: String,
    @SerializedName("_id")
    val id: Int,
    @SerializedName("coord")
    val coordinates: Coordinates
)
