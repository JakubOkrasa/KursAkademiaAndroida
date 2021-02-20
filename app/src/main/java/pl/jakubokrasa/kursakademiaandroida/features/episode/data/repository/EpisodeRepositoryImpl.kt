package pl.jakubokrasa.kursakademiaandroida.features.episode.data.repository

import pl.jakubokrasa.kursakademiaandroida.core.api.RickAndMortyApi
import pl.jakubokrasa.kursakademiaandroida.core.network.NetworkStateProvider
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.EpisodeDao
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.EpisodeCached
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.EpisodeRepository
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi,
    private val dao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider
): EpisodeRepository {
    override suspend fun getEpisodes(): List<Episode> {
        return if(networkStateProvider.isNetworkAvailable()) {
            getEpisodesFromRemote()
                .also { saveEpisodesToLocal(it)}
        } else getEpisodesFromLocal()
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
       return api.getEpisodes().results
            .map { it.toEpisode() }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
       return dao.getEpisodes().map { it.toEpisode() }
    }

    override suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { dao.saveEpisodes(*it) }
    }

}