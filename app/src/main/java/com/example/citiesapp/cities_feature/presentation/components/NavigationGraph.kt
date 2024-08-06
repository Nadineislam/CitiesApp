package com.example.citiesapp.cities_feature.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.citiesapp.cities_feature.data.models.City
import com.example.citiesapp.cities_feature.data.models.Coordinates
import com.example.citiesapp.cities_feature.presentation.viewmodel.CityViewModel
import com.example.citiesapp.core.utils.openCityInGoogleMaps

@Composable
fun NavigationGraph(viewModel: CityViewModel) {
    val context = LocalContext.current
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "cityList") {
        composable("cityList") {
            CityListScreen(
                viewModel = viewModel,
                onCityClick = { city ->
                    navController.navigate("cityDetails/${city.name}/${city.coordinates.latitude}/${city.coordinates.longitude}")
                    openCityInGoogleMaps(context, city)
                }
            )
        }
        composable("cityDetails/{name}/{lat}/{lon}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val latitude = backStackEntry.arguments?.getString("lat")?.toDouble()
            val longitude = backStackEntry.arguments?.getString("lon")?.toDouble()


            CityMapScreen(
                City(
                    country = "",
                    name = name ?: "",
                    id = 0,
                    coordinates = Coordinates(
                        longitude = latitude ?: .0, latitude = longitude ?: .0
                    )
                )
            )


        }
    }
}