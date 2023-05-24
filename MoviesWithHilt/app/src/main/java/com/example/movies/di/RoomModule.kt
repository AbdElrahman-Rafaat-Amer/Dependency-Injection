package com.example.movies.di

import android.content.Context
import androidx.room.Room
import com.example.movies.room.AppDatabase
import com.example.movies.room.MoviesDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, AppDatabase.databaseName
        ).fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun provideMoviesDAO(appDatabase: AppDatabase): MoviesDAO {
        return appDatabase.moviesDAO()
    }
}