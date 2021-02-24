package pl.jakubokrasa.kursakademiaandroida.features.episode.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.jakubokrasa.kursakademiaandroida.core.data.api.RickAndMortyApi
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.episode.EpisodesResponse
import pl.jakubokrasa.kursakademiaandroida.core.network.NetworkStateProvider
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.EpisodeDao
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.model.EpisodeCached
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.EpisodeRepository
import pl.jakubokrasa.kursakademiaandroida.mock

internal class EpisodeRepositoryImplTest {

    @Test
    fun `GIVEN no access to network WHEN episodes request THEN get episodes from local database`() {
        // given
        val api = mockk<RickAndMortyApi>(relaxed=true)

        val episodeDao = mockk<EpisodeDao>() {
            coEvery { getEpisodes() } returns listOf(EpisodeCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns false
        }

        val repository: EpisodeRepository = EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // when
        runBlocking { repository.getEpisodes() }

        // then
        coVerify { episodeDao.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }

        val episodeDao = mockk<EpisodeDao>(relaxed = true)

        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }

        val repository: EpisodeRepository = EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // when
        runBlocking { repository.getEpisodes() }

        // then
        coVerify { api.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected AND  WHEN episodes request THEN fetch episodes from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }

        val episodeDao = mockk<EpisodeDao>(relaxed = true)

        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }

        val repository: EpisodeRepository = EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // when
        runBlocking { repository.getEpisodes() }

        // then
        coVerify { episodeDao.saveEpisodes(*anyVararg()) }
    }
}