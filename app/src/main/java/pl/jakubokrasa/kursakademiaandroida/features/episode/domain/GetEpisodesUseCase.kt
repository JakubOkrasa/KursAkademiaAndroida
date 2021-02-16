package pl.jakubokrasa.kursakademiaandroida.features.episode.domain

import pl.jakubokrasa.kursakademiaandroida.base.UseCase
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository):
    UseCase<List<Episode>, Unit>() {
    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()

}