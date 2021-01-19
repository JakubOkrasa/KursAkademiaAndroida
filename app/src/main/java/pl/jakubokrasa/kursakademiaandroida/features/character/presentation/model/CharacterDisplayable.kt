package pl.jakubokrasa.kursakademiaandroida.features.character.presentation.model

import pl.jakubokrasa.kursakademiaandroida.features.character.domain.model.Character
import pl.jakubokrasa.kursakademiaandroida.features.data.remote.model.OriginResponse
import pl.jakubokrasa.kursakademiaandroida.features.data.remote.model.LocationRemote
import pl.jakubokrasa.kursakademiaandroida.features.location.presentation.model.LocationDisplayable

data class CharacterDisplayable(
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDisplayable,
    val name: String,
    val origin: OriginResponse,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(c: Character): this(
        episode = c.episode,
        gender = c.gender,
        id = c.id,
        image = c.image,
        location = LocationDisplayable(c.location),
        name = c.name,
        origin = c.origin,
        species = c.species,
        status = c.status,
        type = c.type,
        url = c.url
    )
}