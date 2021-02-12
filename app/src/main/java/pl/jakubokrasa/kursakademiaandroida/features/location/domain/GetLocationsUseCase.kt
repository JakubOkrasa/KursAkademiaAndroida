package pl.jakubokrasa.kursakademiaandroida.features.location.domain

import pl.jakubokrasa.kursakademiaandroida.base.UseCase
import pl.jakubokrasa.kursakademiaandroida.features.location.LocationRepository
import pl.jakubokrasa.kursakademiaandroida.features.location.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository): UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit) = locationRepository.getLocations()
}