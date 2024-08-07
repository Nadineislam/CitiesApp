package com.example.citiesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.citiesapp.cities_feature.presentation.components.NavigationGraph
import com.example.citiesapp.cities_feature.presentation.viewmodel.CityViewModel
import com.example.citiesapp.ui.theme.CitiesAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: CityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CitiesAppTheme {
                NavigationGraph(viewModel = viewModel)
            }
        }
    }
}



