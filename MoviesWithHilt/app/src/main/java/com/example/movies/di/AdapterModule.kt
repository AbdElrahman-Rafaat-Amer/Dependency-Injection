package com.example.movies.di


import com.example.movies.adapter.OnMovieClickListener
import com.example.movies.models.Movie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@InstallIn(FragmentComponent::class)
@Module
object AdapterModule {

    @FragmentScoped
    @Provides
    fun provideOnMovieClickInstance(): OnMovieClickListener {
        return OnMovieClickImpl()
    }

}

class OnMovieClickImpl @Inject constructor() : OnMovieClickListener {
    override fun onItemClicked(movie: Movie) {

    }

}