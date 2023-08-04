package com.ak87.newsapp.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class ArticleDataBase: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {

        private var instance: ArticleDataBase? = null
        private val LOOK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOOK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) : ArticleDataBase {
            return  Room.databaseBuilder(
                context.applicationContext,
                ArticleDataBase::class.java,
                "article_database"
            ).build()
        }

    }
}