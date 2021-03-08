package pl.jakubokrasa.kursakademiaandroida.core.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.jakubokrasa.kursakademiaandroida.core.data.api.RickAndMortyDatabase

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            RickAndMortyDatabase::class.java,
            "rick-and-morty-db"
        ).build()
    }

    single { get<RickAndMortyDatabase>().episodeDao() }
}