package com.esrakaya.earningapp.di

import com.esrakaya.earningapp.data.service.EarningService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideCommonService(
        retrofit: Retrofit
    ): EarningService {
        return retrofit.create()
    }
}