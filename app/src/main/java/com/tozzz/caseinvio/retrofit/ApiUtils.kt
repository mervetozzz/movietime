package com.tozzz.caseinvio.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class ApiUtils {
    companion object{
        val BASE_URL ="https://www.omdbapi.com/"

        fun getMovieDaoInterface():MovieDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(MovieDaoInterface::class.java)
        }
    }
}