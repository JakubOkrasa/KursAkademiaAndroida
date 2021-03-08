package pl.jakubokrasa.kursakademiaandroida.features.character.domain.model

import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.CharacterLocation
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.CharacterOrigin
import pl.jakubokrasa.kursakademiaandroida.features.location.domain.model.Location
import pl.jakubokrasa.kursakademiaandroida.features.origin.domain.model.Origin

data class Character (
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocation,
    val name: String,
    val origin: CharacterOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)