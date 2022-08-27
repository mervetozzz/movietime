package com.tozzz.caseinvio.viewmodel


import `in`.example.moviesapp.network.model.Search
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tozzz.caseinvio.repo.MovieDaoRepository

class MainPageFragmentViewModel : ViewModel() {
    val mrepo = MovieDaoRepository(Application())
    val movieList: LiveData<Search>
    val showProgress: LiveData<Boolean>


    init {
        this.movieList = mrepo.movielist
        this.showProgress = mrepo.showProgress
    }

    fun changeState(){
        mrepo.changeState()
    }

    fun search(searchWord: String) {
        mrepo.movieSearch(searchWord)
    }
}