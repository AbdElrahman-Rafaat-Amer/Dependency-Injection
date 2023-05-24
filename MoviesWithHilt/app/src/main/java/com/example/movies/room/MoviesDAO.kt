package com.example.movies.room

import androidx.room.*


@Dao
interface MoviesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(note: MovieCashEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(notes: List<MovieCashEntity>)

    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<MovieCashEntity>

    @Query("DELETE FROM movies where rank = :rank")
    suspend fun deleteMovie(rank: Int) : Int

    @Query("SELECT * FROM movies where rank = :rank")
    suspend fun getMovieDetails(rank: Int) : MovieCashEntity
}