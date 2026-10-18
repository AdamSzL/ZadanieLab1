package com.example.zadanielab1.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zadanielab1.R
import com.example.zadanielab1.data.MovieRepository
import com.example.zadanielab1.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieDetailsBinding.bind(view)

        // Task 4: map the selected movie onto the details views.
        val movieId = requireArguments().getInt(ARG_MOVIE_ID)
        val movie = MovieRepository.getMovieById(movieId) ?: return

        binding.textTitle.text = movie.title
        binding.textSubtitle.text = getString(R.string.movie_year_genre, movie.year, movie.genre)
        binding.textDirector.text = getString(R.string.movie_director, movie.director)
        binding.textRating.text = getString(R.string.movie_rating, movie.rating)
        binding.textDescription.text = movie.description
    }

    companion object {
        const val ARG_MOVIE_ID = "movie_id"

        fun newInstance(movieId: Int): MovieDetailsFragment {
            // Task 2: arguments preserve the selected ID when Android recreates the fragment.
            return MovieDetailsFragment().apply {
                arguments = Bundle().apply { putInt(ARG_MOVIE_ID, movieId) }
            }
        }
    }
}
