package pl.jakubokrasa.kursakademiaandroida.features.character.domain

import pl.jakubokrasa.kursakademiaandroida.base.UseCase
import pl.jakubokrasa.kursakademiaandroida.features.character.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository): UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}