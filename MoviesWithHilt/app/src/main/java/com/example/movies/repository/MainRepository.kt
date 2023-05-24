package com.example.movies.repository

import android.util.Log
import com.example.movies.models.Movie
import com.example.movies.network.MoviesService
import com.example.movies.network.NetworkMapper
import com.example.movies.room.CacheMapper
import com.example.movies.room.MoviesDAO
import com.example.movies.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository constructor(
    private val dao: MoviesDAO,
    private val moviesService: MoviesService,
    private val networkMapper: NetworkMapper,
    private val cacheMapper: CacheMapper
) {

    suspend fun getOnlineMovies(): Flow<DataState<List<Movie>>> = flow {
        emit(DataState.Loading)
        try {
            val onlineMovies = moviesService.getAllMovies()
            if (onlineMovies.isSuccessful && onlineMovies.body()?.errorMessage == "") {
                val movies = networkMapper.mapFromEntityList(onlineMovies.body()!!)
                emit(DataState.Success(movies))
            } else {
                if (onlineMovies.isSuccessful)
                    emit(DataState.Error(onlineMovies.body()!!.errorMessage))
                else
                    emit(DataState.Error(onlineMovies.message()))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("MoviesTag", "getOnlineMovies: ${e.localizedMessage}")
            emit(DataState.Error(e.message!!))
        }
    }

    private suspend fun saveMoviesToRoom(movies: List<Movie>) {
        val cacheMovies = cacheMapper.mapToEntityList(movies)
        dao.insertMovies(cacheMovies)
    }

    suspend fun getAllCachedMovies(): List<Movie> {
        val cacheMovies = dao.getAllMovies()
        return cacheMapper.mapFromEntityList(cacheMovies)

    }

    suspend fun insertMovie(movie: Movie): Long {
        val cachedMovie = cacheMapper.mapToEntity(movie)
        return dao.insertMovie(cachedMovie)
    }

    suspend fun deleteMovie(movieRank: Int): Int {
        return dao.deleteMovie(movieRank)

    }

    suspend fun getMovieDetails(movieRank: Int): Movie {
        val cachedMovie = dao.getMovieDetails(movieRank)
        return cacheMapper.mapFromEntity(cachedMovie)
    }
}