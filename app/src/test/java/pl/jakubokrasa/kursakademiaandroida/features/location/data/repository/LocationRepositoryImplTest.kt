package pl.jakubokrasa.kursakademiaandroida.features.location.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pl.jakubokrasa.kursakademiaandroida.core.data.api.RickAndMortyApi
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.location.LocationsResponse
import pl.jakubokrasa.kursakademiaandroida.core.network.NetworkStateProvider
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.LocationDao
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.LocationCached
import pl.jakubokrasa.kursakademiaandroida.mock

internal class LocationRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN locations request THEN get locations from API`() {
        //given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }
        val repository = LocationRepositoryImpl(api, locationDao, networkStateProvider)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is disconnected WHEN locations request THEN get locations from local`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val dao = mockk<LocationDao>() {
            coEvery { getLocations() } returns listOf(LocationCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns false
        }
        val repository = LocationRepositoryImpl(api, dao, networkStateProvider)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { dao.getLocations() }
    }

    @Test
    fun `GIVEN network is connected WHEN locations request AND locations fetch successful THEN save locations to local`() {
        //given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val dao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }
        val repository = LocationRepositoryImpl(api, dao, networkStateProvider)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { dao.saveLocations(*anyVararg()) }
    }
}