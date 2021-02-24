package pl.jakubokrasa.kursakademiaandroida.features.character.data

import pl.jakubokrasa.kursakademiaandroida.core.data.api.RickAndMortyApi
import pl.jakubokrasa.kursakademiaandroida.core.network.NetworkStateProvider
import pl.jakubokrasa.kursakademiaandroida.features.character.domain.CharacterRepository
import pl.jakubokrasa.kursakademiaandroida.features.character.domain.model.Character
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.repository.EpisodeRepositoryImpl

class CharacterRepositoryImpl(
    private val api: RickAndMortyApi,
    private val networkStateProvider: NetworkStateProvider,
    private val characterDao: CharacterDao): CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return if(networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote()
                .also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return characterDao.getCharacters()
            .map { it.toCharacter() }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return api.getCharacters().results
            .map { it.toCharacter() }
    }

    override suspend fun saveCharactersToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }
}