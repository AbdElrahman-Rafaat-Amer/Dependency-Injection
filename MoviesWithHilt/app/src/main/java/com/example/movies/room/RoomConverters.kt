package com.example.movies.room

import androidx.room.TypeConverter
import com.example.movies.models.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class RoomConverters {
    @TypeConverter
    fun moviesListToString(minutelyList: List<Movie>): String? {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Movie>>() {}.type
        return gson.toJson(minutelyList, type)
    }

    @TypeConverter
    fun moviesStringToList(minutelyString: String?): List<Movie> {
        if (minutelyString == null) {
            return emptyList()
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Movie>>() {}.type
        return gson.fromJson(minutelyString, type)
    }

}