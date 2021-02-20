package pl.jakubokrasa.kursakademiaandroida.features.episode.data.local

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode

@Entity
data class EpisodeCached(
    val id: Int,
    val name: String,
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val url: String,
)
{
    constructor(episode: Episode): this(
        id=episode.id,
        name=episode.name,
        airDate=episode.airDate,
        characters=episode.characters,
        code=episode.code,
        url=episode.url
    )

    companion object

    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        characters = characters,
        code = code,
        url = url
    )
}