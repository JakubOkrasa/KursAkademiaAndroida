package pl.jakubokrasa.kursakademiaandroida.features.episode.domain

import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>

    suspend fun saveEpisodesToLocal(episodes: List<Episode>)
}