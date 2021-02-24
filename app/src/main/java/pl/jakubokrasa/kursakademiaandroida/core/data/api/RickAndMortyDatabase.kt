package pl.jakubokrasa.kursakademiaandroida.core.data.api

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.jakubokrasa.kursakademiaandroida.core.data.local.database.ListConverter
import pl.jakubokrasa.kursakademiaandroida.core.data.local.model.OriginCached
import pl.jakubokrasa.kursakademiaandroida.features.character.data.CharacterCached
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.EpisodeDao
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.model.EpisodeCached
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.LocationCached

@Database(entities = [EpisodeCached::class, CharacterCached::class, LocationCached::class, OriginCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
}