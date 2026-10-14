package com.example.zadanielab1.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zadanielab1.R

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO 3: Display the details of the selected movie.
        //  - read the movie id from the fragment's arguments (key: ARG_MOVIE_ID),
        //  - get the movie with MovieRepository.getMovieById(...),
        //  - fill in the views: text_title, text_subtitle, text_director, text_rating
        //    and text_description (the one you added in TODO 1).
        //  Hint: requireArguments().getInt(ARG_MOVIE_ID)
        //        view.findViewById<TextView>(R.id.text_title).text = movie.title
        //        For formatted texts look at R.string.movie_year_genre, movie_director and movie_rating.
    }

    companion object {
        const val ARG_MOVIE_ID = "movie_id"

        fun newInstance(movieId: Int): MovieDetailsFragment {
            // TODO 2: Pass movieId to the fragment through its arguments.
            //  Never pass data through the fragment's constructor: Android recreates fragments
            //  (e.g. after rotation) using the empty constructor, and only the arguments survive.
            //  Hint: MovieDetailsFragment().apply { arguments = bundleOf(ARG_MOVIE_ID to movieId) }
            return MovieDetailsFragment()
        }
    }
}
