package pl.jakubokrasa.kursakademiaandroida.features.location.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetLocationsUseCaseTest {
    @Test
    fun `when use case is invoked, getLocations method from repository should be executed`() {
        //given
        val repository = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationsUseCase(repository)

        //when
        useCase(Unit, GlobalScope)

        //assert
        coVerify { repository.getLocations() }
    }
}