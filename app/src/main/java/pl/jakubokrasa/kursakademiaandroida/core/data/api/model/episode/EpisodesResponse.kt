package pl.jakubokrasa.kursakademiaandroida.core.data.api.model.episode

import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.ResponseInfo

data class EpisodesResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<EpisodeRemote>
) {
    companion object
}