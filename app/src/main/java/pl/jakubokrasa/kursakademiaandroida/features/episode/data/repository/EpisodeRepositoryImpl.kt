package pl.jakubokrasa.kursakademiaandroida.features.episode.data.repository

import pl.jakubokrasa.kursakademiaandroida.core.data.api.RickAndMortyApi
import pl.jakubokrasa.kursakademiaandroida.core.network.NetworkStateProvider
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.EpisodeDao
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.model.EpisodeCached
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.EpisodeRepository
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
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
       return episodeDao.getEpisodes().map { it.toEpisode() }
    }

    override suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

}