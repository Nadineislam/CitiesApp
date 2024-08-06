package com.example.citiesapp.core.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.citiesapp.cities_feature.data.models.City

fun openCityInGoogleMaps(context: Context, city: City) {
    val geoUri =
        Uri.parse("geo:${city.coordinates.latitude},${city.coordinates.longitude}?q=${city.coordinates.latitude},${city.coordinates.longitude}(${city.name})")
    val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
    mapIntent.setPackage("com.google.android.apps.maps")

    mapIntent.resolveActivity(context.packageManager).let {
        context.startActivity(mapIntent)
    }
}