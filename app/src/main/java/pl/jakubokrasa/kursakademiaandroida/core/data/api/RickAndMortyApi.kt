package pl.jakubokrasa.kursakademiaandroida.core.data.api

import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.character.CharactersResponse
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.episode.EpisodesResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}