package pl.jakubokrasa.kursakademiaandroida.features.character.domain

import pl.jakubokrasa.kursakademiaandroida.features.character.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>

    suspend fun saveCharactersToLocal(characters: List<Character>)
}