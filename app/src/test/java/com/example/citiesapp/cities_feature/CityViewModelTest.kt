package com.example.citiesapp.cities_feature

import com.example.citiesapp.cities_feature.base.MainCoroutineExt
import com.example.citiesapp.cities_feature.presentation.viewmodel.CityViewModel
import com.example.citiesapp.core.utils.Resource
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CityViewModelTest {
    @get:Rule
    val mainCoroutineExt = MainCoroutineExt()

    private lateinit var viewModel: CityViewModel
    private lateinit var successCityUseCase: FakeSuccessUseCase
    private lateinit var errorCityUseCase: FakeErrorCityUseCase

    @Before
    fun setup() {
        successCityUseCase = FakeSuccessUseCase(fakeSuccessCityRepository)
        errorCityUseCase = FakeErrorCityUseCase()
    }

    @Test
    fun `when cities are loaded successfully then filteredCities should reflect the data`() =
        runBlocking {
            viewModel = CityViewModel(successCityUseCase)
            assertEquals(
                expectedCities,
                (viewModel.filteredCities.first() as Resource.Success).data
            )
        }


    @Test
    fun `when cities loading fails then filteredCities should reflect the error`() = runBlocking {
        viewModel = CityViewModel(errorCityUseCase)
        assertTrue(viewModel.filteredCities.first() is Resource.Error)
    }
}