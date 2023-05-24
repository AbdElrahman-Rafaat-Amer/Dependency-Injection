package com.example.movies.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@TypeConverters(RoomConverters::class)
@Entity(tableName = "movies")
data class MovieCashEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "rank")
    val rank: String,

    @ColumnInfo(name = "crew")
    val crew: String,

    @ColumnInfo(name = "rate")
    val rate: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "year")
    val year: String

)