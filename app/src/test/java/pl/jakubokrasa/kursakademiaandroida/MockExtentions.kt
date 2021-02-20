package pl.jakubokrasa.kursakademiaandroida

import org.jetbrains.annotations.TestOnly
import pl.jakubokrasa.kursakademiaandroida.core.api.model.EpisodeRemote
import pl.jakubokrasa.kursakademiaandroida.core.api.model.EpisodesResponse
import pl.jakubokrasa.kursakademiaandroida.core.api.model.ResponseInfo
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.EpisodeCached

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "some date"
)

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "some url",
    prev = "some url"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info=ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)