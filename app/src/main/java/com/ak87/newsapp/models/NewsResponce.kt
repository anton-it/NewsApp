package com.ak87.newsapp.models

data class NewsResponce(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)