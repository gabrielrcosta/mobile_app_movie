package com.example.mobile_app_movie

import java.io.Serializable

data class Movie(
    val id: Int,
    val name: String,
    val image: String,
    val certification: String,
    val description: String,
    val starring: List<String>,
    val running_time_min: Int,
    val seats_remaining: Int,
    val seats_selected: Int
) : Serializable

fun getMovies(): MutableList<Movie> {
    val movieList: MutableList<Movie> = mutableListOf()
    val starringList: List<String> = listOf("Chris Pratt", "Anya Taylor-Joy", "Charlie Day", "Jack Black", "Seth Rogen")
    val starringList1: List<String> = listOf("Keanu Reeves", "Donnie Yen", "Bill Skarsgård")
    val starringList2: List<String> = listOf("Michael B. Jordan", "Tessa Thompson", "Jonathan Majors", "Wood Harris")
    val starringList3: List<String> = listOf("Antonio Banderas", "Salma Hayek", "Olivia Colman")
    val randomNumber = (0..15).random()
    movieList.add(Movie(
        id = 0,
        name = "THE SUPER MARIO BROS. MOVIE",
        image = "https://www.myvue.com/-/media/9a0486a0002f46548f04f032c351b6a2.png?w=200",
        certification = "https://www.myvue.com/-/media/system/certificates/certificates%20ireland/pg.png",
        description = "A plumber named Mario travels through an underground labyrinth with his brother," +
                " Luigi, trying to save a captured princess.",
        starring = starringList,
        running_time_min = 92,
        seats_remaining = randomNumber,
        seats_selected = 0
    ))
    movieList.add(Movie(
        id = 1,
        name = "JOHN WICK: CHAPTER 4",
        image = "https://www.myvue.com/-/media/91f304678ae445538a86d3fb16f277d7.png?w=200",
        certification = "https://www.myvue.com/-/media/system/certificates/certificates%20ireland/16.png",
        description = "John Wick (Keanu Reeves) uncovers a path to defeating The High Table. " +
                "But before he can earn his freedom, Wick must face off against a new enemy with powerful " +
                "alliances across the globe and forces that turn old friends into foes.",
        starring = starringList1,
        running_time_min = 169,
        seats_remaining = randomNumber,
        seats_selected = 0
    ))
    movieList.add(Movie(
        id = 2,
        name = "CREED III",
        image = "https://www.myvue.com/-/media/8000b40d5bfd4148b1c2195fdd490a11.png?w=200",
        certification = "https://www.myvue.com/-/media/system/certificates/certificates%20ireland/tbc.png",
        description = "When a childhood friend and former boxing prodigy, Damian (Jonathan Majors)," +
                "resurfaces after serving a long sentence in prison, he is eager to prove that he deserves " +
                "his shot in the ring.",
        starring = starringList2,
        running_time_min = 116,
        seats_remaining = randomNumber,
        seats_selected = 0
    ))
    movieList.add(Movie(
        id = 3,
        name = "PUSS IN BOOTS: THE LAST WISH",
        image = "https://images.mymovies.net/images/film/cin/350x522/fid21516.jpg?sc=.99",
        certification = "https://www.myvue.com/-/media/system/certificates/certificates%20ireland/pg.png",
        description = "This year, everyone's favourite leche-loving, swashbuckling, fear-defying feline returns.",
        starring = starringList3,
        running_time_min = 102,
        seats_remaining = randomNumber,
        seats_selected = 0
    ))
    return movieList
}

fun getMovie(id: Int): Movie? {
    getMovies().forEach {
        if (id == it.id) {
            return it
        }
    }
    return null
}