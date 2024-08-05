package com.example.citiesapp.cities_feature.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.presentation.viewmodel.CityViewModel

@Composable
fun CityListScreen(viewModel: CityViewModel) {
    val cities by viewModel.cities.collectAsState()

    LazyColumn {
        items(cities) { city ->
            CityItem(city)
        }
    }
}


@Composable
fun CityItem(city: City) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 14.dp)
            .fillMaxWidth(),
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
                text = "Coordinates: ${city.coordinates.lat}, ${city.coordinates.lon}",
                style= TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            )
        }
    }
}