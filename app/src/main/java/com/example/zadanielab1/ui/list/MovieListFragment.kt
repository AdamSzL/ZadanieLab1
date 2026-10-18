package com.example.zadanielab1.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zadanielab1.R
import com.example.zadanielab1.data.MovieRepository
import com.example.zadanielab1.databinding.FragmentMovieListBinding

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
        // TODO 3: Navigate to MovieDetailsFragment.
        //  - create the fragment with MovieDetailsFragment.newInstance(movieId) (TODO 2),
        //  - replace the current fragment in R.id.fragment_container,
        //  - add the transaction to the back stack, so the system "back" button returns to the list.
        //  Hint: parentFragmentManager.commit { ... } (androidx.fragment.app.commit)
        //        with setReorderingAllowed(true), replace(...) and addToBackStack(null) inside.
    }
}
