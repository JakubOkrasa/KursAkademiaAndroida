package pl.jakubokrasa.kursakademiaandroida.features.episode.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetEpisodesUseCaseTest {
    @Test
    fun `when use case is invoked, getEpisodes method from repository should be executed`() {
        //given
        val repository = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)

        //when
        useCase(Unit, GlobalScope)

        //assert
        coVerify { repository.getEpisodes() }
    }
}