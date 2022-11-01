package com.ak87.newsapp.data.api

import com.ak87.newsapp.utils.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("q") queery: String,
        @Query("p") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY

    )

    suspend fun getHeadLines(
        @Query("country") country: String = "ru",
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    )
}