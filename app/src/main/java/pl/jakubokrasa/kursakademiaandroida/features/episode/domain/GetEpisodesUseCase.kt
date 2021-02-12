package pl.jakubokrasa.kursakademiaandroida.features.episode.domain

import kotlinx.coroutines.*
import pl.jakubokrasa.kursakademiaandroida.features.EpisodeRepository
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) {
    operator fun invoke(
        scope: CoroutineScope,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (List<Episode>) -> Unit
    ) {
        scope.launch {
            val result = withContext(executionDispatcher) {
                episodeRepository.getEpisodes()
            }
            onResult(result)
        }
    }
}