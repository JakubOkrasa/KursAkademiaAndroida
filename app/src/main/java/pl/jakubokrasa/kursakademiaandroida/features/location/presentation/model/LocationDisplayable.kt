package pl.jakubokrasa.kursakademiaandroida.features.location.presentation.model

import pl.jakubokrasa.kursakademiaandroida.features.location.domain.model.Location

data class LocationDisplayable(
    val id: Int,
    val name: String,
    val dimension: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    constructor(loc: Location): this(
        id = loc.id,
        name = loc.name,
        dimension = loc.dimension,
        residents = loc.residents,
        type = loc.type,
        url = loc.url
    )
}