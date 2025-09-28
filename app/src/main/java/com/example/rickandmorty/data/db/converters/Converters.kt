package com.example.rickandmorty.data.db.converters

import androidx.room.TypeConverter
import com.example.rickandmorty.domain.models.Location
import com.example.rickandmorty.domain.models.Origin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomDataConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromOrigin(origin: Origin): String = gson.toJson(origin)

    @TypeConverter
    fun toOrigin(json: String): Origin =
        gson.fromJson(json, Origin::class.java)

    @TypeConverter
    fun fromLocation(location: Location): String = gson.toJson(location)

    @TypeConverter
    fun toLocation(json: String): Location =
        gson.fromJson(json, Location::class.java)

    @TypeConverter
    fun fromEpisodeList(list: List<String>): String = gson.toJson(list)

    @TypeConverter
    fun toEpisodeList(json: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(json, type)
    }
}
