package pl.jakubokrasa.kursakademiaandroida.core.data.api.model.character

import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.ResponseInfo

data class CharactersResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}