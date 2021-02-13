package pl.jakubokrasa.kursakademiaandroida.features.character.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pl.jakubokrasa.kursakademiaandroida.features.character.CharacterRepository

internal class GetCharactersUseCaseTest {
    @Test
    fun `when use case is invoked, getCharacters method from repository should be executed`() {
        //given
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repository)

        //when
        useCase(Unit, GlobalScope)

        //assert
        coVerify { repository.getCharacters() }
    }
}