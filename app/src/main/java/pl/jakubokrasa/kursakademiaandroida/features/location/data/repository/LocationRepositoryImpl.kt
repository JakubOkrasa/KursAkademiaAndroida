package pl.jakubokrasa.kursakademiaandroida.features.location.data.repository

import pl.jakubokrasa.kursakademiaandroida.core.data.api.RickAndMortyApi
import pl.jakubokrasa.kursakademiaandroida.core.network.NetworkStateProvider
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.LocationDao
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.LocationCached
import pl.jakubokrasa.kursakademiaandroida.features.location.domain.LocationRepository
import pl.jakubokrasa.kursakademiaandroida.features.location.domain.model.Location

class LocationRepositoryImpl(
    private val api: RickAndMortyApi,
    private val locationDao: LocationDao,
    private val networkStateProvider: NetworkStateProvider
    ): LocationRepository {
    override suspend fun getLocations(): List<Location> {
        return if(networkStateProvider.isNetworkAvailable()) {
            getLocationsFromRemote()
                .also { saveLocationsToLocal(it) }
        } else {
            getLocationsFromLocal()
        }
    }

    private suspend fun getLocationsFromLocal(): List<Location> {
        return locationDao.getLocations().map { it.toLocation() }
    }

    private suspend fun getLocationsFromRemote(): List<Location> {
        return api.getLocations().results.map { it.toLocation() }
    }

    override suspend fun saveLocationsToLocal(locations: List<Location>) {
        locations.map { LocationCached(it) }
            .toTypedArray()
            .let { locationDao.saveLocations(*it) }
    }
}