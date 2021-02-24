package pl.jakubokrasa.kursakademiaandroida.features.character.data

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.location.LocationRemote
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.origin.OriginResponse
import pl.jakubokrasa.kursakademiaandroida.core.data.local.model.OriginCached
import pl.jakubokrasa.kursakademiaandroida.features.character.domain.model.Character
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.LocationCached

@Entity
data class CharacterCached(
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: LocationCached,
    val name: String,
    val origin: OriginCached,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {

    fun toCharacter() = Character(
        id=id,
        episode=episode,
        gender=gender,
        image=image,
        location=location.toLocation(),
        name=name,
        origin=origin.toOrigin(),
        species=species,
        status=status,
        type=type,
        url=url
    )
    
    constructor(character: Character) : this(
        id=character.id,
        episode=character.episode,
        gender=character.gender,
        image=character.image,
        location=LocationCached(character.location),
        name=character.name,
        origin=OriginCached(character.origin),
        species=character.species,
        status=character.status,
        type=character.type,
        url=character.url   
        
    )
}