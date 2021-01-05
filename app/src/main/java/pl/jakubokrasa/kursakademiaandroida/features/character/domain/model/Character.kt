package pl.jakubokrasa.kursakademiaandroida.features.character.domain.model

import pl.jakubokrasa.kursakademiaandroida.features.data.remote.model.LocationRemote
import pl.jakubokrasa.kursakademiaandroida.features.data.remote.model.OriginResponse

data class Character (
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationRemote,
    val name: String,
    val origin: OriginResponse,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)