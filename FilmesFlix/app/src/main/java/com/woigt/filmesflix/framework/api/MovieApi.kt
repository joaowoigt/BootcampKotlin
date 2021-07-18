package com.woigt.filmesflix.framework.api

import com.woigt.filmesflix.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {



    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>

}