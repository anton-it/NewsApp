package com.ak87.newsapp.data.api

import com.ak87.newsapp.di.NewsApp
import javax.inject.Inject

class TestRepo @Inject constructor(private val newsService: NewsService) {

    suspend fun getAll() = newsService.getHeadlines()
}