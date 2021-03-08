package pl.jakubokrasa.kursakademiaandroida.features.character.data

import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.location.LocationRemote
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.origin.OriginResponse
import pl.jakubokrasa.kursakademiaandroida.core.data.local.model.OriginCached
import pl.jakubokrasa.kursakademiaandroida.features.character.domain.model.Character
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.CharacterLocation
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.CharacterOrigin
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.LocationCached

@Entity
data class CharacterCached(
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    @Embedded(prefix = "CharacterLocationCached") val location: CharacterLocationCached,
    val name: String,
    @Embedded(prefix = "CharacterOriginCached") val origin: CharacterOriginCached,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        id=character.id,
        episode=character.episode,
        gender=character.gender,
        image=character.image,
        location=CharacterLocationCached(character.location),
        name=character.name,
        origin=CharacterOriginCached(character.origin),
        species=character.species,
        status=character.status,
        type=character.type,
        url=character.url

    )

    fun toCharacter() = Character(
        id=id,
        episode=episode,
        gender=gender,
        image=image,
        location=location.toCharacterLocation(),
        name=name,
        origin=origin.toCharacterOrigin(),
        species=species,
        status=status,
        type=type,
        url=url
    )
    
    companion object
}

class CharacterOriginCached(
    val name: String,
    val url: String
) {

    constructor(origin: CharacterOrigin) : this(origin.name, origin.url)

    fun toCharacterOrigin() = CharacterOrigin(name, url)

}

class CharacterLocationCached(
    val id: Int,
    val dimension: String,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {

    constructor(location: CharacterLocation) : this(
        id = location.id,
        dimension = location.dimension,
        name = location.name,
        residents = location.residents,
        type = location.type,
        url = location.url)

    fun toCharacterLocation() = CharacterLocation(
        id = id,
        dimension = dimension,
        name = name,
        residents = residents,
        type = type,
        url = url)
}