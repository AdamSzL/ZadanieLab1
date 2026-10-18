package com.example.zadanielab1

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.zadanielab1.data.MovieRepository
import com.example.zadanielab1.databinding.FragmentMovieDetailsBinding
import com.example.zadanielab1.ui.details.MovieDetailsFragment
import com.example.zadanielab1.ui.list.MovieListFragment
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

/** Acceptance tests for the five TODOs. Run on a device or emulator. */
@RunWith(AndroidJUnit4::class)
class MovieExerciseTest {
    @Test
    fun task1_detailsLayoutContainsDescription() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                val layout = activity.layoutInflater.inflate(R.layout.fragment_movie_details, null)
                val id = descriptionId(activity)
                assertTrue("TODO 1: add the description TextView to the details layout",
                    layout.findViewById<android.view.View>(id) is TextView)
            }
        }
    }

    @Test
    fun task2_factoryStoresSelectedMovieId() {
        for (id in listOf(1, 2)) {
            val fragment = MovieDetailsFragment.newInstance(id)
            assertEquals("TODO 2: store the selected movie ID in arguments", id,
                fragment.arguments?.getInt(MovieDetailsFragment.ARG_MOVIE_ID))
        }
    }

    @Test
    fun task3_selectionOpensDetailsWithSelectedId() {
        for (id in listOf(1, 2)) {
            ActivityScenario.launch(MainActivity::class.java).use { scenario ->
                openMovie(id)
                scenario.onActivity { activity ->
                    val fragment = details(activity)
                    assertEquals("TODO 2/3: open details for the selected movie", id,
                        fragment.arguments?.getInt(MovieDetailsFragment.ARG_MOVIE_ID))
                    assertEquals("TODO 3: add the transaction to the back stack", 1,
                        activity.supportFragmentManager.backStackEntryCount)
                }
            }
        }
    }

    @Test
    fun task4_detailsDisplaySelectedMovieData() {
        for (id in listOf(1, 2)) {
            ActivityScenario.launch(MainActivity::class.java).use { scenario ->
                openMovie(id)
                assertMovieData(scenario, id)
            }
        }
    }

    @Test
    fun task5_toolbarUpAndSystemBackReturnToList() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            openMovie(1)
            assertUpVisible(scenario)
            tapUp(scenario)
            assertList(scenario)
            openMovie(2)
            assertUpVisible(scenario)
            pressBack()
            assertList(scenario)
        }
    }

    @Test
    fun recreationPreservesSelectedMovieAndUpArrow() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            openMovie(2)
            scenario.recreate()
            assertMovieData(scenario, 2)
            assertUpVisible(scenario)
            tapUp(scenario)
            scenario.recreate()
            assertList(scenario)
        }
    }

    private fun openMovie(id: Int) {
        onView(withText(MovieRepository.getMovieById(id)!!.title)).perform(click())
    }

    private fun details(activity: MainActivity): MovieDetailsFragment {
        val fragment = activity.supportFragmentManager.findFragmentById(R.id.fragment_container)
        assertTrue("TODO 3: selecting a movie must open MovieDetailsFragment",
            fragment is MovieDetailsFragment)
        return fragment as MovieDetailsFragment
    }

    private fun assertMovieData(scenario: ActivityScenario<MainActivity>, id: Int) {
        val movie = MovieRepository.getMovieById(id)!!
        var descriptionViewId = 0
        scenario.onActivity { activity ->
            val view = details(activity).requireView()
            val binding = FragmentMovieDetailsBinding.bind(view)
            assertEquals("TODO 4: display the selected title", movie.title, binding.textTitle.text.toString())
            assertEquals("TODO 4: format the year and genre",
                activity.getString(R.string.movie_year_genre, movie.year, movie.genre), binding.textSubtitle.text.toString())
            assertEquals("TODO 4: format the director",
                activity.getString(R.string.movie_director, movie.director), binding.textDirector.text.toString())
            assertEquals("TODO 4: format the rating",
                activity.getString(R.string.movie_rating, movie.rating), binding.textRating.text.toString())
            descriptionViewId = descriptionId(activity)
            val description = view.findViewById<TextView>(descriptionViewId)
            assertEquals("TODO 4: display the description", movie.description, description?.text?.toString())
        }
        onView(withId(descriptionViewId)).perform(scrollTo()).check(matches(isDisplayed()))
    }

    private fun assertUpVisible(scenario: ActivityScenario<MainActivity>) {
        scenario.onActivity { activity ->
            details(activity)
            assertTrue("TODO 5: show Toolbar Up on details",
                (activity.supportActionBar?.displayOptions ?: 0) and ActionBar.DISPLAY_HOME_AS_UP != 0)
        }
    }

    private fun tapUp(scenario: ActivityScenario<MainActivity>) {
        var description = ""
        scenario.onActivity {
            description = it.getString(androidx.appcompat.R.string.abc_action_bar_up_description)
        }
        onView(withContentDescription(description)).perform(click())
    }

    private fun assertList(scenario: ActivityScenario<MainActivity>) {
        onView(withId(R.id.recycler_movies)).check(matches(isDisplayed()))
        scenario.onActivity { activity ->
            val manager = activity.supportFragmentManager
            assertTrue("Return navigation must restore the list",
                manager.findFragmentById(R.id.fragment_container) is MovieListFragment)
            assertEquals("Do not duplicate the list after recreation", 1, manager.fragments.size)
            assertEquals(0, manager.backStackEntryCount)
            assertEquals("TODO 5: hide Toolbar Up on the list", 0,
                (activity.supportActionBar?.displayOptions ?: 0) and ActionBar.DISPLAY_HOME_AS_UP)
        }
    }

    // Resolve this ID at runtime so the tests compile before TODO 1 creates the view.
    @SuppressLint("DiscouragedApi")
    private fun descriptionId(activity: MainActivity): Int {
        val id = activity.resources.getIdentifier("text_description", "id", activity.packageName)
        assertTrue("TODO 1: add a TextView with ID text_description", id != 0)
        return id
    }
}
