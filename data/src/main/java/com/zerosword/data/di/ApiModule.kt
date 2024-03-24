package com.zerosword.data.di

import com.zerosword.data.services.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideMainServices(retrofit: Retrofit): MainService =
        retrofit.create(MainService::class.java)

}