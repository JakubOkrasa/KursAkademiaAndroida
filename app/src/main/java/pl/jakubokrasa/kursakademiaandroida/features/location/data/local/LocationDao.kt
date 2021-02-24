package pl.jakubokrasa.kursakademiaandroida.features.location.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.jakubokrasa.kursakademiaandroida.features.location.data.local.model.LocationCached

interface LocationDao {

    @Query("select * from LocationCached")
    suspend fun getLocations(): List<LocationCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg locations: LocationCached)
}