package com.woigt.filmesflix.data

import com.woigt.filmesflix.domain.Movie

interface MovieDataSource {

    fun  getAllMovies(): List<Movie>
}