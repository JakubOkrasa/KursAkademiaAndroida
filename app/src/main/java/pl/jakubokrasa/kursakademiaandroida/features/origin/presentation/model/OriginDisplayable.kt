package pl.jakubokrasa.kursakademiaandroida.features.origin.presentation.model

import pl.jakubokrasa.kursakademiaandroida.features.origin.domain.model.Origin

data class OriginDisplayable(
    val name: String,
    val url: String
)
{
    constructor(origin: Origin) : this(
        name = origin.name,
        url = origin.url
    )
}