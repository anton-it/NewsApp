package com.ak87.newsapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ak87.newsapp.data.api.NewsRepository
import com.ak87.newsapp.models.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: NewsRepository): ViewModel() {

    init {
        getSaveArticles()
    }

    fun getSaveArticles() = viewModelScope.launch(Dispatchers.IO) {
        repository.getFavoriteArticle()
    }

    fun saveFavoriteArticle(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        val res = repository.getFavoriteArticle()
        println("DB size: ${res.size}")
        repository.addFavorite(article = article)
    }
}