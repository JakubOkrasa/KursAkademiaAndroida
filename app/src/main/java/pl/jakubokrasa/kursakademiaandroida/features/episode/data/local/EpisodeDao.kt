package pl.jakubokrasa.kursakademiaandroida.features.episode.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.jakubokrasa.kursakademiaandroida.features.episode.data.local.model.EpisodeCached

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM EpisodeCached")
    suspend fun getEpisodes(): List<EpisodeCached>

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(vararg episodes: EpisodeCached) //vararg, bo może być
}