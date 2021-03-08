package pl.jakubokrasa.kursakademiaandroida.features.character.data

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.jakubokrasa.kursakademiaandroida.core.data.api.RickAndMortyApi
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.character.CharactersResponse
import pl.jakubokrasa.kursakademiaandroida.core.network.NetworkStateProvider
import pl.jakubokrasa.kursakademiaandroida.mock

internal class CharacterRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN characters request THEN get characters from API`() {
        //given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacters() } returns CharactersResponse.Companion.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }
        val repository = CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is disconnected WHEN characters request THEN get characters from local`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val dao = mockk<CharacterDao>() {
            coEvery { getCharacters() } returns listOf(CharacterCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns false
        }
        val repository = CharacterRepositoryImpl(api, dao, networkStateProvider)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { dao.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected WHEN characters request AND characters fetch successful THEN save characters to local`() {
        //given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacters() } returns CharactersResponse.Companion.mock()
        }
        val dao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }
        val repository = CharacterRepositoryImpl(api, dao, networkStateProvider)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { dao.saveCharacters(*anyVararg()) }
    }
}