package com.example.citiesapp.cities_feature.presentation.components

import androidx.compose.runtime.Composable
import com.example.citiesapp.cities_feature.data.models.City
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun CityMapScreen(city: City) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(
            LatLng(city.coordinates.latitude, city.coordinates.longitude),
            10f,
            0f,
            0f
        )
    }

    GoogleMap(
        cameraPositionState = cameraPositionState,
        properties = MapProperties(
            isIndoorEnabled = true
        ),
        uiSettings = MapUiSettings(
            zoomControlsEnabled = true,
            compassEnabled = true,
            myLocationButtonEnabled = false
        )
    ) {
        Marker(
            state = MarkerState(position = LatLng(city.coordinates.latitude, city.coordinates.longitude)),
            title = city.name
        )
    }
}