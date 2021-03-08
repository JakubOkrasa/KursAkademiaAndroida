package pl.jakubokrasa.kursakademiaandroida.features.character.presentation.model

import pl.jakubokrasa.kursakademiaandroida.features.character.domain.model.Character
import pl.jakubokrasa.kursakademiaandroida.features.location.presentation.model.LocationDisplayable
import pl.jakubokrasa.kursakademiaandroida.features.origin.presentation.model.OriginDisplayable

data class CharacterDisplayable(
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val originName: String,
    val locationName: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character): this(
        episode = character.episode,
        gender = character.gender,
        id = character.id,
        image = character.image,
        name = character.name,
        locationName = character.location.name,
        originName = character.origin.name,
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )
}