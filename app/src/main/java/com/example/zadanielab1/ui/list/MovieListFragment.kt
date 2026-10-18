package com.example.zadanielab1.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zadanielab1.R
import com.example.zadanielab1.data.MovieRepository
import com.example.zadanielab1.databinding.FragmentMovieListBinding
import com.example.zadanielab1.ui.details.MovieDetailsFragment

class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMovieListBinding.bind(view)
        binding.recyclerMovies.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerMovies.adapter = MovieAdapter(MovieRepository.getMovies()) { movieId ->
            openDetails(movieId)
        }
    }

    private fun openDetails(movieId: Int) {
        // Task 3: open details and keep the transaction for return navigation.
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container, MovieDetailsFragment.newInstance(movieId))
            addToBackStack(null)
        }
    }
}
