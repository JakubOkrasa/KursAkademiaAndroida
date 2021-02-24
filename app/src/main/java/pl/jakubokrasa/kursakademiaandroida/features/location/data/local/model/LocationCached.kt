package pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.features.location.domain.model.Location

@Entity
data class LocationCached(
    val id: Int,
    val dimension: String,
	 val name: String,
	 val residents: List<String>,
	 val type: String,
	 val url: String
)
{
    constructor(location: Location): this(
        id =location.id,
        dimension =location.dimension,
        name =location.name,
        residents =location.residents,
        type =location.type,
        url =location.url
    )
    
    fun toLocation() = Location(
        id = id,
        dimension = dimension,
        name = name,
        residents = residents,
        type = type,
        url = url)
}