package com.example.zadanielab1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.zadanielab1.databinding.ActivityMainBinding
import com.example.zadanielab1.ui.list.MovieListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Add the list only on the first start. After a configuration change (e.g. rotation)
        // the FragmentManager restores its fragments and the back stack by itself.
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container, MovieListFragment())
            }
        }

        // TODO 5a: Show the "up" arrow in the Toolbar only when the details screen is visible.
        //  - check the fragment displayed in R.id.fragment_container (MovieDetailsFragment),
        //  - use supportActionBar?.setDisplayHomeAsUpEnabled(...),
        //  - update after transactions with addOnBackStackChangedListener,
        //    and set the initial state here too, including after Activity recreation.
        //  Hint: findFragmentById(...) checks the displayed screen; backStackEntryCount
        //        may still have its old value while predictive Back is completing.
    }

    override fun onSupportNavigateUp(): Boolean {
        // TODO 5b: Go back to the list when the "up" arrow is tapped.
        //  Hint: supportFragmentManager.popBackStack(), then return true
        return super.onSupportNavigateUp()
    }
}
