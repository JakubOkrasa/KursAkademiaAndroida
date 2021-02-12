package pl.jakubokrasa.kursakademiaandroida.features.character

import pl.jakubokrasa.kursakademiaandroida.features.character.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}