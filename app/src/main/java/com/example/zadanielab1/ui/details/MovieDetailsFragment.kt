package com.example.zadanielab1.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zadanielab1.R
import com.example.zadanielab1.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieDetailsBinding.bind(view)

        // TODO 4: Display the details of the selected movie using the local binding.
        //  - read the movie id from the fragment's arguments (key: ARG_MOVIE_ID),
        //  - get the movie with MovieRepository.getMovieById(...),
        //  - populate textTitle, textSubtitle, textDirector, textRating and textDescription
        //    (the last binding property is generated after you add the view in TODO 1).
        //  Hint: requireArguments().getInt(ARG_MOVIE_ID)
        //        Use binding properties and the movie's fields to set each view's text.
        //        Format year/genre, director and rating with getString and the existing
        //        R.string.movie_year_genre, movie_director and movie_rating resources.
    }

    companion object {
        const val ARG_MOVIE_ID = "movie_id"

        fun newInstance(movieId: Int): MovieDetailsFragment {
            // TODO 2: Pass movieId to the fragment through its arguments.
            //  Never pass data through the fragment's constructor: Android recreates fragments
            //  (e.g. after rotation) using the empty constructor, and only the arguments survive.
            //  Create a Bundle, use putInt with ARG_MOVIE_ID, and set the fragment's arguments.
            return MovieDetailsFragment()
        }
    }
}
