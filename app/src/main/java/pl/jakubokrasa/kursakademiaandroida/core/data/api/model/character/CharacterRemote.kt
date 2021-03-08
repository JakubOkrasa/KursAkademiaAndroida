package pl.jakubokrasa.kursakademiaandroida.core.data.api.model.character


import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.features.character.domain.model.Character
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.CharacterLocation
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.CharacterOrigin

data class CharacterRemote(
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val location: CharacterLocationRemote,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: CharacterOriginResponse,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {

 fun toCharacter() = Character(
  episode=episode,
  gender=gender,
  id=id,
  image=image,
  location= location.toCharacterLocation(),
  name=name,
  origin=origin.toCharacterOrigin(),
  species=species,
  status=status,
  type=type,
  url=url
 )
    companion object
}

class CharacterOriginResponse(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {

    fun toCharacterOrigin() = CharacterOrigin(name, url)
}

class CharacterLocationRemote(
    @SerializedName("id")val id: Int,
    @SerializedName("dimension")val dimension: String,
    @SerializedName("name") val name: String,
    @SerializedName("residents") val residents: List<String>,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {

    fun toCharacterLocation() = CharacterLocation(
        id=id,
        dimension=dimension,
        name=name,
        residents=residents,
        type=type,
        url=url
    )
}
