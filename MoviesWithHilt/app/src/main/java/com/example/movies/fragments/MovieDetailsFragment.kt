package com.example.movies.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.databinding.MovieCustomRowBinding
import com.example.movies.models.Movie
import com.example.movies.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment(R.layout.movie_custom_row) {
    private val moviesViewModel: MoviesViewModel by viewModels()
    private lateinit var binding: MovieCustomRowBinding
    private lateinit var movie: Movie

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieCustomRowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        Glide.with(requireContext()).asBitmap()
            .load(movie.image).override(200, 270)
            .into(binding.moviePoster)
        binding.movieID.text = movie.rank
        binding.movieTitle.text = movie.title
        binding.movieCrew.text = movie.crew
        binding.movieRate.text = movie.rate
        binding.movieYear.text = movie.year
    }
}