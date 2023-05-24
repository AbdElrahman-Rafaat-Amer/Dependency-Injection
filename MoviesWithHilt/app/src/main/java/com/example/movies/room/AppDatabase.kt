package com.example.movies.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [MovieCashEntity::class], version = 1)
@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDAO(): MoviesDAO

    companion object {
        const val databaseName = "MOVIES_DATABASE"
    }
}