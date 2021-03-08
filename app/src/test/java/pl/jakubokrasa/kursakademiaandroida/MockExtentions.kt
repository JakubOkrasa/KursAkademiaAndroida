package pl.jakubokrasa.kursakademiaandroida

import org.jetbrains.annotations.TestOnly
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.episode.EpisodeRemote
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.episode.EpisodesResponse
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.ResponseInfo
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.character.CharacterLocationRemote
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.character.CharacterOriginResponse
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.character.CharacterRemote
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.character.CharactersResponse
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.location.LocationRemote
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.location.LocationsResponse
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.origin.OriginResponse
import pl.jakubokrasa.kursakademiaandroida.core.data.local.model.OriginCached
import pl.jakubokrasa.kursakademiaandroida.features.character.data.CharacterCached
import pl.jakubokrasa.kursakademiaandroida.features.character.data.CharacterLocationCached
import pl.jakubokrasa.kursakademiaandroida.features.character.data.CharacterOriginCached
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.model.EpisodeCached
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.CharacterLocation
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.LocationCached

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
    info= ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    created = "some created date",
    episode= listOf("E10", "E12", "E44"),
    gender= "male",
    id=33,
    image= "image url",
    location = CharacterLocationRemote(
        10,
        "example dimension",
        "example name",
        listOf("example resident"),
        "example type",
        "example url"
    ),
    name="name",
    origin= CharacterOriginResponse(
        "example name",
        "example url"
    ),
    species="species name",
    status="ready status",
    type="type",
    url="url"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info= ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    episode= listOf("E10", "E12", "E44"),
    gender= "male",
    id=33,
    image= "image url",
    location = CharacterLocationCached(
        10,
        "example dimension",
        "example name",
        listOf("example resident"),
        "example type",
        "example url"
    ),
    name="name",
    origin= CharacterOriginCached(
        "example name",
        "example url"
    ),
    species="species name",
    status="ready status",
    type="type",
    url="url"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    created = "some created date",
    id = 77,
    dimension = "dimension",
    name = "name",
    residents = listOf("res1", "res2"),
    type = "type",
    url = "url"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info= ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 77,
    dimension = "dimension",
    name = "name",
    residents = listOf("res1", "res2"),
    type = "type",
    url = "url"
)

@TestOnly
fun OriginResponse.Companion.mock() = OriginResponse(
    name= "origin name",
    url = "origin url"
)

@TestOnly
fun OriginCached.Companion.mock() = OriginCached(
    name= "origin name",
    url = "origin url"
)