package com.example.zadanielab1

import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.zadanielab1.ui.list.MovieListFragment
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun listHasTenMoviesAndRecreationDoesNotDuplicateIt() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            assertInitialList(scenario)
            scenario.recreate()
            assertInitialList(scenario)
        }
    }

    private fun assertInitialList(scenario: ActivityScenario<MainActivity>) {
        scenario.onActivity { activity ->
            val manager = activity.supportFragmentManager
            manager.executePendingTransactions()
            assertTrue(manager.findFragmentById(R.id.fragment_container) is MovieListFragment)
            assertEquals(1, manager.fragments.size)
            assertEquals(0, manager.backStackEntryCount)
            val recycler = activity.findViewById<RecyclerView>(R.id.recycler_movies)
            assertEquals(10, recycler.adapter?.itemCount)
            val options = activity.supportActionBar?.displayOptions ?: 0
            assertEquals(0, options and ActionBar.DISPLAY_HOME_AS_UP)
        }
    }
}
