package pl.jakubokrasa.kursakademiaandroida.features.episode.presentation.model

import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode

data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
)
{
    constructor(e: Episode): this(
        id = e.id,
        name= e.name,
        airDate = e.airDate,
        code = e.code,
        characters = e.characters,
        url = e.url
        )
}