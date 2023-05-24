package com.example.movies.adapter

import com.example.movies.models.Movie

interface OnMovieClickListener {
    fun onItemClicked(movie : Movie)
}