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
    constructor(episode: Episode): this(
        id = episode.id,
        name= episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
        )
}