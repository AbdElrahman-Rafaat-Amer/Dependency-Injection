package com.example.movies.di

import com.example.movies.network.MoviesService
import com.example.movies.network.NetworkMapper
import com.example.movies.repository.MainRepository
import com.example.movies.room.CacheMapper
import com.example.movies.room.MoviesDAO
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        dao: MoviesDAO,
        moviesService: MoviesService,
        networkMapper: NetworkMapper,
        cacheMapper: CacheMapper
    ): MainRepository {
        return MainRepository(dao, moviesService, networkMapper, cacheMapper)
    }
}