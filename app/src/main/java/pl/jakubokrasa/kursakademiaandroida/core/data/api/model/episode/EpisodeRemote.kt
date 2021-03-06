package pl.jakubokrasa.kursakademiaandroida.core.data.api.model.episode
import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode


data class EpisodeRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val airDate: String,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("episode") val code: String,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)
{
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

