package pl.jakubokrasa.kursakademiaandroida.features.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RickAndMorty::class], version = 1, exportSchema = false)
abstract class RickAndMortyDatabase : RoomDatabase() {

}