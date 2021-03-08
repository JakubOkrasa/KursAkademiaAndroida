package pl.jakubokrasa.kursakademiaandroida.core.data.local.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter {
    companion object {
        @JvmStatic
        @TypeConverter
        fun toJson(data: List<String>): String {
            return Gson().toJson(data)
        }

        @JvmStatic
        @TypeConverter
        fun toList(json: String): List<String> {
            return Gson().fromJson(json, object: TypeToken<List<String>>() {}.type)
        }
    }


}