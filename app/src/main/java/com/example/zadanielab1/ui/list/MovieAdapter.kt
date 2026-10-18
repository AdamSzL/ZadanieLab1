package com.example.zadanielab1.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zadanielab1.R
import com.example.zadanielab1.data.Movie
import com.example.zadanielab1.databinding.ItemMovieBinding

class MovieAdapter(
    private val movies: List<Movie>,
    private val onMovieClick: (movieId: Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        val context = holder.itemView.context

        holder.binding.textTitle.text = movie.title
        holder.binding.textSubtitle.text = context.getString(R.string.movie_year_genre, movie.year, movie.genre)
        holder.binding.textRating.text = context.getString(R.string.movie_rating, movie.rating)
        holder.itemView.setOnClickListener { onMovieClick(movie.id) }
    }

    override fun getItemCount(): Int = movies.size
}
