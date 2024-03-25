package com.zerosword.data.di

import android.content.Context
import androidx.core.os.BuildCompat
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import com.zerosword.data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        responseCallAdapterFactory: ApiResponseCallAdapterFactory,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.baseUrl)
        .addCallAdapterFactory(responseCallAdapterFactory)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun providesApiResponseConverterFactory(): ApiResponseCallAdapterFactory =
        ApiResponseCallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create(
        GsonBuilder()
            .create()
    ) ?: GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpCache: Cache,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .cache(httpCache)
        .connectTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .callTimeout(10, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideOkHttpCache(@ApplicationContext context: Context): Cache = Cache(
        directory = File(
            context.cacheDir,
            "http_cache",
        ),
        // $0.05 worth of phone storage in 2020
        maxSize = 50L * 1024L * 1024L // 50 MiB
    )

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.BASIC
    }

}