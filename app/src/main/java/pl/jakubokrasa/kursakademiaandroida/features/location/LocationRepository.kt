package pl.jakubokrasa.kursakademiaandroida.features.location

import pl.jakubokrasa.kursakademiaandroida.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}