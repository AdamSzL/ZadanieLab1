package com.example.zadanielab1.data

/**
 * In-memory source of sample data. In a real app this would be a database or a network API.
 */
object MovieRepository {

    private val movies = listOf(
        Movie(
            id = 1,
            title = "The Shawshank Redemption",
            year = 1994,
            director = "Frank Darabont",
            genre = "Drama",
            rating = 9.3,
            description = "A banker sentenced to life in Shawshank prison forms an unlikely " +
                    "friendship with a fellow inmate and quietly plans his way to freedom."
        ),
        Movie(
            id = 2,
            title = "The Godfather",
            year = 1972,
            director = "Francis Ford Coppola",
            genre = "Crime",
            rating = 9.2,
            description = "The aging head of a mafia family transfers control of his empire " +
                    "to his reluctant youngest son."
        ),
        Movie(
            id = 3,
            title = "The Dark Knight",
            year = 2008,
            director = "Christopher Nolan",
            genre = "Action",
            rating = 9.0,
            description = "Batman faces the Joker, a criminal mastermind who wants to plunge " +
                    "Gotham City into chaos."
        ),
        Movie(
            id = 4,
            title = "Pulp Fiction",
            year = 1994,
            director = "Quentin Tarantino",
            genre = "Crime",
            rating = 8.9,
            description = "Several intertwined stories of Los Angeles criminals, told out of " +
                    "chronological order."
        ),
        Movie(
            id = 5,
            title = "Inception",
            year = 2010,
            director = "Christopher Nolan",
            genre = "Sci-Fi",
            rating = 8.8,
            description = "A thief who steals secrets from dreams is given the opposite task: " +
                    "planting an idea in someone's mind."
        ),
        Movie(
            id = 6,
            title = "Spirited Away",
            year = 2001,
            director = "Hayao Miyazaki",
            genre = "Animation",
            rating = 8.6,
            description = "A young girl wanders into a world of spirits and must work in a " +
                    "bathhouse to free her parents."
        ),
        Movie(
            id = 7,
            title = "Interstellar",
            year = 2014,
            director = "Christopher Nolan",
            genre = "Sci-Fi",
            rating = 8.7,
            description = "A team of astronauts travels through a wormhole in search of a new " +
                    "home for humanity."
        ),
        Movie(
            id = 8,
            title = "Parasite",
            year = 2019,
            director = "Bong Joon-ho",
            genre = "Thriller",
            rating = 8.5,
            description = "A poor family schemes its way into the household of a wealthy one, " +
                    "with unexpected consequences."
        ),
        Movie(
            id = 9,
            title = "The Matrix",
            year = 1999,
            director = "Lana Wachowski, Lilly Wachowski",
            genre = "Sci-Fi",
            rating = 8.7,
            description = "A hacker learns that the world he lives in is a simulation and joins " +
                    "the rebellion against its creators."
        ),
        Movie(
            id = 10,
            title = "Whiplash",
            year = 2014,
            director = "Damien Chazelle",
            genre = "Drama",
            rating = 8.5,
            description = "A young jazz drummer is pushed to his limits by a ruthless music " +
                    "instructor."
        )
    )

    fun getMovies(): List<Movie> = movies

    fun getMovieById(id: Int): Movie? = movies.find { it.id == id }
}
