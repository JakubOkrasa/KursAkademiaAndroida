package pl.jakubokrasa.kursakademiaandroida.features.character.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface CharacterDao {

    @Query("select * from CharacterCached")
    suspend fun getCharacters(): List<CharacterCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(vararg characters: CharacterCached)


}