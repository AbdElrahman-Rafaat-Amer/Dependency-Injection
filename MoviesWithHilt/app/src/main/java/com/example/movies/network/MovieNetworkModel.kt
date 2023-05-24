package com.example.movies.network
import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("errorMessage")
    val errorMessage: String,

    @SerializedName("items")
    val movies: List<MovieNetworkModel>
)


data class MovieNetworkModel(

    @SerializedName("crew")
    val crew: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("rank")
    val rank: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("year")
    val year: String,

    @SerializedName("imDbRating")
    val imDbRating: String
)