package com.example.movies.utils

sealed class DataState<out R> {
    data class Success<out T>(val movies: T) : DataState<T>()

    data class Error(val exception: String) : DataState<Nothing>()

    object Loading : DataState<Nothing>()
}