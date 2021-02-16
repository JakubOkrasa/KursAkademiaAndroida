package pl.jakubokrasa.kursakademiaandroida.features.location.domain

import pl.jakubokrasa.kursakademiaandroida.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}