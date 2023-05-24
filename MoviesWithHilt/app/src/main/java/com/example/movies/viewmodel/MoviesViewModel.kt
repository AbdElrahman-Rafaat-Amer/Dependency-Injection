package com.example.movies.viewmodel

import android.util.Log
import androidx.lifecycle.*

import com.example.movies.models.Movie
import com.example.movies.repository.MainRepository
import com.example.movies.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MainRepository) : ViewModel() {

    private var _movies = MutableLiveData<List<Movie>>()
    var movies: LiveData<List<Movie>> = _movies

    private var _movie = MutableLiveData<Movie>()
    var movie: LiveData<Movie> = _movie

    private var _errorMessage = MutableLiveData<Int>()
    var errorMessage: LiveData<Int> = _errorMessage

    private var _dataState = MutableLiveData<DataState<List<Movie>>>()
    var dataState: LiveData<DataState<List<Movie>>> = _dataState


    fun setSateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetMovies -> {
                    repository.getOnlineMovies().onEach {
                        _dataState.value = it
                    }.launchIn(viewModelScope)
                }

                is MainStateEvent.None -> {
                    Log.i("MoviesTag", "setSateEvent: at MainStateEvent.None")
                }
            }
        }
    }
    /*  init {
          getAllMovies()
      }

      private fun getAllMovies() {
          repository.getOnlineMovies()
      }

      fun getMovieDetails(movieID: Int) {
          repository.getMovieDetails(movieID)
      }

      fun deleteMovie(movieID: Int) {
          val state = repository.deleteMovie(movieID)
          if (state > 0){
              _errorMessage.postValue(R.string.delete_success_message)
          }else{
              _errorMessage.postValue(R.string.delete_error_message)
          }
      }

      fun insertMovie(movie: Movie) {
          val state = repository.insertMovie(movie)
          if (state > 0){
              _errorMessage.postValue(R.string.insert_success_message)
          }else{
              _errorMessage.postValue(R.string.insert_error_message)
          }
      }*/
}

sealed class MainStateEvent {
    object GetMovies : MainStateEvent()

    object None : MainStateEvent()
}