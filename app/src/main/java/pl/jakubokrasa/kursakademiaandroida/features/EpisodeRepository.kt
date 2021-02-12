package pl.jakubokrasa.kursakademiaandroida.features

import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}