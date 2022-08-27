package com.tozzz.caseinvio.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tozzz.caseinvio.entity.MovieDetails
import com.tozzz.caseinvio.repo.MovieDaoRepository

class DetailPageViewModel : ViewModel() {
    private val mrepo = MovieDaoRepository(Application())
    val details: MutableLiveData<MovieDetails>

    init {
        details = mrepo.details
    }

    fun detailLoad(imdb: String) {
        mrepo.movieDetail(imdb)
    }
}