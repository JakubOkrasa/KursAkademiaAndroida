package pl.jakubokrasa.kursakademiaandroida.core.api

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.jakubokrasa.kursakademiaandroida.core.database.ListConverter
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.EpisodeDao
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.EpisodeCached

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
}