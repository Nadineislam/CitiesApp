package com.example.citiesapp.cities_feature

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CityUseCaseTest {
    private lateinit var successCityUseCase: FakeSuccessUseCase
    private lateinit var errorCityUseCase: FakeErrorCityUseCase


    @Before
    fun setup() {
        successCityUseCase = FakeSuccessUseCase(fakeSuccessCityRepository)
        errorCityUseCase = FakeErrorCityUseCase()
    }

    @Test
    fun `when invoke is called with success state then a list of cities should be retrieved`() =
        runBlocking {
            assertEquals(expectedCities, successCityUseCase().toList().flatten())
        }


    @Test
    fun `when an error response is encountered during invocation then an error should be handled`() =
        runBlocking {
            val result = errorCityUseCase()
                .catch { _ -> emit(emptyList()) }
                .first()

            assertTrue(
                "Result should be an empty list due to the simulated error",
                result.isEmpty()
            )

        }
}