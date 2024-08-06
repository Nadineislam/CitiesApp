package com.example.citiesapp.cities_feature.presentation.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.presentation.viewmodel.CityViewModel
import com.example.citiesapp.core.utils.Resource


@Composable
fun CityListScreen(viewModel: CityViewModel, onCityClick: (City) -> Unit) {
    val citiesState by viewModel.cities.collectAsStateWithLifecycle()
    val context = LocalContext.current

    when (citiesState) {
        is Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is Resource.Error -> {
            Toast.makeText(
                context,
                "Failed to load cities: ${citiesState.message}",
                Toast.LENGTH_SHORT
            ).show()
        }

        is Resource.Success -> {
            val cities = (citiesState as Resource.Success<List<City>>).data
            val nonNullCities = cities ?: emptyList()
            LazyColumn {
                items(nonNullCities) { city ->
                    CityItem(city) { clickedCity ->
                        onCityClick(clickedCity)
                    }
                }
            }
        }
    }
}

@Composable
fun CityItem(city: City, onClick: (City) -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 14.dp)
            .fillMaxWidth()
            .clickable {
                onClick(city)
            },
        border = BorderStroke(0.1.dp, Color.Gray),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "${city.name}, ${city.country}",
                style = TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
            )
            Text(
                text = "Coordinates: ${city.coordinates.latitude}, ${city.coordinates.longitude}",
                style = TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            )
        }
    }
}
