package com.tozzz.caseinvio.retrofit

import com.tozzz.caseinvio.entity.MovieDetails
import `in`.example.moviesapp.network.model.Search
import retrofit2.Call
import retrofit2.http.*

interface MovieDaoInterface {

    @GET("?apikey=7db023ac")
    fun getMovies(@Query("s")searchString: String): Call<Search>

    @GET("?apikey=7db023ac")
    fun getMovieDetails(@Query("t")details: String): Call<MovieDetails>
}