package com.ak87.newsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ak87.newsapp.models.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    fun getAllArticles():  List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)
}