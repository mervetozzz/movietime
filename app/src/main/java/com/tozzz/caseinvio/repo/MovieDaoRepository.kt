package com.tozzz.caseinvio.repo

import `in`.example.moviesapp.network.model.Search
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.tozzz.caseinvio.entity.MovieDetails
import com.tozzz.caseinvio.retrofit.ApiUtils
import com.tozzz.caseinvio.retrofit.MovieDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDaoRepository(val application: Application) {
    private val sMovie: MovieDaoInterface = ApiUtils.getMovieDaoInterface()
    val movielist = MutableLiveData<Search>()
    val details =MutableLiveData<MovieDetails>()
    val showProgress= MutableLiveData<Boolean>()

    fun changeState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }

    fun movieSearch(searchWord: String) {
        showProgress.value=true

        sMovie.getMovies(searchWord).enqueue(object : Callback<Search> {

            override fun onResponse(call: Call<Search>, response: Response<Search>) {
                Log.d("SearchRepository", "Response : ${Gson().toJson(response.body())}")
                movielist.value = response.body()
                showProgress.value = false
            }

            override fun onFailure(call: Call<Search>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application, "Error while *accessing the API", Toast.LENGTH_SHORT)
                    .show()
                Log.e("ERROR", t.message.toString())
            }
        })
    }


    fun movieDetail(imdb: String) {
        sMovie.getMovieDetails(imdb).enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                details.value =response.body()
            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}