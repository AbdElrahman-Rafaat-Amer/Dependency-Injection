package com.example.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.databinding.MovieCustomRowBinding
import com.example.movies.models.Movie
import javax.inject.Inject

class MovieAdapter @Inject constructor(private var onClickListener: OnMovieClickListener) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var movies: List<Movie> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding =
            MovieCustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.onBind(movie)
    }

    override fun getItemCount(): Int = movies.size

    fun setDataSource(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    fun setOnClickListener(onClickListener: OnMovieClickListener) {
        this.onClickListener = onClickListener
    }

    inner class ViewHolder(private var binding: MovieCustomRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(movie: Movie) {
            Glide.with(context).asBitmap()
                .load(movie.image).override(200, 270)
                .into(binding.moviePoster)
            binding.movieID.text = movie.rank
            binding.movieTitle.text = movie.title
            binding.movieCrew.text = movie.crew
            binding.movieRate.text = movie.rate
            binding.movieYear.text = movie.year
            binding.root.setOnClickListener {
                onClickListener.onItemClicked(movie)
            }
        }
    }
}