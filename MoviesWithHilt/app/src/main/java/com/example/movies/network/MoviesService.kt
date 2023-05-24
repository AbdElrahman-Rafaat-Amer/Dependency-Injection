package com.example.movies.network

import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    @GET("k_hs8g0y00")
    suspend fun getAllMovies() : Response<MovieResponse>
}