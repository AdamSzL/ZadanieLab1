package com.example.zadanielab1.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zadanielab1.R
import com.example.zadanielab1.data.Movie

class MovieAdapter(
    private val movies: List<Movie>,
    private val onMovieClick: (movieId: Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.text_title)
        val subtitle: TextView = itemView.findViewById(R.id.text_subtitle)
        val rating: TextView = itemView.findViewById(R.id.text_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        val context = holder.itemView.context

        holder.title.text = movie.title
        holder.subtitle.text = context.getString(R.string.movie_year_genre, movie.year, movie.genre)
        holder.rating.text = context.getString(R.string.movie_rating, movie.rating)
        holder.itemView.setOnClickListener { onMovieClick(movie.id) }
    }

    override fun getItemCount(): Int = movies.size
}
