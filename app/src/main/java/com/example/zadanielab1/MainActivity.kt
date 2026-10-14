package com.example.zadanielab1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.zadanielab1.ui.list.MovieListFragment
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        // Add the list only on the first start. After a configuration change (e.g. rotation)
        // the FragmentManager restores its fragments and the back stack by itself.
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container, MovieListFragment())
            }
        }

        // TODO 5a: Show the "up" arrow in the Toolbar only when the details screen is visible,
        //  i.e. when the back stack is not empty.
        //  Hint: supportFragmentManager.addOnBackStackChangedListener { ... }
        //        supportFragmentManager.backStackEntryCount
        //        supportActionBar?.setDisplayHomeAsUpEnabled(...)
        //  Check: does the arrow still show correctly after rotating the screen on the details screen?
    }

    override fun onSupportNavigateUp(): Boolean {
        // TODO 5b: Go back to the list when the "up" arrow is tapped.
        //  Hint: supportFragmentManager.popBackStack(), then return true
        return super.onSupportNavigateUp()
    }
}
