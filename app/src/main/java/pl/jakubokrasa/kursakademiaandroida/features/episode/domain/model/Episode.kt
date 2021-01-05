package pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model


data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
)