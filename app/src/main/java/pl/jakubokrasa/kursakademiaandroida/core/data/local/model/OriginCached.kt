package pl.jakubokrasa.kursakademiaandroida.core.data.local.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.features.origin.domain.model.Origin

@Entity
data class OriginCached(
    val name: String,
    val url: String
) {
    constructor(origin: Origin): this(
        name = origin.name,
        url = origin.url
    )

    fun toOrigin() = Origin(
        name = name,
        url = url)
}