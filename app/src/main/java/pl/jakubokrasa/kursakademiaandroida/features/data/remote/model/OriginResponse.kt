package pl.jakubokrasa.kursakademiaandroida.features.data.remote.model


import com.google.gson.annotations.SerializedName

data class OriginResponse(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)