package pl.jakubokrasa.kursakademiaandroida.core.data.api.model.origin


import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.features.origin.domain.model.Origin

data class OriginResponse(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

{
    fun toOrigin() = Origin(name, url)
}