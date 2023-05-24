package com.example.movies.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.adapter.MovieAdapter
import com.example.movies.adapter.OnMovieClickListener
import com.example.movies.databinding.FragmentMoviesBinding
import com.example.movies.models.Movie
import com.example.movies.utils.DataState
import com.example.movies.viewmodel.MainStateEvent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.example.movies.viewmodel.MoviesViewModel


@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val moviesViewModel: MoviesViewModel by viewModels()

    @Inject
    lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObservers()
        moviesViewModel.setSateEvent(MainStateEvent.GetMovies)
    }

    private fun initRecyclerView() {
        binding.allMoviesRecyclerView.apply {
            val customLayoutManager = LinearLayoutManager(requireContext())
            customLayoutManager.orientation = LinearLayoutManager.VERTICAL
            layoutManager = customLayoutManager
            adapter = movieAdapter
        }

        movieAdapter.setOnClickListener(object : OnMovieClickListener {
            override fun onItemClicked(movie: Movie) {
                Navigation.findNavController(requireView()).navigate(R.id.movieDetailsFragment)
            }

        })
    }

    private fun subscribeObservers() {
        /*   moviesViewModel.movies.observe(viewLifecycleOwner) {
               if (!it.isNullOrEmpty()) {
                   movieAdapter.setDataSource(it)
               }
           }*/

        moviesViewModel.dataState.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Success<List<Movie>> -> {
                    binding.allMoviesRecyclerView.visibility = View.VISIBLE
                    binding.loadingProgressBar.visibility = View.GONE
                    movieAdapter.setDataSource(it.movies)
                }

                is DataState.Error -> {
                    binding.allMoviesRecyclerView.visibility = View.GONE
                    binding.loadingProgressBar.visibility = View.GONE
                    Log.i("MoviesTag", "subscribeObservers:error ${it.exception}")
                }

                is DataState.Loading -> {
                    binding.allMoviesRecyclerView.visibility = View.GONE
                    binding.loadingProgressBar.visibility = View.VISIBLE
                }

                else -> {
                    binding.allMoviesRecyclerView.visibility = View.GONE
                    binding.loadingProgressBar.visibility = View.GONE
                    Log.i("MoviesTag", "subscribeObservers:error Unknown Error")
                }
            }
        }
    }

}