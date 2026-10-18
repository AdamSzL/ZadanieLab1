package com.example.zadanielab1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.zadanielab1.databinding.ActivityMainBinding
import com.example.zadanielab1.ui.details.MovieDetailsFragment
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

        // Task 5: keep the Toolbar state in sync, including after Activity recreation.
        supportFragmentManager.addOnBackStackChangedListener { updateUpButton() }
        updateUpButton()
    }

    private fun updateUpButton() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        supportActionBar?.setDisplayHomeAsUpEnabled(currentFragment is MovieDetailsFragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true
    }
}
