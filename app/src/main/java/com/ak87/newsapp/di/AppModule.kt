package com.ak87.newsapp.di

import android.content.Context
import androidx.room.Room
import com.ak87.newsapp.data.api.NewsService
import com.ak87.newsapp.data.db.ArticleDao
import com.ak87.newsapp.data.db.ArticleDataBase
import com.ak87.newsapp.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun baseUrl() = BASE_URL

    @Provides
    fun logging() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient() = OkHttpClient.Builder()
        .addInterceptor(logging())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): NewsService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
            .create(NewsService::class.java)

    @Provides
    @Singleton
    fun provideArticleDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ArticleDataBase::class.java,
            "article_database"
        ).build()

    @Provides
    fun provideArticleDao(appDataBase: ArticleDataBase): ArticleDao {
        return appDataBase.getArticleDao()
    }

}
