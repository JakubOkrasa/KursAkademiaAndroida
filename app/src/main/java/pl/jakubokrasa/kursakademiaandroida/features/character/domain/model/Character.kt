package pl.jakubokrasa.kursakademiaandroida.features.character.domain.model

import pl.jakubokrasa.kursakademiaandroida.features.data.remote.model.OriginResponse
import pl.jakubokrasa.kursakademiaandroida.features.location.domain.model.Location
import pl.jakubokrasa.kursakademiaandroida.features.origin.domain.model.Origin

data class Character (
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)