package com.example.movies.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.movies.fragments.MovieDetailsFragment
import com.example.movies.fragments.MoviesFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi

import javax.inject.Inject

class FragmentsFactory @Inject constructor() : FragmentFactory() {

//    @OptIn(ExperimentalCoroutinesApi::class)
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            MoviesFragment::class.java.name -> {
                return MoviesFragment()
            }

            MovieDetailsFragment::class.java.name -> {
                return MovieDetailsFragment()
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}